package gizmadicks.common.block;

import gizmadicks.Gizmadicks;
import gizmadicks.lib.Textures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.common.Optional;

public abstract class BlockGizmadicks extends BlockContainer{

    protected BlockGizmadicks(Material par2Material){
        super(par2Material);
        setCreativeTab(Gizmadicks.tabGizmadicks);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata){
        try {
            return getTileEntityClass().newInstance();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected abstract Class<? extends TileEntity> getTileEntityClass();

    protected int getGuiID(){
        return -1;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
        return true;
    }

    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack){
        
    }

    public boolean isRotatable(){
        return false;
    }

    protected boolean canRotateToTopOrBottom(){
        return false;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta){
        dropInventory(world, x, y, z);
        super.breakBlock(world, x, y, z, block, meta);
    }

    protected void dropInventory(World world, int x, int y, int z){

        TileEntity tileEntity = world.getTileEntity(x, y, z);

        if(!(tileEntity instanceof IInventory)) return;

        IInventory inventory = (IInventory)tileEntity;
        Random rand = new Random();
        for(int i = getInventoryDropStartSlot(inventory); i < getInventoryDropEndSlot(inventory); i++) {

            ItemStack itemStack = inventory.getStackInSlot(i);

            if(itemStack != null && itemStack.stackSize > 0) {
                float dX = rand.nextFloat() * 0.8F + 0.1F;
                float dY = rand.nextFloat() * 0.8F + 0.1F;
                float dZ = rand.nextFloat() * 0.8F + 0.1F;

                EntityItem entityItem = new EntityItem(world, x + dX, y + dY, z + dZ, new ItemStack(itemStack.getItem(), itemStack.stackSize, itemStack.getItemDamage()));

                if(itemStack.hasTagCompound()) {
                    entityItem.getEntityItem().setTagCompound((NBTTagCompound)itemStack.getTagCompound().copy());
                }

                float factor = 0.05F;
                entityItem.motionX = rand.nextGaussian() * factor;
                entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                entityItem.motionZ = rand.nextGaussian() * factor;
                world.spawnEntityInWorld(entityItem);
                itemStack.stackSize = 0;
            }
        }
    }

    protected int getInventoryDropStartSlot(IInventory inventory){
        return 0;
    }

    protected int getInventoryDropEndSlot(IInventory inventory){
        return inventory.getSizeInventory();
    }
}
