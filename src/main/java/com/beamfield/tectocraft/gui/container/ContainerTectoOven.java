package com.beamfield.tectocraft.gui.container;

import com.beamfield.tectocraft.tileentity.TileEntityTectonicOven;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class ContainerTectoOven extends Container {
	private TileEntityTectonicOven tectoOven;
	public int lastBurnTime;				
	public int lastCurrentItemBurnTime;		
	public int lastCookTime;				

	public ContainerTectoOven(InventoryPlayer inventory, TileEntityTectonicOven tileEntity) {
		this.tectoOven = tileEntity;

		this.addSlotToContainer(new Slot(tileEntity, 0, 51, 21));
		//energy
		this.addSlotToContainer(new Slot(tileEntity, 1, 8, 58));
		this.addSlotToContainer(new SlotFurnace(inventory.player, tileEntity, 2, 109, 22));
		this.addSlotToContainer(new Slot(tileEntity, 3, 150, 9));
		this.addSlotToContainer(new Slot(tileEntity, 4, 150, 33));
		this.addSlotToContainer(new Slot(tileEntity, 5, 150, 57)); 
		


		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++){
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for(int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}


	public void addCraftingToCrafters(ICrafting crafting) {
		super.addCraftingToCrafters(crafting);

		crafting.sendProgressBarUpdate(this, 0, this.tectoOven.cookTime);
		crafting.sendProgressBarUpdate(this, 1, this.tectoOven.burnTime);
		crafting.sendProgressBarUpdate(this, 2, this.tectoOven.currentItemBurnTime);
	}


	public void detectAndSendChanges() {
		super.detectAndSendChanges();

		for(int i = 0; i < this.crafters.size(); i++) {
			ICrafting crafting = (ICrafting)this.crafters.get(i);

			if(this.lastCookTime != this.tectoOven.cookTime)
				crafting.sendProgressBarUpdate(this, 0, this.tectoOven.cookTime);

			if(this.lastBurnTime != this.tectoOven.cookTime)
				crafting.sendProgressBarUpdate(this, 1, this.tectoOven.burnTime);

			if(this.lastCurrentItemBurnTime != this.tectoOven.cookTime)
				crafting.sendProgressBarUpdate(this, 2, this.tectoOven.currentItemBurnTime);
		}

		this.lastCookTime = this.tectoOven.cookTime;
		this.lastBurnTime = this.tectoOven.burnTime;
		this.lastCurrentItemBurnTime = this.tectoOven.currentItemBurnTime;
	}


	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int slot, int newValue) {
		if(slot == 0)
			this.tectoOven.cookTime = newValue;

		if(slot == 1)
			this.tectoOven.burnTime = newValue;

		if(slot == 2)
			this.tectoOven.currentItemBurnTime = newValue;
	}


	@Override
	public boolean canInteractWith(EntityPlayer entityPlayer) {
		return true;
	}
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 2) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (par2 != 1 && par2 != 0) {
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                        return null;
                    }
                } else if (TileEntityTectonicOven.isItemFuel(itemstack1)) {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
                        return null;
                    }
                } else if (par2 >= 3 && par2 < 30) {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
                        return null;
                    }
                } else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0)
                slot.putStack((ItemStack)null);
            else
                slot.onSlotChanged();

            if (itemstack1.stackSize == itemstack.stackSize)
                return null;

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }
}
