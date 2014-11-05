package com.beamfield.tectocraft.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public interface IWrenchableDevice {
public void onWrenchRightClick(World world, EntityPlayer player, int x, int y, int z, int side, int metadata);
	
	public void onWrenchSneakRightClick(World world, EntityPlayer player, int x, int y, int z, int side, int metadata);
}
