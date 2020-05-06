package org.minedustry.tileentity;

import org.minedustry.container.ContainerBioFuelGenerator;
import org.minedustry.registry.TileEntityRegistry;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;

public class TileBioFuelGenerator extends TileEntityStorage
{
	public TileBioFuelGenerator()
	{
		super(TileEntityRegistry.BIOFUEL_GENERATOR);
	}
	
	@Override
	public int[] getSlotsForFace(Direction side)
	{
		return null;
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