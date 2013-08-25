package Brendan.modules.Values;

import Brendan.modules.ModulesCore;
import Brendan.modules.Blocks.BlockLiquefier;
import Brendan.modules.Blocks.BlockSmelter;
import Brendan.modules.Blocks.Infuser;
import Brendan.modules.Blocks.Refinery;
import Brendan.modules.Inventory.GuiHandler;
import Brendan.modules.Inventory.TileEntityInfuser;
import Brendan.modules.Inventory.TileEntityRefinery;
import Brendan.modules.Inventory.TileEntitySmelter;
import Brendan.modules.Inventory.TileEntityTest;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;



/**
 * Values and other for the world expansion.
 * 
 * @author BrendanP123
 *
 */
public class MachineValues {
	
	
	public static MachineValues proxy;
	//Ore Based blocks
	public static Block RefineryIdle;
	public static Block RefineryActive;
	public static Block InfuserIdle;
	public static Block InfuserActive;
	public static Block SmelterIdle;
	public static Block SmelterActive;
	public static Block AlchemyTable;
	public static Block Liquefier;
	
	

	public static GuiHandler guiHandler = new GuiHandler();

	
	
    public static void initialize() {
    
    	
		RefineryIdle = new Refinery(1009, false).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("RefineryIdle").setCreativeTab(ModulesCore.Modules);
		RefineryActive = new Refinery(1010, true).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("RefineryActive");		
		InfuserIdle = new Infuser(1011, false).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("InfuserIdle").setCreativeTab(ModulesCore.Modules);
		InfuserActive = new Infuser(1012, true).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("InfuserActive");
		SmelterIdle = new BlockSmelter(1013, false).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("SmelterIdle").setCreativeTab(ModulesCore.Modules);
		SmelterActive = new BlockSmelter(1014, true).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("SmelterActive");
    	
    	NetworkRegistry.instance().registerGuiHandler(null, guiHandler);
    	GameRegistry.registerTileEntity(TileEntityRefinery.class,"tileEntityRefinery");				
    	GameRegistry.registerBlock(RefineryIdle, "RefineryIdle");
    	GameRegistry.registerBlock(RefineryActive, "RefineryActive");
        LanguageRegistry.addName(RefineryIdle, "Refinery");
        LanguageRegistry.addName(RefineryActive, "Refinery Active");
        //Infuser
    	GameRegistry.registerTileEntity(TileEntityInfuser.class,"tileEntityInfuser");				
    	GameRegistry.registerBlock(InfuserIdle, "InfuserIdle");
    	GameRegistry.registerBlock(InfuserActive, "InfuserActive");
        LanguageRegistry.addName(InfuserIdle, "Infuser");
        LanguageRegistry.addName(InfuserActive, "Infuser Active");
        //Smeltery
        GameRegistry.registerTileEntity(TileEntitySmelter.class,"tileEntitySmelter");				
    	GameRegistry.registerBlock(SmelterIdle, "SmelterIdle");
    	GameRegistry.registerBlock(SmelterActive, "SmelterActive");
        LanguageRegistry.addName(SmelterIdle, "Smelter");
        LanguageRegistry.addName(SmelterActive, "Smelter Active");
        
        
        GameRegistry.addRecipe(new ItemStack(InfuserIdle), new Object[]{
			"QQQ","AIA","AAA", Character.valueOf('I'), Block.furnaceIdle, Character.valueOf('A'), Item.ingotGold, Character.valueOf('Q'), Block.stone
        });
    }
}
 
