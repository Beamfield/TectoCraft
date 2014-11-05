package com.beamfield.tectocraft;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;

public class SmasherRecipes
{
    private static final SmasherRecipes smeltingBase = new SmasherRecipes();
    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private static final String __OBFID = "CL_00000085";

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static SmasherRecipes smelting()
    {
        return smeltingBase;
    }

    private SmasherRecipes()
    {
        this.func_151393_a(Blocks.iron_ore, new ItemStack(TectoCraft.dustIron), 0.5F);
        this.func_151393_a(Blocks.gold_ore, new ItemStack(TectoCraft.dustGold), 0.5F);
        this.func_151393_a(TectoCraft.oreCopper, new ItemStack(TectoCraft.dustCopper), 0.5F);
        this.func_151393_a(TectoCraft.oreAluminum, new ItemStack(TectoCraft.dustAluminum), 0.5F);
        this.func_151393_a(TectoCraft.oreLead, new ItemStack(TectoCraft.dustLead), 0.5F);
        this.func_151393_a(TectoCraft.oreNickel, new ItemStack(TectoCraft.dustNickel), 0.5F);
        this.func_151393_a(TectoCraft.oreSilver, new ItemStack(TectoCraft.dustSilver), 0.5F);
        this.func_151393_a(TectoCraft.oreTin, new ItemStack(TectoCraft.dustTin), 0.5F);
        this.func_151393_a(Blocks.quartz_ore, new ItemStack(Items.quartz, 2), 0.5F);
        this.func_151393_a(Blocks.diamond_ore, new ItemStack(Items.diamond, 1), 0.5F);
        this.func_151393_a(Blocks.redstone_ore, new ItemStack(Items.redstone, 4), 0.5F);
        this.func_151393_a(Blocks.emerald_ore, new ItemStack(Items.emerald, 1), 0.5F);
        this.func_151393_a(Blocks.lapis_ore, new ItemStack(Items.dye, 3, 4), 0.5F);
        this.func_151393_a(Blocks.coal_ore, new ItemStack(Items.coal, 1), 0.5F);
        this.func_151396_a(TectoCraft.chunkLapis, new ItemStack(Items.dye, 3 , 4), 0.5F);
        this.func_151396_a(TectoCraft.chunkRedstone, new ItemStack(Items.redstone, 4), 0.5F);
        this.func_151396_a(TectoCraft.chunkLead, new ItemStack(TectoCraft.dustLead), 0.5F);
        this.func_151396_a(TectoCraft.chunkNickel, new ItemStack(TectoCraft.dustNickel), 0.5F);
        this.func_151396_a(TectoCraft.chunkTin, new ItemStack(TectoCraft.dustTin), 0.5F);
        this.func_151396_a(TectoCraft.chunkAluminum, new ItemStack(TectoCraft.dustAluminum), 0.5F);
        this.func_151396_a(TectoCraft.chunkSilver, new ItemStack(TectoCraft.dustSilver), 0.5F);
        this.func_151396_a(TectoCraft.chunkIron, new ItemStack(TectoCraft.dustIron), 0.5F);
        this.func_151396_a(TectoCraft.chunkGold, new ItemStack(TectoCraft.dustGold), 0.5F);
        this.func_151396_a(TectoCraft.chunkCopper, new ItemStack(TectoCraft.dustCopper), 0.5F);
    }

    public void func_151393_a(Block p_151393_1_, ItemStack p_151393_2_, float p_151393_3_)
    {
        this.func_151396_a(Item.getItemFromBlock(p_151393_1_), p_151393_2_, p_151393_3_);
    }

    public void func_151396_a(Item p_151396_1_, ItemStack p_151396_2_, float p_151396_3_)
    {
        this.func_151394_a(new ItemStack(p_151396_1_, 1, 32767), p_151396_2_, p_151396_3_);
    }

    public void func_151394_a(ItemStack p_151394_1_, ItemStack p_151394_2_, float p_151394_3_)
    {
        this.smeltingList.put(p_151394_1_, p_151394_2_);
        this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSmeltingResult(ItemStack p_151395_1_)
    {
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151395_1_, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
    {
        return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    public float func_151398_b(ItemStack p_151398_1_)
    {
        float ret = p_151398_1_.getItem().getSmeltingExperience(p_151398_1_);
        if (ret != -1) return ret;

        Iterator iterator = this.experienceList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(p_151398_1_, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}