package com.beamfield.tectocraft;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class OreRecipes {
	private static SmasherRecipes oreBase = SmasherRecipes.smelting();
	
	public static void addBlockRecipe(Block inputBlock, ItemStack output, float xp){
		oreBase.func_151393_a(inputBlock, output, xp);
	}
	public static void addItemRecipe(Item inputItem, ItemStack output, float xp){
		oreBase.func_151396_a(inputItem, output, xp);
	}
	public static SmasherRecipes getRecipes(){
		return oreBase;
	}
}
