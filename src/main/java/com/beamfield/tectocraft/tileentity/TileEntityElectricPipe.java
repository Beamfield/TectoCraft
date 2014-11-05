package com.beamfield.tectocraft.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityElectricPipe extends TileEntity {
	
	private boolean renderNorth = false;
	private boolean renderSouth = false;
	private boolean renderEast = false;
	private boolean renderWest = false;
	private boolean renderUp = false;
	private boolean renderDown = false;
	
	private boolean connectNorth = false;
	private boolean connectSouth = false;
	private boolean connectEast = false;
	private boolean connectWest = false;
	private boolean connectUp = false;
	private boolean connectDown = false;
	
	private boolean allowConnNorth = true;
	private boolean allowConnSouth = true;
	private boolean allowConnEast = true;
	private boolean allowConnWest = true;
	private boolean allowConnUp = true;
	private boolean allowConnDown = true;
	
	
	public void setRenderNorth(boolean newValue) { renderNorth = newValue; }
	public boolean getRenderNorth() { return renderNorth; }

	
	public void setRenderSouth(boolean newValue) { renderSouth = newValue; }
	public boolean getRenderSouth() { return renderSouth; }

	
	public void setRenderEast(boolean newValue) { renderEast = newValue; }
	public boolean getRenderEast() { return renderEast; }

	
	public void setRenderWest(boolean newValue) { renderWest = newValue; }
	public boolean getRenderWest() { return renderWest; }

	
	public void setRenderUp(boolean newValue) { renderUp = newValue; }
	public boolean getRenderUp() { return renderUp; }

	
	public void setRenderDown(boolean newValue) { renderDown = newValue; }
	public boolean getRenderDown() { return renderDown; }

	
	public void setConnectNorth(boolean newValue) { connectNorth = newValue; }
	public boolean getConnectNorth() { return connectNorth; }

	
	public void setConnectSouth(boolean newValue) { connectSouth = newValue; }
	public boolean getConnectSouth() { return connectSouth; }

	
	public void setConnectEast(boolean newValue) { connectEast = newValue; }
	public boolean getConnectEast() { return connectEast; }

	
	public void setConnectWest(boolean newValue) { connectWest = newValue; }
	public boolean getConnectWest() { return connectWest; }

	
	public void setConnectUp(boolean newValue) { connectUp = newValue; }
	public boolean getConnectUp() { return connectUp; }

	
	public void setConnectDown(boolean newValue) { connectDown = newValue; }
	public boolean getConnectDown() { return connectDown; }

	
	public void setAllowConnNorth(boolean newValue) {allowConnNorth = newValue; }
	public boolean getAllowConnNorth() { return allowConnNorth; }

	
	public void setAllowConnSouth(boolean newValue) {allowConnSouth = newValue; }
	public boolean getAllowConnSouth() { return allowConnSouth; }

	
	public void setAllowConnEast(boolean newValue) {allowConnEast = newValue; }
	public boolean getAllowConnEast() { return allowConnEast; }

	
	public void setAllowConnWest(boolean newValue) {allowConnWest = newValue; }
	public boolean getAllowConnWest() { return allowConnWest; }

	
	public void setAllowConnUp(boolean newValue) {allowConnUp = newValue; }
	public boolean getAllowConnUp() { return allowConnUp; }

	
	public void setAllowConnDown(boolean newValue) {allowConnDown = newValue; }
	public boolean getAllowConnDown() { return allowConnDown; }
	
		
	@Override
    public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 2, nbt);
    }
	
	
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
    	super.onDataPacket(net, packet);
    	readFromNBT(packet.func_148857_g());
    }
	
	
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		
		renderNorth = nbt.getBoolean("renderNorth");
		renderSouth = nbt.getBoolean("renderSouth");
		renderEast = nbt.getBoolean("renderEast");
		renderWest = nbt.getBoolean("renderWest");
		renderUp = nbt.getBoolean("renderUp");
		renderDown = nbt.getBoolean("renderDown");
		connectNorth = nbt.getBoolean("connectNorth");
		connectSouth = nbt.getBoolean("connectSouth");
		connectEast = nbt.getBoolean("connectEast");
		connectWest = nbt.getBoolean("connectWest");
		connectUp = nbt.getBoolean("connectUp");
		connectDown = nbt.getBoolean("connectDown");
		allowConnNorth = nbt.getBoolean("allowConnNorth");
		allowConnSouth = nbt.getBoolean("allowConnSouth");
		allowConnEast = nbt.getBoolean("allowConnEast");
		allowConnWest = nbt.getBoolean("allowConnWest");
		allowConnUp = nbt.getBoolean("allowConnUp");
		allowConnDown = nbt.getBoolean("allowConnDown");
		
		/*
		if(canConnectToMachines)
			System.out.println("Read \"true\" from NBT...");
		else
			System.out.println("Read \"false\" from NBT...");
		*/
	}
	
	
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		
		nbt.setBoolean("renderNorth", renderNorth);
		nbt.setBoolean("renderSouth", renderSouth);
		nbt.setBoolean("renderEast", renderEast);
		nbt.setBoolean("renderWest", renderWest);
		nbt.setBoolean("renderUp", renderUp);
		nbt.setBoolean("renderDown", renderDown);
		nbt.setBoolean("connectNorth", connectNorth);
		nbt.setBoolean("connectSouth", connectSouth);
		nbt.setBoolean("connectEast", connectEast);
		nbt.setBoolean("connectWest", connectWest);
		nbt.setBoolean("connectUp", connectUp);
		nbt.setBoolean("connectDown", connectDown);
		nbt.setBoolean("allowConnNorth", allowConnNorth);
		nbt.setBoolean("allowConnSouth", allowConnSouth);
		nbt.setBoolean("allowConnEast", allowConnEast);
		nbt.setBoolean("allowConnWest", allowConnWest);
		nbt.setBoolean("allowConnUp", allowConnUp);
		nbt.setBoolean("allowConnDown", allowConnDown);

		/*
		if(canConnectToMachines)
			System.out.println("Wrote \"true\" to NBT...");
		else
			System.out.println("Wrote \"false\" to NBT...");
		*/
	}

	
}