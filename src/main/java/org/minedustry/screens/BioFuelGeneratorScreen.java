package org.minedustry.screens;

import org.minedustry.References;
import org.minedustry.container.ContainerBioFuelGenerator;
import org.minedustry.tileentity.TileEntityStorage;
import org.minedustry.utilities.BarTexture;
import org.minedustry.utilities.NBTs;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class BioFuelGeneratorScreen extends ContainerEnergyScreen<ContainerBioFuelGenerator>
{
	private TileEntityStorage tile;

	public BioFuelGeneratorScreen(ContainerBioFuelGenerator container, PlayerInventory inv, ITextComponent title)
	{
		super(container, inv, title);
		this.setSize(176, 166);
		this.addTexturedEnergyBar(100, 10, 9, 20, 60, false, new BarTexture(References.getLoc("textures/gui/energybar.png"), 0, 0, 10, 2), new BarTexture(References.getLoc("textures/gui/energybarbackground.png"), 0, 0, 10, 2), null);
		this.tile = container.tile;
	}
	
	@Override
	public void render(int mouseX, int mouseY, float partialTicks)
	{
		int energy = tile.getTileData().getInt(NBTs.ENERGY);
		this.updateTooltip("Energy : " + energy + "/" + this.getMaxEnergy());
		this.updateEnergy(10);
		super.render(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
	    this.minecraft.getTextureManager().bindTexture(new ResourceLocation("minedustry:textures/gui/container/biofuel_generator.png")); // Test to show a GUI
	    int x = (this.width - this.xSize) / 2;
	    int y = (this.height - this.ySize) / 2;
	    this.blit(x, y, 0, 0, this.xSize, this.ySize);
	}
}
