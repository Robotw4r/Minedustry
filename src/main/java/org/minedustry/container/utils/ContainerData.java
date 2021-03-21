package org.minedustry.container.utils;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class ContainerData extends Container
{
	private Map<String, Integer> clientData = new HashMap<String, Integer>();
	
	protected ContainerData(ContainerType<?> type, int id)
	{
		super(type, id);
	}
	
	@OnlyIn(Dist.CLIENT)
	public Map<String, Integer> getClientData()
	{
		return clientData;
	}
	
	@OnlyIn(Dist.CLIENT)
	public void setClientData(Map<String, Integer> map)
	{
		this.clientData = map;
	}
}
