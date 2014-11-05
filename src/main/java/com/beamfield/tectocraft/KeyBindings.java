package com.beamfield.tectocraft;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

public class KeyBindings {
	//public static KeyBinding fly;
	public static KeyBinding refuel;
	
	public static void SetupKeyBindings() {
		
		//fly = new KeyBinding("key.fly", Keyboard.KEY_SPACE, "key.categories.tectocraft");
		refuel = new KeyBinding("key.refuel", Keyboard.KEY_F, "key.categories.tectocraft");
		
		
		//ClientRegistry.registerKeyBinding(fly);
		ClientRegistry.registerKeyBinding(refuel);
		
	}
}
