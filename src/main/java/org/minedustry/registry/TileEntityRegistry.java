package org.minedustry.registry;

import org.minedustry.MinedustryMain;
import org.minedustry.References;
import org.minedustry.tileentity.TileBioFuelGenerator;

import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(References.MODID)
@EventBusSubscriber(modid = References.MODID, bus = Bus.MOD)
public class TileEntityRegistry
{
	public static final TileEntityType<TileBioFuelGenerator> BIO_FUEL_GENERATOR = null;
	
	@SubscribeEvent
	public static void registerTileEntities(RegistryEvent.Register<TileEntityType<?>> event)
	{
		MinedustryMain.LOGGER.debug("Registering Tile Entities...");
		
		event.getRegistry().register(TileEntityType.Builder.create(TileBioFuelGenerator::new, BlockRegistry.BIOFUEL_GENERATOR).build(null).setRegistryName(getLoc("bio_fuel_generator")));

		MinedustryMain.LOGGER.debug("Tile Entities Successfully Registered !");
	}
	
	private static ResourceLocation getLoc(String path)
	{
		return new ResourceLocation(References.MODID, path);
	}
}
