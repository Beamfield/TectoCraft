package com.beamfield.tectocraft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class oil_pump extends ModelBase
{
  //fields
    public ModelRenderer base;
    public ModelRenderer right_pole;
    public ModelRenderer central_pole;
    public ModelRenderer left_pole;
    public ModelRenderer thin_pipe;
    public ModelRenderer tank;
    public ModelRenderer thick_pipe;
    public ModelRenderer extraction_pipe;
    public ModelRenderer gearbox;
    public ModelRenderer axis;
    public ModelRenderer junction;
    public ModelRenderer main_stick;
    public ModelRenderer head;
  
  public oil_pump()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      base = new ModelRenderer(this, 0, 0);
      base.addBox(0F, 0F, 0F, 32, 4, 64);
      base.setRotationPoint(-8F, 20F, -8F);
      base.setTextureSize(256, 128);
      base.mirror = true;
      setRotation(base, 0F, 0F, 0F);
      right_pole = new ModelRenderer(this, 209, 0);
      right_pole.addBox(0F, 0F, 0F, 4, 33, 2);
      right_pole.setRotationPoint(6F, -10F, -4F);
      right_pole.setTextureSize(256, 128);
      right_pole.mirror = true;
      setRotation(right_pole, 0F, 0F, 0.4363323F);
      central_pole = new ModelRenderer(this, 167, 0);
      central_pole.addBox(0F, 0F, 0F, 4, 44, 4);
      central_pole.setRotationPoint(6F, -24F, -5F);
      central_pole.setTextureSize(256, 128);
      central_pole.mirror = true;
      setRotation(central_pole, 0F, 0F, 0F);
      left_pole = new ModelRenderer(this, 208, 0);
      left_pole.addBox(-4F, 0F, 0F, 4, 33, 2);
      left_pole.setRotationPoint(10F, -10F, -4F);
      left_pole.setTextureSize(256, 128);
      left_pole.mirror = true;
      setRotation(left_pole, 0F, 0F, -0.4363323F);
      thin_pipe = new ModelRenderer(this, 140, 0);
      thin_pipe.addBox(0F, 0F, 0F, 2, 32, 2);
      thin_pipe.setRotationPoint(7F, -19F, -3F);
      thin_pipe.setTextureSize(256, 128);
      thin_pipe.mirror = true;
      setRotation(thin_pipe, 0.5971298F, 0F, 0F);
      tank = new ModelRenderer(this, 65, 69);
      tank.addBox(0F, 0F, 0F, 12, 16, 12);
      tank.setRotationPoint(2F, 4F, 8F);
      tank.setTextureSize(256, 128);
      tank.mirror = true;
      setRotation(tank, 0F, 0F, 0F);
      thick_pipe = new ModelRenderer(this, 0, 34);
      thick_pipe.addBox(0F, 0F, 0F, 10, 4, 4);
      thick_pipe.setRotationPoint(-8F, 10F, 12F);
      thick_pipe.setTextureSize(256, 128);
      thick_pipe.mirror = true;
      setRotation(thick_pipe, 0F, 0F, 0F);
      extraction_pipe = new ModelRenderer(this, 150, 10);
      extraction_pipe.addBox(0F, 0F, 0F, 2, 37, 2);
      extraction_pipe.setRotationPoint(7F, -13F, -35F);
      extraction_pipe.setTextureSize(256, 128);
      extraction_pipe.mirror = true;
      setRotation(extraction_pipe, 0F, 0F, 0F);
      gearbox = new ModelRenderer(this, 0, 69);
      gearbox.addBox(0F, 0F, 0F, 16, 16, 16);
      gearbox.setRotationPoint(0F, 4F, 36F);
      gearbox.setTextureSize(256, 128);
      gearbox.mirror = true;
      setRotation(gearbox, 0F, 0F, 0F);
      axis = new ModelRenderer(this, 130, 0);
      axis.addBox(0F, 0F, 0F, 2, 32, 2);
      axis.setRotationPoint(7F, -11F, 43F);
      axis.setTextureSize(256, 128);
      axis.mirror = true;
      setRotation(axis, 0F, 0F, 0F);
      junction = new ModelRenderer(this, 150, 0);
      junction.addBox(0F, 0F, 0F, 4, 4, 4);
      junction.setRotationPoint(6F, -15F, 42F);
      junction.setTextureSize(256, 128);
      junction.mirror = true;
      setRotation(junction, 0F, 0F, 0F);
      main_stick = new ModelRenderer(this, 194, 0);
      main_stick.addBox(-1F, -48F, 0F, 2, 73, 4);
      main_stick.setRotationPoint(8F, -24F, -3F);
      main_stick.setTextureSize(256, 128);
      main_stick.mirror = true;
      setRotation(main_stick, -1.780236F, 0F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, 25F, -5F, 8, 10, 22);
      head.setRotationPoint(8F, -24F, -3F);
      head.setTextureSize(256, 128);
      head.mirror = true;
      setRotation(head, -1.745329F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    base.render(f5);
    right_pole.render(f5);
    central_pole.render(f5);
    left_pole.render(f5);
    thin_pipe.render(f5);
    tank.render(f5);
    thick_pipe.render(f5);
    extraction_pipe.render(f5);
    gearbox.render(f5);
    axis.render(f5);
    junction.render(f5);
    main_stick.render(f5);
    head.render(f5);
  }
  public void renderModel(float f5){
	  base.render(f5);
	    right_pole.render(f5);
	    central_pole.render(f5);
	    left_pole.render(f5);
	    thin_pipe.render(f5);
	    tank.render(f5);
	    thick_pipe.render(f5);
	    extraction_pipe.render(f5);
	    gearbox.render(f5);
	    axis.render(f5);
	    junction.render(f5);
	    main_stick.render(f5);
	    head.render(f5);
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
