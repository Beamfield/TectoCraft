package com.beamfield.tectocraft.block;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class flashLight0 extends Block{

	public flashLight0(Material material) {
		super(material);
		setLightLevel(0.85F);
	}

	@Override
	public int getRenderType() {
		return -1;
	}
	@Override
	public boolean isBlockNormalCube() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	@Override
	public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity e) {
		return false;
	}

	@Override
	public boolean canCollideCheck(int par1, boolean par2) {
		return false;
	}

	@Override
	public boolean canBeReplacedByLeaves(IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@Override
	public boolean canDropFromExplosion(Explosion par1Explosion) {
		return false;
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		return new ArrayList();
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		return null;
	}

	@Override
	public boolean isAir(IBlockAccess world, int x, int y, int z) {
		return true;
	}
}
