package com.beamfield.tectocraft.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.beamfield.tectocraft.reference.ItemUtils;
import com.beamfield.tectocraft.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class EnderRemote extends TectoItem{
	private IIcon remote_off;
	private IIcon remote_on;
	public EnderRemote(){
		this.setMaxStackSize(1);
		this.setTextureName(Reference.MODID+":enderRemote_off");
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			list.add("You can bind this to other blocks by shift right-click and remote them far away");
		}else{
			list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
		}
	}
	  @SideOnly(Side.CLIENT)
	    public IIcon getIconFromDamage(int meta)
	    {
	        return meta == 1 ? this.remote_on : super.getIconFromDamage(meta);
	    }
	    @SideOnly(Side.CLIENT)
	    public void registerIcons(IIconRegister ireg)
	    {
	        super.registerIcons(ireg);
	        this.remote_on = ireg.registerIcon(Reference.MODID+":enderRemote_on");
	    }
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float xOff, float yOff, float zOff){
			NBTTagCompound tag = ItemUtils.getItemTag(stack);
			if(player.isSneaking()){
			tag.setInteger("dimension", world.provider.dimensionId);
			tag.setInteger("x", x);
			tag.setInteger("y", y);
			tag.setInteger("z", z);
			tag.setInteger("side", side);
			stack.setItemDamage(1);
			}
			return true;
		}
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
			if (world.isRemote) return stack;
			NBTTagCompound tag = stack.getTagCompound();
			if (tag != null && tag.hasKey("x") && tag.hasKey("y") && tag.hasKey("z") && tag.hasKey("dimension")) {
				final int x = tag.getInteger("x");
				final int y = tag.getInteger("y");
				final int z = tag.getInteger("z");
				final int dimension = tag.getInteger("dimension");
				if (world.provider.dimensionId == dimension && world.blockExists(x, y, z)) clickBlock(world, player, x, y, z, tag.getInteger("side"));
			}
			return stack;
		}
		
	private static void clickBlock(World world, EntityPlayer player, final int x, final int y, final int z, int side) {
		Block block = world.getBlock(x, y, z);
		if (block != null) {
			block.onBlockActivated(world, x, y, z, player, side, 0, 0, 0);
		}
	}
}
