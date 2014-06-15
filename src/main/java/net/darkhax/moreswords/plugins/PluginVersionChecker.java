package net.darkhax.moreswords.plugins;

import cpw.mods.fml.common.event.FMLInterModComms;
import net.darkhax.moreswords.util.Reference;

/**
 * Adds support for Dynious's Version Checker mod. Support will only be
 * added if the Version Checker mod is installed. Support can be turned off
 * in the config file. To find out more information about the Version Checker 
 * mod visit http://www.minecraftforum.net/topic/2721902-
 */
public class PluginVersionChecker {

	String versionLink = "http://dl.dropboxusercontent.com/u/38575752/files/versions/MSM3%20Version%20Info.txt";
	
	public PluginVersionChecker(Boolean enabled) {
		
		if (enabled)
			FMLInterModComms.sendRuntimeMessage(Reference.MOD_ID, "VersionChecker", "addVersionCheck", versionLink);
	}
}
