package com.beamfield.tectocraft.block;

import com.beamfield.tectocraft.reference.Reference;
import com.beamfield.tectocraft.tileentity.TileEntityElectricEngine;
import com.beamfield.tectocraft.tileentity.TileEntityOilEngine;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class OilEngine extends BlockContainer implements IElectricalDevice, IWrenchableDevice{
	public static boolean active = false;
	@SideOnly(Side.CLIENT)
    protected IIcon icon;
	public OilEngine(Material p_i45394_1_) {
		super(p_i45394_1_);
		float px = 1F/16F;
		setBlockBounds(px*3, 0F, 0F, px*14, px*13, 1F);
	}
	@Override
	public TileEntity createNewTileEntity(World world, int arg1){
		return new TileEntityOilEngine();
		
	}
    public int getRenderType()
    {
        return -1;
    }
    @Override
    public IIcon getIcon(int side, int meta) {
            return icon;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
            icon = register.registerIcon(Reference.MODID+":engine_oil_off");
    }
    public boolean isOpaqueCube(){
    	return false;
    }
    public boolean renderAsNormalBlock(){
    	return false;
    }
    private void setDefaultDirection(World world, int x, int y, int z) {
		if(!world.isRemote) {
			Block block0 = world.getBlock(x, y, z - 1);
			Block block1 = world.getBlock(x, y, z + 1);
			Block block2 = world.getBlock(x - 1, y, z);
			Block block3 = world.getBlock(x + 1, y, z);

			byte byte0 = 3;

			if(block0.func_149730_j() && !block1.func_149730_j())
				byte0 = 3;

			if(block1.func_149730_j() && !block0.func_149730_j())
				byte0 = 2;

			if(block2.func_149730_j() && !block3.func_149730_j())
				byte0 = 5;

			if(block3.func_149730_j() && !block2.func_149730_j())
				byte0 = 4;

			world.setBlockMetadataWithNotify(x, y, z, byte0, 2);
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
