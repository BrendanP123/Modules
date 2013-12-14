package Brendan.modules.Lib;



import Brendan.modules.Inventory.GuiHandler;

public class GlobalValues {
	//Mod Info
	public static final String MODID = "Modules";
	public static final String ModIDCore = "ModulesCore";
	public static final String ModNameCore = "Modules";
	public static final String ModIDWorld = "Modules|World";
	public static final String ModNameWorld = "Modules World Expansion";
	public static final String ModNameMechanical = "Modules Mechanical Expansion";
	public static final String ModIDMachines = "Modules|Mach";
	public static final String ModNameMachines = "Modules Machines Expansion";
	public static final String ModVersion = "1.6.4_A";
	public static final String CreativeTabModulesBlocks = "Module Blocks";
	public static final String CreativeTabModulesItems = "Module Items";
	

	//Dependency variables
	public static final String Core = "required-after:" + MODID + "@" + ModVersion;


    //Texture Path
	public static final String PATH_TEXTURES = "/textures/";
	public static final String PATH_TEXTURES_BLOCKS = PATH_TEXTURES + "blocks/";
	public static final String PATH_TEXTURES_ITEMS = PATH_TEXTURES + "items/";
	public static final String PATH_TEXTURES_GUI = PATH_TEXTURES + "gui/";
	public static final String PATH_TEXTURES_GUI_HUD = PATH_TEXTURES + "hud/";
	public static final String PATH_SOUNDS = "/sounds/";
	public static final String PATH_MODELS = "/models/";
	public static final String PATH_TEXTURES_MODELS = PATH_TEXTURES + "model/";
	
	//Gui Texture Locations
	public static final String infuser = "gui/InfuserDouble.png";
	

	//GuiHandlers
	public static GuiHandler GUIHandler = new GuiHandler();

	public static boolean initialize() {
		return true;
	}

}