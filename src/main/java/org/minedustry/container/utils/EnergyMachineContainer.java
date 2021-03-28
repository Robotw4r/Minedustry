package org.minedustry.container.utils;

import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.IIntArray;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class EnergyMachineContainer extends EnergyContainer
{
	/**
	 * 0 = fuel time,
	 * 1 = work time,
	 * 2 = work time total
	 */
	private IIntArray machineData;
	
	public EnergyMachineContainer(ContainerType<?> type, IIntArray energyData, IIntArray machineData, int id, int size)
	{
		super(type, energyData, id, size);
		this.machineData = machineData;
		this.trackIntArray(machineData);
	}

	@OnlyIn(Dist.CLIENT)
	public int getFuelTime()
	{
		return this.machineData.get(0);
	}

	@OnlyIn(Dist.CLIENT)
	public int getWorkTime()
	{
		return this.machineData.get(1);
	}

	@OnlyIn(Dist.CLIENT)
	public int getWorkTimeTotal()
	{
		return this.machineData.get(2);
	}
}