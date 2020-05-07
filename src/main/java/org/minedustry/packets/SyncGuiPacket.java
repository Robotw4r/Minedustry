package org.minedustry.packets;

import java.util.function.Supplier;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent;

public class SyncGuiPacket
{
	private CompoundNBT nbt;
	private BlockPos pos;

	public SyncGuiPacket(BlockPos pos, CompoundNBT nbt)
	{
		this.pos = pos;
		this.nbt = nbt;
	}

	public static void encode(SyncGuiPacket msg, PacketBuffer buf)
	{
		buf.writeBlockPos(msg.pos);
		buf.writeCompoundTag(msg.nbt);
	}

	public static SyncGuiPacket decode(PacketBuffer buf)
	{
		return new SyncGuiPacket(buf.readBlockPos(), buf.readCompoundTag());
	}

	public static class ClientHandler
	{
		public static void handle(final SyncGuiPacket msg, Supplier<NetworkEvent.Context> ctx)
		{
			ClientPlayerEntity player = Minecraft.getInstance().player;
			BlockPos pos = msg.pos;
			//player.world.getTileEntity(pos).getTileData().merge(other)
		}
	}
}