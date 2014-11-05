package com.beamfield.tectocraft.block;

import com.beamfield.tectocraft.TectoCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;

public class BlockTectonium extends TectoBlock{

	public BlockTectonium(Material p_i45394_1_) {
		super(p_i45394_1_);
	}
	//public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		//world.setBlock(x, y, z, Blocks.mob_spawner);
		//TileEntityMobSpawner spawner = (TileEntityMobSpawner) world.getTileEntity(x, y, z);
		//MobSpawnerBaseLogic logic = spawner.func_145881_a();
        //logic.setEntityName("Witch");
		//return true;
	//}
}
