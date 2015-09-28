package net.darkhax.moreswords.gui;

import java.util.ArrayList;
import java.util.List;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.util.Constants;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

public class MoreSwordsConfigGui extends GuiConfig {

    static Configuration cfg = ConfigurationHandler.config;
    static ConfigurationHandler cfgh;

    public MoreSwordsConfigGui(GuiScreen parent) {

        super(parent, generateConfigList(), Constants.ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.config.toString()));
    }

    public static List<IConfigElement> generateConfigList() {

        ArrayList<IConfigElement> elements = new ArrayList<IConfigElement>();
        String[] categories = { cfgh.general, cfgh.damage, cfgh.durability, cfgh.enchant, cfgh.harvest, cfgh.efficient, cfgh.repair, cfgh.crafting, cfgh.monster, cfgh.plugins, cfgh.ignite, cfgh.spark, cfgh.feast, cfgh.vitality, cfgh.venom, cfgh.absorb, cfgh.keenEdge, cfgh.scorn, cfgh.enderPulse, cfgh.enderAura, cfgh.greed, cfgh.wisdom, cfgh.frozen, cfgh.frost, cfgh.ascension, cfgh.ascension, cfgh.descension, cfgh.shadows, cfgh.decay, cfgh.stealth, cfgh.extinction };

        for (int i = 0; i < categories.length; i++) {

            elements.add(new ConfigElement(cfg.getCategory(categories[i])));
            System.out.println(categories[i]);
        }

        return elements;
    }
}
