package com.beamfield.tectocraft.gui;

import java.util.Arrays;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.beamfield.tectocraft.TectoCraft;
import com.beamfield.tectocraft.reference.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiRecipeBook extends GuiScreen{

	public static int pageNumber = 0;
	public ResourceLocation tcbackground = new ResourceLocation(Reference.MODID + ":" + "textures/gui/recipebook/tcbackground.png");
	public ResourceLocation tclayer1 = new ResourceLocation(Reference.MODID + ":" + "textures/gui/recipebook/tclayer1.png");
	public ResourceLocation tclayer2 = new ResourceLocation(Reference.MODID + ":" + "textures/gui/recipebook/tclayer2.png");
	public ResourceLocation tclayer3 = new ResourceLocation(Reference.MODID + ":" + "textures/gui/recipebook/tclayer3.png");
	public GuiRecipeBook(EntityPlayer p_i1080_1_, ItemStack p_i1080_2_,
			boolean p_i1080_3_) {
		super();
	}
	public GuiRecipeBook(InventoryPlayer inventory, World world, int x, int y,
			int z) {
		super();
	}
	private ResourceLocation texture = new ResourceLocation(Reference.MODID + ":" + "textures/gui/recipeBook.png");
	public final int xSizeOfTexture = 256;
	public final int ySizeOfTexture = 256;

	@Override
	public boolean doesGuiPauseGame()
	{
	return false;
	}

	public void drawScreen(int x, int y, float f)
	{
	drawDefaultBackground();

    super.drawScreen(x, y, f);
	
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	this.mc.renderEngine.bindTexture(texture);

	int posX = (this.width - xSizeOfTexture) / 2;
	int posY = (this.height - ySizeOfTexture) / 2;

	drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
    
 
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);    
    /**
     * TC Crafter MBlock Layers
     */
    if(pageNumber == 0){
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    this.mc.getTextureManager().bindTexture(tclayer1);
	drawTexturedModalRect(posX+103, posY+60, 0, 0, xSizeOfTexture, ySizeOfTexture);

    this.drawCenteredString(this.fontRendererObj, I18n.format("Tectonic Crafter Layer 1", new Object[0]), this.width / 2, 90, 16777215);
    }else if(pageNumber == 1){
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.mc.getTextureManager().bindTexture(tclayer2);
        	drawTexturedModalRect(posX+103, posY+60, 0, 0, xSizeOfTexture, ySizeOfTexture);

            this.drawCenteredString(this.fontRendererObj, I18n.format("Tectonic Crafter Layer 2", new Object[0]), this.width / 2, 90, 16777215);
    }else if(pageNumber == 2){
    		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         this.mc.getTextureManager().bindTexture(tclayer3);
     	drawTexturedModalRect(posX+103, posY+60, 0, 0, xSizeOfTexture, ySizeOfTexture);

        this.drawCenteredString(this.fontRendererObj, I18n.format("Tectonic Crafter Layer 3", new Object[0]), this.width / 2, 90, 16777215);
        //Diamond
    }else if(pageNumber == 3){
    	
    	this.drawCenteredString(this.fontRendererObj, I18n.format("Diamond", new Object[0]), this.width / 2, 85, 16777215);
    	 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   	 	this.mc.getTextureManager().bindTexture(tcbackground);
   		drawTexturedModalRect(posX+60, posY+50, 0, 0, xSizeOfTexture, ySizeOfTexture);
   		
   	//1. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-67, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-67, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-67, (this.height/2)-41);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-67, (this.height/2)-23);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-67, (this.height/2)-5);
   		//2. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-49, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-49, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-49, (this.height/2)-41);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-49, (this.height/2)-23);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-49, (this.height/2)-5);
   		//3. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-31, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-31, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-31, (this.height/2)-41);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-31, (this.height/2)-23);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-31, (this.height/2)-5);
   		//4. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-13, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-13, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-13, (this.height/2)-41);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-13, (this.height/2)-23);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-13, (this.height/2)-5);
   		//5. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)+5, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)+5, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)+5, (this.height/2)-41);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)+5, (this.height/2)-23);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)+5, (this.height/2)-5);
   		//Output
   		RenderHelper.enableGUIStandardItemLighting();
   		itemRender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.diamond), (this.width / 2)+64, (this.height/2)-60);
   		//Rocket Casing
    }else if(pageNumber == 4){
    	
    	this.drawCenteredString(this.fontRendererObj, I18n.format("Rocket Casing", new Object[0]), this.width / 2, 85, 16777215);
    	 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   	 	this.mc.getTextureManager().bindTexture(tcbackground);
   		drawTexturedModalRect(posX+60, posY+50, 0, 0, xSizeOfTexture, ySizeOfTexture);
   		RenderHelper.enableGUIStandardItemLighting();
   	//1. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.iron_ingot), (this.width / 2)-67, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)-67, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)-67, (this.height/2)-23);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.iron_ingot), (this.width / 2)-67, (this.height/2)-5);
   		//2. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.iron_ingot), (this.width / 2)-49, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)-49, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)-49, (this.height/2)-23);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.iron_ingot), (this.width / 2)-49, (this.height/2)-5);
   		//3. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.iron_ingot), (this.width / 2)-31, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)-31, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)-31, (this.height/2)-23);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.iron_ingot), (this.width / 2)-31, (this.height/2)-5);
   		//4. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.iron_ingot), (this.width / 2)-13, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)-13, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)-13, (this.height/2)-23);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.iron_ingot), (this.width / 2)-13, (this.height/2)-5);
   		//5. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.iron_ingot), (this.width / 2)+5, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)+5, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)+5, (this.height/2)-23);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.iron_ingot), (this.width / 2)+5, (this.height/2)-5);
   		//Output
   		
   		itemRender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.rocket_casing), (this.width / 2)+64, (this.height/2)-60);	
    }else if(pageNumber == 5){
    	
    	this.drawCenteredString(this.fontRendererObj, I18n.format("Rocket Sealing", new Object[0]), this.width / 2, 85, 16777215);
    	 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   	 	this.mc.getTextureManager().bindTexture(tcbackground);
   		drawTexturedModalRect(posX+60, posY+50, 0, 0, xSizeOfTexture, ySizeOfTexture);
   		RenderHelper.enableGUIStandardItemLighting();
   		//1. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)-67, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.iron_ingot), (this.width / 2)-67, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.quartz), (this.width / 2)-67, (this.height/2)-41);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.diamond), (this.width / 2)-67, (this.height/2)-23);
   		RenderHelper.disableStandardItemLighting();
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-67, (this.height/2)-5);
   		RenderHelper.enableGUIStandardItemLighting();
   		//2. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)-49, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.iron_ingot), (this.width / 2)-49, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.quartz), (this.width / 2)-49, (this.height/2)-41);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.diamond), (this.width / 2)-49, (this.height/2)-23);
   		RenderHelper.disableStandardItemLighting();
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-49, (this.height/2)-5);
   		RenderHelper.enableGUIStandardItemLighting();
   		//3. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)-31, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.iron_ingot), (this.width / 2)-31, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.quartz), (this.width / 2)-31, (this.height/2)-41);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.diamond), (this.width / 2)-31, (this.height/2)-23);
   		RenderHelper.disableStandardItemLighting();
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-31, (this.height/2)-5);
   		RenderHelper.enableGUIStandardItemLighting();
   		//4. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)-13, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.iron_ingot), (this.width / 2)-13, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.quartz), (this.width / 2)-13, (this.height/2)-41);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.diamond), (this.width / 2)-13, (this.height/2)-23);
   		RenderHelper.disableStandardItemLighting();
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)-13, (this.height/2)-5);
   		RenderHelper.enableGUIStandardItemLighting();
   		//5. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)+5, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.iron_ingot), (this.width / 2)+5, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.quartz), (this.width / 2)+5, (this.height/2)-41);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.diamond), (this.width / 2)+5, (this.height/2)-23);
   		RenderHelper.disableStandardItemLighting();
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.coal_block)), (this.width / 2)+5, (this.height/2)-5);
   		RenderHelper.enableGUIStandardItemLighting();
   		//Output
   		
   		itemRender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.rocket_sealing), (this.width / 2)+64, (this.height/2)-60);	
    }else if(pageNumber == 6){
    	
    	this.drawCenteredString(this.fontRendererObj, I18n.format("Rocket Thruster", new Object[0]), this.width / 2, 85, 16777215);
    	 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   	 	this.mc.getTextureManager().bindTexture(tcbackground);
   		drawTexturedModalRect(posX+60, posY+50, 0, 0, xSizeOfTexture, ySizeOfTexture);
   		RenderHelper.enableGUIStandardItemLighting();
   		//1. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)-67, (this.height/2)-41);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)-67, (this.height/2)-23);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)-67, (this.height/2)-5);
   		//2. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)-49, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.LED), (this.width / 2)-49, (this.height/2)-23);
   		//3. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.rocket_sealing), (this.width / 2)-31, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)-31, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.rocket_fuel), (this.width / 2)-31, (this.height/2)-23);
   		//4. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)-13, (this.height/2)-59);
   		RenderHelper.disableStandardItemLighting();
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.tnt)), (this.width / 2)-13, (this.height/2)-23);
   		RenderHelper.enableGUIStandardItemLighting();
   		//5. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)+5, (this.height/2)-41);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)+5, (this.height/2)-23);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tungsten_ingot), (this.width / 2)+5, (this.height/2)-5);
   		
   		//Output
   		
   		itemRender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.rocket_thruster), (this.width / 2)+64, (this.height/2)-60);	
    }else if(pageNumber == 7){
    	
    	this.drawCenteredString(this.fontRendererObj, I18n.format("Solid Fueled Rocket", new Object[0]), this.width / 2, 85, 16777215);
    	 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   	 	this.mc.getTextureManager().bindTexture(tcbackground);
   		drawTexturedModalRect(posX+60, posY+50, 0, 0, xSizeOfTexture, ySizeOfTexture);
   		
   	//1. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.rocket_casing), (this.width / 2)-67, (this.height/2)-23);
   		//2. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.rocket_casing), (this.width / 2)-49, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.rocket_casing), (this.width / 2)-49, (this.height/2)-41);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.rocket_casing), (this.width / 2)-49, (this.height/2)-23);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.rocket_thruster), (this.width / 2)-49, (this.height/2)-5);
   		//3. Oszlop
   		RenderHelper.disableStandardItemLighting();
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.iron_block)), (this.width / 2)-31, (this.height/2)-77);
   		RenderHelper.enableGUIStandardItemLighting();
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.glass_pane)), (this.width / 2)-31, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.rocket_casing), (this.width / 2)-31, (this.height/2)-41);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.rocket_casing), (this.width / 2)-31, (this.height/2)-23);
   		//4. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.rocket_casing), (this.width / 2)-13, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.rocket_casing), (this.width / 2)-13, (this.height/2)-41);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.rocket_casing), (this.width / 2)-13, (this.height/2)-23);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.rocket_thruster), (this.width / 2)-13, (this.height/2)-5);
   		//5. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.rocket_casing), (this.width / 2)+5, (this.height/2)-23);
   		//Output
   		RenderHelper.enableGUIStandardItemLighting();
   		itemRender.renderItemIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.rocket), (this.width / 2)+64, (this.height/2)-60);
   		//Rocket Casing
    }else if(pageNumber == 8){
    	
    	this.drawCenteredString(this.fontRendererObj, I18n.format("Nether's Bane", new Object[0]), this.width / 2, 85, 16777215);
    	 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   	 	this.mc.getTextureManager().bindTexture(tcbackground);
   		drawTexturedModalRect(posX+60, posY+50, 0, 0, xSizeOfTexture, ySizeOfTexture);
   		RenderHelper.enableGUIStandardItemLighting();
   	//1. Oszlop
   		RenderHelper.disableStandardItemLighting();
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.emerald_block)), (this.width / 2)-67, (this.height/2)-23);
   		RenderHelper.enableGUIStandardItemLighting();
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.stick), (this.width / 2)-67, (this.height/2)-5);
   		//2. Oszlop
   		RenderHelper.disableStandardItemLighting();
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Blocks.diamond_block), (this.width / 2)-49, (this.height/2)-41);
   		RenderHelper.enableGUIStandardItemLighting();
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Items.nether_star), (this.width / 2)-49, (this.height/2)-23);
   		RenderHelper.disableStandardItemLighting();
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.emerald_block)), (this.width / 2)-49, (this.height/2)-5);
   		RenderHelper.enableGUIStandardItemLighting();
   		//3. Oszlop
   		RenderHelper.disableStandardItemLighting();
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.diamond_block)), (this.width / 2)-31, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Blocks.diamond_block), (this.width / 2)-31, (this.height/2)-41);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.diamond_block)), (this.width / 2)-31, (this.height/2)-23);
   		RenderHelper.enableGUIStandardItemLighting();
   		//4. Oszlop
   		RenderHelper.disableStandardItemLighting();
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.diamond_block)), (this.width / 2)-13, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Blocks.diamond_block), (this.width / 2)-13, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Blocks.diamond_block), (this.width / 2)-13, (this.height/2)-41);
   		RenderHelper.enableGUIStandardItemLighting();
   		//5. Oszlop
   		RenderHelper.disableStandardItemLighting();
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.diamond_block)), (this.width / 2)+5, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(Blocks.diamond_block)), (this.width / 2)+5, (this.height/2)-59);
   		RenderHelper.enableGUIStandardItemLighting();
   		//Output
   		
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.nethersBane), (this.width / 2)+64, (this.height/2)-60);	
    }else if(pageNumber == 9){
    	
    	this.drawCenteredString(this.fontRendererObj, I18n.format("Tectonic Mace", new Object[0]), this.width / 2, 85, 16777215);
    	 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   	 	this.mc.getTextureManager().bindTexture(tcbackground);
   		drawTexturedModalRect(posX+60, posY+50, 0, 0, xSizeOfTexture, ySizeOfTexture);
   		RenderHelper.disableStandardItemLighting();
   		//1. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(TectoCraft.tungsten_block)), (this.width / 2)-67, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(TectoCraft.tungsten_block)), (this.width / 2)-67, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(TectoCraft.tungsten_block)), (this.width / 2)-49, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(TectoCraft.tungsten_block)), (this.width / 2)-49, (this.height/2)-59);
   		//3. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.nethersBane), (this.width / 2)-31, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(TectoCraft.tungsten_block)), (this.width / 2)-31, (this.height/2)-59);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(TectoCraft.tungsten_block)), (this.width / 2)-31, (this.height/2)-41);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(TectoCraft.tungsten_block)), (this.width / 2)-31, (this.height/2)-23);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(TectoCraft.tungsten_block)), (this.width / 2)-31, (this.height/2)-5);
   		//4. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(TectoCraft.tungsten_block)), (this.width / 2)-13, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(TectoCraft.tungsten_block)), (this.width / 2)-13, (this.height/2)-59);
   		//5. Oszlop
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(TectoCraft.tungsten_block)), (this.width / 2)+5, (this.height/2)-77);
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(Item.getItemFromBlock(TectoCraft.tungsten_block)), (this.width / 2)+5, (this.height/2)-59);
   		//Output
   		
   		itemRender.renderItemAndEffectIntoGUI(this.fontRendererObj, this.mc.getTextureManager(), new ItemStack(TectoCraft.tectonicMultitool), (this.width / 2)+64, (this.height/2)-60);	
    }
    RenderHelper.disableStandardItemLighting();
    this.drawCenteredString(this.fontRendererObj, I18n.format(pageNumberS, new Object[0]), this.width / 2, 65, 16777215);
	
	super.drawScreen(x, y, f);
	}
	String pageNumberS = "Page: "+pageNumber;
	String title;
	public void initGui()
	{
	this.buttonList.clear();
	title = Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem().getDisplayName();
	int posX = (this.width - xSizeOfTexture) / 2;
	int posY = (this.height - ySizeOfTexture) / 2;


	this.buttonList.add(new GuiButton(0, posX+ 15, posY + 9, 28, 20, "<<"));
	this.buttonList.add(new GuiButton(1, posX+ 205, posY + 9, 28, 20, ">>"));
	RenderHelper.enableGUIStandardItemLighting();
	}
	public void actionPerformed(GuiButton button)
	{
	switch(button.id)
	{
	case 0: 
		pageNumber = pageNumber - 1;
		if(pageNumber < 1)pageNumber = 0;
		updateScreen();
		break;
	case 1:
		if(pageNumber > 8)pageNumber=8;
		updateScreen();
		pageNumber = pageNumber + 1;
		break;
	default:
		break;
		}
	}
	@Override
	public void updateScreen(){
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		World world = Minecraft.getMinecraft().theWorld;
		int x1 = (int) player.posX;
	 	int y1 = (int) player.posY;
	 	int z1 = (int) player.posZ;
		player.openGui(TectoCraft.instance, TectoCraft.guiIDRecipeBook, world, x1, y1, z1);
		super.updateScreen();
		
	}
}
