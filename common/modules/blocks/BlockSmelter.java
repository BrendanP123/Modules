package common.modules.blocks;

import java.util.Random;

import common.modules.Modules;
import common.modules.inventory.tileentity.TileEntitySmelter;
import common.modules.lib.GuiIds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSmelter extends BlockContainer
{
	@SideOnly(Side.CLIENT)
	private Icon side;
	@SideOnly(Side.CLIENT)
	private Icon front;
	@SideOnly(Side.CLIENT)
	private Icon front_active;
	@SideOnly(Side.CLIENT)
	private Icon bottom;

	private final Random furnaceRand = new Random();

	private static boolean keepFurnaceInventory = false;
	private final boolean isActive;

	public BlockSmelter(int par1, boolean par2)
	{
		super(par1, Material.iron);
		this.isActive = par2;
		setHardness(3.0F);
		setResistance(5.0F);
		this.setCreativeTab(Modules.creativeTabModulesBlocks);
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return ModBlocks.SmelterIdle.blockID;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntitySmelter();
	}

	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4)
	{
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
	         if (par1World.isRemote)
	{
	return true;
	}
	else if (!par5EntityPlayer.isSneaking())
	{
	TileEntitySmelter var10 = (TileEntitySmelter) par1World.getBlockTileEntity(par2, par3, par4);
	if (var10 != null)
	{
		par5EntityPlayer.openGui(Modules.instance, GuiIds.SMELTER, par1World, par2, par3, par4);
	}
	return true;
	}
	else
	{
	return false;
	}
	}

	public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
	{
		int l = par1World.getBlockMetadata(par2, par3, par4);
		TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
		keepFurnaceInventory = true;

		if (par0){par1World.setBlock(par2, par3, par4, ModBlocks.SmelterActive.blockID);}
		else{par1World.setBlock(par2, par3, par4, ModBlocks.SmelterIdle.blockID);}

		keepFurnaceInventory = false;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

		if (tileentity != null)
		{
			tileentity.validate();
			par1World.setBlockTileEntity(par2, par3, par4, tileentity);
		}
	}

	private void setDefaultDirection(World par1World, int par2, int par3, int par4)
	{
		if (!par1World.isRemote)
		{
			int l = par1World.getBlockId(par2, par3, par4 - 1);
			int i1 = par1World.getBlockId(par2, par3, par4 + 1);
			int j1 = par1World.getBlockId(par2 - 1, par3, par4);
			int k1 = par1World.getBlockId(par2 + 1, par3, par4);
			byte b0 = 3;

			if (Block.opaqueCubeLookup[l] && !Block.opaqueCubeLookup[i1]){b0 = 3;}
			if (Block.opaqueCubeLookup[i1] && !Block.opaqueCubeLookup[l]){b0 = 2;}
			if (Block.opaqueCubeLookup[j1] && !Block.opaqueCubeLookup[k1]){b0 = 5;}
			if (Block.opaqueCubeLookup[k1] && !Block.opaqueCubeLookup[j1]){b0 = 4;}
			par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
		}
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
	{
		int l = MathHelper.floor_double(par5EntityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		if (l == 0){par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);}
		if (l == 1){par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);}
		if (l == 2){par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);}
		if (l == 3){par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		if (this.isActive)
		{
			int l = par1World.getBlockMetadata(par2, par3, par4);
			float f = par2 + 0.5F;
			float f1 = par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
			float f2 = par4 + 0.5F;
			float f3 = 0.52F;
			float f4 = par5Random.nextFloat() * 0.6F - 0.3F;

			if (l == 4)
			{
				par1World.spawnParticle("smoke", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
			}
			else if (l == 5)
			{
				par1World.spawnParticle("smoke", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
			}
			else if (l == 2)
			{
				par1World.spawnParticle("smoke", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
			}
			else if (l == 3)
			{
				par1World.spawnParticle("smoke", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
				par1World.spawnParticle("flame", f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
	{
		if (!keepFurnaceInventory)
		{
			TileEntitySmelter tileentityfurnace = (TileEntitySmelter)par1World.getBlockTileEntity(par2, par3, par4);

			if (tileentityfurnace != null)
			{
				for (int j1 = 0; j1 < tileentityfurnace.getSizeInventory(); ++j1)
				{
					ItemStack itemstack = tileentityfurnace.getStackInSlot(j1);

					if (itemstack != null)
					{
						float f = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

						while (itemstack.stackSize > 0)
						{
							int k1 = this.furnaceRand.nextInt(21) + 10;

							if (k1 > itemstack.stackSize){k1 = itemstack.stackSize;}

							itemstack.stackSize -= k1;
							EntityItem entityitem = new EntityItem(par1World, par2 + f, par3 + f1,
									par4 + f2, new ItemStack(itemstack.itemID, k1, itemstack.getItemDamage()));

							if (itemstack.hasTagCompound())
							{
								entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
							}

							float f3 = 0.05F;
							entityitem.motionX = (float)this.furnaceRand.nextGaussian() * f3;
							entityitem.motionY = (float)this.furnaceRand.nextGaussian() * f3 + 0.2F;
							entityitem.motionZ = (float)this.furnaceRand.nextGaussian() * f3;
							par1World.spawnEntityInWorld(entityitem);
						}
					}
				}

				par1World.func_96440_m(par2, par3, par4, par5);
			}
		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	@Override
	public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.side : par1 == 0 ? this.bottom : (par1 == 1 ? this.front_active : (par1 != par2 ? this.blockIcon : this.front_active));
    }

    @Override
	@SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("Modules:infuser_side");
        this.front_active = par1IconRegister.registerIcon(this.isActive ? "Modules:infuser_active_front" : "Modules:infuser_front");
        this.side = par1IconRegister.registerIcon("Modules:infuser_side");
        this.bottom = par1IconRegister.registerIcon("Modules:infuser_side");
 
    }

	@Override
	public int idPicked(World world, int x, int y, int z)
	{
		return ModBlocks.SmelterIdle.blockID;
	}
}