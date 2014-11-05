package com.beamfield.tectocraft.handler;

import com.beamfield.tectocraft.TectoCraft;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class OnSmeltEvent {
	@SubscribeEvent
	public void whenISmeltAnItemOrBlock(PlayerEvent.ItemSmeltedEvent e){
		if((e.smelting.getItem()).equals(TectoCraft.tungsten_ingot)){
			e.player.addStat(TectoCraft.achievementHighTemperatures, 1);
		}
	}
}
