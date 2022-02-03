package org.minedustry.registry;

import net.minecraft.block.Block.Properties;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import org.minedustry.References;
import org.minedustry.blocks.BiofuelGeneratorBlock;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.minedustry.blocks.BlockBase;
import org.minedustry.utilities.Tabs;

import static net.minecraft.block.material.Material.IRON;
import static net.minecraft.block.material.Material.WOOD;

public class BlockRegistry
{
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, References.MODID);
	
	public static final RegistryObject<Block> BIOFUEL_GENERATOR = BLOCKS.register("biofuel_generator", () -> new BiofuelGeneratorBlock());

	public static final RegistryObject<Block> BISMUTH_BLOCK = BLOCKS.register("bismuth_block", () -> new Block(Block.Properties.create(IRON)));
}
