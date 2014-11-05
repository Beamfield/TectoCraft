package com.beamfield.tectocraft.items;

import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Multitool extends ItemTool {

	private final Item.ToolMaterial toolmaterialfield;
	public Multitool(float p_i45333_1_, ToolMaterial toolmaterial, Set p_i45333_3_) {
		super(p_i45333_1_, toolmaterial, p_i45333_3_);
		this.toolmaterialfield = toolmaterial;
		this.setMaxDamage(-1);
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			list.add("A multifunctional tool.");
		}else{
			list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
		}
	}
	@Override
	public boolean hitEntity(ItemStack itemstack, EntityLivingBase hitEntity, EntityLivingBase player)
	{
			hitEntity.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)player), this.toolMaterial.getDamageVsEntity());
		return false;
	}
	@Override
	public float getDigSpeed(ItemStack itemstack, Block block, int meta)
	{
		return 300;
	}
	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player)
	{
		super.onBlockStartBreak(itemstack, x, y, z, player);

		if(!player.worldObj.isRemote)
		{
			Block block = player.worldObj.getBlock(x, y, z);
			int meta = player.worldObj.getBlockMetadata(x, y, z);
			
			if(block == Blocks.lit_redstone_ore)
			{
				block = Blocks.redstone_ore;
			}

			ItemStack stack = new ItemStack(block, 1, meta);

					block.onBlockDestroyedByPlayer(player.worldObj, x, y, z, meta);
					player.worldObj.playAuxSFXAtEntity(null, 2001, x, y, z, meta << 12);
					player.worldObj.setBlockToAir(x, y, z);
					block.breakBlock(player.worldObj, x, y, z, block, meta);
					block.dropBlockAsItem(player.worldObj, x, y, z, meta, 0);

				}

		return false;
	}
}
