package Brendan.modules.Rendering;

import org.lwjgl.opengl.GL11;

import Brendan.modules.Models.ModelSRod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderLauncher implements IItemRenderer {
	
	protected ModelSRod SRod;
	
	public ItemRenderLauncher()
	{
		SRod = new ModelSRod();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) 
	{
		switch(type)
		{
		case EQUIPPED: return true;
		default: return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) 
	{
		switch(type)
		{
		case EQUIPPED:
		{
			GL11.glPushMatrix();
			
			ResourceLocation texture = (new ResourceLocation("Modules:textures/models/Lol.png")); 
			
			float scale = 1.0f;
			GL11.glScalef(scale, scale, scale);
			//GL11.glRotatef(angle, x, y, z)
			
			boolean isFirstPerson = false;
			
			if(data[1] != null && data[1] instanceof EntityPlayer)
			{
				if(!((EntityPlayer)data[1] == Minecraft.getMinecraft().renderViewEntity && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && !((Minecraft.getMinecraft().currentScreen instanceof GuiInventory || Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative) && RenderManager.instance.playerViewY == 180.0F)))
				{
					GL11.glTranslatef(1, 1, 1);
				}
				else
				{
					isFirstPerson = true;
					
				}
			}
			else
			{
				GL11.glTranslatef(1, 1, 1);
			}
			
			
			
			SRod.render((Entity)data[1], 0.0F, 0.0f, 0.0f, 0.0f, 0.0625f, 0, isFirstPerson);
			GL11.glPopMatrix();
		}
		default:
			break;
		}
	}
}
