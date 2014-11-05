package com.beamfield.tectocraft;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class PlayerHelper {
	public static int[] getBlockInFrontInfo(World world, EntityPlayer player, double reach) {
		int[] blockInfo = { 0, 0, 0, -1, 0 };

		MovingObjectPosition movingObjectPosition = getMovingObjectPositionFromPlayer(world, player, true, reach);
		if (movingObjectPosition != null) {
			if (movingObjectPosition.typeOfHit == MovingObjectType.BLOCK) {
				blockInfo[0] = movingObjectPosition.blockX;
				blockInfo[1] = movingObjectPosition.blockY;
				blockInfo[2] = movingObjectPosition.blockZ;
				blockInfo[3] = movingObjectPosition.sideHit;
				blockInfo[4] = world.getBlockMetadata(blockInfo[1], blockInfo[2], blockInfo[3]);
			}
		}
		return blockInfo;
	}
	
	
	public static Block getBlockInFront(World world, EntityPlayer player, double reach) {
		int[] blockInfo = new int[]{0, 0, 0, 0, 0};
		
		blockInfo = getBlockInFrontInfo(world, player, reach);
		
		if(blockInfo[3] != -1) {
			return world.getBlock(blockInfo[0], blockInfo[1], blockInfo[2]);
		} else {
			return null;
		}
	}


	private static MovingObjectPosition getMovingObjectPositionFromPlayer(World world, EntityPlayer entityplayer, boolean flag, double reach) {
		float f = 1.0F;
		float playerPitch = entityplayer.prevRotationPitch + (entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f;
		float playerYaw = entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f;
		double playerPosX = entityplayer.prevPosX + (entityplayer.posX - entityplayer.prevPosX) * f;
		double playerPosY = (entityplayer.prevPosY + (entityplayer.posY - entityplayer.prevPosY) * f + 1.6200000000000001D) - entityplayer.yOffset;
		double playerPosZ = entityplayer.prevPosZ + (entityplayer.posZ - entityplayer.prevPosZ) * f;
		Vec3 vecPlayer = Vec3.createVectorHelper(playerPosX, playerPosY, playerPosZ);
		float cosYaw = MathHelper.cos(-playerYaw * 0.01745329F - 3.141593F);
		float sinYaw = MathHelper.sin(-playerYaw * 0.01745329F - 3.141593F);
		float cosPitch = -MathHelper.cos(-playerPitch * 0.01745329F);
		float sinPitch = MathHelper.sin(-playerPitch * 0.01745329F);
		float pointX = sinYaw * cosPitch;
		float pointY = sinPitch;
		float pointZ = cosYaw * cosPitch;
		Vec3 vecPoint = vecPlayer.addVector(pointX * reach, pointY * reach, pointZ * reach);
		MovingObjectPosition movingobjectposition = world.rayTraceBlocks(vecPlayer, vecPoint, flag);
		
		return movingobjectposition;
	}
}