package org.minedustry.registry;

import org.minedustry.References;
import org.minedustry.container.ContainerBioFuelGenerator;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = References.MODID, bus = Bus.MOD)
public class ContainerRegistry
{
	public static final ContainerType<ContainerBioFuelGenerator> BIO_FUEL_GENERATOR = null;
	
	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<ContainerType<?>> event)
	{
		event.getRegistry().register(IForgeContainerType.create((id, inv, data) -> new ContainerBioFuelGenerator(id, inv, data.readBlockPos())).setRegistryName(getLoc("bio_fuel_generator")));
	}
	
	private static ResourceLocation getLoc(String path)
	{
		return new ResourceLocation(References.MODID, path);
	}
}
