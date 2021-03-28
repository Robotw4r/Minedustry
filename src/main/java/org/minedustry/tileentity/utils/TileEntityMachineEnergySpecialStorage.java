package org.minedustry.tileentity.utils;

import org.minedustry.utilities.NBTs;
import org.minedustry.utilities.SlotsFacing;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.IIntArray;
import net.minecraft.util.ResourceLocation;

public abstract class TileEntityMachineEnergySpecialStorage extends TileEntityMachineEnergyStorage
{
	protected ResourceLocation storedMaterial;
	
	protected int storedMaterialValue;
	protected int materialStorageCapacity;
	
	protected IIntArray specialStorageData = new IIntArray()
	{		
		@Override
		public void set(int index, int value)
		{
			switch(index)
			{
				case 0:
					TileEntityMachineEnergySpecialStorage.this.storedMaterialValue = value;
					break;
				case 1:
					TileEntityMachineEnergySpecialStorage.this.materialStorageCapacity = value;
					break;
			}
		}
		
		@Override
		public int get(int index)
		{
			switch(index)
			{
				case 0:
					return TileEntityMachineEnergySpecialStorage.this.storedMaterialValue;
				case 1:
					return TileEntityMachineEnergySpecialStorage.this.materialStorageCapacity;
				default:
					return 0;
			}
		}
		
		@Override
		public int size()
		{
			return 2;
		}
	};
	
	public TileEntityMachineEnergySpecialStorage(TileEntityType<?> type, SlotsFacing slots, int capacity, int maxReceive, int maxExtract, ResourceLocation loc, int maxSpecialStorageCapacity)
	{
		super(type, slots, capacity, maxReceive, maxExtract);
		this.storedMaterial = loc;
		this.materialStorageCapacity = maxSpecialStorageCapacity;
	}
	
	public boolean hasSpecialSpace(int space)
	{
		return this.storedMaterialValue + space <= this.materialStorageCapacity;
	}
	
	public ResourceLocation getStoredMaterial()
	{
		return this.storedMaterial;
	}
	
	public void setStoredMaterial(ResourceLocation loc)
	{
		this.storedMaterial = loc;
	}
	
	public int getStoredMaterialValue()
	{
		return this.storedMaterialValue;
	}
	
	public void setStoredMaterialValue(int value)
	{
		this.storedMaterialValue = value;
	}
	
	public void addStoredMaterial(int value)
	{
		this.storedMaterialValue += value;
		
		if(!checkSpecialCapacity()) this.storedMaterialValue = this.materialStorageCapacity;
	}
	
	public boolean checkSpecialCapacity()
	{
		return this.storedMaterialValue < materialStorageCapacity;
	}
	
	public int getMaterialStorageCapacity()
	{
		return this.materialStorageCapacity;
	}
	
	public void setMaterialStorageCapacity(int capacity)
	{
		this.materialStorageCapacity = capacity;
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound)
	{
		compound.putString(NBTs.SPECIAL_STORAGE, this.storedMaterial.toString());
		compound.putInt(NBTs.SPECIAL_STORAGE_VALUE, this.storedMaterialValue);
		compound.putInt(NBTs.SPECIAL_STORAGE_CAPACITY, this.materialStorageCapacity);
		return super.write(compound);
	}
	
	@Override
	public void read(CompoundNBT compound)
	{
		this.setStoredMaterial(ResourceLocation.create(compound.getString(NBTs.SPECIAL_STORAGE), ':'));
		this.setStoredMaterialValue(compound.getInt(NBTs.SPECIAL_STORAGE_VALUE));
		this.setMaterialStorageCapacity(compound.getInt(NBTs.SPECIAL_STORAGE_CAPACITY));
		super.read(compound);
	}
}