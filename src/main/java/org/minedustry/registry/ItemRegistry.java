package org.minedustry.registry;

import org.minedustry.MinedustryMain;
import org.minedustry.References;
import org.minedustry.items.ItemBase;
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
public class ItemRegistry
{
	public static final Item PLATINUM_INGOT = new ItemBase("platinum_ingot");
	public static final Item COBALT_INGOT = new ItemBase("cobalt_ingot");
    public static final Item THORIUM_INGOT = new ItemBase("thorium_ingot");
    public static final Item BISMUTH_CHUNK = new ItemBase("bismuth_chunk");
    
    public static final Item PLATINUM_BLOCK = new ItemBlock(BlockRegistry.PLATINUM_BLOCK);
    public static final Item COBALT_BLOCK = new ItemBlock(BlockRegistry.COBALT_BLOCK);
    public static final Item THORIUM_BLOCK = new ItemBlock(BlockRegistry.THORIUM_BLOCK);
    public static final Item BISMUTH_BLOCK = new ItemBlock(BlockRegistry.BISMUTH_BLOCK);
    
    public static final Item BIOFUEL_GENERATOR = new ItemBlock(BlockRegistry.BIOFUEL_GENERATOR, Tabs.MACHINES);
    
    
	@SubscribeEvent
	public static void registerTileEntities(RegistryEvent.Register<Item> event)
	{
		MinedustryMain.LOGGER.debug("Registering Items...");
		
		IForgeRegistry<Item> reg = event.getRegistry();
		
		reg.register(PLATINUM_INGOT);
		reg.register(COBALT_INGOT);
		reg.register(THORIUM_INGOT);
		reg.register(BISMUTH_CHUNK);
		
		reg.register(PLATINUM_BLOCK);
		reg.register(COBALT_BLOCK);
		reg.register(THORIUM_BLOCK);
		reg.register(BISMUTH_BLOCK);
		
		reg.register(BIOFUEL_GENERATOR);

		MinedustryMain.LOGGER.debug("Items Successfully Registered !");
	}
}
