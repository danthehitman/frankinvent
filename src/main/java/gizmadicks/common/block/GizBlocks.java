package gizmadicks.common.block;

import gizmadicks.Gizmadicks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class GizBlocks{

    public static Block gizStationConsole;

    public static void init(){
    	gizStationConsole = new BlockGizStationConsole(Material.ground).setBlockName("gizStationConsole");
        
        registerBlocks();
    }

    private static class HelperBlock extends Block{//helper class, as the constructor of Block is protected.
        public HelperBlock(Material material){
            super(material);
            setCreativeTab(Gizmadicks.tabGizmadicks);
        }
    }

    private static void registerBlocks(){
        registerBlock(gizStationConsole);
    }

    public static void registerBlock(Block block){
        registerBlock(block, ItemBlock.class);
    }

    private static void registerBlock(Block block, Class<? extends ItemBlock> itemBlockClass){
        GameRegistry.registerBlock(block, itemBlockClass, block.getUnlocalizedName().substring("tile.".length()));
    }
}
