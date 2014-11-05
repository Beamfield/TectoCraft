package com.beamfield.tectocraft.block;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.beamfield.tectocraft.reference.Reference;
import com.beamfield.tectocraft.tileentity.TileEntityElectricEngine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ElectricEngine extends BlockContainer implements IElectricalDevice, IWrenchableDevice{
	public static boolean active = false;
	@SideOnly(Side.CLIENT)
    protected IIcon icon;
	public ElectricEngine(Material p_i45394_1_) {
		super(p_i45394_1_);
		float px = 1F/16F;
		setBlockBounds(px*3, 0F, 0F, px*13, px*13, 1F);
	}
	@Override
	public TileEntity createNewTileEntity(World world, int arg1){
		return new TileEntityElectricEngine();
		
	}
    @Override
    public IIcon getIcon(int side, int meta) {
            return icon;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
            icon = register.registerIcon(Reference.MODID+":engine_electric_off");
    }
    public int getRenderType()
    {
        return -1;
    }
    public boolean isOpaqueCube(){
    	return false;
    }
    public boolean renderAsNormalBlock(){
    	return false;
    }
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityliving)
    {
    	int orientation = BlockPistonBase.determineOrientation(world, x, y, z, entityliving);
		TileEntityElectricEngine eEngine = (TileEntityElectricEngine) world.getTileEntity(x, y, z);
		world.setBlockMetadataWithNotify(x, y, z, Minecraft.getMinecraft().thePlayer.inventory.getItemStack().getItemDamage(), 1 | 2);

		switch(orientation) {
		case 0:
			eEngine.rotationY = -90F;
			break;
		case 1:
			eEngine.rotationY = 90F;
			break;
		case 2:
			eEngine.rotationX = 270F;
			break;
		case 3:
			eEngine.rotationX = 90F;
			break;
		case 4:
			break;
		default:
			eEngine.rotationX = 180F;
			break;
		}
    }
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_){
    	if(active == false)
    		active = true;
    	if(active == true)
    		active = false;
		return active;
    }
	@Override
	public void onWrenchRightClick(World world, EntityPlayer player, int x, int y, int z, int side, int metadata) {
	}

	@Override
	public void onWrenchSneakRightClick(World world, EntityPlayer player, int x, int y, int z, int side, int metadata) {
			ItemStack drop = new ItemStack(Item.getItemFromBlock(world.getBlock(x, y, z)));
			world.setBlockToAir(x, y, z);
			player.inventory.addItemStackToInventory(drop);
			player.playSound("random.pop", 1F, 1F);
	}
}
