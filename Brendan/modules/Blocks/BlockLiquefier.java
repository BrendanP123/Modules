package Brendan.modules.Blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.util.Icon;
import net.minecraft.world.World;


public class BlockLiquefier extends Block {

    @SideOnly(Side.CLIENT)
    private Icon field_94461_a;
    @SideOnly(Side.CLIENT)
    private Icon field_94460_b;
	
        public BlockLiquefier (int id) {
                super(id, Material.wood);
                setHardness(2.0F);
                setResistance(5.0F);
                this.setUnlocalizedName("AlchemyTable");
                setCreativeTab(CreativeTabs.tabDecorations);
        }

        @SideOnly(Side.CLIENT)

        /**
         * A randomly called display update to be able to add particles or other items for display
         */
        public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
        {
            super.randomDisplayTick(par1World, par2, par3, par4, par5Random);

            for (int l = par2 - 2; l <= par2 + 2; ++l)
            {
                for (int i1 = par4 - 2; i1 <= par4 + 2; ++i1)
                {
                    if (l > par2 - 2 && l < par2 + 2 && i1 == par4 - 1)
                    {
                        i1 = par4 + 2;
                    }

                    if (par5Random.nextInt(16) == 0)
                    {
                        for (int j1 = par3; j1 <= par3 + 1; ++j1)
                        {
                            if (par1World.getBlockId(l, j1, i1) == Block.bookShelf.blockID)
                            {
                                if (!par1World.isAirBlock((l - par2) / 2 + par2, j1, (i1 - par4) / 2 + par4))
                                {
                                    break;
                                }

                                par1World.spawnParticle("enchantmenttable", (double)par2 + 0.5D, (double)par3 + 2.0D, (double)par4 + 0.5D, (double)((float)(l - par2) + par5Random.nextFloat()) - 0.5D, (double)((float)(j1 - par3) - par5Random.nextFloat() - 1.0F), (double)((float)(i1 - par4) + par5Random.nextFloat()) - 0.5D);
                            }
                        }
                    }
                }
            }
        }

        /**
         * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
         * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
         */
        public boolean isOpaqueCube()
        {
            return false;
        }

        @SideOnly(Side.CLIENT)

        /**
         * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
         */
        public Icon getIcon(int par1, int par2)
        {
            return par1 == 0 ? this.field_94460_b : (par1 == 1 ? this.field_94461_a : this.blockIcon);
        }

        /**
         * Called when the block is placed in the world.
         */
        public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving, ItemStack par6ItemStack)
        {
            super.onBlockPlacedBy(par1World, par2, par3, par4, par5EntityLiving, par6ItemStack);

            if (par6ItemStack.hasDisplayName())
            {
                ((TileEntityEnchantmentTable)par1World.getBlockTileEntity(par2, par3, par4)).func_94134_a(par6ItemStack.getDisplayName());
            }
        }

        @SideOnly(Side.CLIENT)

        /**
         * When this method is called, your block should register all the icons it needs with the given IconRegister. This
         * is the only chance you get to register icons.
         */
        public void registerIcons(IconRegister par1IconRegister)
        {
            this.blockIcon = par1IconRegister.registerIcon("enchantment_side");
            this.field_94461_a = par1IconRegister.registerIcon("enchantment_top");
            this.field_94460_b = par1IconRegister.registerIcon("enchantment_bottom");
        }
    }
        
        
        /**
        @Override
        public boolean onBlockActivated(World world, int x, int y, int z,
                        EntityPlayer player, int idk, float what, float these, float are) {
                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if (tileEntity == null || player.isSneaking()) {
                        return false;
                }
        //code to open gui explained later
                player.openGui(ModulesMachines.instance, GuiIds.ALCHEMYTABLE, world, x, y, z);
                return true;
        }

        @Override
        public void breakBlock(World world, int x, int y, int z, int par5, int par6) {
                dropItems(world, x, y, z);
                super.breakBlock(world, x, y, z, par5, par6);
        }

        private void dropItems(World world, int x, int y, int z){
                Random rand = new Random();

                TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
                if (!(tileEntity instanceof IInventory)) {
                        return;
                }
                IInventory inventory = (IInventory) tileEntity;

                for (int i = 0; i < inventory.getSizeInventory(); i++) {
                        ItemStack item = inventory.getStackInSlot(i);

                        if (item != null && item.stackSize > 0) {
                                float rx = rand.nextFloat() * 0.8F + 0.1F;
                                float ry = rand.nextFloat() * 0.8F + 0.1F;
                                float rz = rand.nextFloat() * 0.8F + 0.1F;

                                EntityItem entityItem = new EntityItem(world,
                                                x + rx, y + ry, z + rz,
                                                new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));
                                float factor = 0.05F;
                                entityItem.motionX = rand.nextGaussian() * factor;
                                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                                entityItem.motionZ = rand.nextGaussian() * factor;
                                world.spawnEntityInWorld(entityItem);
                                item.stackSize = 0;
                        }
                }
        }
        @Override
        public TileEntity createNewTileEntity(World world) {
                return new TileEntityAlchemyTable();
        }
        **/