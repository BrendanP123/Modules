package common.modules.proxy.client;

import common.modules.items.ModItems;
import common.modules.lib.RenderID;
import common.modules.lib.RenderUtil;
import common.modules.proxy.server.ServerProxy;
import common.modules.rendering.blockrendering.MetalStorageRender;
import common.modules.rendering.blockrendering.OreRender;
import common.modules.rendering.blockrendering.waterMillRender;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends ServerProxy implements IClientProxy {
	public static int currentRenderPass;
	public static int renderPass;

	@Override
	public void loadRendering() 
	{
		RenderingRegistry.registerBlockHandler(new MetalStorageRender());
		RenderingRegistry.registerBlockHandler(new OreRender());
		RenderingRegistry.registerBlockHandler(new waterMillRender());
		RenderUtil.loadRenderingUtils();
	}

	@Override
	public void loadRenderIds()
	{
		RenderID.renderIDGlowBrick = RenderingRegistry.getNextAvailableRenderId();
		RenderID.renderIDIngotStorage = RenderingRegistry.getNextAvailableRenderId();
		RenderID.renderIDOre = RenderingRegistry.getNextAvailableRenderId();
		RenderID.renderIDKasTest = RenderingRegistry.getNextAvailableRenderId();
	}

	@Override
	public void loadTileEntities() 
	{
		super.loadTileEntities();
	}

	@Override
	public void loadCustomRarities()
	{

	}

	@Override
	public void registerHandlers() 
	{
		super.registerHandlers();
		TickRegistry.registerTickHandler(new RenderUtil(), Side.CLIENT);
	}

	@Override
	public void loadKeyBindings() 
	{

	}
}
