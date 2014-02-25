package common.modules.inventory.container;


import common.modules.crafting.RefineryRecipes;
import common.modules.inventory.container.slot.SlotRefinery;
import common.modules.inventory.tileentity.TileEntityRefinery;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerRefinery extends Container
{
	private TileEntityRefinery furnace;
	private int lastCookTime = 0;
	private int lastBurnTime = 0;
	private int lastItemBurnTime = 0;

	public ContainerRefinery(InventoryPlayer par1InventoryPlayer, TileEntityRefinery par2TileEntityRefinery)
	{
		this.furnace = par2TileEntityRefinery;
		this.addSlotToContainer(new Slot(par2TileEntityRefinery, 0, 56, 17));
		this.addSlotToContainer(new Slot(par2TileEntityRefinery, 1, 56, 53));
		this.addSlotToContainer(new SlotRefinery(par1InventoryPlayer.player, par2TileEntityRefinery, 2, 116, 35));
		int var3;

		for (var3 = 0; var3 < 3; ++var3)
		{
			for (int var4 = 0; var4 < 9; ++var4)
			{
				this.addSlotToContainer(new Slot(par1InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
			}
		}

		for (var3 = 0; var3 < 9; ++var3)
		{
			this.addSlotToContainer(new Slot(par1InventoryPlayer, var3, 8 + var3 * 18, 142));
		}

	}

	public void addCraftingToCrafters(ICrafting par1ICrafting)
	{
		super.addCraftingToCrafters(par1ICrafting);
		par1ICrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime);
		par1ICrafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceBurnTime);
		par1ICrafting.sendProgressBarUpdate(this, 2, this.furnace.currentItemBurnTime);
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	 public void detectAndSendChanges()
	{
		 super.detectAndSendChanges();

		 for (int i = 0; i < this.crafters.size(); ++i)
		 {
			 ICrafting icrafting = (ICrafting)this.crafters.get(i);

			 if (this.lastCookTime != this.furnace.furnaceCookTime)
			 {
				 icrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime);
			 }

			 if (this.lastBurnTime != this.furnace.furnaceBurnTime)
			 {
				 icrafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceBurnTime);
			 }

			 if (this.lastItemBurnTime != this.furnace.currentItemBurnTime)
			 {
				 icrafting.sendProgressBarUpdate(this, 2, this.furnace.currentItemBurnTime);
			 }
		 }

		 this.lastCookTime = this.furnace.furnaceCookTime;
		 this.lastBurnTime = this.furnace.furnaceBurnTime;
		 this.lastItemBurnTime = this.furnace.currentItemBurnTime;
	}

	 @SideOnly(Side.CLIENT)
	 public void updateProgressBar(int par1, int par2)
	 {
		 if (par1 == 0)
		 {
			 this.furnace.furnaceCookTime = par2;
		 }

		 if (par1 == 1)
		 {
			 this.furnace.furnaceBurnTime = par2;
		 }

		 if (par1 == 2)
		 {
			 this.furnace.currentItemBurnTime = par2;
		 }
	 }

	 public boolean canInteractWith(EntityPlayer par1EntityPlayer)
	 {
		 return this.furnace.isUseableByPlayer(par1EntityPlayer);
	 }

	 /**
	  * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	  */
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
				 if (RefineryRecipes.smelting().getSmeltingResult(itemstack1) != null)
				 {
					 if (!this.mergeItemStack(itemstack1, 0, 1, false))
					 {
						 return null;
					 }
				 }
				 else if (TileEntityRefinery.isItemFuel(itemstack1))
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