package com.beamfield.tectocraft.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.beamfield.tectocraft.tileentity.TileEntityElectricPipe;

public class ElectricPipe extends BlockContainer implements IWrenchableDevice{
	private IIcon icon;
	public ElectricPipe(Material p_i45386_1_) {
		super(p_i45386_1_);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityElectricPipe();
	}
	 public int getRenderType()
	    {
	        return -1;
	    }
	    @Override
	    public IIcon getIcon(int side, int meta) {
	            return icon;
	    }
	    public boolean isOpaqueCube(){
	    	return false;
	    }
	    public boolean renderAsNormalBlock(){
	    	return false;
	    }
	    private AxisAlignedBB[] getParts(TileEntityElectricPipe wTE) {
			
			boolean cUp = wTE.getRenderUp();
			boolean cDown = wTE.getRenderDown();
			boolean cNorth = wTE.getRenderNorth();
			boolean cSouth = wTE.getRenderSouth();
			boolean cEast = wTE.getRenderEast();
			boolean cWest = wTE.getRenderWest();
			
			AxisAlignedBB[] parts = new AxisAlignedBB[13];
			
			// Wire Core
			parts[0] = AxisAlignedBB.getBoundingBox(0.3125F, 0.3125F, 0.3125F, 0.6875F, 0.6875F, 0.6875F);
			
			// Up Side - Works
			parts[1] = cUp ? AxisAlignedBB.getBoundingBox(0.3125F, 0.6875F, 0.3125F, 0.6875F, 0.8125F, 0.6875F) : null;
			parts[2] = cUp ? AxisAlignedBB.getBoundingBox(0.3125F, 0.8125F, 0.3125F, 0.6875F, 1.0F, 0.6875F) : null;
			
			// Down Side
			parts[3] = cDown ? AxisAlignedBB.getBoundingBox(0.3125F, 0.1875F, 0.3125F, 0.6875F, 0.3125F, 0.6875F) : null;
			parts[4] = cDown ? AxisAlignedBB.getBoundingBox(0.3125F, 0.0F, 0.3125F, 0.6875F, 0.1875F, 0.6875F) : null;
			
			// North Side
			parts[5] = cNorth ? AxisAlignedBB.getBoundingBox(0.3125F, 0.3125F, 0.1875F, 0.6875F, 0.6875F, 0.3125F) : null;
			parts[6] = cNorth ? AxisAlignedBB.getBoundingBox(0.3125F, 0.3125F, 0.0F, 0.6875F, 0.6875F, 0.1875F) : null;
			
			// South Side - Works
			parts[7] = cSouth ? AxisAlignedBB.getBoundingBox(0.3125F, 0.3125F, 0.6875F, 0.6875F, 0.6875F, 0.8125F) : null;
			parts[8] = cSouth ? AxisAlignedBB.getBoundingBox(0.3125F, 0.3125F, 0.8125F, 0.6875F, 0.6875F, 1.0F) : null;
			
			// East Side - Works
			parts[9] = cEast ? AxisAlignedBB.getBoundingBox(0.6875F, 0.3125F, 0.3125F, 0.8125F, 0.6875F, 0.6875F) : null;
			parts[10] = cEast ? AxisAlignedBB.getBoundingBox(0.8125F, 0.3125F, 0.3125F, 1.0F, 0.6875F, 0.6875F) : null;
			
			// West Side
			parts[11] = cWest ? AxisAlignedBB.getBoundingBox(0.1875F, 0.3125F, 0.3125F, 0.3125F, 0.6875F, 0.6875F) : null;
			parts[12] = cWest ? AxisAlignedBB.getBoundingBox(0.0F, 0.3125F, 0.3125F, 0.1875F, 0.6875F, 0.6875F) : null;
			
			return parts;
		}
		
		
		private int getPartClicked(EntityPlayer player, double reachDistance, TileEntityElectricPipe tileEntity) {

			AxisAlignedBB[] wireParts = getParts(tileEntity);
			
			Vec3 playerPosition = Vec3.createVectorHelper(player.posX - tileEntity.xCoord, player.posY - tileEntity.yCoord + player.getEyeHeight(), player.posZ - tileEntity.zCoord);
			Vec3 playerLook = player.getLookVec();
			
			Vec3 playerViewOffset = Vec3.createVectorHelper(playerPosition.xCoord + playerLook.xCoord * reachDistance, playerPosition.yCoord + playerLook.yCoord * reachDistance, playerPosition.zCoord + playerLook.zCoord * reachDistance);
			
			int closest = -1;
			double closestDistance = Double.MAX_VALUE;
			
			for(int i = 0; i < wireParts.length; i++) {
				AxisAlignedBB part = wireParts[i];
				if(part == null)
					continue;
				
				MovingObjectPosition hit = part.calculateIntercept(playerPosition, playerViewOffset);
				if(hit != null) {
					double distance = playerPosition.distanceTo(hit.hitVec);
					if(distance < closestDistance) {
						closestDistance = distance;
						closest = i;
					}
				}
			}
			
			return closest;
		}
		
		
		@Override
		public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB collisionTest, List collisionBoxList, Entity entity) {
			
			TileEntity wire = world.getTileEntity(x, y, z);
			
			if(wire instanceof TileEntityElectricPipe) {
				for(AxisAlignedBB aabb : getParts((TileEntityElectricPipe)wire)) {
					if(aabb == null)
						continue;
					
					aabb = AxisAlignedBB.getBoundingBox(aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);
					aabb.minX += x;
					aabb.minY += y;
					aabb.minZ += z;
					aabb.maxX += x;
					aabb.maxY += y;
					aabb.maxZ += z;
					
					if(collisionTest.intersectsWith(aabb)) {
						collisionBoxList.add(aabb);
					}
				}
			} else {
				super.addCollisionBoxesToList(world, x, y, z, collisionTest, collisionBoxList, entity);
			}
			
		}
		
		
		@Override
		public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
			
			float xMin = 1, yMin = 1, zMin = 1;
			float xMax = 0, yMax = 0, zMax = 0;
			
			TileEntity wire = world.getTileEntity(x, y, z);
			
			if(wire instanceof TileEntityElectricPipe) {
				for(AxisAlignedBB aabb : getParts((TileEntityElectricPipe)wire)) {
					if(aabb == null)
						continue;
					
					xMin = Math.min(xMin, (float)aabb.minX);
					yMin = Math.min(yMin, (float)aabb.minY);
					zMin = Math.min(zMin, (float)aabb.minZ);
					xMax = Math.max(xMax, (float)aabb.maxX);
					yMax = Math.max(yMax, (float)aabb.maxY);
					zMax = Math.max(zMax, (float)aabb.maxZ);
				}
				this.setBlockBounds(xMin, yMin, zMin, xMax, yMax, zMax);
			} else {
				super.setBlockBoundsBasedOnState(world, x, y, z);
			}
			
		}
		 @Override
		    public void onNeighborChange(IBlockAccess world, int x, int y, int z, int tileX, int tileY, int tileZ) {

		    	Block nBlock = world.getBlock(tileX, tileY, tileZ);
		    	TileEntity tTE = world.getTileEntity(x, y, z);
		    	TileEntity nTE = world.getTileEntity(tileX, tileY, tileZ);
		    	
		    	//if(!((World)world).isRemote) {
			    	if(y < tileY) {
			    		//UP
			    		if(nBlock instanceof ElectricPipe) {
			    			((TileEntityElectricPipe)tTE).setRenderUp(true);
			    			((TileEntityElectricPipe)tTE).setConnectUp(false);
			    			((TileEntityElectricPipe)nTE).setRenderDown(true);
			    			((TileEntityElectricPipe)nTE).setConnectDown(false);
			    		} else if(nBlock instanceof IElectricalDevice) {
			    			((TileEntityElectricPipe)tTE).setRenderUp(true);
			    			((TileEntityElectricPipe)tTE).setConnectUp(true);
			    		} else {
			    			((TileEntityElectricPipe)tTE).setRenderUp(false);
			    			((TileEntityElectricPipe)tTE).setConnectUp(false);
			    		}
			    	} else if(y > tileY) {
			    		//DOWN
			    		if(nBlock instanceof ElectricPipe) {
			    			((TileEntityElectricPipe)tTE).setRenderDown(true);
			    			((TileEntityElectricPipe)tTE).setConnectDown(false);
			    			((TileEntityElectricPipe)nTE).setRenderUp(true);
			    			((TileEntityElectricPipe)nTE).setConnectUp(false);
			    		} else if(nBlock instanceof IElectricalDevice) {
			    			((TileEntityElectricPipe)tTE).setRenderDown(true);
			    			((TileEntityElectricPipe)tTE).setConnectDown(true);
			    		} else {
			    			((TileEntityElectricPipe)tTE).setRenderDown(false);
			    			((TileEntityElectricPipe)tTE).setConnectDown(false);
			    		}
			    	} else if(z > tileZ) {
			    		//NORTH
			    		if(nBlock instanceof ElectricPipe) {
			    			((TileEntityElectricPipe)tTE).setRenderNorth(true);
			    			((TileEntityElectricPipe)tTE).setConnectNorth(false);
			    			((TileEntityElectricPipe)nTE).setRenderSouth(true);
			    			((TileEntityElectricPipe)nTE).setConnectSouth(false);
			    		} else if(nBlock instanceof IElectricalDevice) {
			    			((TileEntityElectricPipe)tTE).setRenderNorth(true);
			    			((TileEntityElectricPipe)tTE).setConnectNorth(true);
			    		} else {
			    			((TileEntityElectricPipe)tTE).setRenderNorth(false);
			    			((TileEntityElectricPipe)tTE).setConnectNorth(false);
			    		}
			    	} else if(z < tileZ) {
			    		//SOUTH
			    		if(nBlock instanceof ElectricPipe) {
			    			((TileEntityElectricPipe)tTE).setRenderSouth(true);
			    			((TileEntityElectricPipe)tTE).setConnectSouth(false);
			    			((TileEntityElectricPipe)nTE).setRenderNorth(true);
			    			((TileEntityElectricPipe)nTE).setConnectNorth(false);
			    		} else if(nBlock instanceof IElectricalDevice) {
			    			((TileEntityElectricPipe)tTE).setRenderSouth(true);
			    			((TileEntityElectricPipe)tTE).setConnectSouth(true);
			    		} else {
			    			((TileEntityElectricPipe)tTE).setRenderSouth(false);
			    			((TileEntityElectricPipe)tTE).setConnectSouth(false);
			    		}
			    	} else if(x < tileX) {
			    		//EAST
			    		if(nBlock instanceof ElectricPipe) {
			    			((TileEntityElectricPipe)tTE).setRenderEast(true);
			    			((TileEntityElectricPipe)tTE).setConnectEast(false);
			    			((TileEntityElectricPipe)nTE).setRenderWest(true);
			    			((TileEntityElectricPipe)nTE).setConnectWest(false);
			    		} else if(nBlock instanceof IElectricalDevice) {
			    			((TileEntityElectricPipe)tTE).setRenderEast(true);
			    			((TileEntityElectricPipe)tTE).setConnectEast(true);
			    		} else {
			    			((TileEntityElectricPipe)tTE).setRenderEast(false);
			    			((TileEntityElectricPipe)tTE).setConnectEast(false);
			    		}
			    	} else if(x > tileX) {
			    		//WEST
			    		if(nBlock instanceof ElectricPipe) {
			    			((TileEntityElectricPipe)tTE).setRenderWest(true);
			    			((TileEntityElectricPipe)tTE).setConnectWest(false);
			    			((TileEntityElectricPipe)nTE).setRenderEast(true);
			    			((TileEntityElectricPipe)nTE).setConnectEast(false);
			    		} else if(nBlock instanceof IElectricalDevice) {
			    			((TileEntityElectricPipe)tTE).setRenderWest(true);
			    			((TileEntityElectricPipe)tTE).setConnectWest(true);
			    		} else {
			    			((TileEntityElectricPipe)tTE).setRenderWest(false);
			    			((TileEntityElectricPipe)tTE).setConnectWest(false);
			    		}
			    	}
		    	//}

		    }
			
			
			public void onBlockAdded(World world, int x, int y, int z) {
				super.onBlockAdded(world, x, y, z);
				
				TileEntity tTE = world.getTileEntity(x, y, z);
				
				Block upBlock = world.getBlock(x, y + 1, z);
				
				if(upBlock instanceof IElectricalDevice) {
					((TileEntityElectricPipe)tTE).setRenderUp(true);
					((TileEntityElectricPipe)tTE).setConnectUp(true);
				}
				
				Block downBlock = world.getBlock(x, y - 1, z);
				
				if(downBlock instanceof IElectricalDevice) {
					((TileEntityElectricPipe)tTE).setRenderDown(true);
					((TileEntityElectricPipe)tTE).setConnectDown(true);
				}
				
				Block northBlock = world.getBlock(x, y, z - 1);
				
				if(northBlock instanceof IElectricalDevice) {
					((TileEntityElectricPipe)tTE).setRenderNorth(true);
					((TileEntityElectricPipe)tTE).setConnectNorth(true);
				}
				
				Block southBlock = world.getBlock(x, y, z + 1);
				
				if(southBlock instanceof IElectricalDevice) {
					((TileEntityElectricPipe)tTE).setRenderSouth(true);
					((TileEntityElectricPipe)tTE).setConnectSouth(true);
				}
				
				Block eastBlock = world.getBlock(x + 1, y, z);
				
				if(eastBlock instanceof IElectricalDevice) {
					((TileEntityElectricPipe)tTE).setRenderEast(true);
					((TileEntityElectricPipe)tTE).setConnectEast(true);
				}
				
				Block westBlock = world.getBlock(x - 1, y, z);
				
				if(westBlock instanceof IElectricalDevice) {
					((TileEntityElectricPipe)tTE).setRenderWest(true);
					((TileEntityElectricPipe)tTE).setConnectWest(true);
				}
			}

			@Override
			public void onWrenchRightClick(World world, EntityPlayer player, int x, int y, int z, int side, int metadata) {
	
			}

			@Override
			public void onWrenchSneakRightClick(World world, EntityPlayer player, int x, int y, int z, int side, int metadata) {
					ItemStack drop = new ItemStack(Item.getItemFromBlock(world.getBlock(x, y, z)));
					world.setBlockToAir(x, y, z);
					player.inventory.addItemStackToInventory(drop);
					player.playSound("random.pop", 1F, 1F);
			}

}
