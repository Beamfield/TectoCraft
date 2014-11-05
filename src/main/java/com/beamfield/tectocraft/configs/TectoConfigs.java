package com.beamfield.tectocraft.configs;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.config.Configuration;

public class TectoConfigs {
	public static boolean hardTectoniumCraftingRecipe;
	public static boolean bindAcidParticles;
	public static boolean initOreDict;
	public static boolean checkForUpdates;
	public static boolean oreGen;
	public static Logger Log;
	
	public static void readConfig(Configuration config){
		hardTectoniumCraftingRecipe = config.get("Crafting", "isHard", true, "If this true, Tectonium will be hard to craft").getBoolean(true);
		bindAcidParticles = config.get("Particles", "emitAcidParticles", true, "If this true, Bind Acid will emit particles").getBoolean(true);
		initOreDict = config.get("OreDictionary", "oreDictionary", true, "If this is true the mod will initialize the OreDictionary").getBoolean(true);
		checkForUpdates = config.get("Update", "checkForUpdates", true, "When this is true the mod will check for updates automatically").getBoolean(true);
		oreGen = config.get("OreGen", "OreGen", true, "If this is true the mod will generate custom ores").getBoolean(true);
	}
}
