package org.minedustry.utilities;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.energy.EnergyStorage;

public class CustomEnergyStorage extends EnergyStorage implements INBTSerializable<CompoundNBT>
{
	public CustomEnergyStorage(int capacity, int maxTransfer)
	{
		super(capacity, maxTransfer);
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
		return maxExtract;
	}
	
	private int getMaxReceive()
	{
		return maxReceive;
	}

	public void addEnergy(int energy)
	{
		this.energy += energy;
		if (this.energy > this.capacity)
		{
			this.energy = this.capacity;
		}
	}

	public void consumeEnergy(int energy)
	{
		this.energy -= energy;
		if (this.energy < 0)
		{
			this.energy = 0;
		}
	}

	@Override
	public CompoundNBT serializeNBT()
	{
		CompoundNBT tag = new CompoundNBT();
		tag.putInt("Energy", getEnergyStored());
		tag.putInt("Capacity", getMaxEnergyStored());
		tag.putInt("ExtractCapacity", getMaxExtract());
		tag.putInt("InsertCapacity", getMaxReceive());
		return tag;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt)
	{
		setEnergy(nbt.getInt("Energy"));
		setCapacity(nbt.getInt("Capacity"));
		this.maxExtract = nbt.getInt("ExtractCapacity");
		this.maxReceive = nbt.getInt("InsertCapacity");		
	}
}
