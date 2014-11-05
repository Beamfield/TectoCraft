package com.beamfield.tectocraft.enchantment;

import com.beamfield.tectocraft.TectoCraft;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;


public class OreFragments extends Enchantment{
	public OreFragments() {
		super(235, 10, EnumEnchantmentType.digger);
		this.setName("oreFragments");
	}

	public int getMaxLevel() {
		return 3;
	}

	public boolean canApplyTogether(Enchantment enchantment) {
		return super.canApplyTogether(enchantment) && enchantment.effectId != Enchantment.silkTouch.effectId && enchantment.effectId != TectoCraft.oreFragments.effectId;
	}
	public int getMinEnchantability(int level){
		return 5 + (level-1) * 10;
	}

	public int getMaxEnchantability(int level){
		return this.getMinEnchantability(level) + 30;
	}
}