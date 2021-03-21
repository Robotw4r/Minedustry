package org.minedustry.registry;

import org.minedustry.blocks.BlockBase;
import org.minedustry.items.ItemBase;
import org.minedustry.items.ItemBlock;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Ore
{
	private final String name;
	private String suffix;
	private final Item item;
	private final Block block;
	private final Item itemBlock;

	public Ore(String name)
	{
		this.name = name;

		item = new ItemBase(name + "_ingot");
		block = new BlockBase(name + "_block");
		itemBlock = new ItemBlock(block);
	}

	public Ore(String name, String itemSuffix)
	{
		this.name = name;
		this.suffix = itemSuffix;

		item = new ItemBase(name + "_" + itemSuffix);
		block = new BlockBase(name + "_block");
		itemBlock = new ItemBlock(block);
	}

	public String getName()
	{
		return name;
	}

	public Item getItem()
	{
		return item;
	}

	public Block getBlock()
	{
		return block;
	}

	public Item getItemBlock()
	{
		return itemBlock;
	}

	public String getSuffix()
	{
		return suffix;
	}
}