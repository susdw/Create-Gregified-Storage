package net.sansdw.create_gs.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ServerConfig {
    public static final ForgeConfigSpec SERVER_SPEC;
    public static final ServerConfig SERVER;

    // Per‐tier entries
    public final ForgeConfigSpec.IntValue copperMultiplier;
    public final ForgeConfigSpec.IntValue copperCapacity;

    public final ForgeConfigSpec.IntValue bronzeMultiplier;
    public final ForgeConfigSpec.IntValue bronzeCapacity;

    public final ForgeConfigSpec.IntValue steelMultiplier;
    public final ForgeConfigSpec.IntValue steelCapacity;

    public final ForgeConfigSpec.IntValue aluminiumMultiplier;
    public final ForgeConfigSpec.IntValue aluminiumCapacity;

    public final ForgeConfigSpec.IntValue stainlessSteelMultiplier;
    public final ForgeConfigSpec.IntValue stainlessSteelCapacity;

    public final ForgeConfigSpec.IntValue titaniumMultiplier;
    public final ForgeConfigSpec.IntValue titaniumCapacity;

    public final ForgeConfigSpec.IntValue tungstenSteelMultiplier;
    public final ForgeConfigSpec.IntValue tungstenSteelCapacity;
    // …and so on for each TierMaterials constant

    static {
        var builder = new ForgeConfigSpec.Builder();
        SERVER = new ServerConfig(builder);
        SERVER_SPEC = builder.build();
    }

    private ServerConfig(ForgeConfigSpec.Builder builder) {
        builder.comment("Tiered Vault Settings").push("tiers");

        copperMultiplier = builder
                .comment("Copper vault stacking multiplier (default 2)")
                .defineInRange("copper.multiplierLength", 2, 1, 10);
        copperCapacity   = builder
                .comment("Copper vault slot capacity (default 27)")
                .defineInRange("copper.capacity", 27, 1, 1000);

        bronzeMultiplier = builder
                .comment("Bronze vault stacking multiplier (default 3)")
                .defineInRange("bronze.multiplierLength", 3, 1, 10);
        bronzeCapacity   = builder
                .comment("Bronze vault slot capacity (default 54)")
                .defineInRange("bronze.capacity", 54, 1, 2000);

        steelMultiplier = builder
                .comment("Steel vault stacking multiplier (default 4)")
                .defineInRange("steel.multiplierLength", 4, 1, 10);
        steelCapacity   = builder
                .comment("Steel vault slot capacity (default 72)")
                .defineInRange("steel.capacity", 72, 1, 2000);

        aluminiumMultiplier = builder
                .comment("Aluminium vault stacking multiplier (default 4)")
                .defineInRange("aluminium.multiplierLength", 4, 1, 10);
        aluminiumCapacity   = builder
                .comment("Aluminium vault slot capacity (default 90)")
                .defineInRange("aluminium.capacity", 90, 1, 2000);

        stainlessSteelMultiplier = builder
                .comment("Stainless Steel vault stacking multiplier (default 5)")
                .defineInRange("stainless_steel.multiplierLength", 5, 1, 10);
        stainlessSteelCapacity  = builder
                .comment("Stainless Steel slot capacity (default 108)")
                .defineInRange("stainless_steel.capacity", 108, 1, 2000);

        titaniumMultiplier = builder
                .comment("Titanium vault stacking multiplier (default 5)")
                .defineInRange("titanium.multiplierLength", 5, 1, 10);
        titaniumCapacity  = builder
                .comment("Titanium vault slot capacity (default 126)")
                .defineInRange("titanium.capacity", 126, 1, 2000);

        tungstenSteelMultiplier = builder
                .comment("Tungstensteel vault stacking multiplier (default 6)")
                .defineInRange("tungsten_steel.multiplierLength", 6, 1, 10);
        tungstenSteelCapacity  = builder
                .comment("Tungstensteel vault slot capacity (default 144)")
                .defineInRange("tungsten_steel.capacity", 144, 1, 2000);

        builder.pop();
    }
}
