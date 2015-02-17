package gizmadicks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import gizmadicks.client.CreativeTabGizmadicks;
import gizmadicks.common.block.GizBlocks;
import gizmadicks.common.item.GizItems;
import gizmadicks.lib.Strings;
import gizmadicks.lib.Versions;
import gizmadicks.proxy.CommonProxy;


@Mod(modid = Strings.MOD_ID, name = Strings.MOD_NAME,  guiFactory = "gizmadicks.client.GuiConfigHandler", dependencies = "required-after:Forge@[10.13.2.1254,);")
public class Gizmadicks {
	
	@SidedProxy(clientSide = "gizmadicks.proxy.ClientProxy", serverSide = "gizmadicks.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Instance(Strings.MOD_ID)
    public static Gizmadicks instance;

    public static CreativeTabGizmadicks tabGizmadicks;
    
    @EventHandler
    public void PreInit(FMLPreInitializationEvent event){
        event.getModMetadata().version = Versions.fullVersionString();

        NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
        tabGizmadicks = new CreativeTabGizmadicks("tabPneumaticCraft");
        
        GizBlocks.init();
        GizItems.init();
        
        proxy.registerRenders();
        proxy.registerHandlers();
        
    }

    @EventHandler
    public void load(FMLInitializationEvent event){
        proxy.init();
    }

    @EventHandler
    public void onServerStart(FMLServerStartingEvent event){
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit();
    }
    
}
