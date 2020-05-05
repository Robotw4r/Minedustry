package org.minedustry.screens;

import org.minedustry.container.ContainerBioFuelGenerator;
import org.minedustry.tileentity.TileEntityStorage;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public class BioFuelGeneratorScreen extends ContainerScreen<ContainerBioFuelGenerator>
{
	private TileEntityStorage tile;

	public BioFuelGeneratorScreen(ContainerBioFuelGenerator screen, PlayerInventory inv, ITextComponent title)
	{
		super(screen, inv, title);
		this.setSize(176, 166);
		this.tile = screen.tile;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		// TODO Auto-generated method stub
		
	}

}
