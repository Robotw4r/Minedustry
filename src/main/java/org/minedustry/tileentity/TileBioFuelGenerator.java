package org.minedustry.tileentity;

import org.minedustry.registry.TileEntityRegistry;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;

public class TileBioFuelGenerator extends TileEntityStorage
{	
	public TileBioFuelGenerator()
	{
		super(TileEntityRegistry.BIO_FUEL_GENERATOR);
	}
	
	@Override
	public int[] getSlotsForFace(Direction side)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, Direction direction)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, Direction direction)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSizeInventory()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack decrStackSize(int index, int count)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack removeStackFromSlot(int index)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUsableByPlayer(PlayerEntity player)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSlotLimit(int slot)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSlots()
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
}