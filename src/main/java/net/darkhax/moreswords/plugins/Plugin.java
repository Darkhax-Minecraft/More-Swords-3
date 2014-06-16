package net.darkhax.moreswords.plugins;

import net.darkhax.moreswords.util.Config;
import cpw.mods.fml.common.Loader;

public class Plugin {
	
	Config cfg;
	public Plugin(Boolean enabled) {
		
		if (enabled) {
			
			new PluginVersionChecker(cfg.enabledVersionChecker);
			new PluginEnchantingPlus(cfg.enabledEnchantingPlus);
		}
	}
}
