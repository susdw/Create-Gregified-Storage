package net.sansdw.create_gs;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription;
import net.createmod.catnip.lang.FontHelper;
import net.createmod.ponder.foundation.registration.PonderTagRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.sansdw.create_gs.config.ServerConfig;
import net.sansdw.create_gs.content.TierMaterials;
import net.sansdw.create_gs.infrastructure.data.GSDatagen;
import net.sansdw.create_gs.registry.GSBlockEntities;
import net.sansdw.create_gs.registry.GSBlocks;
import net.sansdw.create_gs.registry.GSMovementChecks;
import net.sansdw.create_gs.registry.GSSpriteShifts;

import static net.minecraft.world.item.CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS;

@SuppressWarnings("unused")
@Mod(CreateGS.MOD_ID)
public class CreateGS {
    public static final String NAME = "Create: Gregified Storage";
    public static final String MOD_ID = "create_gs";

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);
    static {
        REGISTRATE.setTooltipModifierFactory(item -> new ItemDescription.Modifier(item, FontHelper.Palette.STANDARD_CREATE));
    }

    public CreateGS() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        REGISTRATE.registerEventListeners(modEventBus);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> GSSpriteShifts::register);

        GSBlocks.register();
        GSBlockEntities.register();
        GSMovementChecks.register();

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(EventPriority.LOWEST, (GatherDataEvent event) -> GSDatagen.gatherData());
        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(
                ModConfig.Type.SERVER,
                ServerConfig.SERVER_SPEC
        );
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(AllCreativeModeTabs.BASE_CREATIVE_TAB.getKey()))
            for (TierMaterials tier : TierMaterials.values()) {
                if (!tier.valid) continue;
                event.getEntries().putBefore(AllBlocks.ITEM_VAULT.asStack(), GSBlocks.VAULTS.get(tier).asStack(), PARENT_AND_SEARCH_TABS);
            }
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
