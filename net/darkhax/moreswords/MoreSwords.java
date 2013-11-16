package net.darkhax.moreswords;

import java.util.Arrays;

import net.darkhax.moreswords.core.proxy.CommonProxy;
import net.darkhax.moreswords.lib.Config;
import net.darkhax.moreswords.lib.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MoreSwords {
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Mod.Instance(Reference.MOD_ID)
	public static MoreSwords instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent pre) {
		
		setModInfo(pre.getModMetadata());
		new Config(pre);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent init) {
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent post) {
		
	}
	
	void setModInfo(ModMetadata meta) {
		
		meta.authorList = Arrays.asList(new String[] {"Darkhax"});
		meta.logoFile = "";
		meta.credits = "Maintained by Darkhax";
		meta.description = "More Swords provides a magnificent chain of lustrous new swords that expound upon the foundation of Minecraft weaponry. Razor sharp swords of magic as well as stronger, more practical blaes!";
		meta.url = "http://darkhax.net";
		meta.autogenerated = false;
	}
}