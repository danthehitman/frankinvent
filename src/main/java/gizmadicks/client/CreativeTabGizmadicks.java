package gizmadicks.client;

import gizmadicks.common.item.GizItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class CreativeTabGizmadicks extends CreativeTabs{

    public CreativeTabGizmadicks(String par2Str){
        super(par2Str);
    }

    @Override
    public Item getTabIconItem(){
        return GizItems.GizPad;
    }

}
