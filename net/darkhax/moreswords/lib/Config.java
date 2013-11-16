package net.darkhax.moreswords.lib;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.Configuration;

public class Config {

	public Configuration config;
	
	public Config(FMLPreInitializationEvent event) {
		
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		generateConfig();
		config.save();	
	}
	
	void generateConfig() {
		
	}
}