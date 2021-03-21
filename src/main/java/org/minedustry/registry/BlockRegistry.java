package org.minedustry.registry;

import org.minedustry.References;
import org.minedustry.blocks.BiofuelGeneratorBlock;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry
{
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, References.MODID);
	
	public static final RegistryObject<Block> BIOFUEL_GENERATOR = BLOCKS.register("biofuel_generator", () -> new BiofuelGeneratorBlock());
}
