package com.beamfield
.tectocraft.items;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

public class ItemRainbow extends Item{
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float xPos, float yPos, float zPos){

		 if (side == 0)
	        {
	            --y;
	        }

	        if (side == 1)
	        {
	            ++y;
	        }

	        if (side == 2)
	        {
	            --z;
	        }

	        if (side == 3)
	        {
	            ++z;
	        }

	        if (side == 4)
	        {
	            --x;
	        }

	        if (side == 5)
	        {
	            ++x;
	        }

			//world.setBlock(x, y, z, Blocks.hardened_clay);
		if(world.getBlock(x, y, z) != null){

			world.setBlock(x, y, z, Blocks.chest);
			world.setTileEntity(x, y, z, new TileEntityChest());
			TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(x, y, z);
			 if (tileentitychest != null){
				 ChestGenHooks info = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
				 Random rnd = new Random();
				 WeightedRandomChestContent.generateChestContents(rnd, info.getItems(rnd), tileentitychest, info.getCount(rnd));
			 }
			//if(world.isRemote){
			//for(int i = 0; i < 16; i++){
				//world.setBlock(x, y+i+1, z, Blocks.stained_hardened_clay, i, 2);
			//}
			if(!player.capabilities.isCreativeMode){
				stack.stackSize--;
			//}
			}
		}
		return true; 
	   }
}
