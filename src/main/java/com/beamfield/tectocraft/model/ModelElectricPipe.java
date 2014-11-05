package com.beamfield.tectocraft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelElectricPipe extends ModelBase {

	public enum ModelWireDirection { CORE, NORTHSOUTH, EASTWEST, UPDOWN };
	
	// fields
	ModelRenderer WireCoreElbow;
	ModelRenderer WireCoreNorthSouth;
	ModelRenderer WireCoreEastWest;
	ModelRenderer WireCoreUpDown;
	ModelRenderer WestSideInner;
	ModelRenderer WestSideOuter;
	ModelRenderer WestSideConnector;
	ModelRenderer EastSideInner;
	ModelRenderer EastSideOuter;
	ModelRenderer EastSideConnector;
	ModelRenderer NorthSideInner;
	ModelRenderer NorthSideOuter;
	ModelRenderer NorthSideConnector;
	ModelRenderer SouthSideInner;
	ModelRenderer SouthSideOuter;
	ModelRenderer SouthSideConnector;
	ModelRenderer UpSideInner;
	ModelRenderer UpSideOuter;
	ModelRenderer UpSideConnector;
	ModelRenderer DownSideInner;
	ModelRenderer DownSideOuter;
	ModelRenderer DownSideConnector;


	public ModelElectricPipe() {
		textureWidth = 128;
		textureHeight = 128;

		WireCoreElbow = new ModelRenderer(this, 0, 0);
		WireCoreElbow.addBox(0F, 0F, 0F, 6, 6, 6);
		WireCoreElbow.setRotationPoint(-3F, 13F, -3F);
		WireCoreElbow.setTextureSize(128, 128);
		WireCoreElbow.mirror = true;
		setRotation(WireCoreElbow, 0F, 0F, 0F);
		
		WireCoreNorthSouth = new ModelRenderer(this, 23, 13);
		WireCoreNorthSouth.addBox(0F, 0F, 0F, 6, 6, 6);
		WireCoreNorthSouth.setRotationPoint(-3F, 13F, -3F);
		WireCoreNorthSouth.setTextureSize(128, 128);
		WireCoreNorthSouth.mirror = true;
		setRotation(WireCoreNorthSouth, 0F, 0F, 0F);
		
		WireCoreEastWest = new ModelRenderer(this, 84, 10);
		WireCoreEastWest.addBox(0F, 0F, 0F, 6, 6, 6);
		WireCoreEastWest.setRotationPoint(-3F, 13F, -3F);
		WireCoreEastWest.setTextureSize(128, 128);
		WireCoreEastWest.mirror = true;
		setRotation(WireCoreEastWest, 0F, 0F, 0F);
		
		WireCoreUpDown = new ModelRenderer(this, 0, 26);
		WireCoreUpDown.addBox(0F, 0F, 0F, 6, 6, 6);
		WireCoreUpDown.setRotationPoint(-3F, 13F, -3F);
		WireCoreUpDown.setTextureSize(128, 128);
		WireCoreUpDown.mirror = true;
		setRotation(WireCoreUpDown, 0F, 0F, 0F);
		
		WestSideInner = new ModelRenderer(this, 25, 0);
		WestSideInner.addBox(0F, 0F, 0F, 2, 6, 6);
		WestSideInner.setRotationPoint(3F, 13F, -3F);
		WestSideInner.setTextureSize(128, 128);
		WestSideInner.mirror = true;
		setRotation(WestSideInner, 0F, 0F, 0F);
		
		WestSideOuter = new ModelRenderer(this, 42, 0);
		WestSideOuter.addBox(0F, 0F, 0F, 3, 6, 6);
		WestSideOuter.setRotationPoint(5F, 13F, -3F);
		WestSideOuter.setTextureSize(128, 128);
		WestSideOuter.mirror = true;
		setRotation(WestSideOuter, 0F, 0F, 0F);
		
		WestSideConnector = new ModelRenderer(this, 61, 0);
		WestSideConnector.addBox(0F, 0F, 0F, 3, 8, 8);
		WestSideConnector.setRotationPoint(5F, 12F, -4F);
		WestSideConnector.setTextureSize(128, 128);
		WestSideConnector.mirror = true;
		setRotation(WestSideConnector, 0F, 0F, 0F);
		
		EastSideInner = new ModelRenderer(this, 25, 0);
		EastSideInner.addBox(0F, 0F, 0F, 2, 6, 6);
		EastSideInner.setRotationPoint(-5F, 13F, -3F);
		EastSideInner.setTextureSize(128, 128);
		EastSideInner.mirror = true;
		setRotation(EastSideInner, 0F, 0F, 0F);
		
		EastSideOuter = new ModelRenderer(this, 42, 0);
		EastSideOuter.addBox(0F, 0F, 0F, 3, 6, 6);
		EastSideOuter.setRotationPoint(-8F, 13F, -3F);
		EastSideOuter.setTextureSize(128, 128);
		EastSideOuter.mirror = true;
		setRotation(EastSideOuter, 0F, 0F, 0F);
		
		EastSideConnector = new ModelRenderer(this, 61, 0);
		EastSideConnector.addBox(0F, 0F, 0F, 3, 8, 8);
		EastSideConnector.setRotationPoint(-8F, 12F, -4F);
		EastSideConnector.setTextureSize(128, 128);
		EastSideConnector.mirror = true;
		setRotation(EastSideConnector, 0F, 0F, 0F);
		
		NorthSideInner = new ModelRenderer(this, 84, 0);
		NorthSideInner.addBox(0F, 0F, 0F, 6, 6, 2);
		NorthSideInner.setRotationPoint(-3F, 13F, -5F);
		NorthSideInner.setTextureSize(128, 128);
		NorthSideInner.mirror = true;
		setRotation(NorthSideInner, 0F, 0F, 0F);
		
		NorthSideOuter = new ModelRenderer(this, 101, 0);
		NorthSideOuter.addBox(0F, 0F, 0F, 6, 6, 3);
		NorthSideOuter.setRotationPoint(-3F, 13F, -8F);
		NorthSideOuter.setTextureSize(128, 128);
		NorthSideOuter.mirror = true;
		setRotation(NorthSideOuter, 0F, 0F, 0F);
		
		NorthSideConnector = new ModelRenderer(this, 0, 13);
		NorthSideConnector.addBox(0F, 0F, 0F, 8, 8, 3);
		NorthSideConnector.setRotationPoint(-4F, 12F, -8F);
		NorthSideConnector.setTextureSize(128, 128);
		NorthSideConnector.mirror = true;
		setRotation(NorthSideConnector, 0F, 0F, 0F);
		
		SouthSideInner = new ModelRenderer(this, 84, 0);
		SouthSideInner.addBox(0F, 0F, 0F, 6, 6, 2);
		SouthSideInner.setRotationPoint(-3F, 13F, 3F);
		SouthSideInner.setTextureSize(128, 128);
		SouthSideInner.mirror = true;
		setRotation(SouthSideInner, 0F, 0F, 0F);
		
		SouthSideOuter = new ModelRenderer(this, 101, 0);
		SouthSideOuter.addBox(0F, 0F, 0F, 6, 6, 3);
		SouthSideOuter.setRotationPoint(-3F, 13F, 5F);
		SouthSideOuter.setTextureSize(128, 128);
		SouthSideOuter.mirror = true;
		setRotation(SouthSideOuter, 0F, 0F, 0F);
		
		SouthSideConnector = new ModelRenderer(this, 0, 13);
		SouthSideConnector.addBox(0F, 0F, 0F, 8, 8, 3);
		SouthSideConnector.setRotationPoint(-4F, 12F, 5F);
		SouthSideConnector.setTextureSize(128, 128);
		SouthSideConnector.mirror = true;
		setRotation(SouthSideConnector, 0F, 0F, 0F);
		
		UpSideInner = new ModelRenderer(this, 48, 17);
		UpSideInner.addBox(0F, 0F, 0F, 6, 2, 6);
		UpSideInner.setRotationPoint(-3F, 11F, -3F);
		UpSideInner.setTextureSize(128, 128);
		UpSideInner.mirror = true;
		setRotation(UpSideInner, 0F, 0F, 0F);
		
		UpSideOuter = new ModelRenderer(this, 25, 26);
		UpSideOuter.addBox(0F, 0F, 0F, 6, 3, 6);
		UpSideOuter.setRotationPoint(-3F, 8F, -3F);
		UpSideOuter.setTextureSize(128, 128);
		UpSideOuter.mirror = true;
		setRotation(UpSideOuter, 0F, 0F, 0F);
		
		UpSideConnector = new ModelRenderer(this, 50, 26);
		UpSideConnector.addBox(0F, 0F, 0F, 8, 3, 8);
		UpSideConnector.setRotationPoint(-4F, 8F, -4F);
		UpSideConnector.setTextureSize(128, 128);
		UpSideConnector.mirror = true;
		setRotation(UpSideConnector, 0F, 0F, 0F);
		
		DownSideInner = new ModelRenderer(this, 48, 17);
		DownSideInner.addBox(0F, 0F, 0F, 6, 2, 6);
		DownSideInner.setRotationPoint(-3F, 19F, -3F);
		DownSideInner.setTextureSize(128, 128);
		DownSideInner.mirror = true;
		setRotation(DownSideInner, 0F, 0F, 0F);
		
		DownSideOuter = new ModelRenderer(this, 25, 26);
		DownSideOuter.addBox(0F, 0F, 0F, 6, 3, 6);
		DownSideOuter.setRotationPoint(-3F, 21F, -3F);
		DownSideOuter.setTextureSize(128, 128);
		DownSideOuter.mirror = true;
		setRotation(DownSideOuter, 0F, 0F, 0F);
		
		DownSideConnector = new ModelRenderer(this, 50, 26);
		DownSideConnector.addBox(0F, 0F, 0F, 8, 3, 8);
		DownSideConnector.setRotationPoint(-4F, 21F, -4F);
		DownSideConnector.setTextureSize(128, 128);
		DownSideConnector.mirror = true;
		setRotation(DownSideConnector, 0F, 0F, 0F);
	}


	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		WireCoreElbow.render(f5);
		WireCoreNorthSouth.render(f5);
		WireCoreEastWest.render(f5);
		WireCoreUpDown.render(f5);
		WestSideInner.render(f5);
		WestSideOuter.render(f5);
		WestSideConnector.render(f5);
		EastSideInner.render(f5);
		EastSideOuter.render(f5);
		EastSideConnector.render(f5);
		NorthSideInner.render(f5);
		NorthSideOuter.render(f5);
		NorthSideConnector.render(f5);
		SouthSideInner.render(f5);
		SouthSideOuter.render(f5);
		SouthSideConnector.render(f5);
		UpSideInner.render(f5);
		UpSideOuter.render(f5);
		UpSideConnector.render(f5);
		DownSideInner.render(f5);
		DownSideOuter.render(f5);
		DownSideConnector.render(f5);
	}
	
	
	public void renderCore(float f, ModelWireDirection direction) {		
		if(direction == ModelWireDirection.CORE) {
			WireCoreElbow.render(f);
		} else if(direction == ModelWireDirection.NORTHSOUTH) {
			WireCoreNorthSouth.render(f);
		} else if(direction == ModelWireDirection.EASTWEST) {
			WireCoreEastWest.render(f);
		} else if(direction == ModelWireDirection.UPDOWN) {
			WireCoreUpDown.render(f);
		}
	}
	
	
	public void renderNorth(float f, boolean machineConnected) {
		NorthSideInner.render(f);

		if(machineConnected) {
			NorthSideConnector.render(f);
		} else {
			NorthSideOuter.render(f);
		}
	}
	
	
	public void renderSouth(float f, boolean machineConnected) {
		SouthSideInner.render(f);

		if(machineConnected) {
			SouthSideConnector.render(f);
		} else {
			SouthSideOuter.render(f);
		}
	}
	
	
	public void renderEast(float f, boolean machineConnected) {
		EastSideInner.render(f);

		if(machineConnected) {
			EastSideConnector.render(f);
		} else {
			EastSideOuter.render(f);
		}
	}
	
	
	public void renderWest(float f, boolean machineConnected) {
		WestSideInner.render(f);

		if(machineConnected) {
			WestSideConnector.render(f);
		} else {
			WestSideOuter.render(f);
		}
	}
	
	
	public void renderUp(float f, boolean machineConnected) {
		UpSideInner.render(f);

		if(machineConnected) {
			UpSideConnector.render(f);
		} else {
			UpSideOuter.render(f);
		}
	}
	
	
	public void renderDown(float f, boolean machineConnected) {
		DownSideInner.render(f);

		if(machineConnected) {
			DownSideConnector.render(f);
		} else {
			DownSideOuter.render(f);
		}
	}
	

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}


	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}