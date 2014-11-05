package com.beamfield.tectocraft.tileentity;

import java.util.Random;


import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class TileEntityElectricEngine extends TileEntity{

	private static final String TAG_ROTATION_X = "rotationX";
	private static final String TAG_ROTATION_Y = "rotationY";

	public static final int energyPerMJ = 10;
	private int _energyStored;
	public float rotationX, rotationY;
	public TileEntityElectricEngine(){
		super();
	}
	@Override
	public void writeToNBT(NBTTagCompound cmp) {
		super.writeToNBT(cmp);
		cmp.setFloat(TAG_ROTATION_X, rotationX);
		cmp.setFloat(TAG_ROTATION_Y, rotationY);
	}
	@Override
	public void readFromNBT(NBTTagCompound cmp){
		super.readFromNBT(cmp);
		rotationX = cmp.getFloat(TAG_ROTATION_X);
		rotationY = cmp.getFloat(TAG_ROTATION_Y);
	}
	public boolean canUpdate(){
		return true;
	}
	@Override
	public void updateEntity(){
		super.updateEntity();
		if(worldObj.isRemote)return;
	}
	
}
