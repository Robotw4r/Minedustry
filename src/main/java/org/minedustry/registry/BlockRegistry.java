package org.minedustry.registry;

import org.minedustry.MinedustryMain;
import org.minedustry.References;
import org.minedustry.blocks.BiofuelGeneratorBlock;
import org.minedustry.blocks.BlockBase;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(References.MODID)
@EventBusSubscriber(modid = References.MODID, bus = Bus.MOD)
public class BlockRegistry
{
	public static final Block PLATINUM_BLOCK = new BlockBase("platinum_block");
    public static final Block COBALT_BLOCK = new BlockBase("cobalt_block");
    public static final Block THORIUM_BLOCK = new BlockBase("thorium_block");
    public static final Block BISMUTH_BLOCK = new BlockBase("bismuth_block");
    
    public static final Block BIOFUEL_GENERATOR = new BiofuelGeneratorBlock();
	
	@SubscribeEvent
	public static void registerTileEntities(RegistryEvent.Register<Block> event)
	{
		MinedustryMain.LOGGER.debug("Registering Blocks...");
		
		IForgeRegistry<Block> reg = event.getRegistry();
		
		reg.register(PLATINUM_BLOCK);
		reg.register(COBALT_BLOCK);
		reg.register(THORIUM_BLOCK);
		reg.register(BIOFUEL_GENERATOR);
		reg.register(BISMUTH_BLOCK);
		
		MinedustryMain.LOGGER.debug("Blocks Successfully Registered !");
	}
}
