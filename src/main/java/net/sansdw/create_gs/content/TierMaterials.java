package net.sansdw.create_gs.content;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.sansdw.create_gs.config.ServerConfig;

import java.util.function.Supplier;

public enum TierMaterials {
    NONE(0, 0, "None",
            () -> Ingredient.of(Items.AIR),
            false, false, MapColor.NONE,
            () -> 0,     // multiplierLength supplier
            () -> 0,     // capacity supplier
            SoundType.EMPTY
    ),
    COPPER(1, 0, "Copper",
            () -> Ingredient.of(Items.COPPER_INGOT),
            false, true, MapColor.TERRACOTTA_ORANGE,
            ServerConfig.SERVER.copperMultiplier,
            ServerConfig.SERVER.copperCapacity,
            SoundType.COPPER
    ),
    BRONZE(2, 1, "Bronze",
            () -> Ingredient.of(ChemicalHelper.getIngot(GTMaterials.Bronze, 1).getItem()),
            false, true, MapColor.TERRACOTTA_YELLOW,
            ServerConfig.SERVER.bronzeMultiplier,
            ServerConfig.SERVER.bronzeCapacity,
            SoundType.COPPER
    ),
    STEEL(3, 1, "Steel",
            () -> Ingredient.of(ChemicalHelper.getIngot(GTMaterials.Steel, 1).getItem()),
            false, true, MapColor.COLOR_GRAY,
            ServerConfig.SERVER.steelMultiplier,
            ServerConfig.SERVER.steelCapacity,
            SoundType.NETHERITE_BLOCK
    ),
    ALUMINIUM(4, 2, "Aluminium",
            () -> Ingredient.of(ChemicalHelper.getIngot(GTMaterials.Aluminium, 1).getItem()),
            false, true, MapColor.COLOR_CYAN,
            ServerConfig.SERVER.aluminiumMultiplier,
            ServerConfig.SERVER.aluminiumCapacity,
            SoundType.NETHERITE_BLOCK
    ),
    STAINLESS_STEEL(5, 2, "Stainless_Steel",
            () -> Ingredient.of(ChemicalHelper.getIngot(GTMaterials.StainlessSteel, 1).getItem())
            , false, true, MapColor.TERRACOTTA_WHITE,
            ServerConfig.SERVER.stainlessSteelMultiplier,
            ServerConfig.SERVER.stainlessSteelCapacity,
            SoundType.NETHERITE_BLOCK
    ),
    TITANIUM(6, 3, "Titanium",
            () -> Ingredient.of(ChemicalHelper.getIngot(GTMaterials.Titanium, 1).getItem()),
            false, true, MapColor.TERRACOTTA_LIGHT_GRAY,
            ServerConfig.SERVER.titaniumMultiplier,
            ServerConfig.SERVER.titaniumCapacity,
            SoundType.NETHERITE_BLOCK
    ),
    TUNGSTEN_STEEL(7, 3, "Tungsten_Steel",
            () -> Ingredient.of(ChemicalHelper.getIngot(GTMaterials.TungstenSteel, 1).getItem()),
            false, true, MapColor.TERRACOTTA_BROWN,
            ServerConfig.SERVER.tungstenSteelMultiplier,
            ServerConfig.SERVER.tungstenSteelCapacity,
            SoundType.NETHERITE_BLOCK
    );

    public final int level;
    public final int baseLevel;
    public final String name;
    private final Supplier<Ingredient> ingredientSupplier;
    public final boolean valid;
    public final boolean seeThrough;
    public final MapColor mapColor;
    private final Supplier<Integer> multiplierSupplier;
    private final Supplier<Integer> capacitySupplier;
    public final SoundType soundType;

    TierMaterials(int level,
                  int baseLevel,
                  String name,
                  Supplier<Ingredient> ingredientSupplier,
                  boolean seeThrough,
                  boolean valid,
                  MapColor mapColor,
                  Supplier<Integer> multiplierSupplier,
                  Supplier<Integer> capacitySupplier,
                  SoundType soundType) {
        this.level = level;
        this.baseLevel = baseLevel;
        this.name = name;
        this.ingredientSupplier = ingredientSupplier;
        this.seeThrough = seeThrough;
        this.valid = valid;
        this.mapColor = mapColor;
        this.multiplierSupplier = multiplierSupplier;
        this.capacitySupplier = capacitySupplier;
        this.soundType = soundType;
    }

    // Convenience constructor for ItemLike
    TierMaterials(int level,
                  int baseLevel,
                  String name,
                  net.minecraft.world.level.ItemLike item,
                  boolean seeThrough,
                  boolean valid,
                  MapColor mapColor,
                  Supplier<Integer> multiplierSupplier,
                  Supplier<Integer> capacitySupplier,
                  SoundType soundType) {
        this(level, baseLevel, name, () -> Ingredient.of(item),
                seeThrough, valid, mapColor, multiplierSupplier, capacitySupplier, soundType);
    }

    // Convenience constructor for TagKey<Item>
    TierMaterials(int level,
                  int baseLevel,
                  String name,
                  TagKey<Item> tag,
                  boolean seeThrough,
                  boolean valid,
                  MapColor mapColor,
                  Supplier<Integer> multiplierSupplier,
                  Supplier<Integer> capacitySupplier,
                  SoundType soundType) {
        this(level, baseLevel, name, () -> Ingredient.of(tag),
                seeThrough, valid, mapColor, multiplierSupplier, capacitySupplier, soundType);
    }

    /** Retrieves the ingredient when needed. */
    public Ingredient getIngredient() {
        return ingredientSupplier.get();
    }

    /** Retrieves the current multiplierLength from the server config. */
    public int getMultiplierLength() {
        return multiplierSupplier.get();
    }

    /** Retrieves the current capacity from the server config. */
    public int getCapacity() {
        return capacitySupplier.get();
    }
}