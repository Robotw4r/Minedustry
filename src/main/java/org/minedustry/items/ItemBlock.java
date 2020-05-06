package org.minedustry.items;

import org.minedustry.References;
import org.minedustry.utilities.Tabs;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class ItemBlock extends BlockItem
{
	public ItemBlock(Block block)
	{
		super(block, new Item.Properties().group(Tabs.ITEMS));
		this.setRegistryName(References.MODID, block.getRegistryName().getPath());
	}

}
