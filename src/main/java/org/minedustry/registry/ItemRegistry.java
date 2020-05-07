package org.minedustry.registry;

import org.minedustry.MinedustryMain;
import org.minedustry.References;
import org.minedustry.items.ItemBlock;
import org.minedustry.utilities.Tabs;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(References.MODID)
@EventBusSubscriber(modid = References.MODID, bus = Bus.MOD)
public class ItemRegistry {
    
    public static final Item BIOFUEL_GENERATOR = new ItemBlock(BlockRegistry.BIOFUEL_GENERATOR, Tabs.MACHINES);
    
    
	@SubscribeEvent
	public static void registerTileEntities(RegistryEvent.Register<Item> event)
	{
		MinedustryMain.LOGGER.debug("Registering Items...");
		
		IForgeRegistry<Item> reg = event.getRegistry();
		
		OreRegistery.ORES.forEach(o -> {
			reg.register(o.getItem());
			reg.register(o.getItemBlock());
		});
		
		reg.register(BIOFUEL_GENERATOR);

		MinedustryMain.LOGGER.debug("Items Successfully Registered !");
	}
}
