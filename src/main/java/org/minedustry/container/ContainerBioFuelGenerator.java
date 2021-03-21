package org.minedustry.container;

import org.minedustry.container.utils.EnergyContainer;
import org.minedustry.registry.ContainerRegistry;
import org.minedustry.tileentity.TileBioFuelGenerator;
import org.minedustry.tileentity.utils.TileEntityStorage;

import net.minecraft.client.gui.IHasContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerBioFuelGenerator extends EnergyContainer implements IHasContainer<ContainerBioFuelGenerator>
{
	public TileBioFuelGenerator tile;
	public PlayerEntity player;
	
	public ContainerBioFuelGenerator(int id, PlayerInventory playerInv, BlockPos pos)
	{
		this(id, playerInv, new IntArray(4), pos);
	}

	public ContainerBioFuelGenerator(int id, PlayerInventory playerInv, IIntArray intArray, BlockPos pos)
	{
		super(ContainerRegistry.BIOFUEL_GENERATOR.get(), intArray, id, ((TileEntityStorage) playerInv.player.getEntityWorld().getTileEntity(pos)).tileInventory.getSlots());

		final TileEntity tile = playerInv.player.getEntityWorld().getTileEntity(pos);
		this.player = playerInv.player;

		if (tile instanceof TileBioFuelGenerator)
		{
			final TileBioFuelGenerator storage = (TileBioFuelGenerator) tile;
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
		return this.tile.isUsableByPlayer(playerIn);
	}

	@Override
	public ContainerBioFuelGenerator getContainer()
	{
		return this;
	}
}