package com.beamfield.tectocraft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class MinigunModel extends ModelBase
{
	public ModelRenderer Shape1;
	public ModelRenderer Shape2;
	public ModelRenderer Shape3;
	public ModelRenderer Shape4;
	public ModelRenderer Shape5;
	public ModelRenderer Shape6;
	public ModelRenderer Shape7;
	public ModelRenderer Shape8;
	public ModelRenderer Shape9;
	public ModelRenderer Shape10;
	public ModelRenderer Shape11;
	public ModelRenderer Shape12;
	public ModelRenderer Shape13;

	public MinigunModel()
	{
		textureWidth = 64;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 7, 7, 7);
		Shape1.setRotationPoint(-8F, 15F, -6F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 14);
		Shape2.addBox(0F, 0F, 0F, 1, 6, 1);
		Shape2.setRotationPoint(-11F, 14F, -3F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, -0.5410521F);
		Shape3 = new ModelRenderer(this, 4, 14);
		Shape3.addBox(0F, 0F, 0F, 1, 4, 1);
		Shape3.setRotationPoint(-11F, 11F, -3F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 8, 14);
		Shape4.addBox(0F, 0F, 0F, 7, 1, 1);
		Shape4.setRotationPoint(-11F, 11F, -3F);
		Shape4.setTextureSize(64, 32);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 24, 14);
		Shape5.addBox(0F, 0F, 0F, 1, 5, 1);
		Shape5.setRotationPoint(-5F, 11F, -3F);
		Shape5.setTextureSize(64, 32);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 31, 0);
		Shape6.addBox(0F, 0F, 0F, 13, 1, 1);
		Shape6.setRotationPoint(-1F, 16F, -3F);
		Shape6.setTextureSize(64, 32);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 31, 0);
		Shape7.addBox(0F, 0F, 0F, 13, 1, 1);
		Shape7.setRotationPoint(-1F, 20F, -3F);
		Shape7.setTextureSize(64, 32);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 32, 0);
		Shape8.addBox(0F, 0F, 0F, 13, 1, 1);
		Shape8.setRotationPoint(-1F, 19F, -1F);
		Shape8.setTextureSize(64, 32);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 31, 0);
		Shape9.addBox(0F, 0F, 0F, 13, 1, 1);
		Shape9.setRotationPoint(-1F, 17F, -1F);
		Shape9.setTextureSize(64, 32);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0F, 0F);
		Shape10 = new ModelRenderer(this, 31, 0);
		Shape10.addBox(0F, 0F, 0F, 13, 1, 1);
		Shape10.setRotationPoint(-1F, 19F, -5F);
		Shape10.setTextureSize(64, 32);
		Shape10.mirror = true;
		setRotation(Shape10, 0F, 0F, 0F);
		Shape11 = new ModelRenderer(this, 31, 0);
		Shape11.addBox(0F, 0F, 0F, 13, 1, 1);
		Shape11.setRotationPoint(-1F, 17F, -5F);
		Shape11.setTextureSize(64, 32);
		Shape11.mirror = true;
		setRotation(Shape11, 0F, 0F, 0F);
		Shape12 = new ModelRenderer(this, 28, 2);
		Shape12.addBox(0F, 0F, 0F, 1, 7, 7);
		Shape12.setRotationPoint(9F, 15F, -6F);
		Shape12.setTextureSize(64, 32);
		Shape12.mirror = true;
		setRotation(Shape12, 0F, 0F, 0F);
		Shape13 = new ModelRenderer(this, 28, 15);
		Shape13.addBox(0F, 0F, 0F, 1, 8, 9);
		Shape13.setRotationPoint(-2F, 15F, -7F);
		Shape13.setTextureSize(64, 32);
		Shape13.mirror = true;
		setRotation(Shape13, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
		Shape12.render(f5);
		Shape13.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	public void renderModel(float f5){
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
		Shape12.render(f5);
		Shape13.render(f5);
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
