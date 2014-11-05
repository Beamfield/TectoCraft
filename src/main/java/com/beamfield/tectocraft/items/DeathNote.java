package com.beamfield.tectocraft.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class DeathNote extends Item{
	public DeathNote(){
		super();
		this.setMaxStackSize(1);
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			list.add("Used to neutralize unintended Entities");
			}else{
			list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
			}
	}
	public EnumRarity getRarity(ItemStack stack){
		return EnumRarity.epic;
	}
	   public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase eBase)
	    {
		   if(!player.capabilities.isCreativeMode){
		   if(!(eBase instanceof EntityPlayer)){
			   eBase.setDead();
			   stack.stackSize--;
		   }
		   }else{
			   if(!(eBase instanceof EntityPlayer)){
				   eBase.setDead();
			   }
		   }
	        return true;
	    }

}
