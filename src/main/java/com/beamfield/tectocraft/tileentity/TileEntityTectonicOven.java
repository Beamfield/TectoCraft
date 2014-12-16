package com.beamfield.tectocraft.tileentity;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.oredict.OreDictionary;
import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyConnection;
import cofh.api.energy.IEnergyStorage;

import com.beamfield.tectocraft.TectoCraft;
import com.beamfield.tectocraft.block.TectonicOven;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityTectonicOven extends TileEntity implements ISidedInventory, IEnergyConnection, IEnergyStorage{
	private String localizedName;
	private EnergyStorage energyStorage;
	private int cycledTicks;
	private static final int[] slots_top = new int[]{0};
	private static final int[] slots_bottom = new int[]{2, 1};
	private static final int[] slots_side = new int[]{1};
	private static final int[] slots_upgrade = new int[]{3, 4, 5};

	private ItemStack[] slots = new ItemStack [6];

	public static int furnaceSpeed = 150;
	public int burnTime;				
	public int currentItemBurnTime;		
	public int cookTime;	
	public int maxPower = 15000;

	public static boolean isItemFuel(ItemStack itemStack) {
		return getItemBurnTime(itemStack) > 0;
	}
	public TileEntityTectonicOven(){
		super();
		energyStorage = new EnergyStorage(getMaxEnergyStored());
		cycledTicks = -1;
	}
	private static int getItemBurnTime(ItemStack itemStack) {
		if(itemStack == null) {
			return 0;
		} else {
			Item item = itemStack.getItem();

			if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air) {
				Block block = Block.getBlockFromItem(item);

				if (block == Blocks.wooden_slab)
                    return 150;

                if (block.getMaterial() == Material.wood)
                    return 300;

                if (block == Blocks.coal_block)
                    return 16000;
			}

            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;

			return GameRegistry.getFuelValue(itemStack);
		}
	}

	 
	public int getPowerRemainingScaled(int par1){
    	return this.getEnergyStored() * par1 / this.getMaxEnergyStored();
	}
	public void updateEntity() {
		boolean flag = this.burnTime > 0;
		boolean flag1 = false;

		if(this.isBurning())
			this.burnTime--;
			this.energyStorage.setEnergyStored(getEnergyStored() - 1);

		if(!this.worldObj.isRemote) {
			if(this.burnTime == 0 && this.canSmelt()) {
				this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.slots[1]);
				if(this.isBurning()) {
					flag1 = true;

					if(this.slots[1] != null) {
						this.slots[1].stackSize--;

						if(this.slots[1].stackSize == 0) {
							this.slots[1] = this.slots[1].getItem().getContainerItem(this.slots[1]);
						}
					}
				}
			}
		}
	}
		 	public boolean hasPower()
	    	{
	        	return this.energyStorage.getEnergyStored() > 0;
	    	}
	    
		 	public int getItemPower(ItemStack par0ItemStack){
	        	if (par0ItemStack == null){
	            	return 0;
	        	}else{
	        		Item i = par0ItemStack.getItem();
	        	
	        		if (i == Items.redstone) return 10;
	        		if(i == Item.getItemFromBlock(Blocks.redstone_block)) return 90;
	            	return 0;
	        	}
	}
	public boolean canSmelt() {
		if(this.slots[0] == null) {
			return false;
		} else {
			ItemStack itemStack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);

			if(itemStack == null)
				return false;

			if(this.slots[2] == null)
				return true;

			if(!this.slots[2].isItemEqual(itemStack))
				return false;

			int result = this.slots[2].stackSize + itemStack.stackSize;

			return (result <= getInventoryStackLimit() && result <= itemStack.getMaxStackSize());
		}			
	}


	public void smeltItem() {
		if(this.canSmelt()) {
			ItemStack itemStack = FurnaceRecipes.smelting().getSmeltingResult(this.slots[0]);
			ItemStack stack = this.slots[0];

			if(this.slots[2] == null) {
				this.slots[2] = itemStack.copy();
			} else if(this.slots[2].isItemEqual(itemStack)) {
				this.slots[2].stackSize += itemStack.stackSize;
			}

			this.slots[0].stackSize--;
			if(slots[0].getItem() != TectoCraft.tectoMatrix){
				Random rnd = new Random();
				int chance = rnd.nextInt(5);
				if(chance == 3)
				this.slots[2].stackSize++;
			}

			if(this.slots[0].stackSize <= 0) {
				this.slots[0] = null;
			}
		}
	}
	public boolean canDouble(ItemStack itemstack){
		String[] oreNames = OreDictionary.getOreNames();
	
		for(int i = 0; i < oreNames.length; i++){
			if(oreNames[i].contains("ore") || oreNames[i].contains("dust")){
    			if(OreDictionary.getOres(oreNames[i]) != null){
    				if(OreDictionary.getOres(oreNames[i]).get(0) == itemstack){
    					return true;        			
    				}
    			}
			}
		}
	
		return false;
	}

	public boolean isBurning() {
		return this.burnTime > 0;
	}


	public void setGuiDisplayName(String displayName) {
		this.localizedName = displayName;
	}


	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.localizedName : "Tectonic Oven";
	}


	public boolean hasCustomInventoryName() {
		return this.localizedName != null && this.localizedName.length() > 0;
	}


	public int getSizeInventory() {
		return this.slots.length;
	}


	@Override
	public ItemStack getStackInSlot(int var1) {
		return this.slots[var1];
	}


	@Override
	public ItemStack decrStackSize(int slot, int var2) {
		if(this.slots[slot] != null) {
			ItemStack itemStack;

			if(this.slots[slot].stackSize <= var2) {
				itemStack = this.slots[slot];
				this.slots[slot] = null;
				return itemStack;
			} else {
				itemStack = this.slots[slot].splitStack(var2);

				if(this.slots[slot].stackSize == 0) {
					this.slots[slot] = null;
				}
				return itemStack;
			}
		} else {
			return null;
		}
	}
	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if(this.slots[slot] != null) {
			ItemStack itemStack = this.slots[slot];
			this.slots[slot] = null;
			return itemStack;
		}
		return null;
	}


	@Override
	public void setInventorySlotContents(int slot, ItemStack itemStack) {
		this.slots[slot] = itemStack;

		if(itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
			itemStack.stackSize = this.getInventoryStackLimit();
		}
	}


	@Override
	public int getInventoryStackLimit() {
		return 64;
	}


	@Override
	public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}


	public void openInventory() {		

	}


	public void closeInventory() {

	}


	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
		return slot == 2 ? false : (slot == 1 ? isItemFuel(itemStack) : true);
	}


	@Override
	public int[] getAccessibleSlotsFromSide(int blockFace) {
		return blockFace == 0 ? slots_bottom : (blockFace == 1 ? slots_top : slots_side);
	}


	@Override
	public boolean canInsertItem(int i, ItemStack itemStack, int j) {
		return this.isItemValidForSlot(i, itemStack);
	}


	@Override
	public boolean canExtractItem(int i, ItemStack itemStack, int j) {
		return j != 0 || i != 1 || itemStack.getItem() == Items.bucket;
	}


	public int getBurnTimeRemainingScaled(int i) {
		if(this.currentItemBurnTime == 0) {
			this.currentItemBurnTime = this.furnaceSpeed;
		}

		return this.burnTime * i / this.currentItemBurnTime;
	}


	public int getCookProgressScaled(int i) {
		return this.cookTime * i / this.furnaceSpeed;
	}


	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if(nbt.hasKey("energyStorage")){
			this.energyStorage.readFromNBT(nbt.getCompoundTag("energyStorage"));
		}
		if(nbt.hasKey("cycledTicks")){
			cycledTicks = nbt.getInteger("cycledTicks");
		}
		NBTTagList list = nbt.getTagList("Items", 10);
		this.slots = new ItemStack[this.getSizeInventory()];

		for(int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound compound = (NBTTagCompound)list.getCompoundTagAt(i);
			byte b = compound.getByte("Slot");

			if(b >= 0 && b < this.slots.length) {
				this.slots[b] = ItemStack.loadItemStackFromNBT(compound);
			}
		}

		this.burnTime = (int)nbt.getShort("BurnTime");
		this.cookTime = (int)nbt.getShort("CookTime");
		this.currentItemBurnTime = (int)nbt.getShort("CurrentItemBurnTime");

		if(nbt.hasKey("CustomName")) {
			this.localizedName = nbt.getString("CustomName");
		}
	}


	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		NBTTagCompound energyTag = new NBTTagCompound();
		this.energyStorage.writeToNBT(energyTag);
		nbt.setTag("energyStorage", energyTag);
		nbt.setInteger("cycledTicks", cycledTicks);
		nbt.setShort("BurnTime", (short)this.burnTime);
		nbt.setShort("CookTime", (short)this.cookTime);
		nbt.setShort("CurrentItemBurnTime", (short)this.currentItemBurnTime);

		NBTTagList list = new NBTTagList();

		for(int i = 0; i < this.slots.length; i++) {
			if(this.slots[i] != null) {
				NBTTagCompound compound = new NBTTagCompound();
				compound.setByte("Slot", (byte)i);
				this.slots[i].writeToNBT(compound);
				list.appendTag(compound);
			}
		}

		nbt.setTag("Items", list);

		if(this.hasCustomInventoryName()) {
			nbt.setString("CustomName", this.localizedName);
		}
	}
	@Override
	public boolean canConnectEnergy(ForgeDirection arg0) {
		return true;
	}
	@Override
	public int extractEnergy(int arg0, boolean arg1) {
		return energyStorage.extractEnergy(arg0, arg1);
	}
	@Override
	public int getEnergyStored() {
		return energyStorage.getEnergyStored();
	}
	@Override
	public int getMaxEnergyStored() {
		return 10000;
	}
	@Override
	public int receiveEnergy(int arg0, boolean arg1) {
		return energyStorage.receiveEnergy(arg0, arg1);
	}


}
