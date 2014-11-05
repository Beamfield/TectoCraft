package com.beamfield.tectocraft.model.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.beamfield.tectocraft.block.ElectricEngine;
import com.beamfield.tectocraft.block.OilEngine;
import com.beamfield.tectocraft.model.fluid_blue_crossModel;
import com.beamfield.tectocraft.model.fluid_blue_cross_doubleModel;
import com.beamfield.tectocraft.model.fluid_blue_curveModel;
import com.beamfield.tectocraft.model.fluid_blue_curve_doubleModel;
import com.beamfield.tectocraft.model.fluid_blue_straightModel;
import com.beamfield.tectocraft.model.fluid_blue_tModel;
import com.beamfield.tectocraft.model.liquidTank;
import com.beamfield.tectocraft.model.motor_electric;
import com.beamfield.tectocraft.model.motor_oil;
import com.beamfield.tectocraft.reference.Reference;
import com.beamfield.tectocraft.reference.ResourceLocationHelper;

public class RenderFluidPipe extends TileEntitySpecialRenderer{
	private static final ResourceLocation blue_cross= new ResourceLocation(Reference.MODID+":textures/models/pipe_blue/pipe_cross.png");
	private static final ResourceLocation blue_cross_double= new ResourceLocation(Reference.MODID+":textures/models/pipe_blue/pipe_cross_double.png");
	private static final ResourceLocation blue_curve= new ResourceLocation(Reference.MODID+":textures/models/pipe_blue/pipe_curve.png");
	private static final ResourceLocation blue_curve_double= new ResourceLocation(Reference.MODID+":textures/models/pipe_blue/pipe_curve_double.png");
	private static final ResourceLocation blue_straight= new ResourceLocation(Reference.MODID+":textures/models/pipe_blue/pipe_straight.png");
	private static final ResourceLocation blue_t= new ResourceLocation(Reference.MODID+":textures/models/pipe_blue/pipe_t.png");
	private fluid_blue_crossModel blue_cross_model;
	private fluid_blue_cross_doubleModel blue_cross_double_model;
	private fluid_blue_curveModel blue_curve_model;
	private fluid_blue_curve_doubleModel blue_curve_double_model;
	private fluid_blue_straightModel blue_straight_model;
	private fluid_blue_tModel blue_t_model;
	//private fluid_blue_t_doubleModel blue_t_model;
	public RenderFluidPipe(){
		this.blue_cross_model = new fluid_blue_crossModel();
		this.blue_cross_double_model = new fluid_blue_cross_doubleModel();
		this.blue_curve_model = new fluid_blue_curveModel();
		this.blue_curve_double_model = new fluid_blue_curve_doubleModel();
		this.blue_straight_model = new fluid_blue_straightModel();
		this.blue_t_model = new fluid_blue_tModel();
	}
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x,
			double y, double z, float f) {
		   GL11.glPushMatrix();
		    GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		    GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);

			    //bindTexture(textureLava);
			    bindTexture(blue_cross_double);
		    GL11.glPushMatrix();
		    this.blue_cross_double_model.renderModel(0.0625F);
		    GL11.glPopMatrix();
		    GL11.glPopMatrix();
		
	}


}
