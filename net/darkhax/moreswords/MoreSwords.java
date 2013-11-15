package net.darkhax.moreswords;

import net.darkhax.moreswords.lib.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MoreSwords {
	
	@Mod.Instance(Reference.MOD_ID)
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