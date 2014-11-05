package com.beamfield.tectocraft.items;

import java.util.List;
import java.util.Random;

import org.lwjgl.input.Keyboard;

import com.beamfield.tectocraft.TectoCraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumChatFormatting;

public class ItemNethersBane extends ItemSword {

	public ItemNethersBane(ToolMaterial nethersBane) {
		super(nethersBane);
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			list.add("A beast sword, you can not enchant this");
			list.add("If you kill a mob with this there is a chance to drop goodies");
		}else{
			list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
		}
	}
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackingEntity)
	{
		Random random = new Random();
		int chanceDropItem = random.nextInt(10);
		int itemDropped = random.nextInt(12);
		if(chanceDropItem == 5){
			switch(itemDropped){
			case 1:
				  hitEntity.dropItem(Items.bone, 1);
				  break;
			case 2:
				hitEntity.dropItem(Items.diamond, 1);
				break;
			case 3:
				hitEntity.dropItem(Items.emerald, 1);
				break;
			case 4:
				hitEntity.dropItem(Items.gold_ingot, 1);
				break;
			case 5:
				hitEntity.dropItem(Items.iron_ingot, 1);
				break;
			case 6:
				hitEntity.dropItem(Items.carrot, 1);
				break;
			case 7:
				hitEntity.dropItem(Items.potato, 1);
				break;
			case 8:
				hitEntity.dropItem(Items.book, 1);
				break;
			case 9:
				hitEntity.dropItem(Items.blaze_powder, 1);
				break;
			case 10:
				hitEntity.dropItem(Items.clay_ball, 1);
				break;
			case 11:
				hitEntity.dropItem(TectoCraft.cottonFabric, 1);
				break;
			case 12:
				hitEntity.dropItem(TectoCraft.cottonItem, 1);
				break;
				
			}
		
			return true;
		}
		return true;
	}
}
