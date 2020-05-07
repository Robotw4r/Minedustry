package org.minedustry.registry;

import org.minedustry.MinedustryMain;
import org.minedustry.References;
import org.minedustry.blocks.BiofuelGeneratorBlock;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(References.MODID)
@EventBusSubscriber(modid = References.MODID, bus = Bus.MOD)
public class BlockRegistry {
    
    public static final Block BIOFUEL_GENERATOR = new BiofuelGeneratorBlock();
	
	@SubscribeEvent
	public static void registerTileEntities(RegistryEvent.Register<Block> event)
	{
		MinedustryMain.LOGGER.debug("Registering Blocks...");
		
		IForgeRegistry<Block> reg = event.getRegistry();
		
		OreRegistery.ORES.forEach(o -> reg.register(o.getBlock()));
		
		reg.register(BIOFUEL_GENERATOR);
		
		MinedustryMain.LOGGER.debug("Blocks Successfully Registered !");
	}
}
