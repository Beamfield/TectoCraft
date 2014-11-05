package com.beamfield.tectocraft.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;

import com.beamfield.tectocraft.OreRecipes;
import com.beamfield.tectocraft.tileentity.TileEntityTectonicSmasher;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

	public class ContainerSmasher extends Container
	{
		private TileEntityTectonicSmasher smasher;
		private int lastCookTime;
		private int lastBurnTime;

		public ContainerSmasher(InventoryPlayer par1InventoryPlayer, TileEntityTectonicSmasher par2TileEntityFurnace)
		{
			this.smasher = par2TileEntityFurnace;
			this.addSlotToContainer(new Slot(par2TileEntityFurnace, 0, 51, 21));
			this.addSlotToContainer(new Slot(par2TileEntityFurnace, 1, 11, 55));
			this.addSlotToContainer(new SlotFurnace(par1InventoryPlayer.player, par2TileEntityFurnace, 2, 109, 22));
			int i;

			for (i = 0; i < 3; ++i)
			{
				for (int j = 0; j < 9; ++j)
				{
					this.addSlotToContainer(new Slot(par1InventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
				}
			}

			for (i = 0; i < 9; ++i)
			{
				this.addSlotToContainer(new Slot(par1InventoryPlayer, i, 8 + i * 18, 142));
			}
		}

		public void addCraftingToCrafters(ICrafting par1ICrafting)
		{
			super.addCraftingToCrafters(par1ICrafting);
			par1ICrafting.sendProgressBarUpdate(this, 0, this.smasher.cookTime);
			par1ICrafting.sendProgressBarUpdate(this, 1, this.smasher.power);
		}

		public void detectAndSendChanges()
		{
			super.detectAndSendChanges();

			for (int i = 0; i < this.crafters.size(); ++i)
			{
				ICrafting icrafting = (ICrafting)this.crafters.get(i);

				if (this.lastCookTime != this.smasher.cookTime)
				{
					icrafting.sendProgressBarUpdate(this, 0, this.smasher.cookTime);
				}

				if (this.lastBurnTime != this.smasher.power)
				{
					icrafting.sendProgressBarUpdate(this, 1, this.smasher.power);
				}
			}

			this.lastCookTime = this.smasher.cookTime;
			this.lastBurnTime = this.smasher.power;
		}

		@SideOnly(Side.CLIENT)
		public void updateProgressBar(int par1, int par2)
		{
			if (par1 == 0)
			{
				this.smasher.cookTime = par2;
			}

			if (par1 == 1)
			{
				this.smasher.power = par2;
			}
		}

		public boolean canInteractWith(EntityPlayer par1EntityPlayer)
		{
			return this.smasher.isUseableByPlayer(par1EntityPlayer);
		}
		public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
		{
			ItemStack itemstack = null;
			Slot slot = (Slot)this.inventorySlots.get(par2);

			if (slot != null && slot.getHasStack())
			{
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();

				if (par2 == 2)
				{
					if (!this.mergeItemStack(itemstack1, 3, 39, true))
					{
						return null;
					}

					slot.onSlotChange(itemstack1, itemstack);
				}
				else if (par2 != 1 && par2 != 0)
				{
					if (OreRecipes.getRecipes().smelting().getSmeltingResult(itemstack1) != null)
					{
						if (!this.mergeItemStack(itemstack1, 0, 1, false))
						{
							return null;
						}
					}
					else if (TileEntityTectonicSmasher.isItemFuel(itemstack1))
					{
						if (!this.mergeItemStack(itemstack1, 1, 2, false))
						{
							return null;
						}
					}
					else if (par2 >= 3 && par2 < 30)
					{
						if (!this.mergeItemStack(itemstack1, 30, 39, false))
						{
							return null;
						}
					}
					else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
					{
						return null;
					}
				}
				else if (!this.mergeItemStack(itemstack1, 3, 39, false))
				{
					return null;
				}

				if (itemstack1.stackSize == 0)
				{
					slot.putStack((ItemStack)null);
				}
				else
				{
					slot.onSlotChanged();
				}

				if (itemstack1.stackSize == itemstack.stackSize)
				{
					return null;
				}

				slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
			}

			return itemstack;
		}
	}