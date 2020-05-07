package org.minedustry.registry;

import org.minedustry.References;
import org.minedustry.packets.SyncGuiPacket;

import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketRegistry
{
	private static final String PROTOCOL_VERSION = Integer.toString(1);
	
	private static final SimpleChannel NETWORK = NetworkRegistry.ChannelBuilder
			.named(References.getLoc("main_channel"))
			.clientAcceptedVersions(PROTOCOL_VERSION::equals)
			.serverAcceptedVersions(PROTOCOL_VERSION::equals)
			.networkProtocolVersion(() -> PROTOCOL_VERSION)
			.simpleChannel();
	
	public static void registerMessages()
	{
		int disc = 0;
		
		NETWORK.registerMessage(disc++, SyncGuiPacket.class, SyncGuiPacket::encode, SyncGuiPacket::decode, SyncGuiPacket.ClientHandler::handle);
	}
}
