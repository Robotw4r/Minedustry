package org.minedustry.tileentity.utils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.minedustry.utilities.ItemStackUtils;
import org.minedustry.utilities.SlotsFacing;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.items.ItemStackHandler;

public abstract class TileEntityStorage extends TileEntity implements ITileEntityMachine
{
	public final ItemStackHandler tileInventory = new ItemStackHandler(this.getSlots())
	{
		@Override
		public int getSlotLimit(int slot)
		{
			return TileEntityStorage.this.getSlotLimit(slot);
		}

		@Override
		public boolean isItemValid(int slot, @Nonnull ItemStack stack)
		{
			return TileEntityStorage.this.isItemValid(slot, stack);
		}
	};
	
	private ITextComponent name;
	private SlotsFacing slots;

	public TileEntityStorage(TileEntityType<?> type, SlotsFacing slots)
	{
		super(type);
		this.slots = slots;
	}

	@Override
	public void read(CompoundNBT compound)
	{
		super.read(compound);
		this.tileInventory.deserializeNBT(compound.getCompound("Inventory"));
		this.name = new StringTextComponent(compound.getString("CustomName"));
	}

	@Override
	public CompoundNBT write(CompoundNBT compound)
	{
		super.write(compound);
		compound.put("Inventory", this.tileInventory.serializeNBT());
		compound.putString("CustomName", this.getName().getFormattedText());
		return compound;
	}

	@Override
	public void setStackInSlot(int slot, @Nonnull ItemStack stack)
	{
		this.tileInventory.setStackInSlot(slot, stack);
	}

	@Nonnull
	@Override
	public ItemStack getStackInSlot(int slot)
	{
		return this.tileInventory.getStackInSlot(slot);
	}

	@Nonnull
	@Override
	public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate)
	{
		return this.tileInventory.insertItem(slot, stack, simulate);
	}

	@Nonnull
	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate)
	{
		return this.tileInventory.extractItem(slot, amount, simulate);
	}

	@Override
	public abstract boolean isItemValid(int slot, @Nonnull ItemStack stack);

	@Nullable
	@Override
	public abstract Container createMenu(int guiId, PlayerInventory inv, PlayerEntity player);

	@Override
	public ITextComponent getName()
	{
		return this.name == null ? this.getWorld().getBlockState(this.pos).getBlock().getNameTextComponent() : this.name;
	}

	@Override
	public boolean hasCustomName()
	{
		return this.name != null;
	}

	@Override
	public ITextComponent getDisplayName()
	{
		return this.getName();
	}

	public void setCustomName(ITextComponent text)
	{
		this.name = text;
	}

	@Override
	public int[] getSlotsForFace(Direction side)
	{
		return this.slots.getSlots(side).stream().mapToInt(Integer::intValue).toArray();
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, Direction direction)
	{
		if(getSlotsForFace(direction).length > 0 && this.tileInventory.isItemValid(index, itemStackIn))
		{
			return true;
		}
		
		return false;
	}

	@Override
	public abstract boolean canExtractItem(int index, ItemStack stack, Direction direction);

	@Override
	public int getSizeInventory()
	{
		return this.tileInventory.getSlots();
	}

	@Override
	public boolean isEmpty()
	{
		for(int i = 0; i < this.tileInventory.getSlots(); i++)
		{
			if(!this.tileInventory.getStackInSlot(i).isEmpty())
			{
				return false;
			}
		}
		
		return true;
	}

	@Override
	public ItemStack decrStackSize(int index, int count)
	{
		return ItemStackUtils.getAndSplit(tileInventory, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index)
	{
		return ItemStackUtils.getAndRemove(tileInventory, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack)
	{
		this.tileInventory.setStackInSlot(index, stack);
	}

	@Override
	public abstract boolean isUsableByPlayer(PlayerEntity player);

	@Override
	public void clear()
	{
		for(int i = 0; i < this.tileInventory.getSlots(); i++)
		{
			this.tileInventory.setStackInSlot(i, ItemStack.EMPTY);
		}
	}

	@Override
	public int getSlotLimit(int slot)
	{
		return 64;
	}
	
	@Override
	public int getSlots()
	{
		return 10;
	}
}