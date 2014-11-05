package com.beamfield.tectocraft.handler;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.beamfield.tectocraft.OreRecipes;
import com.beamfield.tectocraft.TectoCraft;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class TectoHandler{
	@SubscribeEvent
		public void playerHarvestEvent(HarvestDropsEvent event){
		if (event.harvester != null && event.harvester instanceof EntityPlayer) {
			if(event.block == Blocks.tallgrass){
				event.dropChance = (float) 0.1;
				event.drops.add(new ItemStack(TectoCraft.cottonItem));
			}
		}
	}
	
	@SubscribeEvent
	public void smeltDropsEvent(HarvestDropsEvent event){
		try{
		if(event.harvester != null && event.harvester instanceof EntityPlayer){
			/**ItemStack smeltRecipe = FurnaceRecipes.smelting().getSmeltingResult(new ItemStack(event.block));
			if(event.block != null && smeltRecipe != null){
				int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(TectoCraft.autoSmelt.effectId, event.harvester.getCurrentEquippedItem());
				int enchantmentLevel0 = EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, event.harvester.getCurrentEquippedItem());
				if(enchantmentLevel == 1){
				event.drops.add(smeltRecipe);
				System.out.println("Dropped "+ smeltRecipe.getDisplayName());
				}
				if(enchantmentLevel == 2){
					Random fortuneRand = new Random();
					event.drops.add(smeltRecipe);
				}
			}
**/
				int enchantmentLevel2 = EnchantmentHelper.getEnchantmentLevel(TectoCraft.oreFragments.effectId, event.harvester.getCurrentEquippedItem());
				if(enchantmentLevel2 > 0){
					Random rnd = new Random();
					try{
						int chance2 = 0;
						switch(enchantmentLevel2){
						case 1: 
							chance2 = rnd.nextInt(10);
							break;
						case 2:
							chance2 = rnd.nextInt(7);
							break;
						case 3:
							chance2 = rnd.nextInt(5);
						}
					if(chance2 == 3){
					if(event.block == Blocks.lapis_ore){
					event.drops.add(new ItemStack(TectoCraft.chunkLapis));
					}
					if(event.block == Blocks.redstone_ore){
					event.drops.add(new ItemStack(TectoCraft.chunkRedstone));
					}
					if(event.block.getUnlocalizedName().contains("orelead") || event.block.getUnlocalizedName().contains("oreLead")){
					event.drops.add(new ItemStack(TectoCraft.chunkLead));
					}
					if(event.block.getUnlocalizedName().contains("orenickel") || event.block.getUnlocalizedName().contains("oreNickel")){
					event.drops.add(new ItemStack(TectoCraft.chunkNickel));
					}
					if(event.block.getUnlocalizedName().contains("oretin") || event.block.getUnlocalizedName().contains("oreTin")){
					event.drops.add(new ItemStack(TectoCraft.chunkTin));
					}
					if(event.block.getUnlocalizedName().contains("orealuminum") || event.block.getUnlocalizedName().contains("oreAluminum")){
					event.drops.add(new ItemStack(TectoCraft.chunkAluminum));
					}
					if(event.block.getUnlocalizedName().contains("oresilver") || event.block.getUnlocalizedName().contains("oreSilver")){
					event.drops.add(new ItemStack(TectoCraft.chunkSilver));
					}
					if(event.block == Blocks.iron_ore){
					event.drops.add(new ItemStack(TectoCraft.chunkIron));
					}
					if(event.block == Blocks.gold_ore){
					event.drops.add(new ItemStack(TectoCraft.chunkGold));
					}
					if(event.block.getUnlocalizedName().contains("orecopper") || event.block.getUnlocalizedName().contains("oreCopper")){
					event.drops.add(new ItemStack(TectoCraft.chunkCopper));
					}
					}
					}
						catch(Exception e){
					}
				}
			
			
		if (event.block == Blocks.iron_ore) {
			int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(TectoCraft.autoSmelt.effectId, event.harvester.getCurrentEquippedItem());
			if (enchantmentLevel > 0) {
				event.drops.clear();
				event.drops.add(new ItemStack(Items.iron_ingot));
			}
		}

		else if (event.block == Blocks.gold_ore) {
			int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(TectoCraft.autoSmelt.effectId, event.harvester.getCurrentEquippedItem());
			if (enchantmentLevel > 0) {
				event.drops.clear();
				event.drops.add(new ItemStack(Items.gold_ingot));
			}
		}
		if (event.block == Blocks.cobblestone) {
			int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(TectoCraft.autoSmelt.effectId, event.harvester.getCurrentEquippedItem());
			if (enchantmentLevel > 0) {
				event.drops.clear();
				event.drops.add(new ItemStack(Blocks.stone));
			}
		}

		else if (event.block == Blocks.netherrack) {
			int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(TectoCraft.autoSmelt.effectId, event.harvester.getCurrentEquippedItem());
			if (enchantmentLevel > 0) {
				event.drops.clear();
				event.drops.add(new ItemStack(Items.netherbrick));
			}
		}

		else if (event.block == Blocks.sand) {
			int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(TectoCraft.autoSmelt.effectId, event.harvester.getCurrentEquippedItem());
			if (enchantmentLevel > 0) {
				event.drops.clear();
				event.drops.add(new ItemStack(Blocks.glass));
			}
		}

		else if (event.block == Blocks.clay) {
			int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(TectoCraft.autoSmelt.effectId, event.harvester.getCurrentEquippedItem());
			if (enchantmentLevel > 0) {
				event.drops.clear();
				event.drops.add(new ItemStack(Items.brick, 4));
			}
		}

		else if (event.block == Blocks.clay) {
			int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(TectoCraft.autoSmelt.effectId, event.harvester.getCurrentEquippedItem());
			if (enchantmentLevel > 0) {
				event.drops.clear();
				event.drops.add(new ItemStack(Items.brick, 4));
			}
		}

		else if (event.block == Blocks.cactus) {
			int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(TectoCraft.autoSmelt.effectId, event.harvester.getCurrentEquippedItem());
			if (enchantmentLevel > 0) {
				event.drops.clear();
				event.drops.add(new ItemStack(Items.dye, 1, 2));
			}
		}
		else if (event.block == TectoCraft.tungsten_ore) {
			int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(TectoCraft.autoSmelt.effectId, event.harvester.getCurrentEquippedItem());
			if (enchantmentLevel > 0) {
				event.drops.clear();
				event.drops.add(new ItemStack(TectoCraft.tungsten_ingot));
			}
		}
		if (event.block == Blocks.log || event.block == Blocks.log2) {
			int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(TectoCraft.autoSmelt.effectId, event.harvester.getCurrentEquippedItem());
			if (enchantmentLevel > 0) {
				event.drops.clear();
				event.drops.add(new ItemStack(Items.coal, 1, 1));
			}
		}
		if (event.block == Blocks.sand || event.block == Blocks.sand) {
			int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(TectoCraft.autoSmelt.effectId, event.harvester.getCurrentEquippedItem());
			if (enchantmentLevel > 0) {
				event.drops.clear();
				event.drops.add(new ItemStack(Blocks.glass, 1, 1));
			}
		}
		if (event.block == TectoCraft.oreAluminum) {
			int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(TectoCraft.autoSmelt.effectId, event.harvester.getCurrentEquippedItem());
			if (enchantmentLevel > 0) {
				event.drops.clear();
				event.drops.add(new ItemStack(TectoCraft.ingotAluminum));
			}
		}
		if (event.block == TectoCraft.oreCopper) {
			int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(TectoCraft.autoSmelt.effectId, event.harvester.getCurrentEquippedItem());
			if (enchantmentLevel > 0) {
				event.drops.clear();
				event.drops.add(new ItemStack(TectoCraft.ingotCopper));
			}
		}
		if (event.block == TectoCraft.oreLead) {
			int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(TectoCraft.autoSmelt.effectId, event.harvester.getCurrentEquippedItem());
			if (enchantmentLevel > 0) {
				event.drops.clear();
				event.drops.add(new ItemStack(TectoCraft.ingotLead));
			}
		}
		if (event.block == TectoCraft.oreNickel) {
			int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(TectoCraft.autoSmelt.effectId, event.harvester.getCurrentEquippedItem());
			if (enchantmentLevel > 0) {
				event.drops.clear();
				event.drops.add(new ItemStack(TectoCraft.ingotNickel));
			}
		}
		if (event.block == TectoCraft.oreSilver) {
			int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(TectoCraft.autoSmelt.effectId, event.harvester.getCurrentEquippedItem());
			if (enchantmentLevel > 0) {
				event.drops.clear();
				event.drops.add(new ItemStack(TectoCraft.ingotSilver));
			}
		}
		if (event.block == TectoCraft.oreTin){
			int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(TectoCraft.autoSmelt.effectId, event.harvester.getCurrentEquippedItem());
			if (enchantmentLevel > 0) {
				event.drops.clear();
				event.drops.add(new ItemStack(TectoCraft.ingotTin));
			}
		}
			}
		}catch(Exception e){
			
		}
	}
	  public static TectoHandler INSTANCE = new TectoHandler();
      public Map<Block, Item> buckets = new HashMap<Block, Item>();

      public TectoHandler() {
      }
      @SubscribeEvent(priority = EventPriority.HIGHEST)
      public void onBucketFill(FillBucketEvent event) {

              ItemStack result = fillCustomBucket(event.world, event.target);

              if (result == null)
                      return;

              event.result = result;
              event.setResult(Result.ALLOW);
      }

      private ItemStack fillCustomBucket(World world, MovingObjectPosition pos) {

              Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);

              Item bucket = buckets.get(block);
              if (bucket != null && world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0) {
                      world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
                      return new ItemStack(bucket);
              } else
                      return null;

      }
}
