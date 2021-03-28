package org.minedustry.tileentity.utils;

import org.minedustry.utilities.NBTs;
import org.minedustry.utilities.SlotsFacing;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.IIntArray;

public abstract class TileEntityMachineEnergyStorage extends TileEntityEnergyStorage
{
	protected int fuelTime;
	protected int workTime;
	protected int workTimeTotal;
	
	protected final IIntArray machineData = new IIntArray()
	{
		@Override
		public int get(int index)
		{
			switch(index)
			{
				case 0:
					return TileEntityMachineEnergyStorage.this.fuelTime;
				case 1:
					return TileEntityMachineEnergyStorage.this.workTime;
				case 2:
					return TileEntityMachineEnergyStorage.this.workTimeTotal;
				default:
					return 0;
			}
		}

		@Override
		public void set(int index, int value)
		{
			switch(index)
			{
				case 0:
					TileEntityMachineEnergyStorage.this.fuelTime = value;
				case 1:
					TileEntityMachineEnergyStorage.this.workTime = value;
				case 2:
					TileEntityMachineEnergyStorage.this.workTimeTotal = value;
			}
		}

		@Override
		public int size()
		{
			return 3;
		}
		
	};
	
	public TileEntityMachineEnergyStorage(TileEntityType<?> type, SlotsFacing slots, int capacity, int maxReceive, int maxExtract)
	{
		super(type, slots, capacity, maxReceive, maxExtract);
	}
	
	public int getFuelTime()
	{
		return this.fuelTime;
	}
	
	public boolean hasFuel()
	{
		return this.fuelTime > 0;
	}
	
	public void setFuelTime(int fuelTime)
	{
		this.fuelTime = fuelTime;
	}
	
	public void addFuelTime(int fuelTime)
	{
		this.fuelTime += fuelTime;
	}
	
	public int getWorkTime()
	{
		return this.workTime;
	}
	
	public void setWorkTime(int workTime)
	{
		this.workTime = workTime;
	}
	
	public int getWorkTimeTotal()
	{
		return this.workTimeTotal;
	}
	
	public void setWorkTimeTotal(int workTimeTotal)
	{
		this.workTimeTotal = workTimeTotal;
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound)
	{
		compound.putInt(NBTs.FUEL_TIME, this.fuelTime);
		compound.putInt(NBTs.WORK_TIME, this.workTime);
		compound.putInt(NBTs.WORK_TIME_TOTAL, this.workTimeTotal);
		return super.write(compound);
	}
	
	@Override
	public void read(CompoundNBT compound)
	{
		this.setFuelTime(compound.getInt(NBTs.FUEL_TIME));
		this.setWorkTime(compound.getInt(NBTs.WORK_TIME));
		this.setWorkTimeTotal(compound.getInt(NBTs.WORK_TIME_TOTAL));
		super.read(compound);
	}
}