package common.modules.rendering.blockrendering;

import java.awt.Color;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import common.modules.blocks.*;
import common.modules.lib.RenderID;
import common.modules.lib.RenderUtil;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class waterMillRender implements ISimpleBlockRenderingHandler {
    public int[] colours = new int[] {
            0xF535AA
        };
    
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
    {
        int colour = colours[metadata];
        
        GL11.glPushMatrix();
        block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        
        Tessellator t = Tessellator.instance;
        t.setBrightness(255);
        
        Color c = new Color(colour);
        float r = c.getRed() / 255.0F;
        float g = c.getGreen() / 255.0F;
        float b = c.getBlue() / 255.0F;
        GL11.glColor3f(r, g, b);
        RenderUtil.instance();
		RenderUtil.drawFaces(renderer, block, ((BlockTest) block).textureBackground, true);
        GL11.glColor3f(1f, 1f, 1f);
        
        renderer.clearOverrideBlockTexture();
        
        RenderUtil.instance();
		RenderUtil.drawFaces(renderer, block, block.getIcon(0, metadata), block.getIcon(1, metadata), block.getIcon(2, metadata), block.getIcon(3, metadata), block.getIcon(4, metadata), block.getIcon(5, metadata), false);
        
        block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        GL11.glPopMatrix();
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        int colour = colours[FMLClientHandler.instance().getClient().theWorld.getBlockMetadata(x, y, z)];
        
        GL11.glPushMatrix();
        block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        renderer.setRenderBoundsFromBlock(block);
        
        Tessellator t = Tessellator.instance;
        t.setColorOpaque_I(colour);
        t.setBrightness(255);
        RenderUtil.instance().renderAllSides(world, x, y, z, block, renderer, ((BlockTest) block).textureBackground, true);
        
        renderer.clearOverrideBlockTexture();
        block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        
        renderer.renderStandardBlock(block, x, y, z);
        renderer.setRenderBoundsFromBlock(block);
        GL11.glPopMatrix();
        
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory()
    {
        return true;
    }

    @Override
    public int getRenderId()
    {
        return RenderID.renderIDKasTest;
    }
}
