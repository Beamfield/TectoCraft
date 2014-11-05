package com.beamfield.tectocraft.model.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.beamfield.tectocraft.block.ElectricEngine;
import com.beamfield.tectocraft.block.OilEngine;
import com.beamfield.tectocraft.model.motor_electric;
import com.beamfield.tectocraft.model.motor_oil;
import com.beamfield.tectocraft.reference.Reference;
import com.beamfield.tectocraft.reference.ResourceLocationHelper;

public class RenderOilEngine extends TileEntitySpecialRenderer{
	private static final ResourceLocation textureOff = new ResourceLocation(Reference.MODID+":textures/models/engine_oil_off.png");
	private static final ResourceLocation textureOn = new ResourceLocation(Reference.MODID+":textures/models/engine_oil_on.png");
	private motor_oil model;
	public RenderOilEngine(){
		this.model = new motor_oil();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x,
			double y, double z, float f) {
		   GL11.glPushMatrix();
		    GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		    if(OilEngine.active){
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
