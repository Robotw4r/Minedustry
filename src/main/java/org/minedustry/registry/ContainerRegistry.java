package org.minedustry.registry;

import org.minedustry.References;
import org.minedustry.container.ContainerBioFuelGenerator;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@EventBusSubscriber(modid = References.MODID, bus = Bus.MOD)
public class ContainerRegistry
{
	public static final DeferredRegister<ContainerType<?>> CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS, References.MODID);
	
	public static final RegistryObject<ContainerType<ContainerBioFuelGenerator>> BIOFUEL_GENERATOR = CONTAINERS.register("biofuel_generator", () -> IForgeContainerType.create((id, inv, data) -> new ContainerBioFuelGenerator(id, inv, data.readBlockPos())));
}