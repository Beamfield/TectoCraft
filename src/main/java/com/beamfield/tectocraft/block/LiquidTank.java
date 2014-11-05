package com.beamfield.tectocraft.block;

import com.beamfield.tectocraft.reference.Reference;
import com.beamfield.tectocraft.tileentity.TileEntityLiquidTank;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class LiquidTank extends BlockContainer implements IWrenchableDevice{
	private IIcon icon;
	public LiquidTank(Material p_i45386_1_) {
		super(p_i45386_1_);
		float px = 1F/16F;
		this.setBlockBounds(px*2, 0F, px*2, px*14, 1F, px*14);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityLiquidTank();
	}
	public int getRenderType()
    {
        return -1;
    }
    @Override
    public IIcon getIcon(int side, int meta) {
            return icon;
    }
    /*
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
            icon = register.registerIcon(Reference.MODID+":engine_oil_off");
    }**/
    public boolean isOpaqueCube(){
    	return false;
    }
    public boolean renderAsNormalBlock(){
    	return false;
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
