package org.minedustry.tileentity;

import java.util.Arrays;

import org.minedustry.container.ContainerBioFuelGenerator;
import org.minedustry.registry.TileEntityRegistry;
import org.minedustry.tileentity.utils.TileEntityEnergyStorage;
import org.minedustry.utilities.SlotsFacing;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;

public class TileBioFuelGenerator extends TileEntityEnergyStorage
{
	private static SlotsFacing SLOTS = new SlotsFacing().setSlots(Direction.EAST, Arrays.asList(0, 1, 2));

	public TileBioFuelGenerator()
	{
		super(TileEntityRegistry.BIOFUEL_GENERATOR, SLOTS, 1000, 10, 10, 0);
		this.tileInventory.setSize(10);
	}
	
	@Override
	public Container createMenu(int guiId, PlayerInventory inv, PlayerEntity player)
	{
		return new ContainerBioFuelGenerator(guiId, inv, this.energyStorageData, this.getPos());
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
}