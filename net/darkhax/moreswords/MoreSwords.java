package net.darkhax.moreswords;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = "", name = "", version = "")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MoreSwords {
	
	@Mod.Instance("")
	public static MoreSwords instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent pre) {
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent init) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent post) {
		
	}
}