package org.minedustry.screens;

import java.math.BigDecimal;
import java.util.Arrays;

import org.minedustry.container.ContainerBioFuelGenerator;
import org.minedustry.tileentity.TileEntityStorage;
import org.minedustry.utilities.BarTexture;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class BioFuelGeneratorScreen extends ContainerEnergyScreen<ContainerBioFuelGenerator>
{
	private TileEntityStorage tile;

	public BioFuelGeneratorScreen(ContainerBioFuelGenerator screen, PlayerInventory inv, ITextComponent title)
	{
		super(screen, inv, title);
		this.setSize(176, 166);
		this.addTexturedEnergyBar(100, 10, 10, 20, 70, false, new BarTexture(new ResourceLocation("minedustry:textures/gui/energybar.png"), 0, 0, 10, 2), new BarTexture(new ResourceLocation("minedustry:textures/gui/energybarbackground.png"), 0, 0, 10, 2), null);
		this.tile = screen.tile;
	}
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks)
	{
		int energy = 10;
		// tile.getUpdateTag()
		this.updateTooltip(Arrays.asList("Energy : " + energy + "/" + BigDecimal.valueOf(this.getMaxEnergy()).setScale(0).doubleValue()));
		this.updateEnergy(10);
		super.render(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
	    this.minecraft.getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/dispenser.png")); // Test to show a GUI
	    int x = (this.width - this.xSize) / 2;
	    int y = (this.height - this.ySize) / 2;
	    this.blit(x, y, 0, 0, this.xSize, this.ySize);
	}
}
