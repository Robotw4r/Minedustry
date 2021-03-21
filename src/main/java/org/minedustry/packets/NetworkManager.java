package org.minedustry.packets;

import java.util.Optional;

import org.minedustry.References;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

@SuppressWarnings("unused")
public class NetworkManager
{
	private static final String PROTOCOL_VERSION = Integer.toString(1);	
	private static SimpleChannel network = null;
	
	public static final void initNetwork()
	{
		if(network != null)
		{
			throw new RuntimeException("Network has been already initialized !");
		}
		
		network = NetworkRegistry.ChannelBuilder
				.named(new ResourceLocation(References.MODID, "main_channel"))
				.clientAcceptedVersions(PROTOCOL_VERSION::equals)
				.serverAcceptedVersions(PROTOCOL_VERSION::equals)
				.networkProtocolVersion(() -> PROTOCOL_VERSION)
				.simpleChannel();
	}
	
	public static final SimpleChannel getNetWork()
	{
		if(network == null)
		{
			throw new RuntimeException("Network hasn't been initialized !");
		}
		
		return network;
	}
	
	public static void registerMessages()
	{		
		int id = 0;	    
		
	}
	
	private static Optional<NetworkDirection> distClient() { return Optional.of(NetworkDirection.PLAY_TO_CLIENT); }
	private static Optional<NetworkDirection> distServer() { return Optional.of(NetworkDirection.PLAY_TO_SERVER); }
}