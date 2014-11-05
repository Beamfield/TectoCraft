package com.beamfield.tectocraft.proxy;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

import com.beamfield.tectocraft.TectoCraft;
import com.beamfield.tectocraft.model.render.ItemRenderIphone6;
import com.beamfield.tectocraft.model.render.ItemRenderMinigun;
import com.beamfield.tectocraft.model.render.ItemRenderNethersBane;
import com.beamfield.tectocraft.model.render.ItemRenderTectoMultitool;
import com.beamfield.tectocraft.model.render.ItemRendererElectricEngine;
import com.beamfield.tectocraft.model.render.ItemRendererElectricPipe;
import com.beamfield.tectocraft.model.render.ItemRendererFluidPipe;
import com.beamfield.tectocraft.model.render.ItemRendererLiquidTank;
import com.beamfield.tectocraft.model.render.ItemRendererOilEngine;
import com.beamfield.tectocraft.model.render.ItemRendererOilPump;
import com.beamfield.tectocraft.model.render.RenderElectricEngine;
import com.beamfield.tectocraft.model.render.RenderElectricPipe;
import com.beamfield.tectocraft.model.render.RenderFluidPipe;
import com.beamfield.tectocraft.model.render.RenderLiquidTank;
import com.beamfield.tectocraft.model.render.RenderOilEngine;
import com.beamfield.tectocraft.model.render.RenderOilPump;
import com.beamfield.tectocraft.tileentity.TileEntityElectricEngine;
import com.beamfield.tectocraft.tileentity.TileEntityElectricPipe;
import com.beamfield.tectocraft.tileentity.TileEntityFluidPipe;
import com.beamfield.tectocraft.tileentity.TileEntityLiquidTank;
import com.beamfield.tectocraft.tileentity.TileEntityOilEngine;
import com.beamfield.tectocraft.tileentity.TileEntityOilPump;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy{
	public static int minigun;
	public static int electricEngine;
	public static int oilEngine;
	public static int oilPump;
	public void registerRenderers(){
		  TileEntitySpecialRenderer render = new RenderElectricEngine();
		  TileEntitySpecialRenderer render2 = new RenderOilEngine();
		  TileEntitySpecialRenderer render3 = new RenderOilPump();
		  TileEntitySpecialRenderer render4 = new RenderLiquidTank();
		  TileEntitySpecialRenderer render5 = new RenderFluidPipe();
		  TileEntitySpecialRenderer render6 = new RenderElectricPipe();
		  ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectricEngine.class, render);
		  ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOilEngine.class, render2);
		  ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOilPump.class, render3);
		  ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFluidPipe.class, render5);
		  ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLiquidTank.class, render4);
		  ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectricPipe.class, render6);
		  MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TectoCraft.electricEngine), new ItemRendererElectricEngine(render, new TileEntityElectricEngine()));
		  MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TectoCraft.oilEngine), new ItemRendererOilEngine(render2, new TileEntityOilEngine()));
		  MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TectoCraft.oilPump), new ItemRendererOilPump(render3, new TileEntityOilPump()));
		  MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TectoCraft.liquidTank), new ItemRendererLiquidTank(render4, new TileEntityLiquidTank()));
		  MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TectoCraft.fluidPipe), new ItemRendererFluidPipe(render5, new TileEntityFluidPipe()));
		  MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(TectoCraft.electricPipe), new ItemRendererElectricPipe(render6, new TileEntityElectricPipe()));
		  MinecraftForgeClient.registerItemRenderer(TectoCraft.minigun, new ItemRenderMinigun());
		  MinecraftForgeClient.registerItemRenderer(TectoCraft.iphone6, new ItemRenderIphone6());
		  MinecraftForgeClient.registerItemRenderer(TectoCraft.nethersBane, new ItemRenderNethersBane());
		  MinecraftForgeClient.registerItemRenderer(TectoCraft.tectonicMultitool, new ItemRenderTectoMultitool());
	}
	public World getClientWorld()
	  {
	    return FMLClientHandler.instance().getClient().theWorld;
	  }
	public void load(){
		System.out.println("[TectoCraft] AutoUpdate System initialized");
	}
}
