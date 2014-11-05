package com.beamfield.tectocraft.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import com.beamfield.tectocraft.TectoCraft;
import com.beamfield.tectocraft.configs.TectoConfigs;
import com.beamfield.tectocraft.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBindAcid extends BlockFluidClassic{

	@SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;
    
    public BlockBindAcid(Fluid fluid, Material material) {
            super(fluid, material);
            setCreativeTab(TectoCraft.tabTectoCraft);
            this.quantaPerBlock = 2;
    }
    
    @Override
    public IIcon getIcon(int side, int meta) {
            return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
            stillIcon = register.registerIcon(Reference.MODID+":bindAcidStill");
            flowingIcon = register.registerIcon(Reference.MODID+":bindAcidFlow");
    }
    
    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.canDisplace(world, x, y, z);
    }
    
    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.displaceIfPossible(world, x, y, z);
    }
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity){
    	if (entity instanceof EntityLivingBase)
		{
    	((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.poison.id, 1200, 1));
		}
    	int l = world.getBlockMetadata(x, y, z);
    	if(entity instanceof EntityItem && l == 0){
        	ItemStack item = ((EntityItem) entity).getEntityItem();

			if(item.getItem() == Item.getItemFromBlock(Blocks.iron_block) && TectoConfigs.hardTectoniumCraftingRecipe){
	        	entity.setDead();
				world.setBlock(x, y, z, TectoCraft.tectonium_block);
				world.playSound(x, y, z, "random.fizz", 10F, 10F, true);
			}	
		}
    }
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
      if ((random.nextInt(2) == 0) && TectoConfigs.bindAcidParticles) {
        world.spawnParticle("instantSpell", x + random.nextFloat(), y + 1.1F, z + random.nextFloat(), 0.0D, 0.05D, 0.0D);
      		}
   }
}
