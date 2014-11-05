package com.beamfield.tectocraft.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.beamfield.tectocraft.TectoCraft;
import com.beamfield.tectocraft.gui.GuiCalculator;
import com.beamfield.tectocraft.gui.GuiRecipeBook;
import com.beamfield.tectocraft.gui.GuiSmasher;
import com.beamfield.tectocraft.gui.GuiTectoCrafter;
import com.beamfield.tectocraft.gui.GuiTectonicOven;
import com.beamfield.tectocraft.gui.container.ContainerSmasher;
import com.beamfield.tectocraft.gui.container.ContainerTectoCrafter;
import com.beamfield.tectocraft.gui.container.ContainerTectoOven;
import com.beamfield.tectocraft.tileentity.TileEntityTectonicOven;
import com.beamfield.tectocraft.tileentity.TileEntityTectonicSmasher;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if(entity != null) {
			switch(ID) {
			case TectoCraft.guiIDTectoOven:
				if (entity instanceof TileEntityTectonicOven) {
					return new ContainerTectoOven(player.inventory, (TileEntityTectonicOven) entity);
				}
				return null;
			}
		}

		if(ID == TectoCraft.guiIDTectoCrafter) {
			return ID == TectoCraft.guiIDTectoCrafter && world.getBlock(x, y, z) == TectoCraft.tectonic_crafter ? new ContainerTectoCrafter(player.inventory, world, x, y, z) : null;
		}
		if(ID == TectoCraft.guiIDSmasher){
			if (entity instanceof TileEntityTectonicSmasher) {
				return new ContainerSmasher(player.inventory, (TileEntityTectonicSmasher) entity);
			} 
		}
		return null;

	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if(entity != null) {
			switch(ID) {
			case TectoCraft.guiIDTectoOven:
				if (entity instanceof TileEntityTectonicOven) {
					return new GuiTectonicOven(player.inventory, (TileEntityTectonicOven) entity);
				}

				return null;
			}
		}

		if(ID == TectoCraft.guiIDTectoCrafter) {
			return ID == TectoCraft.guiIDTectoCrafter && world.getBlock(x, y, z) == TectoCraft.tectonic_crafter ? new GuiTectoCrafter(player.inventory, world, x, y, z) : null;
		}
		if(ID == TectoCraft.guiIDRecipeBook) {
			return ID == TectoCraft.guiIDRecipeBook ? new GuiRecipeBook(player.inventory, world, x, y, z) : null;
		}
		if(ID == TectoCraft.guiIDCalculator) {
			return ID == TectoCraft.guiIDCalculator ? new GuiCalculator(player.inventory, world, x, y, z) : null;
		}
		if(ID == TectoCraft.guiIDSmasher) {
			return new GuiSmasher(player.inventory, (TileEntityTectonicSmasher) entity);
		}
		return null;
	}
}
