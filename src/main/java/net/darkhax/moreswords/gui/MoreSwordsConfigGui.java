package net.darkhax.moreswords.gui;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.util.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.GuiConfig;

public class MoreSwordsConfigGui extends GuiConfig {

	public MoreSwordsConfigGui(GuiScreen parent) {
		
		super(parent, new ConfigElement(ConfigurationHandler.config.getCategory("general settings")).getChildElements(), Reference.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.config.toString()));
	}
}
