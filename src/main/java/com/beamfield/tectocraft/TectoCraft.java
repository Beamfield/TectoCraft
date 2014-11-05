package com.beamfield.tectocraft;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import cofh.mod.updater.IUpdatableMod;

import com.beamfield.tectocraft.configs.TectoConfigs;
import com.beamfield.tectocraft.handler.GuiHandler;
import com.beamfield.tectocraft.handler.KeyInputHandler;
import com.beamfield.tectocraft.handler.TectoHandler;
import com.beamfield.tectocraft.handler.TradeHandler;
import com.beamfield.tectocraft.proxy.CommonProxy;
import com.beamfield.tectocraft.reference.Reference;
import com.beamfield.tectocraft.worldgen.TungstenWorldGen;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;


@Mod(modid=Reference.MODID, version=Reference.VERSION)
public class TectoCraft implements IUpdatableMod{
	@Instance(Reference.MODID)
	public static TectoCraft instance;
	//Items:
	public static Item tectonium;
	public static Item tectoMatrix;
	public static Item tungsten_dust;
	public static Item tungsten_ingot;
	public static Item minigun;
	public static Item rocket_thruster;
	public static Item rocket_sealing;
	public static Item rocket_casing;
	public static Item rocket_fuel;
	public static Item rocket;
	public static Item enderRemote;
	public static Item LED;
	public static Item enhancedEnderPearl;
	public static Item jetpack;
	public static Item flashLight;
	public static Item feedomatic;
	public static Item tectoRecipeBook;
	public static Item calculator;
	public static Item upgradeChipCalc;
	public static Item deathNote;
	public static Item bindAcidbucket;
	public static Item cottonItem;
	public static Item cottonFabric;
	public static Item pogoStick;
	public static Item iphone6;
	public static Item tectonicMultitool;
	public static Item bankNote;
	public static Item rainbow;
	
	//Ingots
	public static Item ingotLead;
	public static Item ingotSteel;
	public static Item ingotSilver;
	public static Item ingotNickel;
	public static Item ingotCopper;
	public static Item ingotBronze;
	public static Item ingotAluminum;
	public static Item ingotTin;
	//chunk 
	public static Item chunkLapis;
	public static Item chunkRedstone;
	public static Item chunkLead;
	public static Item chunkNickel;
	public static Item chunkTin;
	public static Item chunkAluminum;
	public static Item chunkSilver;
	public static Item chunkIron;
	public static Item chunkGold;
	public static Item chunkCopper;
	//Dusts
	public static Item dustSteel;
	public static Item dustBronze;
	public static Item dustCopper;
	public static Item dustTin;
	public static Item dustLead;
	public static Item dustAluminum;
	public static Item dustNickel;
	public static Item dustIron;
	public static Item dustGold;
	public static Item dustSilver;
	//Armors:
	public static Item tectoniumHelmet;
	public static Item tectoniumChestplate;
	public static Item tectoniumLeggings;
	public static Item tectoniumBoots;
	public static Item tectoBoots;
	public static int armorIDtectoniumHelmet;
	public static int armorIDtectoniumChestplate;
	public static int armorIDtectoniumLeggings;
	public static int armorIDtectoniumBoots;
	public static int armorIDjetpack;
	public static int armorIDtectoBoots;
	//Materials:
	public static final Item.ToolMaterial TectoniumMaterial = EnumHelper.addToolMaterial("TectoniumMaterial", 2, 1343, 7.0F, 3.0F, 10);
	public static final ItemArmor.ArmorMaterial TectoniumMaterialArmor = EnumHelper.addArmorMaterial("TectoniumMaterialArmor", 17, new int[] {2, 6, 5, 2}, 9);
	public static final Item.ToolMaterial NethersBaneMaterial = EnumHelper.addToolMaterial("NethersBaneMaterial", 3, -1, 7.0F, 70.0F, 50);	
	public static final Item.ToolMaterial MultitoolMaterial = EnumHelper.addToolMaterial("MultitoolMaterial", 5, 1, 50F, 50.0F, 50);	
	//Tools:
	public static Item tectoniumSword;
	public static Item nethersBane;
	public static Item tectoniumPickaxe;
	public static Item tectoniumSpade;
	public static Item tectoniumAxe;
	public static Item tectoniumHoe;
	public static Item acidRod;
	public static Item megaMagnet;
	public static Item hammer;
	//Blocks:
	public static Block tectonium_block;
	public static Block tungsten_ore;
	public static Block tungsten_block;
	public static Block tectonic_crafter;
	public static Block tectoOven_idle;
	public static Block tectoOven_active;
	public static Block flashLight0;
	public static Block tectoWall;
	public static Block electricEngine;
	public static Block oilEngine;
	public static Block oilPump;
	public static Block fluidPipe;
	public static Block liquidTank;
	public static Block electricPipe;
	public static Block cottonCrop;
	public static Block fabricBlock;
	public static Block blockSmasherIdle;
	public static Block blockSmasherActive;
	
	//Ore
	public static Block oreAluminum;
	public static Block oreCopper;
	public static Block oreLead;
	public static Block oreNickel;
	public static Block oreSilver;
	public static Block oreTin;
	//Fluids:
	public static Block bindAcidBlock;
	public static Fluid bindAcid;
	//Achievement:
	public static Achievement achievementHighTemperatures;

	//GUI:
	public static final int guiIDTectoCrafter = 1701;
	public static final int guiIDTectoOven = 1702;
	public static final int guiIDRecipeBook = 1703;
	public static final int guiIDCalculator = 1704;
	public static final int guiIDSmasher = 1705;
	
	//Enchantments:
	public static Enchantment autoSmelt;
	public static Enchantment oreFragments;
	
	//CreativeTab:
	public static CreativeTabs tabTectoCraft = new CreativeTabs("tectocraft")
	{
		public Item getTabIconItem()
		{
			return tectonium;
		}
	};
	//WorldGen:
	TungstenWorldGen eventWorldGen = new TungstenWorldGen();
	@SidedProxy(clientSide=Reference.CLProxyLoc, serverSide=Reference.CProxyLoc)
	public static CommonProxy proxy;
	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.registerRenderers();
		ModRegistry.init();
		
	}
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		 if (FMLCommonHandler.instance().getSide().isClient())
	        {
			 	KeyBindings.SetupKeyBindings();
				FMLCommonHandler.instance().bus().register(new KeyInputHandler());
	        }
		ModRegistry.preInit();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		
		//FMLCommonHandler.instance().bus().register(new ClientTickHandler());
		System.out.println("[TectoCraft] AutoUpdate System initialized");
		for (int i = 0; i < 5; ++i) {
			VillagerRegistry.instance().registerVillageTradeHandler(i, new TradeHandler());
		}
	}
	@EventHandler
	public void onPreInitializationEvent(FMLPreInitializationEvent event){
		TectoConfigs.Log = event.getModLog();
		Configuration configFile = new Configuration(event.getSuggestedConfigurationFile());
		TectoConfigs.readConfig(configFile);
		if(configFile.hasChanged())configFile.save();
	}
	@EventHandler
	public void onInitializationEvent(FMLInitializationEvent event){
		
	}
	@EventHandler
	public void load(FMLInitializationEvent event){
		ModRegistry.init();
		MinecraftForge.EVENT_BUS.register(new TectoHandler());
		proxy.load();
		TectoHandler.INSTANCE.buckets.put(TectoCraft.bindAcidBlock, bindAcidbucket);
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		SmasherRecipes.smelting();
	}
	@Override
	public Logger getLogger() {
		return LogManager.getLogger(Reference.MODID);
	}
	@Override
	public String getModId() {
		return Reference.MODID;
	}
	@Override
	public String getModName() {
		return Reference.MODNAME;
	}
	@Override
	public String getModVersion() {
		return Reference.VERSION;
	}
}
