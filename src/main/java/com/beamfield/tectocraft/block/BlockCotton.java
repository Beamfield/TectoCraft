package com.beamfield.tectocraft.block;

import java.util.Random;

import com.beamfield.tectocraft.TectoCraft;
import com.beamfield.tectocraft.reference.Reference;

import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class BlockCotton extends BlockCrops{
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		this.iconArray = new IIcon[6];
		this.iconArray[0] = iconRegister.registerIcon(Reference.MODID+":cotton_" + 0);
		for( int i = 1; i < this.iconArray.length; i++){
			this.iconArray[i] = iconRegister.registerIcon(Reference.MODID+":cotton_" + i);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta){
		if(meta < 7){
			if(meta == 6){
				meta = 5;
			}
			return iconArray[meta >> 1];
		}
		return iconArray[5];
	}
	public int getRenderType(){
		return 6;
	}
	protected Item func_149866_i(){
		return TectoCraft.cottonItem;
	}
    protected Item func_149865_P()
    {
        return TectoCraft.cottonItem;
    }
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }

	
}
