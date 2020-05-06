package org.minedustry.registry;

import org.minedustry.screens.BioFuelGeneratorScreen;

import net.minecraft.client.gui.ScreenManager;

public class ClientRegistry
{
	public ClientRegistry()
	{
		this.bindScreensWithContainers();
	}
	
	private void bindScreensWithContainers()
	{
    	ScreenManager.registerFactory(ContainerRegistry.BIOFUEL_GENERATOR, BioFuelGeneratorScreen::new);
	}
}
