package org.minedustry.tileentity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.items.ItemStackHandler;

public abstract class TileEntityStorage extends TileEntity implements ITileEntityMachine
{
	private final ItemStackHandler tileInventory = new ItemStackHandler(this.getSlots())
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

	public TileEntityStorage(TileEntityType<?> type)
	{
		super(type);
	}

	@Override
	public void read(CompoundNBT compound)
	{
		super.read(compound);
		this.tileInventory.deserializeNBT(compound);
		this.name = new StringTextComponent(compound.getString("CustomName"));
	}

	@Override
	public CompoundNBT write(CompoundNBT compound)
	{
		compound.merge(this.tileInventory.serializeNBT());
		compound.putString("CustomName", this.getName().getFormattedText());
		return super.write(compound);
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
	public boolean isItemValid(int slot, @Nonnull ItemStack stack)
	{
		return true;
	}

	@Override
	public abstract int getSlotLimit(int slot);

	@Override
	public abstract int getSlots();

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
}
