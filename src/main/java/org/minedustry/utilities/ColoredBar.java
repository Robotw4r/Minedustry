package org.minedustry.utilities;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.util.math.MathHelper;

public class ColoredBar extends Bar
{
	protected int color, backgroundColor;
	
	public ColoredBar(ContainerScreen<?> parent, int x, int y, int width, int height, boolean isHorizontal, int color, int backgroundColor, @Nullable List<String> tooltip)
	{
		super(parent, x, y, width, height, isHorizontal, tooltip);
		this.color = color;
		this.backgroundColor = backgroundColor;
	}
	
	public void drawBar()
	{
		if(isHorizontal)
		{
			AbstractGui.fill(barX, barY, barX + barWidth, barY + barHeight, backgroundColor);
			
			int width = MathHelper.floor((double) this.getCurrentValue() / (double) this.getMaxValue() * (double) this.barWidth);
			
			AbstractGui.fill(barX, barY, barX + width, barY + barHeight, this.color);
		}
		else
		{
			AbstractGui.fill(barX, barY, barX + barWidth, barY + barHeight, color);

			int height = barHeight - MathHelper.floor((double) this.getCurrentValue() / (double) this.getMaxValue() * (double) this.barHeight);
			
			AbstractGui.fill(barX, barY, barX + barWidth, barY + height, this.backgroundColor);
		}
	}
}
