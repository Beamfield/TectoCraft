package com.beamfield.tectocraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemPogoStick extends Item{
	public ItemPogoStick(){
		this.setMaxDamage(1024);
	}
	 public boolean onItemUse(ItemStack stack ,EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10){
		 if(world.getBlock(x, y, z) != null && par7 == 1){
			 Vec3 look = player.getLookVec();
			 player.motionX = look.xCoord;
			 player.motionY = 0.7;
			 player.motionZ = look.zCoord;
			 stack.damageItem(1, player);
			 player.fallDistance = 3;
		 }
		 return true;
	 }

}
