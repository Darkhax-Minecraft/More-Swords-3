package net.darkhax.moreswords;

import java.util.Arrays;

import net.darkhax.moreswords.enchantment.Enchantments;
import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.handler.MobHandler;
import net.darkhax.moreswords.handler.RecipeHandler;
import net.darkhax.moreswords.item.SwordItems;
import net.darkhax.moreswords.plugins.Plugin;
import net.darkhax.moreswords.proxy.CommonProxy;
import net.darkhax.moreswords.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER)
public class MoreSwords {

    public static CreativeTabs tabSwords = new CreativeTabMoreSwords(CreativeTabs.getNextID(), "moreSwords");
    public static EnumEnchantmentType enumSwords = EnumHelper.addEnchantmentType("moreSword");
    ConfigurationHandler cfg;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.Instance(Reference.MOD_ID)
    public static MoreSwords instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent pre) {

        setModInfo(pre.getModMetadata());
        proxy.registerSidedEvents();
        new ConfigurationHandler(pre.getSuggestedConfigurationFile());
        new SwordItems();
        // new SwordBlocks();
        new Enchantments(cfg.enabledEnchant);
        new RecipeHandler(cfg.itemsCraftable);
        new MobHandler(cfg.enabledSpawning);
    }

    @EventHandler
    public void init(FMLInitializationEvent init) {

        new Plugin(cfg.enabledPlugins);
    }

    void setModInfo(ModMetadata meta) {

        meta.authorList = Arrays.asList(new String[] { "Darkhax" });
        meta.logoFile = "";
        meta.credits = "Maintained by Darkhax";
        meta.description = "More Swords provides a magnificent chain of lustrous new swords that expound upon the foundation of Minecraft weaponry. Razor sharp swords of magic as well as stronger, more practical blaes!";
        meta.url = "http://darkhax.net";
        meta.autogenerated = false;
    }
}