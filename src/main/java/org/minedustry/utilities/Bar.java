package org.minedustry.utilities;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

import org.minedustry.References;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;

public abstract class Bar
{
	Minecraft mc = Minecraft.getInstance();
	private ContainerScreen<?> parent;
	
	protected int barX, barY, barWidth, barHeight;
	protected boolean isHorizontal;
	protected List<String> tooltip;
	
	private int currentValue;
	private int maxValue;
	
	public Bar(ContainerScreen<?> parent, int x, int y, int width, int height, boolean isHorizontal, @Nullable List<String> tooltip)
	{
		this.parent = parent;
		this.barX = x;
		this.barY = y;
		this.barWidth = width;
		this.barHeight = height;
		this.isHorizontal = isHorizontal;
		this.tooltip = tooltip;
	}
	
	public abstract void drawBar();
	
	public void drawForegroundLayer()
	{
		if(this.isBarSet())
		{
			this.drawBar();
		}
	}
	
	public void updateValue(int value, int maxValue)
	{
		this.currentValue = value;
		this.maxValue = maxValue;
	}
	
	public void updateTooltip(List<String> tooltip)
	{
		this.tooltip = tooltip;
	}
	
	public void updateTooltip(String tooltip)
	{
		this.tooltip = Arrays.asList(tooltip);
	}
	
	public void render(int mouseX, int mouseY, float partialTicks)
	{		
		if(isInRectangle(mouseX, mouseY, barX, barY, barWidth, barHeight))
		{
			if(tooltip != null && !tooltip.isEmpty())
				this.parent.renderTooltip(tooltip, mouseX, mouseY, mc.fontRenderer);
			else
				this.parent.renderTooltip(References.getTranslate("screen.bar.default", this.getCurrentValue(), this.getMaxValue()), mouseX, mouseY);
		}
	}
	
	public boolean isInRectangle(int mouseX, int mouseY, int x, int y, int width, int height)
	{
		int xx = this.parent.width / 2 - this.parent.getXSize() / 2;
		int yy = this.parent.height / 2 - this.parent.getYSize() / 2;
		return mouseX > xx + x && mouseX < xx + x + width && mouseY > yy + y && mouseY < yy + y + height;
	}
	
	private boolean isBarSet()
	{
		return barWidth > 0 && barHeight > 0 && this.getMaxValue() > 0;
	}
	
	public int getCurrentValue()
	{
		return this.currentValue;
	}
	
	public int getMaxValue()
	{
		return this.maxValue;
	}
}