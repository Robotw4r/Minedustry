package org.minedustry.tileentity.utils;

import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.INameable;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.common.extensions.IForgeTileEntity;
import net.minecraftforge.items.IItemHandlerModifiable;

/*
 * A simple useful class to mix IItemHandlerModifiable, INameable, INamedContainerProvider, ISidedInventory and IForgeTileEntity
 */
public interface ITileEntityMachine extends IItemHandlerModifiable, INameable, INamedContainerProvider, ISidedInventory, IForgeTileEntity
{
	@Override
	public ITextComponent getDisplayName();
}
