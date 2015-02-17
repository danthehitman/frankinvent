package gizmadicks.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.relauncher.Side;


public class CommonProxy implements IGuiHandler{
	
	public int SPECIAL_RENDER_TYPE_VALUE;

    public void initConfig(Configuration config){}

    public World getClientWorld(){
        return null;
    }

    public EntityPlayer getPlayer(){
        return null;
    }

    public Side getSide(){
        return FMLCommonHandler.instance().getEffectiveSide();
    }

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public void registerRenders() {		
	}

	public void registerHandlers() {	
	}

	public void postInit() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}
}
