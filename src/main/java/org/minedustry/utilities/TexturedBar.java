package org.minedustry.utilities;

import java.awt.Color;
import java.util.List;

import javax.annotation.Nullable;

import org.minedustry.References;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.util.math.MathHelper;

public class TexturedBar extends Bar
{
	protected BarTexture barTexture;
	protected BarTexture emptyBarTexture;
	protected Color color = Color.WHITE;
	
	public TexturedBar(ContainerScreen<?> parent, int x, int y, int width, int height, boolean isHorizontal, BarTexture bar, BarTexture emptyBar, @Nullable List<String> tooltip)
	{
		super(parent, x, y, width, height, isHorizontal, tooltip);
		this.barTexture = bar;
		this.emptyBarTexture = emptyBar;
	}
	
	public TexturedBar(ContainerScreen<?> parent, int x, int y, int width, int height, boolean isHorizontal, Color color, @Nullable List<String> tooltip)
	{
		super(parent, x, y, width, height, isHorizontal, tooltip);
		this.color = color;
		this.barTexture = new BarTexture(References.getLoc("textures/gui/energybar1.png"), 0, 0, 10, 2);
		this.emptyBarTexture = new BarTexture(References.getLoc("textures/gui/energybarbackground.png"), 0, 0, 10, 2);
	}
	
	public void drawBar()
	{
		if(isHorizontal)
		{
			mc.getTextureManager().bindTexture(emptyBarTexture.getTexture());
			AbstractGui.blit(barX, barY, emptyBarTexture.getX(), emptyBarTexture.getY(), barWidth, barHeight, 16, 16);

			mc.getTextureManager().bindTexture(barTexture.getTexture());

			int width = MathHelper.floor(this.getCurrentValue() / this.getMaxValue() * this.barWidth);
			
			changeColor();
			AbstractGui.blit(barX, barY, barTexture.getX(), barTexture.getY(), width, barHeight, 16, 16);
		}
		else
		{
			mc.getTextureManager().bindTexture(barTexture.getTexture());
			changeColor();
			AbstractGui.blit(barX, barY, barTexture.getX(), barTexture.getY(), barWidth, barHeight, 16, 16);
			RenderSystem.color3f(1F, 1F, 1F);

			int height = this.barHeight - MathHelper.floor((double) this.getCurrentValue() / (double) this.getMaxValue() * (double) this.barHeight);

			mc.getTextureManager().bindTexture(emptyBarTexture.getTexture());
			AbstractGui.blit(barX, barY, emptyBarTexture.getX(), emptyBarTexture.getY(), barWidth, height, 16, 16);
		}
	}
	
	private void changeColor()
	{
		float r = (float) color.getRed() / 255F;
		float g = (float) color.getGreen() / 255F;
		float b = (float) color.getBlue() / 255F;
		
		RenderSystem.color3f(r, g, b);
	}
}
