package org.minedustry.screens;

import java.awt.Color;

import org.minedustry.References;
import org.minedustry.container.ContainerBioFuelGenerator;
import org.minedustry.screens.utils.MachineEnergySpecialContainerScreen;
import org.minedustry.utilities.Bar;
import org.minedustry.utilities.TexturedBar;

import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class BioFuelGeneratorScreen extends MachineEnergySpecialContainerScreen<ContainerBioFuelGenerator>
{
	private Bar energyBar, storageBar;
	
	public BioFuelGeneratorScreen(ContainerBioFuelGenerator container, PlayerInventory inv, ITextComponent title)
	{
		super(container, inv, title);
		this.setSize(176, 166);
		this.addBar(energyBar = new TexturedBar(this, 150, 6, 20, 38, false, Color.RED, null));
		this.addBar(storageBar = new TexturedBar(this, 10, 7, 20, 60, false, Color.GREEN, null));
	}

	@Override
	public void render(int mouseX, int mouseY, float partialTicks)
	{
		energyBar.updateValue(this.getContainer().getEnergy(), this.getContainer().getEnergyCapacity());
		storageBar.updateValue(this.getContainer().getStoredMaterialValue(), this.getContainer().getMaterialStorageCapacity());
		storageBar.updateTooltip(References.getTranslate("screen.bar.bio_fuel", this.getContainer().getStoredMaterialValue(), this.getContainer().getMaterialStorageCapacity()));
		
		super.render(mouseX, mouseY, partialTicks);
		
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.minecraft.getTextureManager().bindTexture(new ResourceLocation(References.MODID, "textures/gui/container/biofuel_generator.png")); // Test to show a GUI
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.blit(x, y, 0, 0, this.xSize, this.ySize);
	}
}
