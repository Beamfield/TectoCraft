package com.beamfield.tectocraft.items;

import java.util.Iterator;
import java.util.List;

import javax.swing.Icon;

import org.lwjgl.input.Keyboard;

import com.beamfield.tectocraft.reference.ItemUtils;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MegaMagnet extends TectoItem{
	private double range = 20.0D;
	public MegaMagnet(){
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
	}
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			list.add("Sucks nearby items and XP in " + range +" blocks");
		}else{
			list.add(EnumChatFormatting.ITALIC+"Press " + EnumChatFormatting.YELLOW+ "SHIFT" +EnumChatFormatting.GRAY + EnumChatFormatting.ITALIC+" for information");
		}
	}
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.epic;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return stack.getItemDamage() == 1 ? true : false;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}
	@Override
	public void onUpdate(ItemStack ist, World world, Entity e, int i, boolean f) {
		if (ist.getItemDamage() == 0) return;
		EntityPlayer player = null;
		if (e instanceof EntityPlayer) {
			player = (EntityPlayer)e;
		}
		if (player == null) return;
		scanForEntitiesInRange(world, player, range);
	}

	private void scanForEntitiesInRange(World world, EntityPlayer player, double d) {
		List iList = world.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getBoundingBox(player.posX - d, player.posY - d, player.posZ - d, player.posX + d, player.posY + d, player.posZ + d));
		Iterator iterator = iList.iterator();
		while (iterator.hasNext()) {
			EntityItem item = (EntityItem)iterator.next();
			if (!checkForRoom(item.getEntityItem(), player)) {
				continue;
			}
			if (item.delayBeforeCanPickup > 0) {
				item.delayBeforeCanPickup = 0;
			}
			if (player.getDistanceToEntity(item) < 1.5D) {
				continue;
			}
			teleportEntityToPlayer(item, player);
			break;
		}
		List iList2 = world.getEntitiesWithinAABB(EntityXPOrb.class, AxisAlignedBB.getBoundingBox(player.posX - d, player.posY - d, player.posZ - d, player.posX + d, player.posY + d, player.posZ + d));
		Iterator iterator2 = iList2.iterator();
		while (iterator2.hasNext()) {
			EntityXPOrb item = (EntityXPOrb)iterator2.next();
			if (player.xpCooldown > 0) {
				player.xpCooldown = 0;
			}
			if (player.getDistanceToEntity(item) < 1.5D) {
				continue;
			}
			teleportEntityToPlayer(item, player);
			break;
		}
	}

	private void teleportEntityToPlayer(Entity item, EntityPlayer player) {
		player.getLookVec();
		double x = player.posX + player.getLookVec().xCoord * 0.2D;
		double y = player.posY - player.height / 2F;
		double z = player.posZ + player.getLookVec().zCoord * 0.2D;
		item.setPosition(x, y, z);
	}

	private boolean checkForRoom(ItemStack item, EntityPlayer player) {
		int remaining = item.stackSize;
		for (ItemStack ist : player.inventory.mainInventory) {
			if (ist == null) {
				continue;
			}
			if (ist.getItem() == item.getItem() && ist.getItemDamage() == item.getItemDamage()) {
				if (ist.stackSize + remaining <= ist.getMaxStackSize()) return true;
				else {
					int count = ist.stackSize;
					while (count < ist.getMaxStackSize()) {
						count++;
						remaining--;
						if (remaining == 0) return true;
					}
				}
			}
		}
		for (int slot = 0; slot < player.inventory.mainInventory.length; slot++) {
			if (player.inventory.mainInventory[slot] == null) return true;
		}
		return false;
	}

	@Override
	public void onUsingItemTick(ItemStack ist, EntityPlayer player, int count) {
		if (ist.getItemDamage() == 0) return;
		scanForEntitiesInRange(player.worldObj, player, 15.0D);
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack) {
		return 64;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.block;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack ist, World world, EntityPlayer player) {
		if (world.isRemote) return ist;
		if (player.isSneaking()) {
			player.setItemInUse(ist, this.getMaxItemUseDuration(ist));
		} else {
			ist.setItemDamage(ist.getItemDamage() == 0 ? 1 : 0);
		}
		return ist;
	}
}
