package net.darkhax.moreswords.handler;

import java.io.File;

import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.util.Constants;
import net.darkhax.moreswords.util.SwordType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler {
    
    public static Configuration config;
    
    public ConfigurationHandler(File configFile) {
    
        config = new Configuration(configFile);
        FMLCommonHandler.instance().bus().register(this);
        syncConfigData();
    }
    
    @SubscribeEvent
    public void onConfigChange (ConfigChangedEvent.OnConfigChangedEvent event) {
    
        if (event.modID.equals(Constants.MOD_ID))
            syncConfigData();
    }
    
    private void syncConfigData () {
    
        itemsCraftable = config.get(general, "Should all swords be craftable?", true).getBoolean(true);
        itemsRepairable = config.get(general, "Should all swords be repairable?", true).getBoolean(true);
        privateEnchant = config.get(general, "Should enchantments be restricted to the sword of their theme?", true).getBoolean(true);
        enabledEnchant = config.get(general, "Should enchantments be enabled in the game?", true).getBoolean(true);
        enabledSpawning = config.get(general, "Should mobs (zombie, skeleton, pig man) spawn holding these swords?", true).getBoolean(true);
        enabledPlugins = config.get(general, "Should the plugins for this mod be loaded?", true).getBoolean(true);
        
        zombieSwords = config.get(monster, "Should zombies spawn holding swords from this mod?", true).getBoolean(true);
        skeletonSwords = config.get(monster, "Should skeletons spawn holding swords from this mod?", true).getBoolean(true);
        pigSwords = config.get(monster, "Should pig zombies spawn holding swords from this mod?", true).getBoolean(true);
        zombieChance = config.get(monster, "How often should zombies spawn holding swords?", 0.04).getDouble(0.04);
        skeletonChance = config.get(monster, "How often should skeletons spawn holding swords?", 0.04).getDouble(0.04);
        pigChance = config.get(monster, "How often should pig zombies spawn holding swords?", 0.04).getDouble(0.04);
        
        enabledVersionChecker = config.get(plugins, "Should the Version Checker plugin be loaded?", true).getBoolean(true);
        enabledEnchantingPlus = config.get(plugins, "Should the Enchanting Plus plugin be loaded?", true).getBoolean(true);
        enableTinkersConstruct = config.get(plugins, "Should the Tinkers Construct plugin be loaded?", true).getBoolean(true);
        initialIDRange = config.get(plugins, "The initial id range for tinkers construct tool materials", 1337, "This is the intial id for tool materials, you likely won't need to change this, however if another mod uses ids within this range, then tool parts may not be shown. Please check your console if you suspect that this may be the case, warning messages will be printed. This value has no theoretical limit, however increasing this value may cause certain features of tinkers construct, or your game, to decrease in performance.").getInt();
        /*
         *
    public ItemStack swordRepairItem;
    public int swordColor;
    public boolean isCraftable;
         */
        for (SwordType type : MoreSwords.swordTypes.values()) {
            
            String name = type.swordName;
            type.setSwordDamage(config.getInt("damage_" + name, "damage", type.getSwordDamage(), 0, Integer.MAX_VALUE, "The weapon damage for the " + name + " sword"));
            type.setSwordDurability(config.getInt("durability_" + name, "durability", type.getSwordDurability(), 0, Integer.MAX_VALUE, "The weapon durability for the " + name + " sword"));
            type.setSwordEnchantability(config.getInt("enchantability_" + name, "enchantability", type.getSwordEnchantability(), 0, Integer.MAX_VALUE, "The enchantability for the " + name + " sword"));
            type.setSwordHarvestLevel(config.getInt("harvest_" + name, "harvest", type.getSwordHarvestLevel(), 0, Integer.MAX_VALUE, "The harvest level for the " + name + " sword"));
            type.setSwordEfficiency(config.getInt("efficiency_" + name, "efficiency", type.getSwordEfficiency(), 0, Integer.MAX_VALUE, "The efficiency for the " + name + " sword"));
            type.setSwordRepairItem(config.getString("repair_" + name, "repair", type.getSwordRepairItem(), "The String based item id for the repair material for the " + name + " sword"));
            type.setSwordColor(config.getInt("color_" + name, "color", type.getSwordColor(), 0, Integer.MAX_VALUE, "The color associated with the " + name + " sword"));
            type.setCraftable(config.getBoolean("craftable_" + name, "craftable", type.isCraftable(), "Should the " + name  + " sword be craftable?"));
        }
        
        igniteEnabled = config.get(ignite, "Should the Ignite enchantment be available?", true).getBoolean(true);
        igniteID = config.get(ignite, "Enchantment ID for Ignite", 130).getInt();
        igniteDamage = config.get(ignite, "How much base damage the ignite effect has", 2).getInt();
        igniteBoom = config.get(ignite, "Should the ignite effect cause creepers to go boom?", true).getBoolean(true);
        
        sparkEnabled = config.get(spark, "Should the Spark enchantment be available?", true).getBoolean(true);
        sparkID = config.get(ignite, "Enchantment ID for Spark", 131).getInt();
        sparkDamage = config.get(spark, "How much is the base damage for the Spark enchantment", 3).getInt();
        sparkRange = config.get(spark, "How close do mobs have to be to be effected by the spark effect", 2.4).getDouble(3.5d);
        
        feastEnabled = config.get(feast, "Should the Feast enchantment be available?", true).getBoolean(true);
        feastID = config.get(feast, "Enchantment ID for Feast", 132).getInt();
        feastMin = config.get(feast, "What is the minimum amount of durability that should be restored per level?", 0).getInt();
        feastMax = config.get(feast, "What is the maximum amount of durability that should be restored per kevel?", 3).getInt();
        
        vitalityEnabled = config.get(vitality, "Should the Vitality enchantment be available?", true).getBoolean(true);
        vitalityID = config.get(vitality, "Enchantment ID for Vitality", 133).getInt();
        vitalityDamage = config.get(vitality, "How much damage should the Vitality enchantment do to the item?", 256).getInt();
        vitalityRegenTime = config.get(vitality, "How long should the regen effect last per level?", 60).getInt();
        vitalityRegenLevel = config.get(vitality, "What level of regen should be applied?", 0).getInt();
        vitalityHeartsTime = config.get(vitality, "How long should the extra hearts last per level?", 60).getInt();
        vitalityHeartsLevel = config.get(vitality, "What level of the hearts should be applied?", 1).getInt();
        vitalityHealTime = config.get(vitality, "How long should the heal effect last", 1).getInt();
        vitalityHealLevel = config.get(vitality, "What level of heal effect should be applied?", 0).getInt();
        
        venomEnabled = config.get(venom, "Should the Venom enchantment be available?", true).getBoolean(true);
        venomID = config.get(venom, "Enchantment ID for Venom Aspect", 134).getInt();
        venomTime = config.get(venom, "How long should the venom last per level?", 20).getInt();
        venomLevel = config.get(venom, "What level of poison should be applied?", 1).getInt();
        
        absorbEnabled = config.get(absorb, "Should the Absorb Enchantment be available?", true).getBoolean(true);
        absorbID = config.get(absorb, "Enchantment ID for Absorb", 135).getInt();
        absorbChance = config.get(absorb, "The percent chance this effect will trigger", 0.05).getDouble(0.05);
        absorbSaturation = config.get(absorb, "The multiplier for the saturation given", 0.4).getDouble(0.4);
        absorbMin = config.get(absorb, "Minimum food restored", 0).getInt();
        absorbMax = config.get(absorb, "Maximum food restored", 2).getInt();
        
        keenEdgeEnabled = config.get(keenEdge, "Should the Keen Edge Enchantment be available?", true).getBoolean(true);
        keenEdgeID = config.get(keenEdge, "Enchantment ID for Keen Edge", 136).getInt();
        
        scornEnabled = config.get(scorn, "Should the Scorn Enchantment be available?", true).getBoolean(true);
        scornID = config.get(scorn, "Enchantment ID for Scorn", 137).getInt();
        scornMultiplier = config.get(scorn, "Scorn damage multiplier", 2).getInt();
        
        enderPulseEnabled = config.get(enderPulse, "Should the Ender Pulse Enchantment be available?", true).getBoolean(true);
        enderPulseID = config.get(enderPulse, "Enchantment ID for Ender Pulse", 138).getInt();
        enderPulseFallDamage = config.get(enderPulse, "How much fall damage should be given?", 1).getInt();
        enderPulseItemDamage = config.get(enderPulse, "How much damage should be done to the item?", 50).getInt();
        enderPulseRange = config.get(enderPulse, "How much range per level?", 18).getInt();
        
        enderAuraEnabled = config.get(enderAura, "Should the Ender Aura Enchantment be available?", true).getBoolean(true);
        enderAuraID = config.get(enderAura, "Enchantment ID for Ender Aura", 139).getInt();
        enderAuraChance = config.get(enderAura, "How often should this effect activate", 0.15).getDouble(0.15);
        enderAuraRange = config.get(enderAura, "What should the range for this effect be?", 32).getInt();
        
        greedEnabled = config.get(greed, "Should the Greed Enchantment be available?", true).getBoolean(true);
        greedID = config.get(greed, "Enchantment ID for Greed", 140).getInt();
        greedChance = config.get(greed, "How often should the bonus be given?", 0.07).getDouble(0.07);
        greedMin = config.get(greed, "Minimum amount of exp given by the effect", 1).getInt();
        greedMax = config.get(greed, "Maximum amount of exp given by the effect", 3).getInt();
        
        wisdomEnabled = config.get(wisdom, "Should the wisdom Enchantment be available?", true).getBoolean(true);
        wisdomID = config.get(wisdom, "Enchantment ID for Wisdom", 141).getInt();
        wisdomChance = config.get(wisdom, "How often should the exp be multiplied?", 0.15).getDouble(0.15);
        wisdomMultiplier = config.get(wisdom, "How many times should the wisdom effect multiply dropped exp?", 2).getInt();
        
        frozenEnabled = config.get(frozen, "Should the Frozen Enchantment be available?", true).getBoolean(true);
        frozenID = config.get(frozen, "Enchantment ID for Frozen", 142).getInt();
        frozenTime = config.get(frozen, "How long the effect should last, per level", 60).getInt();
        frozenLevel = config.get(frozen, "What level of this effect should be applied per level", 1).getInt();
        
        frostEnabled = config.get(frost, "Should the Frost Wave Enchantment be available?", true).getBoolean(true);
        frostID = config.get(frost, "Enchantment ID for FrostWave", 143).getInt();
        frostRange = config.get(frost, "How many blocks should the effect reach?", 2.5).getDouble(2.5);
        frostTime = config.get(frost, "How long will the effect last?", 30).getInt();
        frostLevel = config.get(frost, "What level will the effect be?", 1).getInt();
        
        ascensionEnabled = config.get(ascension, "Should the Ascension Enchantment be available?", true).getBoolean(true);
        ascensionID = config.get(ascension, "Enchantment ID for Ascension", 144).getInt();
        ascensionBase = config.get(ascension, "What is the base distance for this effect?", 0.45).getDouble(0.45);
        
        descensionEnabled = config.get(descension, "Should the Descension Enchantment be available?", true).getBoolean(true);
        descensionID = config.get(descension, "Enchantment ID for Descension", 145).getInt();
        descensionFloat = config.get(descension, "How much resistance should the effect give the player", 0.6).getDouble(0.6);
        descensionFall = config.get(descension, "How much fall distance should be applied", 0).getDouble(0);
        descensionShift = config.get(descension, "Should the effect only work when shifting?", true).getBoolean(true);
        
        shadowsEnabled = config.get(shadows, "Should the Shadows Enchantment be available?", true).getBoolean(true);
        shadowsID = config.get(shadows, "Enchantment ID for Shadows", 146).getInt();
        shadowsTime = config.get(shadows, "How long should blindness last per level?", 30).getInt();
        shadowsLevel = config.get(shadows, "What level of the effect should be applied per effect level?", 1).getInt();
        shadowsWitherChance = config.get(shadows, "How often shout the witther effect be applied?", 0.12).getDouble(0.12);
        shadowsWitherTime = config.get(shadows, "How long should the wither effect last per level", 20).getInt();
        shadowsWitherLevel = config.get(shadows, "What level of wither effect should be applied?", 20).getInt();
        
        decayEnabled = config.get(decay, "Should the Decay Enchantment be available?", true).getBoolean(true);
        decayID = config.get(decay, "Enchantment ID for Decay", 147).getInt();
        decayTime = config.get(decay, "How long should the effect last per level", 75).getInt();
        decayLevel = config.get(decay, "What level of wither should be applied", 1).getInt();
        
        stealthEnabled = config.get(stealth, "Should the Stealth Enchantment be available?", true).getBoolean(true);
        stealthID = config.get(stealth, "Enchantment ID for Stealth", 148).getInt();
        stealthVanilla = config.get(stealth, "Should this effect be available in vanilla?", false).getBoolean(false);
        
        extinctionEnabled = config.get(extinction, "Should the Extinction Enchantment be available?", true).getBoolean(true);
        extinctionID = config.get(extinction, "Enchantment ID for Extinction", 149).getInt();
        extinctionVanilla = config.get(extinction, "Should this effect be available in vanilla?", false).getBoolean(false);
        config.save();
    }
    
    public static String general = "general settings";
    public static boolean itemsCraftable;
    public static boolean itemsRepairable;
    public static boolean privateEnchant;
    public static boolean enabledEnchant;
    public static boolean enabledSpawning;
    public static boolean enabledPlugins;
    
    public static String monster = "monster settings";
    public static boolean zombieSwords;
    public static boolean skeletonSwords;
    public static boolean pigSwords;
    public static double zombieChance;
    public static double skeletonChance;
    public static double pigChance;
    
    public static String plugins = "plugins";
    public static boolean enabledVersionChecker;
    public static boolean enabledEnchantingPlus;
    public static boolean enableTinkersConstruct;
    public static int initialIDRange;
    
    public static String ignite = "enchantment: ignite";
    public static boolean igniteEnabled;
    public static int igniteID;
    public static int igniteDamage;
    public static boolean igniteBoom;
    
    public static String spark = "enchantment: spark";
    public static boolean sparkEnabled;
    public static int sparkID;
    public static int sparkDamage;
    public static double sparkRange;
    
    public static String feast = "enchantment: feast";
    public static boolean feastEnabled;
    public static int feastID;
    public static int feastMin;
    public static int feastMax;
    
    public static String vitality = "enchantment: vitiality";
    public static boolean vitalityEnabled;
    public static int vitalityID;
    public static int vitalityDamage;
    public static int vitalityRegenTime;
    public static int vitalityRegenLevel;
    public static int vitalityHeartsTime;
    public static int vitalityHeartsLevel;
    public static int vitalityHealTime;
    public static int vitalityHealLevel;
    
    public static String venom = "enchantment: venom";
    public static boolean venomEnabled;
    public static int venomID;
    public static int venomTime;
    public static int venomLevel;
    
    public static String absorb = "enchantment: absorb";
    public static boolean absorbEnabled;
    public static int absorbID;
    public static double absorbChance;
    public static double absorbSaturation;
    public static int absorbMin;
    public static int absorbMax;
    
    public static String keenEdge = "enchantment: keen edge";
    public static boolean keenEdgeEnabled;
    public static int keenEdgeID;
    
    public static String scorn = "enchantment: scorn";
    public static boolean scornEnabled;
    public static int scornID;
    public static int scornMultiplier;
    
    public static String enderPulse = "enchantment: ender pulse";
    public static boolean enderPulseEnabled;
    public static int enderPulseID;
    public static int enderPulseFallDamage;
    public static int enderPulseItemDamage;
    public static int enderPulseRange;
    
    public static String enderAura = "enchantment: ender aura";
    public static boolean enderAuraEnabled;
    public static int enderAuraID;
    public static double enderAuraChance;
    public static int enderAuraRange;
    
    public static String greed = "enchantment: greed";
    public static boolean greedEnabled;
    public static int greedID;
    public static double greedChance;
    public static int greedMin;
    public static int greedMax;
    
    public static String wisdom = "enchantent: wisdom";
    public static boolean wisdomEnabled;
    public static int wisdomID;
    public static double wisdomChance;
    public static int wisdomMultiplier;
    
    public static String frozen = "enchantment: frozen";
    public static boolean frozenEnabled;
    public static int frozenID;
    public static int frozenTime;
    public static int frozenLevel;
    
    public static String frost = "enchantment: frost wave";
    public static boolean frostEnabled;
    public static int frostID;
    public static double frostRange;
    public static int frostTime;
    public static int frostLevel;
    
    public static String ascension = "enchantment: ascension";
    public static boolean ascensionEnabled;
    public static int ascensionID;
    public static double ascensionBase;
    
    public static String descension = "enchantment: descension";
    public static boolean descensionEnabled;
    public static int descensionID;
    public static double descensionFloat;
    public static double descensionFall;
    public static boolean descensionShift;
    
    public static String shadows = "enchatment: consuming shadows";
    public static boolean shadowsEnabled;
    public static int shadowsID;
    public static int shadowsTime;
    public static int shadowsLevel;
    public static double shadowsWitherChance;
    public static double shadowsWitherTime;
    public static int shadowsWitherLevel;
    
    public static String decay = "enchantment: decay";
    public static boolean decayEnabled;
    public static int decayID;
    public static int decayTime;
    public static int decayLevel;
    
    public static String stealth = "enchantment: stealth";
    public static boolean stealthEnabled;
    public static int stealthID;
    public static boolean stealthVanilla;
    
    public static String extinction = "enchantment: extinction";
    public static boolean extinctionEnabled;
    public static int extinctionID;
    public static boolean extinctionVanilla;
}