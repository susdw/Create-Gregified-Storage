package net.sansdw.create_gs.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.sansdw.create_gs.content.TieredBEBlockList;
import net.sansdw.create_gs.content.vault.SeeThroughVaultRenderer;
import net.sansdw.create_gs.content.vault.TieredVaultBlockEntity;

import static net.sansdw.create_gs.CreateGS.REGISTRATE;

public class GSBlockEntities {
    public static final TieredBEBlockList<TieredVaultBlockEntity> VAULTS = new TieredBEBlockList<>(tier -> {
        if (!tier.valid) return null;
        String tierID = tier.name.toLowerCase();
        var be = REGISTRATE.blockEntity(tierID + "_item_vault", (BlockEntityType<TieredVaultBlockEntity> t, BlockPos p, BlockState s) -> new TieredVaultBlockEntity(t, p, s, tier))
                .validBlocks(GSBlocks.VAULTS.get(tier));
        if (tier.seeThrough) be.renderer(() -> SeeThroughVaultRenderer::new);
        return be.register();
    });

    public static void register() {}
}
