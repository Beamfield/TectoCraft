package com.beamfield.tectocraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.beamfield.tectocraft.TectoCraft;
import com.beamfield.tectocraft.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TectonicCrafter extends Block implements IWrenchableDevice{
	@SideOnly(Side.CLIENT)
	private IIcon tectoCrafterTop;
	private IIcon tectoCrafterFront;
	public TectonicCrafter(Material p_i45394_1_) {
		super(p_i45394_1_);
		this.setHardness(3.5F);
		this.setResistance(5.0F);
		this.setCreativeTab(TectoCraft.tabTectoCraft);
	}
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return side == 1 ? this.tectoCrafterTop : (side == 0 ? Blocks.iron_block.getBlockTextureFromSide(side) : (side != 2 && side != 4 ? this.blockIcon : this.tectoCrafterFront));
	}


	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Reference.MODID + ":" + "TectoCrafter_Side");
		this.tectoCrafterTop = iconRegister.registerIcon(Reference.MODID + ":" + "TectoCrafter_Top");
		this.tectoCrafterFront = iconRegister.registerIcon(Reference.MODID + ":" + "TectoCrafter_Front");
	}


	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(!player.isSneaking() && isMultiBlockStructure(world,x, y, z)) {
			player.openGui(TectoCraft.instance, TectoCraft.guiIDTectoCrafter, world, x, y, z);
			return true;
		} else {
			if(world.isRemote){
			player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED+"You need to properly setup the multiblock-structure!"));
			}
			return false;
		}
	}

	public boolean isMultiBlockStructure(World world, int x, int y, int z) {
		if (checkNorth(world, x, y, z))/* North */
			return true;
		if (checkEast(world, x, y, z))/* East */
			return true;
		if (checkSouth(world, x, y, z))/* South */
			return true;
		if (checkWest(world, x, y, z))/* West */
			return true;
		return false;
	}

	private static boolean checkNorth(World world, int x, int y, int z) {
		if (world.getBlock(x + -1, y + 0, z + 0) == TectoCraft.tectoWall) {
			if (world.getBlock(x + -1, y + 0, z + -1) == TectoCraft.tectoWall) {
				if (world.getBlock(x + -1, y + 0, z + -2) == TectoCraft.tectoWall) {
					if (world.getBlock(x + -1, y + 1, z + 0) == TectoCraft.tectoWall) {
						if (world.getBlock(x + -1, y + 1, z + -1) == Blocks.redstone_lamp) {
							if (world.getBlock(x + -1, y + 1, z + -2) == TectoCraft.tectoWall) {
								if (world.getBlock(x + -1, y + 2, z + 0) == TectoCraft.tectoWall) {
									if (world.getBlock(x + -1, y + 2, z + -1) == TectoCraft.tectoWall) {
										if (world.getBlock(x + -1, y + 2, z
												+ -2) == TectoCraft.tectoWall) {
											if (world.getBlock(x + 0, y + 0,
													z + -1) == TectoCraft.tungsten_block) {
												if (world.getBlock(x + 0,
														y + 0, z + -2) == TectoCraft.tectoWall) {
													if (world.getBlock(x + 0,
															y + 1, z + 0) == TectoCraft.tectonium_block) {
														if (world.getBlock(
																x + 0, y + 1, z
																		+ -1) == TectoCraft.tungsten_block) {
															if (world
																	.getBlock(
																			x + 0,
																			y + 1,
																			z
																					+ -2) == Blocks.redstone_lamp) {
																if (world
																		.getBlock(
																				x + 0,
																				y + 2,
																				z + 0) == TectoCraft.tectoWall) {
																	if (world
																			.getBlock(
																					x + 0,
																					y + 2,
																					z
																							+ -1) == Blocks.gold_block) {
																		if (world
																				.getBlock(
																						x + 0,
																						y + 2,
																						z
																								+ -2) == TectoCraft.tectoWall) {
																			if (world
																					.getBlock(
																							x + 1,
																							y + 0,
																							z + 0) == TectoCraft.tectoWall) {
																				if (world
																						.getBlock(
																								x + 1,
																								y + 0,
																								z
																										+ -1) == TectoCraft.tectoWall) {
																					if (world
																							.getBlock(
																									x + 1,
																									y + 0,
																									z
																											+ -2) == TectoCraft.tectoWall) {
																						if (world
																								.getBlock(
																										x + 1,
																										y + 1,
																										z + 0) == TectoCraft.tectoWall) {
																							if (world
																									.getBlock(
																											x + 1,
																											y + 1,
																											z
																													+ -1) == Blocks.redstone_lamp) {
																								if (world
																										.getBlock(
																												x + 1,
																												y + 1,
																												z
																														+ -2) == TectoCraft.tectoWall) {
																									if (world
																											.getBlock(
																													x + 1,
																													y + 2,
																													z + 0) == TectoCraft.tectoWall) {
																										if (world
																												.getBlock(
																														x + 1,
																														y + 2,
																														z
																																+ -1) == TectoCraft.tectoWall) {
																											if (world
																													.getBlock(
																															x + 1,
																															y + 2,
																															z
																																	+ -2) == TectoCraft.tectoWall) {
																												return true;
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	private static boolean checkEast(World world, int x, int y, int z) {
		if (world.getBlock(x + 0, y + 0, z + -1) == TectoCraft.tectoWall) {
			if (world.getBlock(x + 1, y + 0, z + -1) == TectoCraft.tectoWall) {
				if (world.getBlock(x + 2, y + 0, z + -1) == TectoCraft.tectoWall) {
					if (world.getBlock(x + 0, y + 1, z + -1) == TectoCraft.tectoWall) {
						if (world.getBlock(x + 1, y + 1, z + -1) == Blocks.redstone_lamp) {
							if (world.getBlock(x + 2, y + 1, z + -1) == TectoCraft.tectoWall) {
								if (world.getBlock(x + 0, y + 2, z + -1) == TectoCraft.tectoWall) {
									if (world.getBlock(x + 1, y + 2, z + -1) == TectoCraft.tectoWall) {
										if (world.getBlock(x + 2, y + 2, z
												+ -1) == TectoCraft.tectoWall) {
											if (world.getBlock(x + 1, y + 0,
													z + 0) == TectoCraft.tungsten_block) {
												if (world.getBlock(x + 2,
														y + 0, z + 0) == TectoCraft.tectoWall) {
													if (world.getBlock(x + 0,
															y + 1, z + 0) == TectoCraft.tectonium_block) {
														if (world.getBlock(
																x + 1, y + 1,
																z + 0) == TectoCraft.tungsten_block) {
															if (world
																	.getBlock(
																			x + 2,
																			y + 1,
																			z + 0) == Blocks.redstone_lamp) {
																if (world
																		.getBlock(
																				x + 0,
																				y + 2,
																				z + 0) == TectoCraft.tectoWall) {
																	if (world
																			.getBlock(
																					x + 1,
																					y + 2,
																					z + 0) == Blocks.gold_block) {
																		if (world
																				.getBlock(
																						x + 2,
																						y + 2,
																						z + 0) == TectoCraft.tectoWall) {
																			if (world
																					.getBlock(
																							x + 0,
																							y + 0,
																							z + 1) == TectoCraft.tectoWall) {
																				if (world
																						.getBlock(
																								x + 1,
																								y + 0,
																								z + 1) == TectoCraft.tectoWall) {
																					if (world
																							.getBlock(
																									x + 2,
																									y + 0,
																									z + 1) == TectoCraft.tectoWall) {
																						if (world
																								.getBlock(
																										x + 0,
																										y + 1,
																										z + 1) == TectoCraft.tectoWall) {
																							if (world
																									.getBlock(
																											x + 1,
																											y + 1,
																											z + 1) == Blocks.redstone_lamp) {
																								if (world
																										.getBlock(
																												x + 2,
																												y + 1,
																												z + 1) == TectoCraft.tectoWall) {
																									if (world
																											.getBlock(
																													x + 0,
																													y + 2,
																													z + 1) == TectoCraft.tectoWall) {
																										if (world
																												.getBlock(
																														x + 1,
																														y + 2,
																														z + 1) == TectoCraft.tectoWall) {
																											if (world
																													.getBlock(
																															x + 2,
																															y + 2,
																															z + 1) == TectoCraft.tectoWall) {
																												return true;
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	private static boolean checkSouth(World world, int x, int y, int z) {
		if (world.getBlock(x + 1, y + 0, z + 0) == TectoCraft.tectoWall) {
			if (world.getBlock(x + 1, y + 0, z + 1) == TectoCraft.tectoWall) {
				if (world.getBlock(x + 1, y + 0, z + 2) == TectoCraft.tectoWall) {
					if (world.getBlock(x + 1, y + 1, z + 0) == TectoCraft.tectoWall) {
						if (world.getBlock(x + 1, y + 1, z + 1) == Blocks.redstone_lamp) {
							if (world.getBlock(x + 1, y + 1, z + 2) == TectoCraft.tectoWall) {
								if (world.getBlock(x + 1, y + 2, z + 0) == TectoCraft.tectoWall) {
									if (world.getBlock(x + 1, y + 2, z + 1) == TectoCraft.tectoWall) {
										if (world.getBlock(x + 1, y + 2,
												z + 2) == TectoCraft.tectoWall) {
											if (world.getBlock(x + 0, y + 0,
													z + 1) == TectoCraft.tungsten_block) {
												if (world.getBlock(x + 0,
														y + 0, z + 2) == TectoCraft.tectoWall) {
													if (world.getBlock(x + 0,
															y + 1, z + 0) == TectoCraft.tectonium_block) {
														if (world.getBlock(
																x + 0, y + 1,
																z + 1) == TectoCraft.tungsten_block) {
															if (world
																	.getBlock(
																			x + 0,
																			y + 1,
																			z + 2) == Blocks.redstone_lamp) {
																if (world
																		.getBlock(
																				x + 0,
																				y + 2,
																				z + 0) == TectoCraft.tectoWall) {
																	if (world
																			.getBlock(
																					x + 0,
																					y + 2,
																					z + 1) == TectoCraft.tungsten_block) {
																		if (world
																				.getBlock(
																						x + 0,
																						y + 2,
																						z + 2) == TectoCraft.tectoWall) {
																			if (world
																					.getBlock(
																							x
																									+ -1,
																							y + 0,
																							z + 0) == TectoCraft.tectoWall) {
																				if (world
																						.getBlock(
																								x
																										+ -1,
																								y + 0,
																								z + 1) == TectoCraft.tectoWall) {
																					if (world
																							.getBlock(
																									x
																											+ -1,
																									y + 0,
																									z + 2) == TectoCraft.tectoWall) {
																						if (world
																								.getBlock(
																										x
																												+ -1,
																										y + 1,
																										z + 0) == TectoCraft.tectoWall) {
																							if (world
																									.getBlock(
																											x
																													+ -1,
																											y + 1,
																											z + 1) == Blocks.redstone_lamp) {
																								if (world
																										.getBlock(
																												x
																														+ -1,
																												y + 1,
																												z + 2) == TectoCraft.tectoWall) {
																									if (world
																											.getBlock(
																													x
																															+ -1,
																													y + 2,
																													z + 0) == TectoCraft.tectoWall) {
																										if (world
																												.getBlock(
																														x
																																+ -1,
																														y + 2,
																														z + 1) == TectoCraft.tectoWall) {
																											if (world
																													.getBlock(
																															x
																																	+ -1,
																															y + 2,
																															z + 2) == TectoCraft.tectoWall) {
																												return true;
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	private static boolean checkWest(World world, int x, int y, int z) {
		if (world.getBlock(x + 0, y + 0, z + 1) == TectoCraft.tectoWall) {
			if (world.getBlock(x + -1, y + 0, z + 1) == TectoCraft.tectoWall) {
				if (world.getBlock(x + -2, y + 0, z + 1) == TectoCraft.tectoWall) {
					if (world.getBlock(x + 0, y + 1, z + 1) == TectoCraft.tectoWall) {
						if (world.getBlock(x + -1, y + 1, z + 1) == Blocks.redstone_lamp) {
							if (world.getBlock(x + -2, y + 1, z + 1) == TectoCraft.tectoWall) {
								if (world.getBlock(x + 0, y + 2, z + 1) == TectoCraft.tectoWall) {
									if (world.getBlock(x + -1, y + 2, z + 1) == TectoCraft.tectoWall) {
										if (world.getBlock(x + -2, y + 2,
												z + 1) == TectoCraft.tectoWall) {
											if (world.getBlock(x + -1, y + 0,
													z + 0) == TectoCraft.tungsten_block) {
												if (world.getBlock(x + -2,
														y + 0, z + 0) == TectoCraft.tectoWall) {
													if (world.getBlock(x + 0,
															y + 1, z + 0) == TectoCraft.tectonium_block) {
														if (world.getBlock(x
																+ -1, y + 1,
																z + 0) == TectoCraft.tungsten_block) {
															if (world
																	.getBlock(
																			x
																					+ -2,
																			y + 1,
																			z + 0) == Blocks.redstone_lamp) {
																if (world
																		.getBlock(
																				x + 0,
																				y + 2,
																				z + 0) == TectoCraft.tectoWall) {
																	if (world
																			.getBlock(
																					x
																							+ -1,
																					y + 2,
																					z + 0) == TectoCraft.tungsten_block) {
																		if (world
																				.getBlock(
																						x
																								+ -2,
																						y + 2,
																						z + 0) == TectoCraft.tectoWall) {
																			if (world
																					.getBlock(
																							x + 0,
																							y + 0,
																							z
																									+ -1) == TectoCraft.tectoWall) {
																				if (world
																						.getBlock(
																								x
																										+ -1,
																								y + 0,
																								z
																										+ -1) == TectoCraft.tectoWall) {
																					if (world
																							.getBlock(
																									x
																											+ -2,
																									y + 0,
																									z
																											+ -1) == TectoCraft.tectoWall) {
																						if (world
																								.getBlock(
																										x + 0,
																										y + 1,
																										z
																												+ -1) == TectoCraft.tectoWall) {
																							if (world
																									.getBlock(
																											x
																													+ -1,
																											y + 1,
																											z
																													+ -1) == Blocks.redstone_lamp) {
																								if (world
																										.getBlock(
																												x
																														+ -2,
																												y + 1,
																												z
																														+ -1) == TectoCraft.tectoWall) {
																									if (world
																											.getBlock(
																													x + 0,
																													y + 2,
																													z
																															+ -1) == TectoCraft.tectoWall) {
																										if (world
																												.getBlock(
																														x
																																+ -1,
																														y + 2,
																														z
																																+ -1) == TectoCraft.tectoWall) {
																											if (world
																													.getBlock(
																															x
																																	+ -2,
																															y + 2,
																															z
																																	+ -1) == TectoCraft.tectoWall) {
																												return true;
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
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
