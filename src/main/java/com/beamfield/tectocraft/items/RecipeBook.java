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
import net.minecraft.world.World;

public class RecipeBook extends Item{
	public RecipeBook(){
		this.setCreativeTab(TectoCraft.tabTectoCraft);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			list.add("Shows all the recipes in the Tectonic Crafter");
		}else{
			list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
		}
	}
	 public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		 	int x = (int) player.posX;
		 	int y = (int) player.posY;
		 	int z = (int) player.posZ;
			player.openGui(TectoCraft.instance, TectoCraft.guiIDRecipeBook, world, x, y, z);
			return stack;
	 }
}
