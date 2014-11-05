package com.beamfield.tectocraft.gui;

import org.lwjgl.opengl.GL11;

import com.beamfield.tectocraft.gui.container.ContainerTectoOven;
import com.beamfield.tectocraft.reference.Reference;
import com.beamfield.tectocraft.tileentity.TileEntityTectonicOven;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiTectonicOven extends GuiContainer{

	public static final ResourceLocation bkGround = new ResourceLocation(Reference.MODID + ":" + "textures/gui/GuiTectoOven2.png");

	public TileEntityTectonicOven tectoOven;

	public GuiTectonicOven(InventoryPlayer inventoryPlayer, TileEntityTectonicOven entity) {
		super(new ContainerTectoOven(inventoryPlayer, entity));

		this.tectoOven = entity;

		this.xSize = 176;
		this.ySize = 166;


	}


	public void drawGuiContainerForegroundLayer(int par1, int par2) {
		String name = I18n.format("Tectonic Oven", new Object[0]); 

		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
		this.fontRendererObj.drawString(I18n.format("Power: "+ tectoOven.getEnergyStored()), 80, this.ySize - 96 + 5, 4210752);
	}


	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);

		Minecraft.getMinecraft().getTextureManager().bindTexture(bkGround);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		if(this.tectoOven.isBurning()) {
			int k = this.tectoOven.getBurnTimeRemainingScaled(48);
			int j = 48 - k;
			int i1;
			if(this.tectoOven.getEnergyStored() > 0){
				i1 = this.tectoOven.getPowerRemainingScaled(45);
				this.drawTexturedModalRect(guiLeft + 8, guiTop + 54 - i1, 176, 62 - i1, 16, i1);
			}
			//drawTexturedModalRect(guiLeft + 76, guiTop + 54, 176, 0, 48 - j, 8); 
		}

		int p = this.tectoOven.getCookProgressScaled(24);
		drawTexturedModalRect(guiLeft + 72, guiTop + 21, 176, 9, p, 17);
	}

}
