package org.minedustry.container.utils;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.IIntArray;

public abstract class EnergyMachineSpecialContainer extends EnergyMachineContainer
{
	/**
	 * 0 = stored material value,
	 * 1 = material storage capacity
	 */
	protected IIntArray specialStorageData;
	
	public EnergyMachineSpecialContainer(ContainerType<?> type, IIntArray energyData, IIntArray machineData, IIntArray specialStorageData, int id, int size)
	{
		super(type, energyData, machineData, id, size);
		this.specialStorageData = specialStorageData;
		this.trackIntArray(specialStorageData);
	}
	
	public int getStoredMaterialValue()
	{
		return this.specialStorageData.get(0);
	}
	
	public int getMaterialStorageCapacity()
	{
		return this.specialStorageData.get(1);
	}
}
