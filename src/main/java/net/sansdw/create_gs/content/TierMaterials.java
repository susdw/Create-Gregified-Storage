package net.sansdw.create_gs.content;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

public enum TierMaterials {
    NONE(0, 0, "None", () -> Ingredient.of(Items.AIR), false, false, MapColor.NONE, 0, 0, SoundType.EMPTY),
    COPPER(1, 0, "Copper", () -> Ingredient.of(Items.COPPER_INGOT), false, true, MapColor.TERRACOTTA_ORANGE, 2, 27, SoundType.COPPER),

    BRONZE(2, 1, "Bronze", () -> Ingredient.of(ChemicalHelper.getIngot(GTMaterials.Bronze, 1).getItem()), false, true, MapColor.TERRACOTTA_YELLOW, 3, 54, SoundType.COPPER),
    STEEL(3, 1, "Steel", () -> Ingredient.of(ChemicalHelper.getIngot(GTMaterials.Steel, 1).getItem()), false, true, MapColor.COLOR_GRAY, 4, 72, SoundType.NETHERITE_BLOCK),

    ALUMINIUM(4, 2, "Aluminium", () -> Ingredient.of(ChemicalHelper.getIngot(GTMaterials.Aluminium, 1).getItem()), false, true, MapColor.COLOR_CYAN, 4, 90, SoundType.NETHERITE_BLOCK),
    STAINLESS_STEEL(5, 2, "Stainless_Steel", () -> Ingredient.of(ChemicalHelper.getIngot(GTMaterials.StainlessSteel, 1).getItem()), false, true, MapColor.TERRACOTTA_WHITE, 5, 108, SoundType.NETHERITE_BLOCK),

    TITANIUM(6, 3, "Titanium", () -> Ingredient.of(ChemicalHelper.getIngot(GTMaterials.Titanium, 1).getItem()), false, true, MapColor.COLOR_PINK, 5, 126, SoundType.NETHERITE_BLOCK),
    TUNGSTEN_STEEL(7, 3, "Tungsten_Steel", () -> Ingredient.of(ChemicalHelper.getIngot(GTMaterials.TungstenSteel, 1).getItem()), false, true, MapColor.LAPIS, 6, 144, SoundType.NETHERITE_BLOCK);

    public final int level;
    public final int baseLevel;
    public final String name;
    public final Supplier<Ingredient> ingredientSupplier;
    public final boolean valid;
    public final boolean seeThrough;
    public final MapColor mapColor;
    public final int multiplierLength;
    public final int capacity;
    public final SoundType soundType;

    TierMaterials(int level, int baseLevel, String name, Supplier<Ingredient> ingredientSupplier, boolean seeThrough, boolean valid, MapColor mapColor, int multiplierLength, int capacity, SoundType soundType) {
        this.level = level;
        this.baseLevel = baseLevel;
        this.name = name;
        this.ingredientSupplier = ingredientSupplier;
        this.seeThrough = seeThrough;
        this.valid = valid;
        this.mapColor = mapColor;
        this.multiplierLength = multiplierLength;
        this.capacity = capacity;
        this.soundType = soundType;
    }

    // Convenience overloads for easier use
    TierMaterials(int level, int baseLevel, String name, ItemLike item, boolean seeThrough, boolean valid, MapColor mapColor, int multiplierLength, int capacity, SoundType soundType) {
        this(level, baseLevel, name, () -> Ingredient.of(item), seeThrough, valid, mapColor, multiplierLength, capacity, soundType);
    }

    TierMaterials(int level, int baseLevel, String name, TagKey<Item> tag, boolean seeThrough, boolean valid, MapColor mapColor, int multiplierLength, int capacity, SoundType soundType) {
        this(level, baseLevel, name, () -> Ingredient.of(tag), seeThrough, valid, mapColor, multiplierLength, capacity, soundType);
    }

    // Usage: safely get the Ingredient when needed
    public Ingredient getIngredient() {
        return ingredientSupplier.get();
    }
}
