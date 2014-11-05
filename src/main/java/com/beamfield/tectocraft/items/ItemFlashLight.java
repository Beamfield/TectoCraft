package com.beamfield.tectocraft.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.beamfield.tectocraft.TectoCraft;
import com.beamfield.tectocraft.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class ItemFlashLight extends TectoItem {
	private IIcon flashlight_off;
	private IIcon flashlight_on;
	public ItemFlashLight(){
		this.setMaxStackSize(1);
	}
	@SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta)
    {
		return meta == 1 ? this.flashlight_on : this.flashlight_off;
    }
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			list.add("Used to create light");
		}else{
			list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
		}
	}

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ireg)
    {
        super.registerIcons(ireg);
        this.flashlight_on = ireg.registerIcon(Reference.MODID+":flashlight_on");
        this.flashlight_off = ireg.registerIcon(Reference.MODID+":flashlight_off");
    }
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
    	if (world.isRemote) return stack;
    	if(stack.getItemDamage() == 0){
    	stack.setItemDamage(1);
    	}else if(stack.getItemDamage() == 1){
    		stack.setItemDamage(0);
    	}
    	return stack;
    }
	@Override
	public void onUpdate(ItemStack stack, World world, Entity par3Entity, int par4, boolean par5) {
		int x = (int) Math.floor(par3Entity.posX);
		int y = (int) par3Entity.posY + 1;
		int z = (int) Math.floor(par3Entity.posZ);
		if(stack.getItemDamage() == 1 && (world.getBlock(x, y, z) == Blocks.air && !world.isRemote)){
			world.setBlock(x, y, z, TectoCraft.flashLight0, 0, 2);
		}
	}
}
