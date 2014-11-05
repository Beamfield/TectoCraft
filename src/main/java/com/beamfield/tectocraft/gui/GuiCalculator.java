package com.beamfield.tectocraft.gui;

import java.awt.event.KeyEvent;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import scala.swing.event.Key;

import com.beamfield.tectocraft.TectoCraft;
import com.beamfield.tectocraft.reference.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiCalculator extends GuiScreen{
	private ResourceLocation texture = new ResourceLocation(Reference.MODID + ":" + "textures/gui/recipeBook.png");

	public final int xSizeOfTexture = 256;
	public final int ySizeOfTexture = 256;
	private GuiTextField textfield;
	public GuiCalculator(InventoryPlayer inventory, World world, int x, int y,
			int z) {
		super();
	}
	@Override
	public boolean doesGuiPauseGame()
	{
	return false;
	}
	
	public void drawScreen(int x, int y, float f)
	{
	drawDefaultBackground();

    
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	this.mc.renderEngine.bindTexture(texture);

	int posX = (this.width - xSizeOfTexture) / 2;
	int posY = (this.height - ySizeOfTexture) / 2;

	drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
    
	textfield.drawTextBox();
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); 
    super.drawScreen(x, y, f);
	}
	String equation;
	public void initGui()
	{	
		buttonList.clear();
		int posX = (this.width - xSizeOfTexture) / 2;
		int posY = (this.height - ySizeOfTexture) / 2;
		textfield = new GuiTextField(fontRendererObj, posX+15, posY+9, 217, 20);
		this.buttonList.add(new GuiButton(0, posX+ 15, posY + 40, 28, 20, "CE"));
		
		this.buttonList.add(new GuiButton(1, posX+ 60, posY + 40, 28, 20, "1"));
		this.buttonList.add(new GuiButton(2, posX+ 105, posY + 40, 28, 20, "2"));
		this.buttonList.add(new GuiButton(3, posX+ 150, posY + 40, 28, 20, "3"));
		this.buttonList.add(new GuiButton(4, posX+ 195, posY + 40, 28, 20, "4"));
		this.buttonList.add(new GuiButton(5, posX+ 60, posY + 75, 28, 20, "5"));
		this.buttonList.add(new GuiButton(6, posX+ 105, posY + 75, 28, 20, "6"));
		this.buttonList.add(new GuiButton(7, posX+ 150, posY + 75, 28, 20, "7"));
		this.buttonList.add(new GuiButton(8, posX+ 195, posY + 75, 28, 20, "8"));
		this.buttonList.add(new GuiButton(9, posX+ 60, posY + 105, 28, 20, "9"));
		this.buttonList.add(new GuiButton(10, posX+ 105, posY + 105, 28, 20, "0"));
		this.buttonList.add(new GuiButton(11, posX+ 150, posY + 105, 28, 20, "+"));
		this.buttonList.add(new GuiButton(12, posX+ 195, posY + 105, 28, 20, "-"));
		this.buttonList.add(new GuiButton(13, posX+ 60, posY + 135, 28, 20, "*"));
		this.buttonList.add(new GuiButton(14, posX+ 105, posY + 135, 28, 20, "/"));
		this.buttonList.add(new GuiButton(15, posX+ 150, posY + 135, 28, 20, "BIN"));
		this.buttonList.add(new GuiButton(16, posX+ 195, posY + 135, 28, 20, "HEX"));
		this.buttonList.add(new GuiButton(17, posX+ 15, posY + 75, 28, 20, "="));
		this.buttonList.add(new GuiButton(18, posX+ 15, posY + 105, 28, 20, "."));
		this.buttonList.add(new GuiButton(19, posX+ 15, posY + 135, 28, 20, "SQRT"));
		
		textfield.setFocused(false);
		textfield.setMaxStringLength(33);
	}
	public void keyTyped(char c, int i){
		super.keyTyped(c, i);
		textfield.textboxKeyTyped(c, i);
	}
	public void mouseClicked(int i, int j, int k){
		super.mouseClicked(i, j, k);
		textfield.mouseClicked(i, j, k);
	}
	public void actionPerformed(GuiButton button)
	{
		float value = 0;
		float prevValue = 0;
		String operation = ""; //0:def, 1:+, 2:-, 3:*, 4:/,
		boolean operation_pressed = false;
		switch(button.id){
		case 0:
			textfield.setText("");
			break;
			
		case 1:
			textfield.setText(textfield.getText() + "1");
			if(!textfield.getText().isEmpty() && isNumeric(textfield.getText())){
				value = Float.parseFloat(textfield.getText());
			}
			break;
		case 2:
			textfield.setText(textfield.getText() + "2");
			if(!textfield.getText().isEmpty() && isNumeric(textfield.getText())){
				value = Float.parseFloat(textfield.getText());
			}
			break;
		case 3:
			textfield.setText(textfield.getText() + "3");
			if(!textfield.getText().isEmpty() && isNumeric(textfield.getText())){
				value = Float.parseFloat(textfield.getText());
			}
			break;
		case 4:
			textfield.setText(textfield.getText() + "4");
			if(!textfield.getText().isEmpty() && isNumeric(textfield.getText())){
				value = Float.parseFloat(textfield.getText());
			}
			break;
		case 5:
			textfield.setText(textfield.getText() + "5");
			if(!textfield.getText().isEmpty() && isNumeric(textfield.getText())){
				value = Float.parseFloat(textfield.getText());
			}
			break;
		case 6:
			textfield.setText(textfield.getText() + "6");
			if(!textfield.getText().isEmpty() && isNumeric(textfield.getText())){
				value = Float.parseFloat(textfield.getText());
			}
			break;
		case 7:
			textfield.setText(textfield.getText() + "7");
			if(!textfield.getText().isEmpty() && isNumeric(textfield.getText())){
				value = Float.parseFloat(textfield.getText());
			}
			break;
		case 8:
			textfield.setText(textfield.getText() + "8");
			if(!textfield.getText().isEmpty() && isNumeric(textfield.getText())){
				value = Float.parseFloat(textfield.getText());
			}
			break;
		case 9:
			textfield.setText(textfield.getText() + "9");
			if(!textfield.getText().isEmpty() && isNumeric(textfield.getText())){
				value = Float.parseFloat(textfield.getText());
			}
			break;
		case 10:
			textfield.setText(textfield.getText() + "0");
			if(!textfield.getText().isEmpty() && isNumeric(textfield.getText())){
				value = Float.parseFloat(textfield.getText());
			}
			break;
		case 11://+
			operation = "+";
			if(!textfield.getText().isEmpty() && isNumeric(textfield.getText())){
				operation_pressed = true;
				prevValue = Float.parseFloat(textfield.getText());
				}
			textfield.setText("");
			break;
		case 12://-
			operation = "-";
			if(!textfield.getText().isEmpty() && isNumeric(textfield.getText())){
				operation_pressed = true;
				prevValue = Float.parseFloat(textfield.getText());
			}
			textfield.setText("");
			break;
		case 13://*
			operation = "*";
			if(!textfield.getText().isEmpty() && isNumeric(textfield.getText())){
				operation_pressed = true;
				prevValue = Float.parseFloat(textfield.getText());
			}
			textfield.setText("");
			break;
		case 14:///
			operation = "/";
			if(!textfield.getText().isEmpty() && isNumeric(textfield.getText())){
				operation_pressed = true;
				prevValue = Float.parseFloat(textfield.getText());
			}
			textfield.setText("");
		break;
		case 15: //Dec
			if(!textfield.getText().isEmpty() && isNumeric(textfield.getText())){
			try{
				value = Integer.parseInt(textfield.getText());
				textfield.setText(Integer.toBinaryString((int) value));
			}
			catch(Exception e){
				textfield.setText("ERROR  [Exception TextToBinary]");
			}
			}
			break;
		case 16: //Hex
			if(!textfield.getText().isEmpty() && isNumeric(textfield.getText())){
			try{
				int beforeHex = Integer.parseInt(textfield.getText());
				textfield.setText(Integer.toHexString(beforeHex));
			}
			catch(Exception e){
				textfield.setText("ERROR  [Exception TextToHex]");
			}
			}
			break;
		case 17://=
			if(operation.equals("+")){
				textfield.setText(Double.toString(value + prevValue));
			}else if(operation.equals("-")){
				textfield.setText(Double.toString(value - prevValue));
			}else if(operation.equals("*")){
				textfield.setText(Double.toString(value * prevValue));
			}else if(operation.equals("/")){
				textfield.setText(Double.toString(value / prevValue));
				}
			operation_pressed = false;
			break;
		case 18:
			textfield.setText(textfield.getText() + ".");
			break;
		case 19:
			if(!textfield.getText().isEmpty() && isNumeric(textfield.getText())){
				try{
					textfield.setText(Double.toString(Math.sqrt((double)Integer.parseInt(textfield.getText()))));
				}
				catch(Exception e){
					textfield.setText("ERROR  [Exception TextToDouble]");
				}
				}
		}		
	}
	@Override
	public void updateScreen(){
	}
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    float d = Float.parseFloat(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
}
