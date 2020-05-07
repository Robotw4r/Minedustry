package org.minedustry.utilities;

import java.util.Collections;
import java.util.List;

import net.minecraft.util.Direction;

public class SlotsFacing
{
	protected Direction face;
	protected List<Integer> north;
	protected List<Integer> south;
	protected List<Integer> east;
	protected List<Integer> west;
	protected List<Integer> down;
	protected List<Integer> up;
	
	public SlotsFacing setSlots(Direction facing, List<Integer> slots)
	{
		switch (facing)
		{
			case NORTH:
				north = slots;
			case DOWN:
				down = slots;
			case EAST:
				east = slots;
			case SOUTH:
				south = slots;
			case UP:
				up = slots;
			case WEST:
				west = slots;
		}
		
		return this;
	}
		
	public List<Integer> getSlots(Direction facing)
	{
		switch (facing)
		{
			case NORTH:
				return north;
			case DOWN:
				return down;
			case EAST:
				return east;
			case SOUTH:
				return south;
			case UP:
				return up;
			case WEST:
				return west;
		}
		
		return Collections.emptyList();
	}
	
	public Direction getFace(Integer slot)
	{
		if(north.contains(slot)) return Direction.NORTH;
		if(east.contains(slot)) return Direction.EAST;
		if(west.contains(slot)) return Direction.WEST;
		if(south.contains(slot)) return Direction.SOUTH;
		if(up.contains(slot)) return Direction.UP;
		if(down.contains(slot)) return Direction.DOWN;
		
		return Direction.NORTH;
	}
}
