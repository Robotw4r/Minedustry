package org.minedustry.screens;

import java.awt.Color;
import java.util.Arrays;

import org.minedustry.container.ContainerBioFuelGenerator;
import org.minedustry.tileentity.TileEntityStorage;

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
		this.addEnergyBar(80, 10, 10, 20, 80, false, Color.BLUE.getRGB(), Color.GREEN.getRGB(), null);
		this.tile = screen.tile;
	}
	
	@Override
	public void render(int p_render_1_, int p_render_2_, float p_render_3_)
	{
		this.updateTooltip(Arrays.asList("salut", "le", "tooltip"));
		this.updateEnergy(10);
		super.render(p_render_1_, p_render_2_, p_render_3_);
		this.renderHoveredToolTip(p_render_1_, p_render_2_);
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
