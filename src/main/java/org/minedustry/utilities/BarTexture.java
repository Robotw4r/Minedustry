package org.minedustry.utilities;

import net.minecraft.util.ResourceLocation;

public class BarTexture
{
	private ResourceLocation texture;
	private int x, y, width, height;
	
	public BarTexture(ResourceLocation texture, int x, int y, int width, int height)
	{
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public ResourceLocation getTexture()
	{
		return texture;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}
}
