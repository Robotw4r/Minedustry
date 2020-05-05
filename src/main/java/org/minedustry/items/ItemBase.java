package org.minedustry.items;

import org.minedustry.utilities.Tabs;

import net.minecraft.item.Item;

public class ItemBase extends Item
{
	public ItemBase()
	{
		super(new Item.Properties().group(Tabs.ITEMS));
	}
}