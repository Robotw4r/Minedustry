package org.minedustry.tileentity;

import java.util.Arrays;

import org.minedustry.References;
import org.minedustry.container.ContainerBioFuelGenerator;
import org.minedustry.registry.TileEntityRegistry;
import org.minedustry.tileentity.utils.TileEntityMachineEnergySpecialStorage;
import org.minedustry.utilities.SlotsFacing;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Direction;

public class TileBioFuelGenerator extends TileEntityMachineEnergySpecialStorage implements ITickableTileEntity
{
	private static final SlotsFacing SLOTS = new SlotsFacing().setSlots(Direction.EAST, Arrays.asList(0, 1, 2));
	
	public TileBioFuelGenerator()
	{
		super(TileEntityRegistry.BIOFUEL_GENERATOR.get(), SLOTS, 1000, 10, 10, References.getLoc("bio_fuel_fluid"), 1000);
	}
	
	@Override
	public int getInventorySize()
	{
		return 10;
	}
	
	@Override
	public void tick()
	{
		if(!this.tileInventory.getStackInSlot(0).isEmpty() && !this.hasFuel())// && this.hasEnoughEnergy()) // Test for energy storage
		{
			this.tileInventory.getStackInSlot(0).shrink(1);
			this.fuelTime = 1200;
			this.energy = capacity / 2;
		}
		
		if(this.hasFuel() && checkSpecialCapacity())// && this.hasEnoughEnergy())
		{
			this.fuelTime--;
			this.addStoredMaterial(3);
		}
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound)
	{
		return super.write(compound);
	}
	
	@Override
	public void read(CompoundNBT compound)
	{
		super.read(compound);
	}
	
	@Override
	public Container createMenu(int guiId, PlayerInventory inv, PlayerEntity player)
	{
		return new ContainerBioFuelGenerator(guiId, inv, this.energyStorageData, this.machineData, this.specialStorageData, this.getPos());
	}

	@Override
	public boolean isItemValid(int slot, ItemStack stack)
	{
		return true;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, Direction direction)
	{
		return true;
	}

	@Override
	public boolean isUsableByPlayer(PlayerEntity player)
	{
		return true;
	}
	
	@Override
	public int requiredEnergy()
	{
		return 10;
	}
}