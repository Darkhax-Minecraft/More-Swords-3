package net.darkhax.moreswords.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.darkhax.moreswords.CreativeTabMoreSwords;
import net.darkhax.moreswords.util.Utils.RandomUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraftforge.common.util.EnumHelper;

public class Constants {

    public static final String ID = "MSM3";
    public static final String NAME = "More Swords 3";
    public static final String VERSION = "3.0.0";
    public static final String SERVER_PROXY = "net.darkhax.moreswords.proxy.CommonProxy";
    public static final String CLIENT_PROXY = "net.darkhax.moreswords.proxy.ClientProxy";
    public static final String FACTORY = "net.darkhax.moreswords.gui.MoreSwordsGuiFactory";
    public static final String TEXTURE_DOMAIN = "moreswords:";
    
    public static final CreativeTabs TAB_SWORDS = new CreativeTabMoreSwords();
    public static final EnumEnchantmentType ENCH_TYPE_SWORDS = EnumHelper.addEnchantmentType("moreSword");
    public static final Logger LOGGER = LogManager.getLogger(NAME);
    public static final RandomUtils RND = new Utils.RandomUtils();
}
