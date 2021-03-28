package org.minedustry.screens.utils;

import java.util.List;

import org.minedustry.container.utils.EnergyContainer;
import org.minedustry.utilities.Bar;

import com.google.common.collect.Lists;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public abstract class EnergyContainerScreen<T extends EnergyContainer> extends ContainerScreen<T>
{
	private List<Bar> bars;
	
	public EnergyContainerScreen(T screenContainer, PlayerInventory inv, ITextComponent titleIn)
	{
		super(screenContainer, inv, titleIn);
		bars = Lists.newArrayList();
	}
	
	public void addBar(Bar bar)
	{
		bars.add(bar);
	}
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks)
	{
		super.render(mouseX, mouseY, partialTicks);
		bars.forEach(b -> b.render(mouseX, mouseY, partialTicks));
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		bars.forEach(b -> b.drawForegroundLayer());
	}
}