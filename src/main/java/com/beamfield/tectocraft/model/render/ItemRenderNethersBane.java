package com.beamfield.tectocraft.model.render;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;


public class ItemRenderNethersBane implements IItemRenderer {
    private IModelCustom model;
    private ResourceLocation texture;
    public ItemRenderNethersBane() {
    	model = AdvancedModelLoader.loadModel(new ResourceLocation("tectocraft:models/sword1.obj"));
    	texture =  new ResourceLocation("tectocraft:models/sw_sword.png");
    }
    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type) {

        case EQUIPPED: 
            GL11.glPushMatrix(); 
            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
            GL11.glRotatef(180, 1, 0, 1);
            //GL11.glRotatef(30, 1, 0, -0.5f);
            GL11.glRotatef(30, 2, 0, -0.5f);
            GL11.glTranslatef(0.37F, -0.6F, 1.2F);
            GL11.glScalef(0.5f, 0.5f, 0.5f);
            model.renderAll();
            GL11.glPopMatrix(); 
            break;
        case EQUIPPED_FIRST_PERSON:

            GL11.glPushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
            GL11.glRotatef(180, 1F, 0F, 1F);
            GL11.glScalef(1F, 1F, 1F);
            GL11.glRotatef(180F, 0F, 1F, 0F);
            GL11.glRotatef(180, 0, 1, 1);
            GL11.glRotatef(60, 1, 0, 0);
            GL11.glRotatef(30, 1, 0, 0f);
            GL11.glTranslatef(1.5F, -1F, 2F);
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
            GL11.glScalef(4F, 4F, 4F);
            GL11.glRotatef(180F, 0F, 0F, 1F);
            GL11.glRotatef(90F, 0F, 1F, 0F);
            //GL11.glRotatef(0F, 0.0f, 1.0f, 0.0f);
            //GL11.glRotatef(45F, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0F, 2F, 0F);
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
            GL11.glScalef(3F, 3F, 3F);
            GL11.glRotatef(180, 0, 0, 0);
            GL11.glTranslatef(0.3F, -0.4F, 0.5F);
            
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