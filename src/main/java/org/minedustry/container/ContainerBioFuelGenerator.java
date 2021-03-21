package org.minedustry.container;

import org.minedustry.container.utils.CommonContainer;
import org.minedustry.registry.ContainerRegistry;
import org.minedustry.tileentity.utils.TileEntityStorage;

import net.minecraft.client.gui.IHasContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerBioFuelGenerator extends CommonContainer implements IHasContainer<ContainerBioFuelGenerator>
{
	public TileEntityStorage tile;

	@SuppressWarnings("resource")
	public ContainerBioFuelGenerator(int id, PlayerInventory playerInv, BlockPos pos)
	{
		super(ContainerRegistry.BIOFUEL_GENERATOR, id, ((TileEntityStorage) playerInv.player.getEntityWorld().getTileEntity(pos)).tileInventory.getSlots());
		
		final TileEntity tile = playerInv.player.getEntityWorld().getTileEntity(pos);

		if(tile instanceof TileEntityStorage)
		{
			final TileEntityStorage storage = (TileEntityStorage) tile;
			this.tile = storage;

			this.addSlot(new SlotItemHandler(storage, 0, 98, 23));
			this.bindPlayerInventory(playerInv, 7, 83);
		}
	}

	public void bindPlayerInventory(PlayerInventory inv, int x, int y)
	{
		for (int x1 = 0; x1 < 3; ++x1)
		{
			for (int y1 = 0; y1 < 9; ++y1)
			{
				this.addSlot(new Slot(inv, y1 + x1 * 9 + 9, x + 1 + y1 * 18, y + 1 + x1 * 18));
			}
		}

		for (int i = 0; i < 9; i++)
		{
			this.addSlot(new Slot(inv, i, x + 1 + i * 18, y + 59));
		}
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn)
	{
		return true;
	}

	@Override
	public ContainerBioFuelGenerator getContainer()
	{
		return this;
	}
}