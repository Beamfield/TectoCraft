package com.beamfield.tectocraft.block;

import com.beamfield.tectocraft.TectoCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;

public class TectoBlock extends Block{

	public TectoBlock(Material material) {
		super(material);
		this.setCreativeTab(TectoCraft.tabTectoCraft);
	}
}
