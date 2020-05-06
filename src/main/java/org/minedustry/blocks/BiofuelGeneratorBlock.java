package org.minedustry.blocks;

import javax.annotation.Nullable;

import org.minedustry.References;
import org.minedustry.tileentity.TileBioFuelGenerator;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

public class BiofuelGeneratorBlock extends Block
{
	public BiofuelGeneratorBlock()
	{
		super(Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(2.0f).lightValue(14).harvestTool(ToolType.PICKAXE));
		this.setRegistryName(References.MODID, "biofuel_generator");
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
	{
		if(!worldIn.isRemote)
		{
			if(worldIn.getTileEntity(pos) instanceof TileBioFuelGenerator)
			{
				NetworkHooks.openGui((ServerPlayerEntity) player, (TileBioFuelGenerator) worldIn.getTileEntity(pos), pos);
			}
		}
		
		return ActionResultType.FAIL;
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack)
	{
		if (entity != null)
		{
			world.setBlockState(pos, state.with(BlockStateProperties.FACING, getFacingFromEntity(pos, entity)), 2);
		}
	}

	public static Direction getFacingFromEntity(BlockPos clickedBlock, LivingEntity entity)
	{
		Vec3d vec = entity.getPositionVec();
		return Direction.getFacingFromVector((float) (vec.x - clickedBlock.getX()), (float) (vec.y - clickedBlock.getY()), (float) (vec.z - clickedBlock.getZ()));
	}

	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
	{
		builder.add(BlockStateProperties.FACING);
	}
}
