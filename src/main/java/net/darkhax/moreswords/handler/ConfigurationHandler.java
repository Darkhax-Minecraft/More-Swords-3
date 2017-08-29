package net.darkhax.moreswords.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {

    public static Configuration config;

    public ConfigurationHandler (File configFile) {

        config = new Configuration(configFile);
        config.load();
        this.syncConfigData();
    }

    public void syncConfigData () {

        if (config.hasChanged()) {
            config.save();
        }
    }
}