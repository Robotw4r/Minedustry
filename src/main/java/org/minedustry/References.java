package org.minedustry;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

public class References
{
	public static final String MODID = "minedustry";
	public static final String MODNAME = "Minedustry";
	public static final String MODVERSION = "1.0.0";
	
	public static ResourceLocation getLoc(String path)
	{
		return new ResourceLocation(MODID, path);
	}
	
	public static String getTranslate(String path)
	{
		return new TranslationTextComponent(path).getFormattedText();
	}
	
	/**
	 * 
	 * @param path
	 * @param args
	 * @return translated path with prefix 'minedustry.'
	 */
	public static String getTranslate(String path, Object... args)
	{
		return new TranslationTextComponent(MODID + "." + path, args).getFormattedText();
	}
}
