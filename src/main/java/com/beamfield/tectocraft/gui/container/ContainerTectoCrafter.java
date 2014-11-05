package com.beamfield.tectocraft.gui.container;

import com.beamfield.tectocraft.TectoCraft;
import com.beamfield.tectocraft.handler.TectoCraftingManager;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerTectoCrafter extends Container {

	public InventoryCrafting craftMatrix;
	public IInventory craftResult;
	private World worldObj;
	private int posX, posY, posZ;


	public ContainerTectoCrafter(InventoryPlayer invPlayer, World world, int x, int y, int z) {
		craftMatrix = new InventoryCrafting(this, 5, 5);
		craftResult = new InventoryCraftResult();
		worldObj = world;
		posX = x; posY = y; posZ = z;

		// Output slot
		this.addSlotToContainer(new SlotCrafting(invPlayer.player, craftMatrix, craftResult, 0, 141, 36));

		// 5x5 Crafting Area
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				this.addSlotToContainer(new Slot(craftMatrix, j + i * 5, 10 + j * 18, 18 + i * 18));
			}
		}

		// Player Inventory
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 116 + i * 18));
			}
		}

		// Hotbar
		for(int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 174));
		}

		onCraftMatrixChanged(craftMatrix);
	}


	public void onCraftMatrixChanged(IInventory inventory) {
		craftResult.setInventorySlotContents(0, TectoCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
	}


	@Override
	public boolean canInteractWith(EntityPlayer entityPlayer) {
		if(worldObj.getBlock(posX, posY, posZ) != TectoCraft.tectonic_crafter) {
			return false;
		} else {
			return entityPlayer.getDistanceSq((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D) <= 64.0D;
		}
	}


	// Handles Shift + Clicking items.
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int iSlot)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(iSlot);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (iSlot == 0) {													// CraftResult
                if (!this.mergeItemStack(itemstack1, 26, 62, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (iSlot >= 26 && iSlot < 53) {								// Player Inventory
                if (!this.mergeItemStack(itemstack1, 53, 62, false)) {
                    return null;
                }
            } else if (iSlot >= 53 && iSlot < 62) {								// Hotbar
                if (!this.mergeItemStack(itemstack1, 26, 53, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 26, 62, false)) {		// CraftMatrix
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }
    
    
    public void onContainerClosed(EntityPlayer entityPlayer)
    {
        super.onContainerClosed(entityPlayer);

        if (!this.worldObj.isRemote) {
            for (int i = 0; i < 25; i++) {
                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

                if (itemstack != null)
                    entityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
            }
        }
    }
    		
}




