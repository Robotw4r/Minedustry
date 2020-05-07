package org.minedustry.tileentity;

import java.util.Arrays;
import java.util.List;

import org.minedustry.container.ContainerBioFuelGenerator;
import org.minedustry.registry.TileEntityRegistry;
import org.minedustry.utilities.SlotsFacing;
import org.minedustry.utilities.energy.TileEntityEnergyStorage;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;

public class TileBioFuelGenerator extends TileEntityEnergyStorage
{
	private SlotsFacing slots = new SlotsFacing().setSlots(Direction.EAST, Arrays.asList(0, 1, 2));
	
	public TileBioFuelGenerator()
	{
		super(TileEntityRegistry.BIOFUEL_GENERATOR, 1000, 10, 10, 0);
	}
	
	@Override
	public int[] getSlotsForFace(Direction side)
	{
		List<Integer> l = this.slots.getSlots(side);
		int[] slots = new int[l.size()];
		for(Integer i : l)
			slots[i] = l.get(i);
		
		return slots;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, Direction direction)
	{
		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, Direction direction)
	{
		return false;
	}

	@Override
	public int getSizeInventory()
	{
		return 0;
	}

	@Override
	public boolean isEmpty()
	{
		return false;
	}

	@Override
	public ItemStack decrStackSize(int index, int count)
	{
		return null;
	}

	@Override
	public ItemStack removeStackFromSlot(int index)
	{
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack)
	{
		
	}

	@Override
	public boolean isUsableByPlayer(PlayerEntity player)
	{
		return false;
	}

	@Override
	public void clear()
	{
		
	}

	@Override
	public int getSlotLimit(int slot)
	{
		return 0;
	}

	@Override
	public int getSlots()
	{
		return 0;
	}

	@Override
	public Container createMenu(int guiId, PlayerInventory inv, PlayerEntity player)
	{
		return new ContainerBioFuelGenerator(guiId, inv, this.getPos());
	}	
}