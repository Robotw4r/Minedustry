package org.minedustry.screens;

import java.util.List;

import javax.annotation.Nullable;

import org.minedustry.utilities.BarTexture;

import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;

public abstract class ContainerEnergyScreen<T extends Container> extends ContainerScreen<T>
{
	protected int barX, barY, barWidth, barHeight;
	protected boolean isLarge, isTextured;	
	protected int color, backgroundColor;
	protected List<String> tooltip;
	protected BarTexture barTexture;
	protected BarTexture emptyBarTexture;
	
	protected int currentEnergy;
	protected int maxEnergy;
	
	public ContainerEnergyScreen(T screenContainer, PlayerInventory inv, ITextComponent titleIn)
	{
		super(screenContainer, inv, titleIn);
		this.currentEnergy = 0;
	}
	
	public void updateEnergy(int energy)
	{
		this.currentEnergy = energy;
	}
	
	public void updateTooltip(List<String> list)
	{
		this.tooltip = list;
	}
	
	public void addEnergyBar(int maxEnergy, int x, int y, int width, int height, boolean isLarge, int color, int backgroundColor, @Nullable List<String> tooltip)
	{
		this.barX = x;
		this.barY = y;
		this.barWidth = width;
		this.barHeight = height;
		this.isLarge = isLarge;
		this.color = color;
		this.backgroundColor = backgroundColor;
		this.tooltip = tooltip;
		this.maxEnergy = maxEnergy;
		this.isTextured = false;
	}
	
	public void addTexturedEnergyBar(int maxEnergy, int x, int y, int width, int height, boolean isLarge, BarTexture bar, BarTexture emptyBar, @Nullable List<String> tooltip)
	{
		this.barX = x;
		this.barY = y;
		this.barWidth = width;
		this.barHeight = height;
		this.isLarge = isLarge;
		this.barTexture = bar;
		this.emptyBarTexture = emptyBar;
		this.tooltip = tooltip;
		this.maxEnergy = maxEnergy;
		this.isTextured = true;
	}
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks)
	{
		super.render(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
		
		if(isInRectangle(mouseX, mouseY, barX, barY, barWidth, barHeight) && tooltip != null && !tooltip.isEmpty())
		{
			this.renderTooltip(tooltip, mouseX, mouseY, this.minecraft.fontRenderer);
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		if(isBarSet())
		{
			if(isTextured)
			{
				this.drawTexturedEnergyBar();
			}
			else
			{
				this.drawEnergyBar();
			}
			
		}
	}
	
	private void drawEnergyBar()
	{
		if(isLarge)
		{
			AbstractGui.fill(barX, barY, barWidth, barHeight, backgroundColor);
			
			int width = MathHelper.floor(this.getCurrentEnergy() / this.getMaxEnergy() * this.barWidth);
			
			AbstractGui.fill(barX, barY, width, barHeight, this.color);
		}
		else
		{
			AbstractGui.fill(barX, barY, barWidth, barHeight, backgroundColor);
			
			int height = this.barHeight - MathHelper.floor(this.getCurrentEnergy() / this.getMaxEnergy() * this.barHeight);
			
			AbstractGui.fill(barX, barY, barWidth, height, this.color);
		}
	}

	private void drawTexturedEnergyBar()
	{
		if(isLarge)
		{
			this.getMinecraft().getTextureManager().bindTexture(emptyBarTexture.getTexture());
			AbstractGui.blit(barX, barY, emptyBarTexture.getX(), emptyBarTexture.getY(), barWidth, barHeight, 16, 16);

			this.getMinecraft().getTextureManager().bindTexture(barTexture.getTexture());

			int width = MathHelper.floor(this.getCurrentEnergy() / this.getMaxEnergy() * this.barWidth);
			
			AbstractGui.blit(barX, barY, barTexture.getX(), barTexture.getY(), width, barHeight, 16, 16);
		}
		else
		{
			this.getMinecraft().getTextureManager().bindTexture(barTexture.getTexture());
			AbstractGui.blit(barX, barY, barTexture.getX(), barTexture.getY(), barWidth, barHeight, 16, 16);

			this.getMinecraft().getTextureManager().bindTexture(emptyBarTexture.getTexture());
			
			int height = this.barHeight - MathHelper.floor(this.getCurrentEnergy() / this.getMaxEnergy() * this.barHeight);
			
			AbstractGui.blit(barX, barY, emptyBarTexture.getX(), emptyBarTexture.getY(), barWidth, height, 16, 16);
		}		
	}

	private boolean isBarSet()
	{
		return barWidth > 0 && barHeight > 0;
	}
	
	public boolean isInRectangle(int mouseX, int mouseY, int x, int y, int width, int height)
	{
		int xx = this.width / 2 - this.xSize / 2;
		int yy = this.height / 2 - this.ySize / 2;
		return mouseX > xx + x && mouseX < xx + x + width && mouseY > yy + y && mouseY < yy + y + height;
	}
	
	public double getCurrentEnergy()
	{
		return this.currentEnergy;
	}
	
	public double getMaxEnergy()
	{
		return this.maxEnergy;
	}
}
