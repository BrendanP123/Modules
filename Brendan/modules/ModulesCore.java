package Brendan.modules;

import Brendan.modules.Extra.CreativeTabModules;
import Brendan.modules.Lib.GlobalValues;
import Brendan.modules.Proxy.ClientProxy;
import Brendan.modules.Proxy.CommonProxy;
import Brendan.modules.Values.CoreValues;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(
		modid = GlobalValues.ModIDCore, 
		name = GlobalValues.ModNameCore, 
		version = GlobalValues.ModVersion 
		)


//NetworkMod annotation. Defines client/server requirement and the packet handler
@NetworkMod(
		clientSideRequired = true, 
		serverSideRequired = false)


public class ModulesCore {
	
	@Instance(GlobalValues.ModIDCore)
	public static ModulesCore instance;
	
	//SidedProxy annotation to specify the Client and Common proxies
	@SidedProxy(
	clientSide = "Brendan.modules.Proxy.ClientProxy",
	serverSide = "Brendan.modules.Proxy.CommonProxy")
	public static CommonProxy proxy;
	
	
	//Called during the pre-load phase
	@EventHandler
    public void PreLoad(FMLPreInitializationEvent event) {
    	CoreValues.initialize();
    }
    
    public static CreativeTabs Modules = new CreativeTabModules();
    
	//Called during the loading phase
    @EventHandler 
	public void load(FMLInitializationEvent event) {

	}
	
	//Called during the post-load phase
    @EventHandler 
	public void PostLoad(FMLPostInitializationEvent event) {
	}
	
}
