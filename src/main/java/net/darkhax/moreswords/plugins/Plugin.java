package net.darkhax.moreswords.plugins;

import net.darkhax.moreswords.handler.ConfigurationHandler;

public class Plugin {

    ConfigurationHandler cfg;

    public Plugin(Boolean enabled) {

        if (enabled) {

            new PluginVersionChecker(cfg.enabledVersionChecker);
            // new PluginTinkersConstruct(true);
            // new PluginEnchantingPlus(cfg.enabledEnchantingPlus);
        }
    }
}
