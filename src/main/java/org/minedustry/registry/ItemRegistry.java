package org.minedustry.registry;

import org.minedustry.References;
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
}