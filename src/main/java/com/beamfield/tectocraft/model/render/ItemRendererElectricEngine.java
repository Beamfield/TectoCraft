package com.beamfield.tectocraft.model.render;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.beamfield.tectocraft.model.motor_electric;
import com.beamfield.tectocraft.reference.Reference;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRendererElectricEngine implements IItemRenderer
{
    TileEntitySpecialRenderer render;
    private TileEntity entity;
    public ItemRendererElectricEngine(TileEntitySpecialRenderer render, TileEntity entity)
    {
    	this.entity = entity;
    	this.render = render;
    }

    @Override
    public boolean handleRenderType(ItemStack itemStack, ItemRenderType itemRenderType)
    {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType itemRenderType, ItemStack itemStack, ItemRendererHelper itemRendererHelper)
    {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType itemRenderType, ItemStack itemStack, Object... data)
    {
    	if(itemRenderType == IItemRenderer.ItemRenderType.ENTITY)
    	{
    		GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
    		GL11.glScalef(2F, 2F, 2F);
    	}
    	this.render.renderTileEntityAt(this.entity, 0.0D, 0.0D, 0.0D, 0.0F);
    }
}