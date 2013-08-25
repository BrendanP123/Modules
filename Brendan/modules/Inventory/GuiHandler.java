package Brendan.modules.Inventory;


import Brendan.modules.Lib.GuiIds;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;


public class GuiHandler implements IGuiHandler {

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		if (!world.blockExists(x, y, z))
			return null;

		TileEntity tile = world.getBlockTileEntity(x, y, z);

		switch (ID) {

		case GuiIds.REFINERY:
			if (!(tile instanceof TileEntityRefinery))
				return null;
			return new GuiRefinery(player.inventory, (TileEntityRefinery) tile);

		case GuiIds.INFUSER:
			if (!(tile instanceof TileEntityInfuser))
				return null;
			return new GuiInfuser(player.inventory, (TileEntityInfuser) tile);
			
		case GuiIds.SMELTER:
			if (!(tile instanceof TileEntitySmelter))
				return null;
			return new GuiSmelter(player.inventory, (TileEntitySmelter) tile);


		default:
			return null;
		}
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		if (!world.blockExists(x, y, z))
			return null;

		TileEntity tile = world.getBlockTileEntity(x, y, z);

		switch (ID) {

		case GuiIds.REFINERY:
			if (!(tile instanceof TileEntityRefinery))
				return null;
			return new ContainerRefinery(player.inventory, (TileEntityRefinery) tile);

		case GuiIds.INFUSER:
			if (!(tile instanceof TileEntityInfuser))
				return null;
			return new ContainerInfuser(player.inventory, (TileEntityInfuser) tile);
        
		case GuiIds.SMELTER:
			if (!(tile instanceof TileEntitySmelter))
				return null;
			return new ContainerSmelter(player.inventory, (TileEntitySmelter) tile);

			
		default:
			return null;
		}
	}

}