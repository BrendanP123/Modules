package common.modules;

import java.io.File;

import common.modules.blocks.*;
import common.modules.crafting.*;
import common.modules.creativetab.*;
import common.modules.items.*;
import common.modules.lib.*;
import common.modules.proxy.server.*;
import common.modules.proxy.client.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod( modid = Reference.MODID, name = Reference.MODName, version = Reference.ModVersion )
@NetworkMod( clientSideRequired = true, serverSideRequired = false )


public class Modules {
	
	@Instance(Reference.MODID)
	public static Modules instance;
	
	
	@SidedProxy(clientSide = "common.modules.proxy.client.ClientProxy", serverSide = "common.modules.proxy.server.ServerProxy")
	public static ServerProxy proxy;

	public static CreativeTabs creativeTabModulesBlocks = new CreativeTabModulesBlocks(CreativeTabs.getNextID());
    public static CreativeTabs creativeTabModulesItems = new CreativeTabModulesItems(CreativeTabs.getNextID());
    
	
	//Called during the pre-load phase
	@EventHandler
    public void PreLoad(FMLPreInitializationEvent event) 
	{
		proxy.loadRenderIds();
        proxy.registerHandlers();
        Reference.initializeConfig();
    }
	
	//Called during the loading phase
    @EventHandler 
	public void load(FMLInitializationEvent event) 
    {
    	ModBlocks.initialize();
    	ModItems.initialize();
    	ItemCrafting.initialise();
		BlockCrafting.initialise();
		
		System.out.println("+++++++++++++++++++++++++[Modules][NOTICE]+++++++++++++++++++++++++");
		System.out.println("Modules Is Loading");
		System.out.println("Credits to DSalcky for the mod idea, Jakemichie97 for the ore/metal blocks, Kasslim for being a friend");
		System.out.println("Made & Coded by BrendanP123");
	}
	
	//Called during the post-load phase
    @EventHandler 
	public void PostLoad(FMLPostInitializationEvent event) 
    {
    	proxy.loadRendering();
	}
	
}
