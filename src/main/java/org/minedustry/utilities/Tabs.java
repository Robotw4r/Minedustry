package org.minedustry.utilities;

import org.minedustry.registry.ItemRegistry;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Tabs {
	public static final ItemGroup ITEMS = new ItemGroup("minedustry.items") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemRegistry.PLATINUM_INGOT);
		}
	};
	
	public static final ItemGroup BLOCKS = new ItemGroup("minedustry.blocks") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemRegistry.COBALT_BLOCK);
		}
	};
	
	public static final ItemGroup MACHINES = new ItemGroup("minedustry.machines") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ItemRegistry.BIOFUEL_GENERATOR);
		}
	};
}
