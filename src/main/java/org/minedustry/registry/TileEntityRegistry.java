package org.minedustry.registry;

import org.minedustry.References;
import org.minedustry.tileentity.TileBioFuelGenerator;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityRegistry
{
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, References.MODID);

	public static final RegistryObject<TileEntityType<TileBioFuelGenerator>> BIOFUEL_GENERATOR = TILE_ENTITIES.register("biofuel_generator", () -> TileEntityType.Builder.create(TileBioFuelGenerator::new, BlockRegistry.BIOFUEL_GENERATOR.get()).build(null));
}
