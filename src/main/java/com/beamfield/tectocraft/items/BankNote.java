package com.beamfield.tectocraft.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.beamfield.tectocraft.reference.ItemUtils;
import com.beamfield.tectocraft.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;

public class BankNote extends TectoItem {	
	 private static final String[] dollarTypes = new String[] {"1", "2", "5", "10", "20", "50", "100"};
	 @SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
				if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
					list.add("This is way to pay for villagers");
				}else{
					list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
				}
		if(stack.getItemDamage() == 0){
			list.add(EnumChatFormatting.ITALIC+"$1");
		}else if(stack.getItemDamage() == 1){
			list.add(EnumChatFormatting.ITALIC+"$2");
		}else if(stack.getItemDamage() == 2){
			list.add(EnumChatFormatting.ITALIC+"$5");
		}else if(stack.getItemDamage() == 3){
		list.add(EnumChatFormatting.ITALIC+"$10");
		}else if(stack.getItemDamage() == 4){
			list.add(EnumChatFormatting.ITALIC+"$20");
		}else if(stack.getItemDamage() == 5){
			list.add(EnumChatFormatting.ITALIC+"$50");
		}else if(stack.getItemDamage() == 6){
			list.add(EnumChatFormatting.ITALIC+"$100");
		}
	}
	public EnumRarity getRarity(ItemStack stack){
		return EnumRarity.epic;
	}
	   public int getMetadata(int meta)
	    {
	        return meta;
	    }
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list)
    {
		for(int i = 0; i < dollarTypes.length; i++){
        list.add(new ItemStack(item, 1, i));
		}
    }
}
