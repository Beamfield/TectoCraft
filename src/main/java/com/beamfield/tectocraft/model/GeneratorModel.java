package com.beamfield.tectocraft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class GeneratorModel extends ModelBase
{
  //fields
    public ModelRenderer Shape1;
    public ModelRenderer Shape2;
    public ModelRenderer Shape3;
    public ModelRenderer Shape4;
    public ModelRenderer Shape5;
    public ModelRenderer Shape6;
    public ModelRenderer Shape7;
    public ModelRenderer Shape8;
  
  public GeneratorModel()
  {
    textureWidth = 256;
    textureHeight = 256;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 16, 1, 16);
      Shape1.setRotationPoint(-8F, 23F, -8F);
      Shape1.setTextureSize(256, 256);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 23);
      Shape2.addBox(0F, 0F, 0F, 14, 3, 14);
      Shape2.setRotationPoint(-7F, 20F, -7F);
      Shape2.setTextureSize(256, 256);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 47);
      Shape3.addBox(0F, 0F, 0F, 10, 5, 10);
      Shape3.setRotationPoint(-5F, 15F, -5F);
      Shape3.setTextureSize(256, 256);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 0, 66);
      Shape4.addBox(0F, 0F, 0F, 6, 5, 5);
      Shape4.setRotationPoint(-3F, 15F, 2F);
      Shape4.setTextureSize(256, 256);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 66);
      Shape5.addBox(0F, 0F, 0F, 6, 5, 5);
      Shape5.setRotationPoint(-3F, 15F, -7F);
      Shape5.setTextureSize(256, 256);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 0, 82);
      Shape6.addBox(0F, 0F, 0F, 4, 5, 6);
      Shape6.setRotationPoint(3F, 15F, -3F);
      Shape6.setTextureSize(256, 256);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 0, 82);
      Shape7.addBox(0F, 0F, 0F, 4, 5, 6);
      Shape7.setRotationPoint(-7F, 15F, -3F);
      Shape7.setTextureSize(256, 256);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 68, 8);
      Shape8.addBox(0F, 0F, 0F, 7, 2, 8);
      Shape8.setRotationPoint(-4F, 13F, -4F);
      Shape8.setTextureSize(256, 256);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
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
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
