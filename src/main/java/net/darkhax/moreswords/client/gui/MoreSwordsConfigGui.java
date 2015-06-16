package net.darkhax.moreswords.client.gui;

import java.util.ArrayList;
import java.util.List;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.util.Constants;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;

public class MoreSwordsConfigGui extends GuiConfig {
    
    static Configuration cfg = ConfigurationHandler.config;
    static ConfigurationHandler cfgh;
    
    public MoreSwordsConfigGui(GuiScreen parent) {
    
        super(parent, generateConfigList(), Constants.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.config.toString()));
    }
    
    public static List<IConfigElement> generateConfigList () {
    
        ArrayList<IConfigElement> elements = new ArrayList<IConfigElement>();
        
        for (String name : cfg.getCategoryNames())
            elements.add(new ConfigElement(cfg.getCategory(name)));
        
        return elements;
    }
}
