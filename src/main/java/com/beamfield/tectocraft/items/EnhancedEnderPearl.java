package com.beamfield.tectocraft.items;

import java.util.List;
import java.util.Random;

import org.lwjgl.input.Keyboard;

import com.beamfield.tectocraft.reference.ItemUtils;
import com.beamfield.tectocraft.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class EnhancedEnderPearl extends TectoItem{
	public EnhancedEnderPearl(){
		this.setMaxStackSize(16);
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			list.add("Shift + right-click to bind");
			list.add("Right-click to teleport");
			list.add("Still work in progress");
		}else{
			list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
		}
	}
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float xOff, float yOff, float zOff){
			NBTTagCompound tag = ItemUtils.getItemTag(stack);
			if(player.isSneaking()){
			tag.setInteger("x", x);
			tag.setInteger("y", y);
			tag.setInteger("z", z);
			}
			return true;
		}
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
			if (world.isRemote) return stack;
			NBTTagCompound tag = stack.getTagCompound();
			if(tag != null && tag.hasKey("x") && tag.hasKey("y") && tag.hasKey("z")){
				final int x = tag.getInteger("x");
				final int y = tag.getInteger("y");
				final int z = tag.getInteger("z");
					player.setPosition(x, y+1, z);
					stack.stackSize--;
				}
			return stack;
	}
}
