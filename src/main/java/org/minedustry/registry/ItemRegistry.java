package org.minedustry.registry;

import org.minedustry.References;
import org.minedustry.blocks.BiofuelGeneratorBlock;
import org.minedustry.items.ChainsawItem;
import org.minedustry.items.ItemBase;
import org.minedustry.items.ItemBlock;
import org.minedustry.utilities.Tabs;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry
{
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, References.MODID);

	public static final RegistryObject<Item> BIOFUEL_GENERATOR = ITEMS.register("biofuel_generator", () -> new ItemBlock(BlockRegistry.BIOFUEL_GENERATOR.get(), Tabs.MACHINES));

	public static final RegistryObject<Item> IMPURE_BISMUTH = ITEMS.register("bismuth_shard1", () -> new Item(new Item.Properties().group(Tabs.ITEMS)));
	public static final RegistryObject<Item> PURE_BISMUTH = ITEMS.register("bismuth_shard2", () -> new Item(new Item.Properties().group(Tabs.ITEMS)));
	public static final RegistryObject<Item> PERFECT_BISMUTH = ITEMS.register("bismuth_shard3", () -> new Item(new Item.Properties().group(Tabs.ITEMS)));

	public static final RegistryObject<Item> BISMUTH_BLOCK = ITEMS.register("bismuth_block", () -> new ItemBlock(BlockRegistry.BISMUTH_BLOCK.get(), Tabs.BLOCKS));

	public static final RegistryObject<Item> CHAINSAW = ITEMS.register("chainsaw", () -> new ChainsawItem());
}