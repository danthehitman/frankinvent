package gizmadicks.proxy;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;

public class ClientProxy extends CommonProxy{

    @Override
    public void registerRenders(){
        super.registerRenders();
    }

    @Override
    public void registerHandlers(){
        super.registerHandlers();
    }

    @Override
    public void init(){
    }

    @Override
    public void postInit(){
    }


    @Override
    public void initConfig(Configuration config){

    }

    @Override
    public World getClientWorld(){
        return FMLClientHandler.instance().getClient().theWorld;
    }

    @Override
    public EntityPlayer getPlayer(){
        return FMLClientHandler.instance().getClient().thePlayer;
    }
}
