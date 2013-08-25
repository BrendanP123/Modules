package Brendan.modules.Blocks;

import java.util.Random;

import Brendan.modules.ModulesCore;
import Brendan.modules.ModulesMachines;
import Brendan.modules.Inventory.TileEntityInfuser;
import Brendan.modules.Lib.GuiIds;
import Brendan.modules.Values.MachineValues;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Infuser extends BlockContainer {
	private Random furnaceRand = new Random();

	private final boolean isActive;

	@SideOnly(Side.CLIENT)
	private Icon side;
	@SideOnly(Side.CLIENT)
	private Icon front;
	@SideOnly(Side.CLIENT)
	private Icon front_active;
	@SideOnly(Side.CLIENT)
	private Icon bottom;

	private static boolean keepFurnaceInventory = false;

	public Infuser(int par1, boolean par2) {
		super(par1, Material.rock);
		this.isActive = par2;
		this.setCreativeTab(ModulesCore.Modules);
		this.setUnlocalizedName("Infuser");
	}

	public int idDropped(int par1, Random par2Random, int par3) {
		return MachineValues.InfuserIdle.blockID;
	}

	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		super.onBlockAdded(par1World, par2, par3, par4);
		this.setDefaultDirection(par1World, par2, par3, par4);
	}

	private void setDefaultDirection(World par1World, int par2, int par3,
			int par4) {
		if (!par1World.isRemote) {
			int var5 = par1World.getBlockId(par2, par3, par4 - 1);
			int var6 = par1World.getBlockId(par2, par3, par4 + 1);
			int var7 = par1World.getBlockId(par2 - 1, par3, par4);
			int var8 = par1World.getBlockId(par2 + 1, par3, par4);
			byte var9 = 3;

			if (Block.opaqueCubeLookup[var5] && !Block.opaqueCubeLookup[var6]) {
				var9 = 3;
			}

			if (Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var5]) {
				var9 = 2;
			}

			if (Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var8]) {
				var9 = 5;
			}

			if (Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var7]) {
				var9 = 4;
			}

			par1World.setBlockMetadataWithNotify(par2, par3, par4, var9, var8);
		}
	}
	
    public Icon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.side : par1 == 0 ? this.bottom : (par1 == 1 ? this.front_active : (par1 != par2 ? this.blockIcon : this.front_active));
    }

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

	//public void registerIcons2(IconRegister par1IconRegister) {
	//	this.field_94392_b = par1IconRegister.registerIcon("MachineValues:infuser_side");
	//	this.field_94459_cP = par1IconRegister.registerIcon(this.isActive ? "MachineValues":"infuser_active_front");
	//	this.field_94458_cA = par1IconRegister.registerIcon(this.isActive ? "MachineValues":"infuser_active_side");
	//	this.field_94392_a = par1IconRegister.registerIcon("MachineValues:infuser_side");
	//}

	//public Icon getBlockTextureFromSideAndMetadata2(int par1, int par2) {
	//	return par1 == 1 ? this.field_94392_a : par1 == 0 ? this.field_94392_b : par1 == 0 ? this.field_94392_b
	//			: (par1 != par2 ? this.blockIcon : this.field_94459_cP) : this.blockIcon : this.field_94459_cP);
	//}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World par1World, int par2, int par3,
			int par4, Random par5Random) {
		if (this.isActive) {
			int var6 = par1World.getBlockMetadata(par2, par3, par4);
			float var7 = (float) par2 + 0.5F;
			float var8 = (float) par3 + 0.0F + par5Random.nextFloat() * 6.0F
					/ 16.0F;
			float var9 = (float) par4 + 0.5F;
			float var10 = 0.52F;
			float var11 = par5Random.nextFloat() * 0.6F - 0.3F;

			if (var6 == 1) {
				par1World.spawnParticle("largesmoke",
						(double) ((float) par2 + par5Random.nextFloat()),
						(double) ((float) par3 + 1.1F),
						(double) ((float) par4 + par5Random.nextFloat()), 0.0D,
						0.0D, 0.0D);
				par1World.spawnParticle("townaura",
						(double) ((float) par2 + par5Random.nextFloat()),
						(double) ((float) par3 + 1.1F),
						(double) ((float) par4 + par5Random.nextFloat()), 0.0D,
						0.0D, 0.0D);
			} else if (var6 == 2) {
				par1World.spawnParticle("largesmoke",
						(double) ((float) par2 + par5Random.nextFloat()),
						(double) ((float) par3 + 1.1F),
						(double) ((float) par4 + par5Random.nextFloat()), 0.0D,
						0.0D, 0.0D);
				par1World.spawnParticle("townaura",
						(double) ((float) par2 + par5Random.nextFloat()),
						(double) ((float) par3 + 1.1F),
						(double) ((float) par4 + par5Random.nextFloat()), 0.0D,
						0.0D, 0.0D);
			} else if (var6 == 3) {
				par1World.spawnParticle("largesmoke",
						(double) ((float) par2 + par5Random.nextFloat()),
						(double) ((float) par3 + 1.1F),
						(double) ((float) par4 + par5Random.nextFloat()), 0.0D,
						0.0D, 0.0D);
				par1World.spawnParticle("townaura",
						(double) ((float) par2 + par5Random.nextFloat()),
						(double) ((float) par3 + 1.1F),
						(double) ((float) par4 + par5Random.nextFloat()), 0.0D,
						0.0D, 0.0D);
			} else if (var6 == 4) {
				par1World.spawnParticle("largesmoke",
						(double) ((float) par2 + par5Random.nextFloat()),
						(double) ((float) par3 + 1.1F),
						(double) ((float) par4 + par5Random.nextFloat()), 0.0D,
						0.0D, 0.0D);
				par1World.spawnParticle("townaura",
						(double) ((float) par2 + par5Random.nextFloat()),
						(double) ((float) par3 + 1.1F),
						(double) ((float) par4 + par5Random.nextFloat()), 0.0D,
						0.0D, 0.0D);
			} else {
				par1World.spawnParticle("largesmoke",
						(double) ((float) par2 + par5Random.nextFloat()),
						(double) ((float) par3 + 1.1F),
						(double) ((float) par4 + par5Random.nextFloat()), 0.0D,
						0.0D, 0.0D);
				par1World.spawnParticle("townaura",
						(double) ((float) par2 + par5Random.nextFloat()),
						(double) ((float) par3 + 1.1F),
						(double) ((float) par4 + par5Random.nextFloat()), 0.0D,
						0.0D, 0.0D);
			}
		}
	}

	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {
		if (par1World.isRemote) {
			return true;
		} else if (!par5EntityPlayer.isSneaking()) {
			TileEntityInfuser var10 = (TileEntityInfuser) par1World
					.getBlockTileEntity(par2, par3, par4);
			if (var10 != null) {
				par5EntityPlayer.openGui(ModulesMachines.instance, GuiIds.INFUSER,
						par1World, par2, par3, par4);
			}
			return true;
		} else {
			return false;
		}
	}

	public static void updateFurnaceBlockState(boolean par0, World par1World, int par2, int par3, int par4)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4);
        TileEntity tileentity = par1World.getBlockTileEntity(par2, par3, par4);
        keepFurnaceInventory = true;

        if (par0)
        {
            par1World.setBlock(par2, par3, par4, MachineValues.InfuserActive.blockID);
        }
        else
        {
            par1World.setBlock(par2, par3, par4, MachineValues.InfuserIdle.blockID);
        }

        keepFurnaceInventory = false;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            par1World.setBlockTileEntity(par2, par3, par4, tileentity);
        }
    }

	public TileEntity createNewTileEntity(World par1World) {
		return new TileEntityInfuser();
	}
	
    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }

        if (l == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (l == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }

        if (par6ItemStack.hasDisplayName())
        {
            ((TileEntityFurnace)par1World.getBlockTileEntity(par2, par3, par4)).setGuiDisplayName(par6ItemStack.getDisplayName());
        }
    }

	public void breakBlock(World par1World, int par2, int par3, int par4,
			int par5, int par6) {
		if (!keepFurnaceInventory) {
			TileEntityInfuser var7 = (TileEntityInfuser) par1World
					.getBlockTileEntity(par2, par3, par4);

			if (var7 != null) {
				for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8) {
					ItemStack var9 = var7.getStackInSlot(var8);

					if (var9 != null) {
						float var10 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float var11 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
						float var12 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

						while (var9.stackSize > 0) {
							int var13 = this.furnaceRand.nextInt(21) + 10;

							if (var13 > var9.stackSize) {
								var13 = var9.stackSize;
							}

							var9.stackSize -= var13;
							EntityItem var14 = new EntityItem(par1World,
									(double) ((float) par2 + var10),
									(double) ((float) par3 + var11),
									(double) ((float) par4 + var12),
									new ItemStack(var9.itemID, var13,
											var9.getItemDamage()));

							if (var9.hasTagCompound()) {
								var14.getEntityItem().setTagCompound(
										(NBTTagCompound) var9.getTagCompound()
												.copy());
							}

							float var15 = 0.05F;
							var14.motionX = (double) ((float) this.furnaceRand
									.nextGaussian() * var15);
							var14.motionY = (double) ((float) this.furnaceRand
									.nextGaussian() * var15 + 0.2F);
							var14.motionZ = (double) ((float) this.furnaceRand
									.nextGaussian() * var15);
							par1World.spawnEntityInWorld(var14);
						}
					}
				}
			}
		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}
}
