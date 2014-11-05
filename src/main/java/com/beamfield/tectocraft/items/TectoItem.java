package com.beamfield.tectocraft.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.beamfield.tectocraft.TectoCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class TectoItem extends Item{
	public TectoItem(){
		super();
		this.setCreativeTab(TectoCraft.tabTectoCraft);
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			list.add("Crafting parts");
		}else{
			list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
		}
	}

	public void onUsingItemTick(ItemStack ist, EntityPlayer player, int count) {
		
	}
	
}
