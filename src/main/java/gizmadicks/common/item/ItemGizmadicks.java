package gizmadicks.common.item;

import gizmadicks.Gizmadicks;
import gizmadicks.lib.Textures;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemGizmadicks extends Item{
    private boolean hasTexture;

    public ItemGizmadicks(){
        setCreativeTab(Gizmadicks.tabGizmadicks);
    }

    public ItemGizmadicks(String textureLocation){
        this();
        setTextureName(Textures.ICON_LOCATION + textureLocation);
        setUnlocalizedName(textureLocation);
    }

    @Override
    public Item setTextureName(String p_111206_1_){
        super.setTextureName(p_111206_1_);
        hasTexture = true;
        return this;
    }

    @Override
    public void registerIcons(IIconRegister par1IconRegister){
        if(hasTexture) super.registerIcons(par1IconRegister);
    }
}
