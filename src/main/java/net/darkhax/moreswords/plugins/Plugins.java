package net.darkhax.moreswords.plugins;

import cpw.mods.fml.common.Loader;

public class Plugins {
	
	public Plugins(Boolean enabled) {
		
		new PluginVersionChecker(true);
	}
}
