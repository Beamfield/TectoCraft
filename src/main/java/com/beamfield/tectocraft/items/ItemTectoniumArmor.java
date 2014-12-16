package com.beamfield.tectocraft.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.beamfield.tectocraft.TectoCraft;
import com.beamfield.tectocraft.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemTectoniumArmor extends ItemArmor{

	public ItemTectoniumArmor(ArmorMaterial p_i45325_1_, int p_i45325_2_,
			int p_i45325_3_) {
		super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) && stack.getItem() != TectoCraft.tectoBoots){
			list.add("A middle tier armor, slightly better than iron");
		}else{
			list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
		}
	}
	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type) {
		if(itemStack.getItem() == TectoCraft.tectoniumHelmet || itemStack.getItem() == TectoCraft.tectoniumChestplate || itemStack.getItem() == TectoCraft.tectoniumBoots)
			return Reference.MODID + ":textures/models/armor/tectonium1.png";
		else if(itemStack.getItem() == TectoCraft.tectoniumLeggings)
			return Reference.MODID + ":textures/models/armor/tectonium2.png";
		else if(itemStack.getItem() == TectoCraft.tectoBoots)
			return Reference.MODID + ":textures/models/armor/tectonium1.png";
			return null;
	}
	 public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	    {
		 	itemStack.setItemDamage(this.getMaxDamage());
	    }
}
