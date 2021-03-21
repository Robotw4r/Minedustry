package org.minedustry.packets;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.minedustry.container.utils.ContainerData;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

public class UpdateTileEntityDataPacket
{
	private int windowId;
	private Map<String, Integer> map;

	public UpdateTileEntityDataPacket() {}

	public UpdateTileEntityDataPacket(int windowId, Map<String, Integer> map)
	{
		this.windowId = windowId;
		this.map = map;
	}

	public static void encode(UpdateTileEntityDataPacket msg, PacketBuffer buf)
	{
		buf.writeInt(msg.windowId);
		
		buf.writeInt(msg.map.size());

		for (String name : msg.map.keySet())
		{
			buf.writeString(name, 32);
			buf.writeInt(msg.map.get(name));
		}
	}

	public static UpdateTileEntityDataPacket decode(PacketBuffer buf)
	{
		int windowId = buf.readInt();
		
		int size = buf.readInt();

		Map<String, Integer> map = new HashMap<String, Integer>(size);

		for (int i = size; i > 0; i--)
		{
			String name = buf.readString();
			
			int data = buf.readInt();
			map.put(name, data);
		}
		
		return new UpdateTileEntityDataPacket(windowId, map);
	}

	public static class ClientHandler
	{
		public static void handle(UpdateTileEntityDataPacket msg, Supplier<NetworkEvent.Context> ctx)
		{
			@SuppressWarnings("resource")
			PlayerEntity player = Minecraft.getInstance().player;
			
			if(player.openContainer.windowId == msg.windowId)
			{
				ContainerData container = ((ContainerData) player.openContainer);
				container.setClientData(msg.map);
			}
			
			ctx.get().setPacketHandled(true);
		}
	}
}
