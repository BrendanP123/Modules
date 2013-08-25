package Brendan.modules;


import Brendan.modules.Lib.GlobalValues;
import Brendan.modules.Proxy.CommonProxy;
import Brendan.modules.Values.MachineValues;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(
		modid = GlobalValues.ModIDMachines,
		name = GlobalValues.ModNameMachines,
		version = GlobalValues.ModVersion,
		dependencies = GlobalValues.World
		)


//NetworkMod annotation. Defines client/server requirement and the packet handler
@NetworkMod(
		clientSideRequired = true, 
		serverSideRequired = false)


public class ModulesMachines {
	
	@Instance(GlobalValues.ModIDMachines)
	public static ModulesMachines instance;
	
	//SidedProxy annotation to specify the Client and Common proxies
	@SidedProxy(
			clientSide = "Brendan.modules.Proxy.ClientProxy",
			serverSide = "Brendan.modules.Proxy.CommonProxy")
	public static CommonProxy proxy;
	
	
	//Called during the pre-load phase
	@EventHandler
    public void PreLoad(FMLPreInitializationEvent event) {
    	MachineValues.initialize();
    }
    
	//Called during the loading phase
	@EventHandler 
	public void load(FMLInitializationEvent event) {
		NetworkRegistry.instance().registerGuiHandler(this, GlobalValues.GUIHandler);
	}
	
	//Called during the post-load phase
	@EventHandler 
	public void PostLoad(FMLPostInitializationEvent event) {
	}
	
}
