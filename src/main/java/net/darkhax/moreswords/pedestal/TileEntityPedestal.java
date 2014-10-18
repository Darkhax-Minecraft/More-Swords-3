package net.darkhax.moreswords.pedestal;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPedestal extends TileEntity {

    private int orientation = 0;

    public TileEntityPedestal() {

    }

    /**
     * Sets the direction that this block should be facing.
     * 
     * @param direction: The direction this block should be facing.
     */
    public void setDirection(int direction) {

        orientation = direction;
    }

    /**
     * Retrieves the direction that this block is curently facing.
     * 
     * @return int: The integer value of the position.
     */
    public int getDirection() {

        return orientation;
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {

        this.readFromNBT(pkt.func_148857_g());

    }

    @Override
    public Packet getDescriptionPacket() {

        NBTTagCompound nbt = new NBTTagCompound();
        this.writeToNBT(nbt);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {

        super.readFromNBT(nbt);
        orientation = nbt.getInteger("direction");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {

        super.writeToNBT(nbt);
        nbt.setInteger("direction", orientation);
    }
}