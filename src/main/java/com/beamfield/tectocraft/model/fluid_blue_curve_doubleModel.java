package com.beamfield.tectocraft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class fluid_blue_curve_doubleModel extends ModelBase
{
  //fields
    public ModelRenderer Shape1;
    public ModelRenderer Shape2;
    public ModelRenderer Shape3;
  
  public fluid_blue_curve_doubleModel()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 9);
      Shape1.addBox(0F, 0F, 0F, 4, 4, 6);
      Shape1.setRotationPoint(-2F, 8F, 2F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, -1.570796F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 10, 4, 4);
      Shape2.setRotationPoint(-8F, 14F, -2F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 9);
      Shape3.addBox(0F, 0F, 0F, 4, 4, 6);
      Shape3.setRotationPoint(-2F, 14F, -8F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
  }
  public void renderModel(float f5){
	  	Shape1.render(f5);
	    Shape2.render(f5);
	    Shape3.render(f5);
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
