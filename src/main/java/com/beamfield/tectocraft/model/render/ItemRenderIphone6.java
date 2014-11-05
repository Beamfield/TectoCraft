package com.beamfield.tectocraft.model.render;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;


public class ItemRenderIphone6 implements IItemRenderer {
    private IModelCustom model;
    private ResourceLocation texture;
    public ItemRenderIphone6() {
    	model = AdvancedModelLoader.loadModel(new ResourceLocation("tectocraft:models/iPhone 6.obj"));
    	texture =  new ResourceLocation("tectocraft:models/iphone6.png");
    }
    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type) {

        case EQUIPPED: 
            GL11.glPushMatrix(); 
            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
            //GL11.glRotatef(0F, 1.0f, 0.0f, 0.0f);	  
            //GL11.glRotatef(-5F, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(180F, 0.3f, 0.6f, 0.2f);
            GL11.glRotatef(40, 1F, -1F, 0F);
            GL11.glTranslatef(-0.2F, 0.7F, 0F);
            GL11.glRotatef(180, 0F, 1F, 0F);
            GL11.glScalef(0.06F, 0.06F, 0.06F);
            GL11.glRotatef(360F, 0F, 0F, 1F);
            model.renderAll();
            GL11.glPopMatrix(); 
            break;
        case EQUIPPED_FIRST_PERSON:

            GL11.glPushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
            GL11.glRotatef(180F, 0.3f, 0.6f, 0.2f);
            GL11.glRotatef(40, 0.3F, -1F, 0.3F);
            GL11.glRotatef(90, 0.3F, 0.3F, 30F);
            GL11.glTranslatef(0.5F, 0F, 0.2F);
            GL11.glScalef(0.07F, 0.07F, 0.07F);
            GL11.glRotatef(180F, 0F, 0F, 1F);
            GL11.glRotatef(60, -0.5f, 5f, 1f);
            model.renderAll();
            GL11.glPopMatrix();
            break;

        case ENTITY:
            GL11.glPushMatrix();
            float scale = 0.2F;
            GL11.glScalef(scale, scale, scale);
            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
            GL11.glRotatef(90F, 0f, 0f, 1f);
            GL11.glRotatef(90F, 0f, 0f, 1.5f);
            GL11.glRotatef(90F, 0F, 1F, 0F);
            GL11.glScalef(0.7F, 0.7F, 0.7F);
            GL11.glRotatef(180F, 0F, 0F, 1F);
            GL11.glRotatef(90F, 0F, 1F, 0F);
            //GL11.glRotatef(0F, 0.0f, 1.0f, 0.0f);
            //GL11.glRotatef(45F, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0F, -1.2F, 0F);
            model.renderAll();
            GL11.glPopMatrix();
            break;

        case INVENTORY:
            GL11.glPushMatrix();
            scale = 0.16F;
            GL11.glScalef(scale, scale, scale);
            Minecraft.getMinecraft().renderEngine.bindTexture(texture);

            //GL11.glRotatef(200F, 1.0f, 0.0f, 0.0f);
            //GL11.glRotatef(-80F, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(1.2F, 1.2F, 1.2F);
            GL11.glTranslatef(0.3F, -3.5F, 0.5F);
            
            model.renderAll();
            GL11.glPopMatrix();
            break;

        default:
            break;
        }
    }
@Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
            ItemRendererHelper helper) {

        switch (type) {
        case INVENTORY:
            return true;
        default:
            break;
        }
        return false;

    }

}