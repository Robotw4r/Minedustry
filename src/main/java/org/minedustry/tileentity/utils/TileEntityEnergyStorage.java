package org.minedustry.tileentity.utils;

import org.minedustry.utilities.NBTs;
import org.minedustry.utilities.SlotsFacing;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.IIntArray;
import net.minecraftforge.energy.IEnergyStorage;

public abstract class TileEntityEnergyStorage extends TileEntityStorage implements IEnergyStorage
{
	protected int energy;
	protected int capacity;
	protected int receiveCapacity;
	protected int extractCapacity;
	
	protected final IIntArray energyStorageData = new IIntArray()
	{
		public int get(int index)
		{
			switch (index)
			{
				case 0:
					return TileEntityEnergyStorage.this.energy;
				case 1:
					return TileEntityEnergyStorage.this.capacity;
				case 2:
					return TileEntityEnergyStorage.this.receiveCapacity;
				case 3:
					return TileEntityEnergyStorage.this.extractCapacity;
				default:
					return 0;
			}
		}

		public void set(int index, int value)
		{
			switch (index)
			{
				case 0:
					TileEntityEnergyStorage.this.energy = value;
					break;
				case 1:
					TileEntityEnergyStorage.this.capacity = value;
					break;
				case 2:
					TileEntityEnergyStorage.this.receiveCapacity = value;
					break;
				case 3:
					TileEntityEnergyStorage.this.extractCapacity = value;
			}
		}

		public int size()
		{
			return 4;
		}
	};

	public TileEntityEnergyStorage(TileEntityType<?> type, SlotsFacing slots, int capacity, int maxReceive, int maxExtract)
	{
		super(type, slots);
		this.capacity = capacity;
		this.receiveCapacity = maxReceive;
		this.extractCapacity = maxExtract;
		this.energy = 0;
	}

	@Override
	public int receiveEnergy(int maxReceive, boolean simulate)
	{
		if (!canReceive())
			return 0;

		int energyReceived = Math.min(capacity - energy, Math.min(this.receiveCapacity, maxReceive));
		if (!simulate)
			energy += energyReceived;
		return energyReceived;
	}

	@Override
	public int extractEnergy(int maxExtract, boolean simulate)
	{
		if (!canExtract())
			return 0;

		int energyExtracted = Math.min(energy, Math.min(this.extractCapacity, maxExtract));
		if (!simulate)
			energy -= energyExtracted;
		return energyExtracted;
	}
	
	public abstract int requiredEnergy();
	
	public boolean hasEnoughEnergy()
	{
		return this.energy >= this.requiredEnergy();
	}

	public void setEnergy(int energy)
	{
		this.energy = energy;
	}

	private void setCapacity(int capacity)
	{
		this.capacity = capacity;
	}

	private int getMaxExtract()
	{
		return extractCapacity;
	}

	private int getMaxReceive()
	{
		return receiveCapacity;
	}

	@Override
	public int getEnergyStored()
	{
		return energy;
	}

	@Override
	public int getMaxEnergyStored()
	{
		return capacity;
	}

	@Override
	public boolean canExtract()
	{
		return this.extractCapacity > 0;
	}

	@Override
	public boolean canReceive()
	{
		return this.receiveCapacity > 0;
	}

	@Override
	public CompoundNBT write(CompoundNBT compound)
	{
		super.write(compound);

		compound.putInt(NBTs.ENERGY, getEnergyStored());
		compound.putInt(NBTs.MAX_ENERGY, getMaxEnergyStored());
		compound.putInt(NBTs.MAX_EXTRACT, getMaxExtract());
		compound.putInt(NBTs.MAX_INSERT, getMaxReceive());
		return compound;
	}

	@Override
	public void read(CompoundNBT compound)
	{
		super.read(compound);

		setEnergy(compound.getInt(NBTs.ENERGY));
		setCapacity(compound.getInt(NBTs.MAX_ENERGY));
		this.extractCapacity = compound.getInt(NBTs.MAX_EXTRACT);
		this.receiveCapacity = compound.getInt(NBTs.MAX_INSERT);
	}
}