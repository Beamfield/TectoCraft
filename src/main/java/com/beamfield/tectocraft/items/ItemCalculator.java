package com.beamfield.tectocraft.items;

import static com.beamfield.tectocraft.TectoCraft.calculator;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import com.beamfield.tectocraft.TectoCraft;
import com.beamfield.tectocraft.reference.ItemUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCalculator extends Item{
	private NBTTagCompound tag = ItemUtils.getItemTag(new ItemStack(this));
	public ItemCalculator(){
		super();
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			list.add("A pocket calculator, can be upgraded.");
			ItemStack calcStack = new ItemStack(calculator, 1);
			calcStack.setTagCompound(new NBTTagCompound());
			NBTTagCompound tags = calcStack.stackTagCompound;
				if(tags.getString("Plus")==UpgradeChipCalc.chipTypes[0]){
					list.add(EnumChatFormatting.ITALIC+tags.getString("Plus"));
				}if(tags.getString("Minus")==UpgradeChipCalc.chipTypes[1]){
					list.add(EnumChatFormatting.ITALIC+tags.getString("Minus"));
				}if(tags.getString("Multiply")==UpgradeChipCalc.chipTypes[2]){
					list.add(EnumChatFormatting.ITALIC+tags.getString("Multiply"));
				}if(tags.getString("Divide")==UpgradeChipCalc.chipTypes[3]){
					list.add(EnumChatFormatting.ITALIC+tags.getString("Divide"));
				}if(tags.getString("Decimal")==UpgradeChipCalc.chipTypes[4]){
					list.add(EnumChatFormatting.ITALIC+tags.getString("Decimal"));
				}if(tags.getString("Hexadecimal")==UpgradeChipCalc.chipTypes[5]){
					list.add(EnumChatFormatting.ITALIC+tags.getString("Hexadecimal"));
				}if(tags.getString("Blockcalc")==UpgradeChipCalc.chipTypes[6]){
					list.add(EnumChatFormatting.ITALIC+tags.getString("Blockcalc"));
		
		}
			}else{
			list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
			}
	}
	 public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		 	int x = (int) player.posX;
		 	int y = (int) player.posY;
		 	int z = (int) player.posZ;
			player.openGui(TectoCraft.instance, TectoCraft.guiIDCalculator, world, x, y, z);
			return stack;
	 }
	 public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float fX, float fY, float fZ)
	    {
		 	NBTTagCompound tag = ItemUtils.getItemTag(stack);
		 	int x1 = 0, y1 = 0, z1 = 0, x2 = 0, y2 = 0, z2 = 0;
		 	if(player.isSneaking() && world.getBlock(x, y, z) != null){
		 			tag.setInteger("x2", x);
		 			tag.setInteger("y2", y);
		 			tag.setInteger("z2", z);
		 		if(world.isRemote){
		 			player.addChatComponentMessage(new ChatComponentText("Second Location Selected is: X: " +tag.getInteger("x2")+" Y: "+tag.getInteger("y2")+" Z: "+tag.getInteger("z2")));
		 		if(tag.getInteger("x2")!=0)
				 	player.addChatComponentMessage(new ChatComponentText("Volume: " + (((Math.abs(tag.getInteger("x2")-tag.getInteger("x1"))+1)*(Math.abs(tag.getInteger("y2")-tag.getInteger("y1"))+1)*(Math.abs(tag.getInteger("z2")-tag.getInteger("z1"))+1))-getVolumeNonAir(world, tag.getInteger("x1"), tag.getInteger("y1"), tag.getInteger("z1"), tag.getInteger("x2"), tag.getInteger("y2"), tag.getInteger("z2"))) + " Blocks in Total"));
		 		}
		 	}else if(world.getBlock(x, y, z) != null){
		 			tag.setInteger("x1", x);
		 			tag.setInteger("y1", y);
		 			tag.setInteger("z1", z);
		 		if(world.isRemote)
		 			player.addChatComponentMessage(new ChatComponentText("First Location Selected is: X: " +tag.getInteger("x1")+" Y: "+tag.getInteger("y1")+" Z: "+tag.getInteger("z1")));
		 	}
	        return true;
	    }
	 public int getVolumeNonAir(World parWorld, int minX, int minY, int minZ, int maxX, int maxY, int maxZ)
	 {
	  int volume = 0;
	  for (int i = minX; i <= maxX; i++)
	  {
	  for (int j = minY; j <= maxY; j++)
	  {
	  for (int k = minZ; k <= maxZ; k++)
	  {
	  if (parWorld.getBlock(i, j, k) != Blocks.air)
	  {
	  volume += 1; 
	  }
	  }
	  }
	  }

	  // DEBUG
	  System.out.println("Volume of non-air blocks = "+volume);

	  return volume;
	 }
}
