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

public class ItemTectoMatrix extends TectoItem {	
	NBTTagCompound tag = new NBTTagCompound();
	 private static final String[] matrixTypes = new String[] {"blank", "infinity", "power", "speed"};
	 private static final String[] field_150921_b = new String[] {"blank", "infinity", "power", "speed"};
	 private IIcon icon; 
	 private IIcon iconinfinity;
	 private IIcon iconpower;
	 private IIcon iconspeed;
	 private IIcon[] iconarray;
	 @SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
				if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
					list.add("This is an upgrade item for many things");
				}else{
					list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
				}
		if(stack.getItemDamage() == 0){
			list.add(EnumChatFormatting.ITALIC+"Blank");
		}else if(stack.getItemDamage() == 1){
			list.add(EnumChatFormatting.ITALIC+"Infinity");
		}else if(stack.getItemDamage() == 2){
			list.add(EnumChatFormatting.ITALIC+"Power");
		}else if(stack.getItemDamage() == 3){
		list.add(EnumChatFormatting.ITALIC+"Speed");
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
		for(int i = 0; i < matrixTypes.length; i++){
        list.add(new ItemStack(item, 1, i));
		}
    }
	@SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta)
    {
        if (meta < 0 || meta >= matrixTypes.length)
        {
            meta = 0;
        }
        return this.iconarray[meta];
    }
	 @SideOnly(Side.CLIENT)
	    public void registerIcons(IIconRegister ireg)
	    {
	        this.iconarray = new IIcon[field_150921_b.length];

	        for (int i = 0; i < field_150921_b.length; ++i)
	        {
	            this.iconarray[i] = ireg.registerIcon(this.getIconString() + "_" + field_150921_b[i]);
	        }
	    }
}
