package org.minedustry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.minedustry.packets.NetworkManager;
import org.minedustry.registry.BlockRegistry;
import org.minedustry.registry.ClientRegistry;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(References.MODID)
public class MinedustryMain
{
	public static final Logger LOGGER = LogManager.getLogger(References.MODNAME);

	public MinedustryMain()
	{
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		BlockRegistry.BLOCKS.register(bus);
		
		bus.addListener(this::setup);
		bus.addListener(this::doClientStuff);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event)
	{
		NetworkManager.initNetwork();
		NetworkManager.registerMessages();
	}

	private void doClientStuff(final FMLClientSetupEvent event)
	{
		new ClientRegistry();
	}
}
