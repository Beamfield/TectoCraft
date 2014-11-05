package com.beamfield.tectocraft.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.beamfield.tectocraft.PlayerHelper;
import com.beamfield.tectocraft.TectoCraft;
import com.beamfield.tectocraft.block.IWrenchableDevice;
import com.beamfield.tectocraft.reference.ItemUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class Wrench extends Item{
 public Wrench(){
	 super();
	 this.setCreativeTab(TectoCraft.tabTectoCraft);
 }
 @SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			list.add("Used to personalize or pick-up machines");
		}else{
			list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
		}
	}
	 public boolean onItemUse(ItemStack stack ,EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10){
			int[] blockLookAtInfo = new int[]{0, 0, 0, 0, 0};
	    	
	    	blockLookAtInfo = PlayerHelper.getBlockInFrontInfo(world, player, 5);
	    	
	    	if(blockLookAtInfo[3] != -1) {
	    		Block blockLookAt = world.getBlock(blockLookAtInfo[0], blockLookAtInfo[1], blockLookAtInfo[2]);
		 if(!(world.getBlock(x, y, z) == null) && world.getBlock(x, y, z) instanceof IWrenchableDevice){
			 if(!player.isSneaking() && blockLookAt instanceof IWrenchableDevice){
				 ((IWrenchableDevice)blockLookAt).onWrenchRightClick(world, player, blockLookAtInfo[0], blockLookAtInfo[1], blockLookAtInfo[2], blockLookAtInfo[3], blockLookAtInfo[4]);
			 }else if(blockLookAt instanceof IWrenchableDevice){
				 ((IWrenchableDevice)blockLookAt).onWrenchSneakRightClick(world, player, blockLookAtInfo[0], blockLookAtInfo[1], blockLookAtInfo[2], blockLookAtInfo[3], blockLookAtInfo[4]);
			 }
		 }
}
			return true;

}
}