package com.beamfield.tectocraft.handler;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class TectoCrafterRecipeSorter implements Comparator {

	final TectoCraftingManager tectoCrafter;


	public TectoCrafterRecipeSorter(TectoCraftingManager tectoCrafterCraftingManager) {
		this.tectoCrafter = tectoCrafterCraftingManager;
	}


	public int compareRecipies(IRecipe recipe1, IRecipe recipe2) {
		return recipe1 instanceof TectoCrafterShapelessRecipes && recipe2 instanceof TectoCrafterShapedRecipes ? 1 : (recipe2 instanceof TectoCrafterShapelessRecipes && recipe1 instanceof TectoCrafterShapedRecipes ? -1 : (recipe2.getRecipeSize() > recipe1.getRecipeSize() ? -1 : (recipe2.getRecipeSize() > recipe1.getRecipeSize() ? 1 : 0)));
	}


	@Override
	public int compare(Object recipe1, Object recipe2) {
		return this.compareRecipies((IRecipe)recipe1, (IRecipe)recipe2);
	}

}