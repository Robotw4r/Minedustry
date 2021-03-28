package org.minedustry.container.utils;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.IIntArray;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EnergyContainer extends CommonContainer
{
	/**
	 * 0 = energy,
	 * 1 = capacity,
	 * 2 = max receive,
	 * 3 = max extract
	 */
	private IIntArray energyStorageData;

	public EnergyContainer(ContainerType<?> type, IIntArray energyStorageData, int id, int size)
	{
		super(type, id, size);
		this.energyStorageData = energyStorageData;
		this.trackIntArray(energyStorageData);
	}
	
	@OnlyIn(Dist.CLIENT)
	public int getEnergy()
	{
		return this.energyStorageData.get(0);
	}
	
	@OnlyIn(Dist.CLIENT)
	public int getEnergyCapacity()
	{
		return this.energyStorageData.get(1);
	}
	
	@OnlyIn(Dist.CLIENT)
	public int getMaxReceive()
	{
		return this.energyStorageData.get(2);
	}
	
	@OnlyIn(Dist.CLIENT)
	public int getMaxExtract()
	{
		return this.energyStorageData.get(3);
	}
}