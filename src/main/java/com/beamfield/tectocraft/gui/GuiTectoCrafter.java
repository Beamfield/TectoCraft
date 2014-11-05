package com.beamfield.tectocraft.gui;

import org.lwjgl.opengl.GL11;

import com.beamfield.tectocraft.gui.container.ContainerTectoCrafter;
import com.beamfield.tectocraft.reference.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class GuiTectoCrafter extends GuiContainer {

	private ResourceLocation texture = new ResourceLocation(Reference.MODID + ":" + "textures/gui/GuiTectoCrafter.png");


	public GuiTectoCrafter(InventoryPlayer invPlayer, World world, int x, int y, int z) {
		super(new ContainerTectoCrafter(invPlayer, world, x, y, z));

		this.xSize = 176;
		this.ySize = 198;
	}


	public void onGuiClosed() {
		super.onGuiClosed();
	}


	protected void drawGuiContainerForegroundLayer(int i, int j) {
		String name = I18n.format("Tectonic Crafter", new Object[0]);

		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 118, this.ySize - 96 + 2, 4210752);
	}


	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}