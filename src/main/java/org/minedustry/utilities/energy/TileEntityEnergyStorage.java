package org.minedustry.utilities.energy;

import org.minedustry.tileentity.TileEntityStorage;
import org.minedustry.utilities.NBTs;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.energy.IEnergyStorage;

public abstract class TileEntityEnergyStorage extends TileEntityStorage implements IEnergyStorage, INBTSerializable<CompoundNBT>
{
    protected int energy;
    protected int capacity;
    protected int maxReceive;
    protected int maxExtract;

    public TileEntityEnergyStorage(TileEntityType<?> type, int capacity, int maxReceive, int maxExtract, int energy)
    {
    	super(type);
        this.capacity = capacity;
        this.maxReceive = maxReceive;
        this.maxExtract = maxExtract;
        this.energy = Math.max(0 , Math.min(capacity, energy));
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate)
    {
        if (!canReceive())
            return 0;

        int energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));
        if (!simulate)
            energy += energyReceived;
        return energyReceived;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate)
    {
        if (!canExtract())
            return 0;

        int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));
        if (!simulate)
            energy -= energyExtracted;
        return energyExtracted;
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
        return this.maxExtract > 0;
    }

    @Override
    public boolean canReceive()
    {
        return this.maxReceive > 0;
    }
    
    @Override
	public CompoundNBT serializeNBT()
	{
		CompoundNBT tag = new CompoundNBT();
		tag.putInt(NBTs.ENERGY, getEnergyStored());
		tag.putInt(NBTs.MAX_ENERGY, getMaxEnergyStored());
		tag.putInt(NBTs.MAX_EXTRACT, getMaxExtract());
		tag.putInt(NBTs.MAX_INSERT, getMaxReceive());
		return tag;
	}

	@Override
	public void deserializeNBT(CompoundNBT nbt)
	{
		setEnergy(nbt.getInt(NBTs.ENERGY));
		setCapacity(nbt.getInt(NBTs.MAX_ENERGY));
		this.maxExtract = nbt.getInt(NBTs.MAX_EXTRACT);
		this.maxReceive = nbt.getInt(NBTs.MAX_INSERT);		
	}
}
