package com.beamfield.tectocraft.block;

import com.beamfield.tectocraft.reference.Reference;
import com.beamfield.tectocraft.tileentity.TileEntityOilPump;

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
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class OilPump extends BlockContainer implements IElectricalDevice, IWrenchableDevice{
	@SideOnly(Side.CLIENT)
    protected IIcon icon;
	float px = 1F/16F;
	public OilPump(Material p_i45386_1_) {
		super(p_i45386_1_);
		this.setBlockBounds(-1F, 0F, 0F, 1F, px*4, 4F);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityOilPump();
	}
    public int getRenderType()
    {
        return -1;
    }
    @Override
    public IIcon getIcon(int side, int meta) {
            return icon;
    }
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z){
    	 this.setBlockBounds(-1F, 0F, 0F, 1F, px*4, 4F);
    	 return AxisAlignedBB.getBoundingBox(x+this.minX, y+this.minY, z+this.minZ, x+this.maxX, y+this.maxY, z+this.maxZ);
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
            icon = register.registerIcon(Reference.MODID+":oil_pump");
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
    public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
    {
        return p_149742_3_ >= p_149742_1_.getHeight() - 1 ? false : World.doesBlockHaveSolidTopSurface(p_149742_1_, p_149742_2_, p_149742_3_ - 1, p_149742_4_) && super.canPlaceBlockAt(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_) && super.canPlaceBlockAt(p_149742_1_, p_149742_2_, p_149742_3_ + 1, p_149742_4_);
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
