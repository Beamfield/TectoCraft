package com.beamfield.tectocraft.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.FoodStats;
import net.minecraft.world.World;

import com.beamfield.tectocraft.TectoCraft;
import com.beamfield.tectocraft.reference.ItemUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class FeedOMatic extends TectoItem{
	private Item[] foodItems = new Item[]{Items.golden_apple, Items.apple, Items.baked_potato, Items.carrot, Items.beef, Items.bread, Items.fish, Items.cooked_chicken, Items.cooked_porkchop, Items.cooked_fished, Items.cooked_beef, Items.cookie, Items.mushroom_stew, Items.potato, Items.pumpkin_pie, Items.melon, Items.rotten_flesh};
	public FeedOMatic(){
		super();
		this.setMaxStackSize(1);
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		NBTTagCompound tag = ItemUtils.getItemTag(stack);
		list.add("Food left: "+tag.getInteger("hungerStorage")+"/10000 Units");
		list.add("Work in progress...");
			if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
				list.add("Press F to consume food from your inventory, and it'll feed you");
			}else{
				list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
			}
	}
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
		if(world.isRemote){
		NBTTagCompound tag = ItemUtils.getItemTag(stack);
		tag.setInteger("hungerStorage", 0);
		tag.setInteger("maxHungerStorage", 0);
		EntityPlayer player = (EntityPlayer)entity;
		if(Keyboard.isKeyDown(Keyboard.KEY_F)){
			if(tag.getInteger("hungerStorage") < tag.getInteger("maxHungerStorage")){
			tag.setInteger("hungerStorage", tag.getInteger("hungerStorage")+((ItemFood) foodFunc(stack, player)).func_150905_g(stack));
			player.inventory.consumeInventoryItem(foodFunc(stack, player));				
			}
		}
		if(player.getFoodStats().getFoodLevel() < 20 && player.getFoodStats().needFood() && tag.getInteger("hungerStorage") > 20 - player.getFoodStats().getFoodLevel()){
			player.getFoodStats().setFoodLevel(20 - player.getFoodStats().getFoodLevel());
			tag.setInteger("hungerStorage", 20 - player.getFoodStats().getFoodLevel());
			}
		}
	}
	public Item foodFunc(ItemStack stack, EntityPlayer player){
		for(int a = 0; a == foodItems.length; a++){
			if(player.inventory.hasItem(foodItems[a])){
				return foodItems[a];
			}
		}
		return null;
	}
}
