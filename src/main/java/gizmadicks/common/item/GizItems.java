package gizmadicks.common.item;

import cpw.mods.fml.common.registry.GameRegistry;
import gizmadicks.lib.Strings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBucket;
import net.minecraftforge.oredict.OreDictionary;

public class GizItems{

    public static Item GizPad;

    public static void init(){
    	GizPad = new ItemGizPad().setUnlocalizedName("gizPad");
        registerItems();
}

    private static void registerItems(){
        registerItem(GizPad);
    }

    public static void registerItem(Item item){
        registerItem(item, item.getUnlocalizedName().substring("item.".length()));
    }

    public static void registerItem(Item item, String registerName){
        GameRegistry.registerItem(item, registerName, Strings.MOD_ID);
    }
}
