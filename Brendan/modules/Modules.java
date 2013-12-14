package Brendan.modules;

import net.minecraft.creativetab.CreativeTabs;
import Brendan.modules.Blocks.ModBlocks;
import Brendan.modules.Crafting.BlockCrafting;
import Brendan.modules.Crafting.ItemCrafting;
import Brendan.modules.Items.ModItems;
import Brendan.modules.Lib.CreativeTabModulesBlocks;
import Brendan.modules.Lib.CreativeTabModulesItems;
import Brendan.modules.Lib.GlobalValues;
import Brendan.modules.Proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(
		modid = "Modules", 
		name = "Modules", 
		version = "1.6.4_B" 
		)


//NetworkMod annotation. Defines client/server requirement and the packet handler
@NetworkMod(
		clientSideRequired = true, 
		serverSideRequired = false)


public class Modules {
	
	@Instance(GlobalValues.MODID)
	public static Modules instance;
	
	
	@SidedProxy(clientSide = "Brendan.modules.Proxy.ClientProxy", serverSide = "Brendan.modules.Proxy.CommonProxy")
	public static CommonProxy proxy;

	public static CreativeTabs creativeTabModulesBlocks = new CreativeTabModulesBlocks(CreativeTabs.getNextID());
    public static CreativeTabs creativeTabModulesItems = new CreativeTabModulesItems(CreativeTabs.getNextID());
    
	
	//Called during the pre-load phase
	@EventHandler
    public void PreLoad(FMLPreInitializationEvent event) {
    	proxy.loadRenderIds();
        proxy.registerHandlers();
        
    }
	
	//Called during the loading phase
    @EventHandler 
	public void load(FMLInitializationEvent event) {
    	ModBlocks.initialize();
    	ModItems.initialize();
		ItemCrafting.initialise();
		BlockCrafting.initialise();
	}
	
	//Called during the post-load phase
    @EventHandler 
	public void PostLoad(FMLPostInitializationEvent event) {
    	proxy.loadRendering();
	}
	
}
