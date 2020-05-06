package org.minedustry;

import net.minecraft.util.ResourceLocation;

public class References
{
	public static final String MODID = "minedustry";
	public static final String MODNAME = "Minedustry";
	public static final String MODVERSION = "1.0.0";
	
	public static ResourceLocation getLoc(String path)
	{
		return new ResourceLocation(MODID, path);
	}
}
