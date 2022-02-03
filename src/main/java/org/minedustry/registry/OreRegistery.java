package org.minedustry.registry;

import java.util.ArrayList;
import java.util.List;

import org.minedustry.References;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = References.MODID, bus = Bus.MOD)
public class OreRegistery
{
	public static final Ore PLATINUM = new Ore("platinum");
	public static final Ore COBALT = new Ore("cobalt");
	public static final Ore THORIUM = new Ore("thorium");



	public static final Ore TITANIUM = new Ore("titanium");

	public static final List<Ore> ORES = new ArrayList<>();

	static
	{
		register(PLATINUM);
		register(COBALT);
		register(THORIUM);
		register(TITANIUM);
	}

	public static void register(Ore ore)
	{
		ORES.add(ore);
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		for(Ore ore : ORES)
		{
			event.getRegistry().register(ore.getBlock());
		}
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		for(Ore ore : ORES)
		{
			event.getRegistry().registerAll(ore.getItem(), ore.getItemBlock().setRegistryName(References.getLoc(ore.getName() + "_block")));
		}
	}
}