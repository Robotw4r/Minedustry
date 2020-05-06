package org.minedustry.registry;

import org.minedustry.MinedustryMain;
import org.minedustry.References;
import org.minedustry.container.ContainerBioFuelGenerator;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = References.MODID, bus = Bus.MOD)
public class ContainerRegistry
{
	public static final ContainerType<ContainerBioFuelGenerator> BIOFUEL_GENERATOR = IForgeContainerType.create((id, inv, data) -> new ContainerBioFuelGenerator(id, inv, data.readBlockPos()));
	
	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<ContainerType<?>> event)
	{
		MinedustryMain.LOGGER.debug("Registering Containers...");
		
		event.getRegistry().register(BIOFUEL_GENERATOR.setRegistryName(References.getLoc("biofuel_container")));

		MinedustryMain.LOGGER.debug("Containers Successfully Registered !");
	}
}