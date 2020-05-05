package org.minedustry.utilities;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Tabs
{
	public static final ItemGroup ITEMS = new ItemGroup("minedustry.items")
	{
		@Override
		public ItemStack createIcon()
		{
			return new ItemStack(RegistryHandler.PLATINUM_INGOT.get());
		}
	};
	
	public static final ItemGroup BLOCKS = new ItemGroup("minedustry.blocks")
	{
		@Override
		public ItemStack createIcon()
		{
			return new ItemStack(RegistryHandler.COBALT_BLOCK.get());
		}
	};
}
