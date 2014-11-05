package com.beamfield.tectocraft.items;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTectoniumSword extends ItemSword{

	public ItemTectoniumSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			list.add("A middle tier tool slightly better than iron");
		}else{
			list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
		}
	}
	 public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackingEntity)
	    {
	        hitEntity.addPotionEffect(new PotionEffect(Potion.poison.id, 500));
	        return true;
	    }
}
