package org.minedustry.items;

import org.minedustry.References;
import org.minedustry.utilities.Tabs;

import net.minecraft.item.Item;

public class ItemBase extends Item
{
	public ItemBase(String registryName)
	{
		super(new Item.Properties().group(Tabs.ITEMS));
		this.setRegistryName(References.MODID, registryName);
	}
}