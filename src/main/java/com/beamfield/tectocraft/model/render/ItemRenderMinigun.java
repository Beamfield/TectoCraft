package com.beamfield.tectocraft.model.render;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.beamfield.tectocraft.model.MinigunModel;

public class ItemRenderMinigun implements IItemRenderer {
    MinigunModel minigunModel;
    public ItemRenderMinigun() {
    	minigunModel = new MinigunModel();
    }
    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch (type) {

        case EQUIPPED: 
            GL11.glPushMatrix(); 
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(
                    "tectocraft:textures/models/minigun.png"));
            //GL11.glRotatef(0F, 1.0f, 0.0f, 0.0f);	  
            //GL11.glRotatef(-5F, 0.0f, 1.0f, 0.0f);
            GL11.glRotatef(180F, 0.3f, 0.6f, 0.2f);
            GL11.glRotatef(40, 1F, -1F, 0F);
            GL11.glTranslatef(0.5F, -0.2F, 0.2F);
            minigunModel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
                    0.0625F);
            GL11.glPopMatrix(); 
            break;
        case EQUIPPED_FIRST_PERSON:

            GL11.glPushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(
            		"tectocraft:textures/models/minigun.png"));
            GL11.glRotatef(180F, 0.3f, 0.6f, 0.2f);
            GL11.glRotatef(40, 0.3F, -1F, 0.3F);
            GL11.glRotatef(50, 0.3F, 0.3F, 30F);
            GL11.glTranslatef(0.5F, -0.2F, 0.2F);
            minigunModel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
                    0.0625F);
            GL11.glPopMatrix();
            break;

        case ENTITY:
            GL11.glPushMatrix();
            float scale = 1.5F;
            GL11.glScalef(scale, scale, scale);
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(
            		"tectocraft:textures/models/minigun.png"));
            GL11.glRotatef(90F, 0f, 0f, 1f);
            GL11.glRotatef(90F, 0f, 0f, 1.5f);
            GL11.glRotatef(90F, 0F, 1F, 0F);
            GL11.glScalef(0.7F, 0.7F, 0.7F);
            //GL11.glRotatef(0F, 0.0f, 1.0f, 0.0f);
            //GL11.glRotatef(45F, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(0.5F, -2.0F, 0.5F);
            minigunModel.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F,
                    0.0625F);
            GL11.glPopMatrix();
            break;

        case INVENTORY:
            GL11.glPushMatrix();
            scale = 0.7F;
            GL11.glScalef(scale, scale, scale);
            Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(
            		"tectocraft:textures/models/minigun.png"));

            //GL11.glRotatef(200F, 1.0f, 0.0f, 0.0f);
            //GL11.glRotatef(-80F, 0.0f, 1.0f, 0.0f);
            GL11.glScalef(1.5F, 1.5F, 1.5F);
            GL11.glTranslatef(0.3F, -0.7F, 0.5F);
            
            minigunModel.renderModel(0.0625F);
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