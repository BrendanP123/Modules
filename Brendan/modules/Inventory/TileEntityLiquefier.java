package Brendan.modules.Inventory;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Field;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraftforge.common.*;
import net.minecraftforge.common.ForgeChunkManager.Ticket;
import net.minecraftforge.common.ForgeChunkManager.Type;

public class TileEntityLiquefier extends TileEntity implements IInventory {

        private ItemStack[] inv;
        public float timeLeft;
        //private Ticket ticket;

        public TileEntityLiquefier(){
                inv = new ItemStack[2];
                timeLeft = 100.0F;
                
                //ticket = ForgeChunkManager.requestTicket(CodeLyoko.instance, worldObj, Type.NORMAL);
                //ticket.getModData().setInteger("SuperCalcX", xCoord);
                //ticket.getModData().setInteger("SuperCalcY", yCoord);
                //ticket.getModData().setInteger("SuperCalcZ", zCoord);
                //ForgeChunkManager.forceChunk(ticket, new ChunkCoordIntPair(xCoord, zCoord));
                //System.out.println("chunk loaded");
        }
        
        @Override
        public int getSizeInventory() {
                return inv.length;
        }

        @Override
        public ItemStack getStackInSlot(int slot) {
                return inv[slot];
        }
        
        @Override
        public void setInventorySlotContents(int slot, ItemStack stack) {
                inv[slot] = stack;
                if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                        stack.stackSize = getInventoryStackLimit();
                }
        }
        
        @Override
        public ItemStack decrStackSize(int slot, int amt) {
                ItemStack stack = getStackInSlot(slot);
                if (stack != null)
                {
                	if (stack.stackSize <= amt)
                    {
                    	setInventorySlotContents(slot, null);
                    }
                    else
                    {
                    	stack = stack.splitStack(amt);
                    	if (stack.stackSize == 0)
                    	{
                    		setInventorySlotContents(slot, null);
                    	}
                    }
                }
                return stack;
        }

        @Override
        public Packet getDescriptionPacket() {
            Packet132TileEntityData packet = (Packet132TileEntityData) super.getDescriptionPacket();
            NBTTagCompound tag = packet != null ? packet.customParam1 : new NBTTagCompound();
            tag.setFloat("time", timeLeft);

            return new Packet132TileEntityData(xCoord, yCoord, zCoord, 1, tag);
        }

        @Override
        public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt) {
            super.onDataPacket(net, pkt);
            NBTTagCompound tag = pkt.customParam1;
            timeLeft = tag.getFloat("time");
        }

        @Override
        public ItemStack getStackInSlotOnClosing(int slot) {
                ItemStack stack = getStackInSlot(slot);
                if (stack != null) {
                        setInventorySlotContents(slot, null);
                }
                return stack;
        }
        
        @Override
        public int getInventoryStackLimit() {
                return 64;
        }

        @Override
        public boolean isUseableByPlayer(EntityPlayer player) {
                return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this &&
                player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
        }

        @Override
        public void openChest() {}

        @Override
        public void closeChest() {}
        
        @Override
        public void readFromNBT(NBTTagCompound tagCompound) {
                super.readFromNBT(tagCompound);
                NBTTagList tagList = tagCompound.getTagList("Inventory");
                for (int i = 0; i < tagList.tagCount(); i++) {
                        NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
                        byte slot = tag.getByte("Slot");
                        if (slot >= 0 && slot < inv.length) {
                                inv[slot] = ItemStack.loadItemStackFromNBT(tag);
                        }
                }
                this.timeLeft = tagCompound.getFloat("remainingTime");
        }

        @Override
        public void writeToNBT(NBTTagCompound tagCompound) {
                super.writeToNBT(tagCompound);
                tagCompound.setFloat("remainingTime", this.timeLeft);
                NBTTagList itemList = new NBTTagList();
                for (int i = 0; i < inv.length; i++) {
                        ItemStack stack = inv[i];
                        if (stack != null) {
                                NBTTagCompound tag = new NBTTagCompound();
                                tag.setByte("Slot", (byte) i);
                                stack.writeToNBT(tag);
                                itemList.appendTag(tag);
                        }
                }
                tagCompound.setTag("Inventory", itemList);
        }
        
        @Override
        public String getInvName()
        {
        	return "tileentitysupercalc";
        }

		@Override
		public boolean isInvNameLocalized()
		{
			return false;
		}

		public boolean isStackValidForSlot(int i, ItemStack itemstack) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isItemValidForSlot(int i, ItemStack itemstack) {
			// TODO Auto-generated method stub
			return false;
		}
}