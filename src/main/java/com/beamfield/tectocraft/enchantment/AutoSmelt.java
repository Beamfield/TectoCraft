package com.beamfield.tectocraft.enchantment;

import com.beamfield.tectocraft.TectoCraft;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;


public class AutoSmelt extends Enchantment{
	public AutoSmelt() {
		super(234, 10, EnumEnchantmentType.digger);
		this.setName("autoSmelt");
	}

	public int getMaxLevel() {
		return 2;
	}

	public boolean canApplyTogether(Enchantment enchantment) {
		return super.canApplyTogether(enchantment) && enchantment.effectId != Enchantment.silkTouch.effectId;
	}
	public int getMinEnchantability(int level){
		return 5 + (level-1) * 10;
	}

	public int getMaxEnchantability(int level){
		return this.getMinEnchantability(level) + 30;
	}
}