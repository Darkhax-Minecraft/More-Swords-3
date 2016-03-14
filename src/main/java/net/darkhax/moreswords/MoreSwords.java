package net.darkhax.moreswords;

import java.util.Arrays;

import net.darkhax.moreswords.common.CommonProxy;
import net.darkhax.moreswords.enchantment.Enchantments;
import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.handler.MobHandler;
import net.darkhax.moreswords.handler.RecipeHandler;
import net.darkhax.moreswords.item.SwordItems;
import net.darkhax.moreswords.util.Constants;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Constants.ID, name = Constants.NAME, version = Constants.VERSION, guiFactory = Constants.FACTORY)
public class MoreSwords {
    
    @SidedProxy(clientSide = Constants.CLIENT_PROXY, serverSide = Constants.SERVER_PROXY)
    public static CommonProxy proxy;
    
    @Mod.Instance(Constants.ID)
    public static MoreSwords instance;
    
    @EventHandler
    public void preInit (FMLPreInitializationEvent pre) {
        
        new ConfigurationHandler(pre.getSuggestedConfigurationFile());
        new SwordItems();
        new Enchantments();
        new RecipeHandler();
        MinecraftForge.EVENT_BUS.register(new MobHandler());
        proxy.registerRenders();
    }
}