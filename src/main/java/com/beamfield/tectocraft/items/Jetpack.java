package com.beamfield.tectocraft.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.beamfield.tectocraft.KeyBindings;
import com.beamfield.tectocraft.TectoCraft;
import com.beamfield.tectocraft.reference.ItemUtils;
import com.beamfield.tectocraft.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class Jetpack extends ItemArmor{
	public static boolean canFly = false;
	public static boolean refuel = false;
	private NBTTagCompound tag = ItemUtils.getItemTag(new ItemStack(this));
	public Jetpack(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
		super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
		this.setMaxDamage(-1);
		tag.setInteger("fuel", 0);
		tag.setInteger("maxFuel", 120000);
	}
	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type) {
		return Reference.MODID+":textures/models/armor/jetpack.png";
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
			if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
				list.add("A flying method, press "+Keyboard.getKeyName(KeyBindings.refuel.getKeyCode())+" to fuel it with Rocket Fuel");
			}else{
				list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
			}

		list.add("Fuel level: "+tag.getInteger("fuel")+"/"+tag.getInteger("maxFuel"));
	}
	@SideOnly(Side.CLIENT)
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack){
		if(tag.getInteger("fuel") > 0)player.fallDistance = 0;
		tag.setInteger("maxFuel", 120000);
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
		{
			if(tag.getInteger("fuel") > 0){
			//player.playSound("tectocraft:jetpack", 1F, 1F);
			player.motionY += 0.09;
			player.fallDistance = 0;
			tag.setInteger("fuel", tag.getInteger("fuel")-1);
			if(tag.getInteger("fuel") % 1000 == 0){
				if(world.isRemote){
				player.addChatComponentMessage(new ChatComponentText("[JetPack] Fuel level: "+tag.getInteger("fuel")));
						}
					}
				}
		if(refuel && player.inventory.hasItem(TectoCraft.rocket_fuel)){
			
			if(tag.getInteger("fuel") < tag.getInteger("maxFuel")-1000){
			tag.setInteger("fuel", tag.getInteger("fuel")+4000);
			if(world.isRemote){
			player.inventory.consumeInventoryItem(TectoCraft.rocket_fuel);
			player.addChatComponentMessage(new ChatComponentText("[JetPack] Fuel level: "+tag.getInteger("fuel")));
			}
			}
			}
		}
	}
}
