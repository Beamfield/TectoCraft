package com.beamfield.tectocraft.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.beamfield.tectocraft.TectoCraft;
import com.beamfield.tectocraft.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class Minigun extends Item {
	public Minigun(){
		this.setMaxStackSize(1);
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
		}else{
			list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
		}
	}
	   public EnumAction getItemUseAction(ItemStack p_77661_1_)
	    {
	        return EnumAction.none;
	    }
	   int time;
	   boolean canFire = false;
	   @Override
	   public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		   if (!world.isRemote && canFire && player.inventory.hasItem(Items.arrow))
		   {
			   player.playSound("tectocraft:minigun", 1F, 1F);
			   EntityArrow arrow = new EntityArrow(world, player, 5F);
			   world.spawnEntityInWorld(arrow);
			   arrow.setFire(10);
			   player.inventory.consumeInventoryItem(Items.arrow);   
			   
		   }
		   if(!world.isRemote && player.capabilities.isCreativeMode){
			   player.playSound("tectocraft:minigun", 1F, 1F);
			   EntityArrow arrow = new EntityArrow(world, player, 5F);
			   world.spawnEntityInWorld(arrow);
			   arrow.setFire(10);
		   }
			   
		   return stack;
	   }
	   @Override
	   public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	   {
		   time++;
		   if(par1ItemStack.getItem() == TectoCraft.minigun && time % 10 == 0)
			   canFire = true;
		   if(time > 1000)
			   time = 0;
	   }
}
