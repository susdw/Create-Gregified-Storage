package net.sansdw.create_gs.registry;

import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.sansdw.create_gs.CreateGS;
import net.sansdw.create_gs.content.TieredBlockList;
import net.sansdw.create_gs.content.vault.TieredVaultBlock;
import net.sansdw.create_gs.content.vault.TieredVaultCTBehaviour;
import net.sansdw.create_gs.content.vault.TieredVaultItem;
import net.sansdw.create_gs.content.vault.TieredVaultMountedStorageType;

import static com.simibubi.create.api.contraption.storage.item.MountedItemStorageType.mountedItemStorage;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static net.sansdw.create_gs.CreateGS.REGISTRATE;

@SuppressWarnings("removal")
public class GSBlocks {
    public static final RegistryEntry<TieredVaultMountedStorageType> TIERED_VAULT = REGISTRATE.mountedItemStorage("tiered_vault", TieredVaultMountedStorageType::new).register();

    public static final TieredBlockList<TieredVaultBlock> VAULTS = new TieredBlockList<>(tier -> {
        if (!tier.valid) return null;
        String tierID = tier.name.toLowerCase();
        var block = REGISTRATE.block(tierID + "_item_vault", p -> new TieredVaultBlock(p, tier))
                .transform(mountedItemStorage(TIERED_VAULT));
        block.initialProperties(SharedProperties::softMetal).properties(p -> p.mapColor(tier.mapColor).sound(tier.soundType).explosionResistance(1200));
        if (tier.seeThrough) block.properties(p -> p
                        .instrument(NoteBlockInstrument.HAT)
                        .noOcclusion()
                        .isValidSpawn(GSBlocks::never)
                        .isRedstoneConductor(GSBlocks::never)
                        .isSuffocating(GSBlocks::never)
                        .isViewBlocking(GSBlocks::never))
                .addLayer(() -> RenderType::cutout);
        if (tier.soundType.equals(SoundType.WOOD)) block.transform(axeOrPickaxe());
        else block.transform(pickaxeOnly());
        block.blockstate((c, p) -> {
                    ResourceLocation bottom = CreateGS.asResource("block/"+tierID+"_vault/vault_bottom_small");
                    ResourceLocation front = CreateGS.asResource("block/"+tierID+"_vault/vault_front_small");
                    ResourceLocation side = CreateGS.asResource("block/"+tierID+"_vault/vault_side_small");
                    ResourceLocation top = CreateGS.asResource("block/"+tierID+"_vault/vault_top_small");
                    ResourceLocation particle = CreateGS.asResource("block/"+tierID+"_vault/vault_top_small");

                    ResourceLocation refModel = CreateGS.asResource("block/item_vault");

                    p.models().withExistingParent("block/" + c.getName(), refModel)
                            .texture("0", bottom)
                            .texture("1", front)
                            .texture("2", side)
                            .texture("3", top)
                            .texture("particle", particle);
                    p.getVariantBuilder(c.get())
                            .forAllStates(s -> ConfiguredModel.builder()
                                    .modelFile(AssetLookup.standardModel(c, p))
                                    .rotationY(s.getValue(TieredVaultBlock.HORIZONTAL_AXIS) == Direction.Axis.X ? 90 : 0)
                                    .build());
                })
                .onRegister(connectedTextures(() -> new TieredVaultCTBehaviour(tier)))
                .item((b, p) -> new TieredVaultItem(b, p, tier))
                .build();
        return block.register();
    });

    private static boolean never(BlockState s, BlockGetter l, BlockPos p) {return false;}
    private static Boolean never(BlockState s, BlockGetter l, BlockPos p, EntityType<?> t) {return false;}

    public static void register() {}
}
