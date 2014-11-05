package com.beamfield.tectocraft.model.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.beamfield.tectocraft.block.ElectricEngine;
import com.beamfield.tectocraft.model.motor_electric;
import com.beamfield.tectocraft.model.motor_oil;
import com.beamfield.tectocraft.reference.Reference;
import com.beamfield.tectocraft.reference.ResourceLocationHelper;
import com.beamfield.tectocraft.tileentity.TileEntityElectricEngine;

public class RenderElectricEngine extends TileEntitySpecialRenderer{
	private static final ResourceLocation textureOff = new ResourceLocation(Reference.MODID+":textures/models/engine_electric_off.png");
	private static final ResourceLocation textureOn= new ResourceLocation(Reference.MODID+":textures/models/engine_electric_on.png");
	private motor_electric model;
	public RenderElectricEngine(){
		this.model = new motor_electric();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
		   GL11.glPushMatrix();
		    GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		    TileEntityElectricEngine eEngine = new TileEntityElectricEngine();
		    eEngine.rotationX = -180F;
		    //TileEntityRendererDispatcher.instance.renderTileEntityAt(eEngine, 0.0D, 0.0D, 0.0D, 0.0F);
		    if(ElectricEngine.active){
			    bindTexture(textureOn);
		    }else{
			    bindTexture(textureOff);
		    }
		    GL11.glPushMatrix();
		    this.model.renderModel(0.0625F);
		    GL11.glPopMatrix();
		    GL11.glPopMatrix();

		
	}
}
