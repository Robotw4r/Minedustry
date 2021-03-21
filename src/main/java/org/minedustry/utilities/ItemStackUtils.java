package org.minedustry.utilities;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class ItemStackUtils
{
	/**
	 * Method from {@link ItemstackHelper.getAndSplit()} with a {@link ItemStackHandler}
	 */
	public static ItemStack getAndSplit(ItemStackHandler inv, int index, int amount)
	{
		return index >= 0 && index < inv.getSlots() && !inv.getStackInSlot(index).isEmpty() && amount > 0 ? inv.getStackInSlot(index).split(amount) : ItemStack.EMPTY;
	}
	
	/**
	 * Method from {@link ItemstackHelper.getAndRemove()} with a {@link ItemStackHandler}
	 */
	public static ItemStack getAndRemove(ItemStackHandler inv, int index)
	{
		if(index >= 0 && index < inv.getSlots())
		{
			inv.setStackInSlot(index, ItemStack.EMPTY);
		}
		
		return ItemStack.EMPTY;
	}
}
