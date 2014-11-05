package com.beamfield.tectocraft.block;

import java.util.Random;

import com.beamfield.tectocraft.TectoCraft;
import com.beamfield.tectocraft.reference.Reference;
import com.beamfield.tectocraft.tileentity.TileEntityTectonicOven;
import com.beamfield.tectocraft.tileentity.TileEntityTectonicSmasher;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TectonicSmasher extends BlockContainer implements IElectricalDevice, IWrenchableDevice{

	private final boolean isActive;

	private static boolean keepInventory;

	private Random rand = new Random();

	@SideOnly(Side.CLIENT)
	private IIcon iconFront;

	@SideOnly(Side.CLIENT)
	private IIcon iconTop;


	// Constructor
	public TectonicSmasher(boolean isActive) {
		super(Material.iron);

		this.isActive = isActive;
		this.setHardness(3.5F);
		this.setStepSound(soundTypeMetal);
	}


	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon("iron_block");
		this.iconFront = iconRegister.registerIcon(Reference.MODID  + ":" + (this.isActive ? "smasher_front_active" : "smasher_front_idle"));
		this.iconTop = iconRegister.registerIcon("iron_block");	
	}


	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		if (metadata == 0 && side == 3)
	         return this.iconFront;		

		return side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side != metadata ? this.blockIcon : this.iconFront));
	}


	public Item getItemDropped(int i, Random random, int j) {
		return Item.getItemFromBlock(TectoCraft.blockSmasherIdle);
	}


	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}



	private void setDefaultDirection(World world, int x, int y, int z) {
		if(!world.isRemote) {
			Block block0 = world.getBlock(x, y, z - 1);
			Block block1 = world.getBlock(x, y, z + 1);
			Block block2 = world.getBlock(x - 1, y, z);
			Block block3 = world.getBlock(x + 1, y, z);

			byte byte0 = 3;

			if(block0.func_149730_j() && !block1.func_149730_j())
				byte0 = 3;

			if(block1.func_149730_j() && !block0.func_149730_j())
				byte0 = 2;

			if(block2.func_149730_j() && !block3.func_149730_j())
				byte0 = 5;

			if(block3.func_149730_j() && !block2.func_149730_j())
				byte0 = 4;

			world.setBlockMetadataWithNotify(x, y, z, byte0, 2);
		}
	}


	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			FMLNetworkHandler.openGui(player, TectoCraft.instance, TectoCraft.guiIDSmasher, world, x, y, z);
		}

		return true;
	}


	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityTectonicSmasher();
	}


	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		if(this.isActive) {
			int direction = world.getBlockMetadata(x, y, z);

			float x1 = (float)x + 0.5F;
			float y1 = (float)y + random.nextFloat();
			float z1 = (float)z + 0.5F;

			float f = 0.52F;
			float f1 = random.nextFloat() * 0.6F - 0.3F;

			if(direction == 4) {
				world.spawnParticle("smoke", (double)(x1 - f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
				world.spawnParticle("flame", (double)(x1 - f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
			} else if(direction == 5) {
				world.spawnParticle("smoke", (double)(x1 + f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
				world.spawnParticle("flame", (double)(x1 + f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
			} else if(direction == 2) {
				world.spawnParticle("smoke", (double)(x1 + f1), (double)(y1), (double)(z1 - f), 0D, 0D, 0D);
				world.spawnParticle("flame", (double)(x1 + f1), (double)(y1), (double)(z1 - f), 0D, 0D, 0D);
			} else if(direction == 3) {
				world.spawnParticle("smoke", (double)(x1 + f1), (double)(y1), (double)(z1 + f), 0D, 0D, 0D);
				world.spawnParticle("flame", (double)(x1 + f1), (double)(y1), (double)(z1 + f), 0D, 0D, 0D);
			}
		}
	}


	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityPlayer, ItemStack itemStack) {
		int direction = MathHelper.floor_double((double)(entityPlayer.rotationYaw * 4.0F / 360.0F) + 0.50) & 3;

		if(direction == 0)
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);

		if(direction == 1)
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);

		if(direction == 2)
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);

		if(direction == 3)
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);

		if(itemStack.hasDisplayName()) {}
			((TileEntityTectonicSmasher)world.getTileEntity(x, y, z)).setGuiDisplayName(itemStack.getDisplayName());
	}


	public void breakBlock(World world, int x, int y, int z, Block oldBlock, int oldMetadata) {
		if(!keepInventory) {
			TileEntityTectonicSmasher tileEntity = (TileEntityTectonicSmasher)world.getTileEntity(x, y, z);

			if(tileEntity != null) {
				for(int i = 0; i < tileEntity.getSizeInventory(); i++) {
					ItemStack itemStack = tileEntity.getStackInSlot(i);

					if(itemStack != null) {
						float f = this.rand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.rand.nextFloat() * 0.8F + 0.1F;

						while(itemStack.stackSize > 0) {
							int j = this.rand.nextInt(21) + 10;

							if(j > itemStack.stackSize)
								j = itemStack.stackSize;

							itemStack.stackSize -= j;

							EntityItem item = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemStack.getItem(), j, itemStack.getItemDamage()));

							if(itemStack.hasTagCompound())
								item.getEntityItem().setTagCompound((NBTTagCompound)itemStack.getTagCompound().copy());

							world.spawnEntityInWorld(item);
						}
					}
				}
				world.func_147453_f(x, y, z, oldBlock);
			}
		}
		super.breakBlock(world, x, y, z, oldBlock, oldMetadata);
	}


	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(TectoCraft.blockSmasherIdle);
	}


	public static void updateForgeOvenBlockState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord) {
		int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		TileEntity tileEntity = worldObj.getTileEntity(xCoord, yCoord, zCoord);

		keepInventory = true;

		if(active) {
			worldObj.setBlock(xCoord, yCoord, zCoord, TectoCraft.blockSmasherActive);
		} else {
			worldObj.setBlock(xCoord, yCoord, zCoord, TectoCraft.blockSmasherIdle);
		}

		keepInventory = false;

		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

		if(tileEntity != null) {
			tileEntity.validate();
			worldObj.setTileEntity(xCoord, yCoord, zCoord, tileEntity);
		}
	}
	@Override
	public void onWrenchRightClick(World world, EntityPlayer player, int x, int y, int z, int side, int metadata) {
			world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z)+1, 2);
			if(world.getBlockMetadata(x, y, z) > 5){
				world.setBlockMetadataWithNotify(x, y, z, 2, 2);
			}
	}

	@Override
	public void onWrenchSneakRightClick(World world, EntityPlayer player, int x, int y, int z, int side, int metadata) {
			ItemStack drop = new ItemStack(Item.getItemFromBlock(world.getBlock(x, y, z)));
			world.setBlockToAir(x, y, z);
			player.inventory.addItemStackToInventory(drop);
			player.playSound("random.pop", 1F, 1F);
	}

}
