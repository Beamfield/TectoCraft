package com.beamfield.tectocraft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class motor_electric extends ModelBase
{
  //fields
    public ModelRenderer cage;
    public ModelRenderer axle;
    public ModelRenderer button_cage;
    public ModelRenderer button;
  
  public motor_electric()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      cage = new ModelRenderer(this, 0, 0);
      cage.addBox(0F, 0F, 0F, 10, 10, 13);
      cage.setRotationPoint(-5F, 14F, -5F);
      cage.setTextureSize(64, 64);
      cage.mirror = true;
      setRotation(cage, 0F, 0F, 0F);
      axle = new ModelRenderer(this, 13, 24);
      axle.addBox(0F, 0F, 0F, 2, 2, 3);
      axle.setRotationPoint(-1F, 18F, -8F);
      axle.setTextureSize(64, 64);
      axle.mirror = true;
      setRotation(axle, 0F, 0F, 0F);
      button_cage = new ModelRenderer(this, 0, 30);
      button_cage.addBox(0F, 0F, 0F, 4, 2, 4);
      button_cage.setRotationPoint(-2F, 12F, 3F);
      button_cage.setTextureSize(64, 64);
      button_cage.mirror = true;
      setRotation(button_cage, 0F, 0F, 0F);
      button = new ModelRenderer(this, 17, 30);
      button.addBox(0F, 0F, 0F, 2, 1, 2);
      button.setRotationPoint(-1F, 11F, 4F);
      button.setTextureSize(64, 64);
      button.mirror = true;
      setRotation(button, 0F, 0F, 0F);
  }
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    cage.render(f5);
    axle.render(f5);
    button_cage.render(f5);
    button.render(f5);
  }
  
  public void renderModel(float f5){
	  this.cage.render(f5);
	  this.axle.render(f5);
	  this.button.render(f5);
	  this.button_cage.render(f5);
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
