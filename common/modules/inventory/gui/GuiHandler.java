package common.modules.inventory.gui;

import common.modules.Modules;
import common.modules.inventory.tileentity.*;
import common.modules.inventory.container.*;
import common.modules.inventory.gui.*;
import common.modules.lib.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {
	public GuiHandler() {
		NetworkRegistry.instance().registerGuiHandler(Modules.instance, this);
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);

		if(entity != null){
			switch (id) {
				case Reference.REFINERY:
					if (entity instanceof TileEntityRefinery) {
						return new ContainerRefinery(player.inventory, (TileEntityRefinery) entity);
					}
				case Reference.SMELTER:
					if (entity instanceof TileEntitySmelter) {
						return new ContainerSmelter(player.inventory, (TileEntitySmelter) entity);
					}
					
					return null;
				default:
					return null;
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);

		if(entity != null){
			switch (id) {
				case Reference.REFINERY:
					if (entity instanceof TileEntityRefinery) {
						return new GuiRefinery(player.inventory, (TileEntityRefinery) entity);
					}
				case Reference.SMELTER:
					if (entity instanceof TileEntitySmelter) {
						return new GuiSmelter(player.inventory, (TileEntitySmelter) entity);
					}
					
					return null;
				default:
					return null;
			}
		}
		return null;
	}	
}
