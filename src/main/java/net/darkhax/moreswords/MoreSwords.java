package net.darkhax.moreswords;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import net.darkhax.bookshelf.lib.LoggingHelper;
import net.darkhax.bookshelf.registry.RegistryHelper;
import net.darkhax.moreswords.awakening.AwakenAdmin;
import net.darkhax.moreswords.awakening.AwakenAether;
import net.darkhax.moreswords.awakening.AwakenCrystal;
import net.darkhax.moreswords.awakening.AwakenDawnStar;
import net.darkhax.moreswords.awakening.AwakenDraconic;
import net.darkhax.moreswords.awakening.AwakenEnder;
import net.darkhax.moreswords.awakening.AwakenGlacial;
import net.darkhax.moreswords.awakening.AwakenGladiolus;
import net.darkhax.moreswords.awakening.AwakenVampiric;
import net.darkhax.moreswords.awakening.AwakenWither;
import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.handler.EffectHandler;
import net.darkhax.moreswords.items.ItemBrokenSword;
import net.darkhax.moreswords.items.ItemInertSword;
import net.darkhax.moreswords.items.ItemSwordBase;
import net.darkhax.moreswords.materials.Quality;
import net.darkhax.moreswords.materials.Speed;
import net.darkhax.moreswords.materials.SwordMaterial;
import net.darkhax.moreswords.tabs.CreativeTabMoreSwords;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.event.entity.living.LivingSpawnEvent.SpecialSpawn;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLFingerprintViolationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "moreswords", name = "More Swords", version = "@VERSION@", dependencies = "required-after:bookshelf@[2.1.450,)", certificateFingerprint = "@FINGERPRINT@")
public class MoreSwords {

    public static final LoggingHelper LOG = new LoggingHelper("More Swords");
    public static final ConfigurationHandler config = new ConfigurationHandler(new File("config/moreswords.cfg"));
    public static final CreativeTabs TAB = new CreativeTabMoreSwords();
    public static final RegistryHelper REGISTRY = new RegistryHelper("moreswords").setTab(TAB);

    public static final Map<String, SwordMaterial> MATERIALS = new LinkedHashMap<>();

    public static final SwordMaterial DAWNSTAR = new SwordMaterial("dawnstar", Quality.UNCOMMON, 666, 6f, new ItemStack(Items.MAGMA_CREAM), Speed.FAST, new AwakenDawnStar());
    public static final SwordMaterial VAMPIRIC = new SwordMaterial("vampiric", Quality.RARE, 1300, 7f, new ItemStack(Blocks.OBSIDIAN), Speed.NORMAL, new AwakenVampiric());
    public static final SwordMaterial GLADIOLUS = new SwordMaterial("gladiolus", Quality.BASIC, 415, 6f, new ItemStack(Blocks.RED_FLOWER, 1, 1), Speed.FAST, new AwakenGladiolus());
    public static final SwordMaterial DRACONIC = new SwordMaterial("draconic", Quality.RARE, 1080, 7f, new ItemStack(Items.DIAMOND), Speed.NORMAL, new AwakenDraconic());
    public static final SwordMaterial ENDER = new SwordMaterial("ender", Quality.EPIC, 1580, 8f, new ItemStack(Items.ENDER_EYE), Speed.NORMAL, new AwakenEnder());
    public static final SwordMaterial CRYSTAL = new SwordMaterial("crystaline", Quality.BASIC, 570, 5f, new ItemStack(Items.QUARTZ), Speed.FAST, new AwakenCrystal());
    public static final SwordMaterial GLACIAL = new SwordMaterial("glacial", Quality.UNCOMMON, 800, 6f, new ItemStack(Blocks.ICE), Speed.FAST, new AwakenGlacial());
    public static final SwordMaterial AETHER = new SwordMaterial("aether", Quality.EPIC, 1777, 8f, new ItemStack(Blocks.GLOWSTONE), Speed.SLOW, new AwakenAether());
    public static final SwordMaterial WITHER = new SwordMaterial("wither", Quality.EPIC, 1666, 8f, new ItemStack(Blocks.SOUL_SAND), Speed.SLOW, new AwakenWither());
    public static final SwordMaterial ADMIN = new SwordMaterial("admin", Quality.EPIC, Integer.MAX_VALUE, Float.MAX_VALUE, new ItemStack(Blocks.BEDROCK), Speed.FAST, new AwakenAdmin());

    @EventHandler
    public void onPreInit (FMLPreInitializationEvent event) {

    	MinecraftForge.EVENT_BUS.register(new EffectHandler());
        MinecraftForge.EVENT_BUS.register(this);

        final Item inertSword = REGISTRY.registerItem(new ItemInertSword(), "inert");
        final Item borkenSword = REGISTRY.registerItem(new ItemBrokenSword(), "broken");
        int meta = 0;

        for (final SwordMaterial material : MATERIALS.values()) {

            material.setMeta(meta);
            material.setAwakenedItem(REGISTRY.registerItem(new ItemSwordBase(material), "sword_" + material.getName()));
            material.setInertItem(new ItemStack(inertSword, 1, meta));
            material.setBrokenItem(new ItemStack(borkenSword, 1, meta));
            meta++;
        }

        config.syncConfigData();
    }

    @SubscribeEvent
    public void onLivingSpawn (SpecialSpawn event) {

        event.getEntity().setCustomNameTag("Spawned");
    }

    @SubscribeEvent
    public void onItemRegistry (Register<Item> event) {

        for (final Item item : REGISTRY.getItems()) {

            event.getRegistry().register(item);
        }
    }

    @SubscribeEvent
    public void onModelRegistry (ModelRegistryEvent event) {

        for (final Item item : REGISTRY.getItems()) {

            REGISTRY.registerInventoryModel(item);
        }
    }

    @EventHandler
    public void onFingerprintViolation (FMLFingerprintViolationEvent event) {

        LOG.warn("Invalid fingerprint detected! The file " + event.getSource().getName() + " may have been tampered with. This version will NOT be supported by the author!");
    }
}