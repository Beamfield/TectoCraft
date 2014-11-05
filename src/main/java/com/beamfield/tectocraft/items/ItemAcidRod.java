package com.beamfield.tectocraft.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.beamfield.tectocraft.TectoCraft;
import com.beamfield.tectocraft.reference.ItemUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagInt;

public class ItemAcidRod extends TectoItem{
	NBTTagCompound tag = new NBTTagCompound();
	public ItemAcidRod(){
		super();
		this.setMaxStackSize(1);
		tag.setInteger("usesLeft", 10);	
		this.setHasSubtypes(true);
	}
	public void getSubItems(Item item, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
        list.add(new ItemStack(item, 1, 2));
    }
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
			if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
				list.add("Used to create Acid Block and that Acid will dissolve iron");
				list.add("Disabled, craft bucket instead");
			}else{
				list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
			}
		if(stack.getItemDamage() == 0){
			if(tag.getInteger("usesLeft")/2 != 1){
				list.add("Uses left: "+tag.getInteger("usesLeft")/2);
			}else{
				list.add("Use left: "+tag.getInteger("usesLeft")/2);
			}
		}else if(stack.getItemDamage() == 1){
			list.add(EnumChatFormatting.ITALIC+"Infinity");
		}else if(stack.getItemDamage() == 2){
			list.add(EnumChatFormatting.ITALIC+"Power");
			if(tag.getInteger("usesLeft")/2 != 1){
				list.add("Uses left: "+tag.getInteger("usesLeft")/2);
			}else{
				list.add("Use left: "+tag.getInteger("usesLeft")/2);
			}
		}else if(stack.getItemDamage() == 3){
			list.add(EnumChatFormatting.ITALIC+"Infinity");
			list.add(EnumChatFormatting.ITALIC+"Power");
		}
	}
	public EnumRarity getRarity(ItemStack stack){
		return EnumRarity.epic;
	}
	 public boolean hasEffect(ItemStack par1ItemStack)
	    {
	        return par1ItemStack.getItemDamage() > 0;
	    }

	public boolean onItemUse(ItemStack par1ItemStack,
			EntityPlayer par2EntityPlayer, World par3World, int x, int y,
			int z, int par7, float par8, float par9, float par10) {
			if (par7 == 0) {
				--y;
			}

			if (par7 == 1) {
				++y;
			}

			if (par7 == 2) {
				--z;
			}

			if (par7 == 3) {
				++z;
			}

			if (par7 == 4) {
				--x;
			}

			if (par7 == 5) {
				++x;
			}

			if (!par2EntityPlayer.canPlayerEdit(x, y, z, par7,
					par1ItemStack)) {
				return false;
			} else {
				if (par3World.getBlock(x, y, z) == Blocks.water) {                             
					par3World.playSoundEffect((double) x + 0.5D,
							(double) y + 0.5D, (double) z + 0.5D,
							"random.splash", 1.0F,
							itemRand.nextFloat() * 0.4F + 0.8F);
					if(par1ItemStack.getItemDamage() == 0 || par1ItemStack.getItemDamage() == 1){
					par3World.setBlock(x, y, z,
							TectoCraft.bindAcidBlock);
					}else if(par1ItemStack.getItemDamage() == 2 || par1ItemStack.getItemDamage() == 3){
						if(par3World.isRemote){
							
							if(par3World.getBlock(x, y, z) == Blocks.water || par3World.getBlockMetadata(x, y, z) == 1)par3World.setBlockToAir(x, y, z);par3World.setBlock(x, y, z, TectoCraft.bindAcidBlock);
							if(par3World.getBlock(x+1, y, z) == Blocks.water || par3World.getBlockMetadata(x+1, y, z) == 1)par3World.setBlock(x+1, y, z, TectoCraft.bindAcidBlock);		
							if(par3World.getBlock(x, y, z+1) == Blocks.water || par3World.getBlockMetadata(x, y, z+1) == 1)par3World.setBlock(x, y, z+1, TectoCraft.bindAcidBlock);
							if(par3World.getBlock(x+1, y, z+1) == Blocks.water || par3World.getBlockMetadata(x+1, y, z+1) == 1)par3World.setBlock(x+1, y, z+1, TectoCraft.bindAcidBlock);
							if(par3World.getBlock(x-1, y, z) == Blocks.water || par3World.getBlockMetadata(x-1, y, z) == 1)par3World.setBlock(x-1, y, z, TectoCraft.bindAcidBlock);
							if(par3World.getBlock(x, y, z-1) == Blocks.water || par3World.getBlockMetadata(x, y, z-1) == 1)par3World.setBlock(x, y, z-1, TectoCraft.bindAcidBlock);
							if(par3World.getBlock(x-1, y, z-1) == Blocks.water || par3World.getBlockMetadata(x-1, y, z-1) == 1)par3World.setBlock(x-1, y, z-1, TectoCraft.bindAcidBlock);
							if(par3World.getBlock(x+1, y, z-1) == Blocks.water || par3World.getBlockMetadata(x+1, y, z-1) == 1)par3World.setBlock(x+1, y, z-1, TectoCraft.bindAcidBlock);
							if(par3World.getBlock(x-1, y, z+1) == Blocks.water || par3World.getBlockMetadata(x-1, y, z+1) == 1)par3World.setBlock(x-1, y, z+1, TectoCraft.bindAcidBlock);
							}
						}
					}
					if(par1ItemStack.getItemDamage() == 0 || par1ItemStack.getItemDamage() == 2 && !par2EntityPlayer.capabilities.isCreativeMode){
						tag.setInteger("usesLeft", tag.getInteger("usesLeft") - 1);
						if (tag.getInteger("usesLeft") <= 0) {
							par1ItemStack.stackSize--;
							par3World.playSound(x, y, z, "random.break", 10F,
								10F, true);
							tag.setInteger("usesLeft", 10);
						}else if(par1ItemStack.getItemDamage() == 0 || par1ItemStack.getItemDamage() == 2 && par2EntityPlayer.capabilities.isCreativeMode){
							
						}
					}
				}
			return true;
	}
}

