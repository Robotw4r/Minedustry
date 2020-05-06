package org.minedustry.blocks;

import org.minedustry.References;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockBase extends Block
{
	public BlockBase(String registryName)
	{
		super(Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(2.0f));
		this.setRegistryName(References.MODID, registryName);
	}

}
