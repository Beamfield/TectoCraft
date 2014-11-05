package com.beamfield.tectocraft.handler;

import net.minecraft.client.Minecraft;

import com.beamfield.tectocraft.KeyBindings;
import com.beamfield.tectocraft.items.Jetpack;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputHandler {

	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) {
		
		/**if(KeyBindings.fly.isPressed()){
			Jetpack.canFly = true;
			Minecraft.getMinecraft().thePlayer.setJumping(true);
		}else{
			Jetpack.canFly = false;
		}
			
		*/
		if(KeyBindings.refuel.isPressed()){
			Jetpack.refuel = true;
			}
			else{
				Jetpack.refuel = false;
			}
	}
}
