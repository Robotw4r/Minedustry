package org.minedustry.screens.utils;

import org.minedustry.container.utils.EnergyMachineContainer;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public abstract class MachineEnergyContainerScreen<T extends EnergyMachineContainer> extends EnergyContainerScreen<T>
{
	public MachineEnergyContainerScreen(T screenContainer, PlayerInventory inv, ITextComponent titleIn)
	{
		super(screenContainer, inv, titleIn);
	}

}
