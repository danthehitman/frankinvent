package gizmadicks.common.block;

import gizmadicks.Gizmadicks;
import net.minecraft.block.material.Material;

public abstract class BlockGizmadicksModeled extends BlockGizmadicks{

    protected BlockGizmadicksModeled(Material par2Material){
        super(par2Material);
    }

    @Override
    public int getRenderType(){
        return Gizmadicks.proxy.SPECIAL_RENDER_TYPE_VALUE;
    }

    @Override
    public boolean renderAsNormalBlock(){
        return false;
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }

}
