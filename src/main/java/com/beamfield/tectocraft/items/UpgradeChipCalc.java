package com.beamfield.tectocraft.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UpgradeChipCalc extends Item{

	 public static final String[] chipTypes = new String[] {"Plus", "Minus", "Multiply", "Divide", "Decimal", "Hexadecimal", "Block Calculation"};
	public UpgradeChipCalc(){
		super();
	}
	public EnumRarity getRarity(ItemStack stack){
		return EnumRarity.epic;
	}
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			list.add("This is an upgrade item for the Calculator");
		}else{
			list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
		}
		if(stack.getItemDamage() == 0){
			list.add(EnumChatFormatting.ITALIC+chipTypes[0]);
		}else if(stack.getItemDamage() == 1){
			list.add(EnumChatFormatting.ITALIC+chipTypes[1]);
		}else if(stack.getItemDamage() == 2){
			list.add(EnumChatFormatting.ITALIC+chipTypes[2]);
		}else if(stack.getItemDamage() == 3){
			list.add(EnumChatFormatting.ITALIC+chipTypes[3]);
		}else if(stack.getItemDamage() == 4){
			list.add(EnumChatFormatting.ITALIC+chipTypes[4]);
		}else if(stack.getItemDamage() == 5){
			list.add(EnumChatFormatting.ITALIC+chipTypes[5]);
		}else if(stack.getItemDamage() == 6){
			list.add(EnumChatFormatting.ITALIC+chipTypes[6]);
	}
}
	public int getMetadata(int meta)
    {
        return meta;
    }
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list)
    {
		for(int i = 0; i < chipTypes.length; i++){
        list.add(new ItemStack(item, 1, i));
		}
    }
}
