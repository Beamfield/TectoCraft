package com.beamfield.tectocraft.worldgen;

import java.util.Random;

import com.beamfield.tectocraft.TectoCraft;
import com.beamfield.tectocraft.configs.TectoConfigs;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class TungstenWorldGen implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);

		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);

		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
	}
	private void generateSurface(World world, Random random, int x, int z) {
		if(TectoConfigs.oreGen){
		this.addOreSpawn(TectoCraft.tungsten_ore, world, random, x, z, 16, 16, 2 + random.nextInt(2), 3, 1, 30);
		}
	}
	private void generateNether(World world, Random random, int x, int z) {
		if(TectoConfigs.oreGen){
		//this.addOreSpawn(Block.getBlockFromItem(new ItemStack(TectoCraft.tungsten_ore).getItem()), world, random, x, z, 16, 16, 4 + random.nextInt(4), 20, 1, 30);
		}
	}
	private void generateEnd(World world, Random random, int x, int z) {
		if(TectoConfigs.oreGen){
		//this.addOreSpawn(Block.getBlockFromItem(new ItemStack(TectoCraft.tungsten_ore).getItem()), world, random, x, z, 16, 16, 4 + random.nextInt(4), 20, 1, 30);
		}
	}
	private void addOreSpawn(Block block, World world, Random random, int blockX, int blockZ, int maxX, int maxZ, int maxVein, int spawnChance, int minY, int maxY) {
		for(int i = 0; i < spawnChance; i++) {
			int posX = blockX + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY);
			int posZ = blockZ + random.nextInt(maxZ);

			(new WorldGenMinable(block, maxVein)).generate(world, random, posX, posY, posZ);

		}
	}


	private void addNetherOreSpawn(Block block, World world, Random random, int blockX, int blockZ, int maxX, int maxZ, int maxVein, int spawnChance, int minY, int maxY) {
		for(int i = 0; i < spawnChance; i++) {
			int posX = blockX + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY);
			int posZ = blockZ + random.nextInt(maxZ);

			(new WorldGenNetherMinable(block, maxVein)).generate(world, random, posX, posY, posZ);
		}		
	}
	private void addEndOreSpawn(Block block, World world, Random random, int blockX, int blockZ, int maxX, int maxZ, int maxVein, int spawnChance, int minY, int maxY) {
		for(int i = 0; i < spawnChance; i++) {
			int posX = blockX + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY);
			int posZ = blockZ + random.nextInt(maxZ);

			(new WorldGenNetherMinable(block, maxVein)).generate(world, random, posX, posY, posZ);
		}		
	}
}
