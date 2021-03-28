package org.minedustry.screens.utils;

import org.minedustry.container.utils.EnergyMachineSpecialContainer;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public abstract class MachineEnergySpecialContainerScreen<T extends EnergyMachineSpecialContainer> extends EnergyContainerScreen<T>
{
	public MachineEnergySpecialContainerScreen(T screenContainer, PlayerInventory inv, ITextComponent titleIn)
	{
		super(screenContainer, inv, titleIn);
	}
}