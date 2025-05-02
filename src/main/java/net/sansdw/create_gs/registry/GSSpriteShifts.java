package net.sansdw.create_gs.registry;

import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import net.createmod.catnip.data.Couple;
import net.sansdw.create_gs.CreateGS;
import net.sansdw.create_gs.content.TierMaterials;

import java.util.EnumMap;
import java.util.Map;

public class GSSpriteShifts {
    public static final Map<TierMaterials, Couple<CTSpriteShiftEntry>>
            VAULT_TOP = new EnumMap<>(TierMaterials.class),
            VAULT_FRONT = new EnumMap<>(TierMaterials.class),
            VAULT_SIDE = new EnumMap<>(TierMaterials.class),
            VAULT_BOTTOM = new EnumMap<>(TierMaterials.class);

    static {
        populateMaps();
    }
    private static void populateMaps() {
        for (TierMaterials tier : TierMaterials.values()) {
            if (!tier.valid) continue;
            String id = tier.name.toLowerCase();
            VAULT_TOP.put(tier, vault("top", id));
            VAULT_FRONT.put(tier, vault("front", id));
            VAULT_SIDE.put(tier, vault("side", id));
            VAULT_BOTTOM.put(tier, vault("bottom", id));
        }
    }
    private static Couple<CTSpriteShiftEntry> vault(String name, String tier) {
        final String prefixed = "block/" + tier + "_vault/vault_" + name;
        return Couple.createWithContext(
                medium -> CTSpriteShifter.getCT(AllCTTypes.RECTANGLE, CreateGS.asResource(prefixed + "_small"),
                        CreateGS.asResource(medium ? prefixed + "_medium" : prefixed + "_large")));
    }

    public static void register() {
    }
}
