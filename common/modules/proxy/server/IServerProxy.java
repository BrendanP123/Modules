package common.modules.proxy.server;

/**
 * Base interface for any ForgeModLoader CommonProxy class.
 * 
 * @author Jcm2606
 * @author BrendanP123
 */
public interface IServerProxy {
    /**
     * Loads the rendering features.
     * 
     * Does nothing on the server.
     */
    public void loadRendering();

    /**
     * Loads the TileEntity's for a mod.
     */
    public void loadTileEntities();

    /**
     * Loads the custom rarities for a mod.
     * 
     * Does nothing on the server.
     */
    public void loadCustomRarities();

    /**
     * Registers the handlers for a mod.
     */
    public void registerHandlers();
    
    /**
     * Loads the keybindings for a mod.
     * 
     * Does nothing on the server.
     */
    public void loadKeyBindings();
    
    /**
     * Loads the render ids for a mod.
     * 
     * Does nothing on the server.
     */
    public void loadRenderIds();
}
