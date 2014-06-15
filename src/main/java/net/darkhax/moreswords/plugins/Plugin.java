package net.darkhax.moreswords.plugins;

import cpw.mods.fml.common.Loader;

public class Plugin {
	
	public Plugin(Boolean enabled) {
		
		new PluginVersionChecker(true);
		new PluginEnchantingPlus(true);
	}
}
