package com.beamfield.tectocraft.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.beamfield.tectocraft.gui.container.ContainerSmasher;
import com.beamfield.tectocraft.reference.Reference;
import com.beamfield.tectocraft.tileentity.TileEntityTectonicSmasher;

	public class GuiSmasher extends GuiContainer{
		public static final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/GuiSmasher.png");
		
		public TileEntityTectonicSmasher smasher;
		
		public GuiSmasher(InventoryPlayer invPlayer, TileEntityTectonicSmasher entity) {
			super(new ContainerSmasher(invPlayer, entity));
			
			this.smasher = entity;

			this.xSize = 176;
			this.ySize = 165;
		}
		
		public void drawGuiContainerForegroundLayer(int par1, int par2){
			String s = this.smasher.isInvNameLocalized() ? this.smasher.getInvName() : I18n.format(this.smasher.getInvName());
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
			this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 5, 4210752);
			this.fontRendererObj.drawString(I18n.format("Power: "+ smasher.power), 80, this.ySize - 96 + 5, 4210752);
		}
		
		public void drawGuiContainerBackgroundLayer(float f, int j, int i) {
			GL11.glColor4f(1F, 1F, 1F, 1F);
			
			Minecraft.getMinecraft().getTextureManager().
			bindTexture(texture);
			
			drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
			
			int i1;

			if(this.smasher.hasPower()){
				i1 = this.smasher.getPowerRemainingScaled(45);
				this.drawTexturedModalRect(guiLeft + 11, guiTop + 51 - i1, 176, 62 - i1, 16, i1);
			}
			
			i1 = this.smasher.getCookProgressScaled(24);
			this.drawTexturedModalRect(guiLeft + 72, guiTop + 22, 176, 0, i1 + 1, 16);
		}
	}