package com.beamfield.tectocraft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.beamfield.tectocraft.reference.Reference;
import com.beamfield.tectocraft.tileentity.TileEntityFluidPipe;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFluidPipe extends BlockContainer implements IWrenchableDevice{
	private IIcon icon;
	public BlockFluidPipe() {
		super(Material.iron);
	}
	public int getRenderType()
    {
        return -1;
    }
    @Override
    public IIcon getIcon(int side, int meta) {
            return icon;
    }
    
   /* @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
            icon = register.registerIcon(Reference.MODID+":engine_oil_off");
    }
    **/
    public boolean isOpaqueCube(){
    	return false;
    }
    public boolean renderAsNormalBlock(){
    	return false;
    }
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityFluidPipe();
	}

	@Override
	public void onWrenchRightClick(World world, EntityPlayer player, int x, int y, int z, int side, int metadata) {
		if(world.isRemote){
		
		}
	}

	@Override
	public void onWrenchSneakRightClick(World world, EntityPlayer player, int x, int y, int z, int side, int metadata) {
		if(world.isRemote){
			ItemStack drop = new ItemStack(Item.getItemFromBlock(world.getBlock(x, y, z)));
			world.setBlockToAir(x, y, z);
			player.inventory.addItemStackToInventory(drop);
			player.playSound("random.pop", 1F, 1F);
		}
	}
}
