package net.sansdw.create_gs.infrastructure.data;

import com.simibubi.create.foundation.data.TagGen;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.sansdw.create_gs.CreateGS;
import net.sansdw.create_gs.registry.GSBlocks;
import static net.sansdw.create_gs.content.TierMaterials.*;

import java.util.Collections;
import java.util.Objects;

@SuppressWarnings({"deprecation", "SameParameterValue"})
public class GSRegistrateTags {

	public static void addGenerators() {
		CreateGS.REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, GSRegistrateTags::genBlockTags);
		CreateGS.REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, GSRegistrateTags::genItemTags);
	}
	private static void genItemTags(RegistrateTagsProvider<Item> provIn) {
		TagGen.CreateTagsProvider<Item> prov = new TagGen.CreateTagsProvider<>(provIn, Item::builtInRegistryHolder);

		prov.tag(createTagItem("vaults", true))
				.add(GSBlocks.VAULTS.get(COPPER).asItem())
				.add(GSBlocks.VAULTS.get(BRONZE).asItem())
				.add(GSBlocks.VAULTS.get(STEEL).asItem())
				.add(GSBlocks.VAULTS.get(ALUMINIUM).asItem())
				.add(GSBlocks.VAULTS.get(STAINLESS_STEEL).asItem())
				.add(GSBlocks.VAULTS.get(TITANIUM).asItem())
				.add(GSBlocks.VAULTS.get(TUNGSTEN_STEEL).asItem())
		;
	}

	private static void genBlockTags(RegistrateTagsProvider<Block> prov) {
	}


	private static TagKey<Item> createTagItem(String path, boolean optional) {
		ResourceLocation id = new ResourceLocation(CreateGS.MOD_ID, path);
		if (optional) return optionalTag(ForgeRegistries.ITEMS, id);
		else return ItemTags.create(id);
	}

	public static <T> TagKey<T> optionalTag(IForgeRegistry<T> registry, ResourceLocation id) {
		return Objects.requireNonNull(registry.tags()).createOptionalTagKey(id, Collections.emptySet());
	}
}
