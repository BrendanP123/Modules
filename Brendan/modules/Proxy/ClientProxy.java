package Brendan.modules.Proxy;

import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import Brendan.modules.Items.ModItems;
import Brendan.modules.Lib.RenderID;
import Brendan.modules.Lib.RenderUtil;
import Brendan.modules.Rendering.ItemRenderLauncher;
import Brendan.modules.Rendering.MetalStorageRender;
import Brendan.modules.Rendering.OreRender;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy implements IClientProxy {
	public static int currentRenderPass;
	public static int renderPass;
	
    @Override
    public void loadRendering() 
    {
        RenderingRegistry.registerBlockHandler(new MetalStorageRender());
        RenderingRegistry.registerBlockHandler(new OreRender());
        RenderUtil.loadRenderingUtils();       
        MinecraftForgeClient.registerItemRenderer(ModItems.SRod.itemID, (IItemRenderer)new ItemRenderLauncher());
    }
    
    @Override
    public void loadRenderIds()
    {
        RenderID.renderIDGlowBrick = RenderingRegistry.getNextAvailableRenderId();
        RenderID.renderIDRubyOre = RenderingRegistry.getNextAvailableRenderId();
        RenderID.renderIDCustomDirt = RenderingRegistry.getNextAvailableRenderId();
        RenderID.renderIDIngotStorage = RenderingRegistry.getNextAvailableRenderId();
        RenderID.renderIDOre = RenderingRegistry.getNextAvailableRenderId();
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
