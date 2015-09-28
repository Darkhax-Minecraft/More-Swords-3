package net.darkhax.moreswords.util;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.darkhax.moreswords.CreativeTabMoreSwords;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraftforge.common.util.EnumHelper;

public class Constants {
    
    public static final String ID = "MSM3";
    public static final String NAME = "More Swords 3";
    public static final String VERSION = "3.0.0";
    public static final String SERVER_PROXY = "net.darkhax.moreswords.common.CommonProxy";
    public static final String CLIENT_PROXY = "net.darkhax.moreswords.client.ClientProxy";
    public static final String FACTORY = "net.darkhax.moreswords.client.gui.GuiFactoryMoreSwords";
    public static final String TEXTURE_DOMAIN = "moreswords:";
    
    public static final CreativeTabs TAB_SWORDS = new CreativeTabMoreSwords();
    public static final EnumEnchantmentType ENCH_TYPE_SWORDS = EnumHelper.addEnchantmentType("moreSword");
    public static final Logger LOGGER = LogManager.getLogger(NAME);
    public static final Random RND = new Random();
}
