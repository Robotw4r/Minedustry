package org.minedustry.container;

import org.minedustry.container.utils.EnergyMachineSpecialContainer;
import org.minedustry.registry.ContainerRegistry;
import org.minedustry.tileentity.TileBioFuelGenerator;
import org.minedustry.tileentity.utils.TileEntityStorage;

import net.minecraft.client.gui.IHasContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerBioFuelGenerator extends EnergyMachineSpecialContainer implements IHasContainer<EnergyMachineSpecialContainer>
{
	public TileBioFuelGenerator tile;
	
	public ContainerBioFuelGenerator(int id, PlayerInventory playerInv, BlockPos pos)
	{
		this(id, playerInv, new IntArray(4), new IntArray(3), new IntArray(2), pos);
	}

	public ContainerBioFuelGenerator(int id, PlayerInventory playerInv, IIntArray energyData, IIntArray machineData, IIntArray specialStorageData, BlockPos pos)
	{
		super(ContainerRegistry.BIOFUEL_GENERATOR.get(), energyData, machineData, specialStorageData, id, ((TileEntityStorage) playerInv.player.getEntityWorld().getTileEntity(pos)).tileInventory.getSlots());

		final TileEntity tile = playerInv.player.getEntityWorld().getTileEntity(pos);

		if(tile instanceof TileBioFuelGenerator)
		{
			final TileBioFuelGenerator storage = (TileBioFuelGenerator) tile;
			this.tile = storage;

			this.addSlot(new SlotItemHandler(storage, 0, 98, 23));
			this.bindPlayerInventory(playerInv, 7, 83);
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