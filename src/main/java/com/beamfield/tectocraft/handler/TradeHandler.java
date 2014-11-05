package com.beamfield.tectocraft.handler;

import java.util.Random;

import com.beamfield.tectocraft.TectoCraft;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Tuple;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class TradeHandler implements IVillageTradeHandler {

	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random)
	{
		switch(villager.getProfession()) {
		case 0:
			recipeList.add(new MerchantRecipe(new ItemStack(TectoCraft.bankNote, 2, 6), new ItemStack(TectoCraft.iphone6, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(TectoCraft.bankNote, 2, 4), new ItemStack(TectoCraft.rainbow, 1)));
			break;
		case 1: 
			recipeList.add(new MerchantRecipe(new ItemStack(TectoCraft.bankNote, 2, 6), new ItemStack(TectoCraft.iphone6, 1)));    
			recipeList.add(new MerchantRecipe(new ItemStack(TectoCraft.bankNote, 2, 4), new ItemStack(TectoCraft.rainbow, 1)));
			break;
		case 2: 
			recipeList.add(new MerchantRecipe(new ItemStack(TectoCraft.bankNote, 2, 6), new ItemStack(TectoCraft.iphone6, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(TectoCraft.bankNote, 2, 4), new ItemStack(TectoCraft.rainbow, 1)));
			break;
		case 3: 
			recipeList.add(new MerchantRecipe(new ItemStack(TectoCraft.bankNote, 2, 6), new ItemStack(TectoCraft.iphone6, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(TectoCraft.bankNote, 2, 4), new ItemStack(TectoCraft.rainbow, 1)));
			break;
		case 4:
			recipeList.add(new MerchantRecipe(new ItemStack(TectoCraft.bankNote, 2, 6), new ItemStack(TectoCraft.iphone6, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(TectoCraft.bankNote, 2, 4), new ItemStack(TectoCraft.rainbow, 1)));
			break;
		default:
			break;
		}
	}

}
