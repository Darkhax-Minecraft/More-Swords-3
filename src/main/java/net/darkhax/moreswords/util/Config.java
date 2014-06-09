package net.darkhax.moreswords.util;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {
	
	public static int damageDawnStar;
	public static int damageVampiric;
	public static int damageGladiolus;
	public static int damageDraconic;
	public static int damageEnder;
	public static int damageCrystal;
	public static int damageInfinity;
	public static int damageGlacial;
	public static int damageAether;
	public static int damageWither;
	public static int damageAdmin;
	
	public static int durabilityDawnStar;
	public static int durabilityVampiric;
	public static int durabilityGladiolus;
	public static int durabilityDraconic;
	public static int durabilityEnder;
	public static int durabilityCrystal;
	public static int durabilityInfinity;
	public static int durabilityGlacial;
	public static int durabilityAether;
	public static int durabilityWither;
	public static int durabilityAdmin;
	
	public static int enchantDawnStar;
	public static int enchantVampiric;
	public static int enchantGladiolus;
	public static int enchantDraconic;
	public static int enchantEnder;
	public static int enchantCrystal;
	public static int enchantInfinity;
	public static int enchantGlacial;
	public static int enchantAether;
	public static int enchantWither;
	public static int enchantAdmin;
	
	public static int harvestDawnStar;
	public static int harvestVampiric;
	public static int harvestGladiolus;
	public static int harvestDraconic;
	public static int harvestEnder;
	public static int harvestCrystal;
	public static int harvestInfinity;
	public static int harvestGlacial;
	public static int harvestAether;
	public static int harvestWither;
	public static int harvestAdmin;
	
	public static int efficientDawnStar;
	public static int efficientVampiric;
	public static int efficientGladiolus;
	public static int efficientDraconic;
	public static int efficientEnder;
	public static int efficientCrystal;
	public static int efficientInfinity;
	public static int efficientGlacial;
	public static int efficientAether;
	public static int efficientWither;
	public static int efficientAdmin;
	
	public static String repairDawnStar;
	public static String repairVampiric;
	public static String repairGladiolus;
	public static String repairDraconic;
	public static String repairEnder;
	public static String repairCrystal;
	public static String repairInfinity;
	public static String repairGlacial;
	public static String repairAether;
	public static String repairWither;
	public static String repairAdmin;
	
	public static boolean craftingDawnStar;
	public static boolean craftingVampiric;
	public static boolean craftingGladiolus;
	public static boolean craftingDraconic;
	public static boolean craftingEnder;
	public static boolean craftingCrystal;
	public static boolean craftingInfinity;
	public static boolean craftingGlacial;
	public static boolean craftingAether;
	public static boolean craftingWither;
	public static boolean craftingAdmin;
	
	public static boolean igniteEnabled;
	public static int igniteID;
	public static int igniteDamage;
	public static boolean igniteBoom;
	
	public static boolean sparkEnabled;
	public static int sparkID;
	public static int sparkDamage;
	public static double sparkRange;
	
	public static boolean feastEnabled;
	public static int feastID;
	public static int feastMin;
	public static int feastMax;
	
	public static boolean vitalityEnabled;
	public static int vitalityID;
	public static int vitalityDamage;
	public static int vitalityRegenTime;
	public static int vitalityRegenLevel;
	public static int vitalityHeartsTime;
	public static int vitalityHeartsLevel;
	public static int vitalityHealTime;
	public static int vitalityHealLevel;
	
	public static boolean venomEnabled;
	public static int venomID;
	public static int venomTime;
	public static int venomLevel;
	
	public static boolean absorbEnabled;
	public static int absorbID;
	public static double absorbChance;
	public static double absorbSaturation;
	public static int absorbMin;
	public static int absorbMax;
	
	public static boolean keenEdgeEnabled;
	public static int keenEdgeID;
	
	public static boolean scornEnabled;
	public static int scornID;
	public static int scornMultiplier;
	
	public static boolean enderPulseEnabled;
	public static int enderPulseID;
	public static int enderPulseFallDamage;
	public static int enderPulseItemDamage;
	public static int enderPulseRange;
	
	public static boolean enderAuraEnabled;
	public static int enderAuraID;
	public static double enderAuraChance;
	public static int enderAuraRange;
	
	public static boolean greedEnabled;
	public static int greedID;
	public static double greedChance;
	public static int greedMin;
	public static int greedMax;
	
	public static boolean wisdomEnabled;
	public static int wisdomID;
	public static double wisdomChance;
	public static int wisdomMultiplier;
	
	public static boolean frozenEnabled;
	public static int frozenID;
	public static int frozenTime;
	public static int frozenLevel;

	public static boolean frostEnabled;
	public static int frostID;
	public static double frostRange;
	public static int frostTime;
	public static int frostLevel;
	
	public static boolean ascensionEnabled;
	public static int ascensionID;
	public static double ascensionBase;
	
	public static boolean descensionEnabled;
	public static int descensionID;
	public static double descensionFloat;
	public static double descensionFall;
	public static boolean descensionShift;
	
	public static boolean shadowsEnabled;
	public static int shadowsID;
	public static int shadowsTime;
	public static int shadowsLevel;
	public static double shadowsWitherChance;
	public static double shadowsWitherTime;
	public static int shadowsWitherLevel;
	
	public static boolean decayEnabled;
	public static int decayID;
	public static int decayTime;
	public static int decayLevel;
	
	public static boolean stealthEnabled;
	public static int stealthID;
	public static boolean stealthVanilla;
	
	public static boolean extinctionEnabled;
	public static int extinctionID;
	public static boolean extinctionVanilla;
	
	public Config(File configFile) {
		
		Configuration config = new Configuration(configFile);
		config.load();
		
		String damage = "Damage Values";
		damageDawnStar = config.get(damage, "Damage Value Of Dawns Star", 7).getInt(); 
		damageVampiric = config.get(damage, "Damage Value Of Vampiric Blade", 7).getInt(); 
		damageGladiolus = config.get(damage, "Damage Value Of Gladiolus", 6).getInt(); 
		damageDraconic = config.get(damage, "Damage Value Of Draconic Blade", 7).getInt(); 
		damageEnder = config.get(damage, "Damage Value Of Eye End Blade", 8).getInt(); 
		damageCrystal = config.get(damage, "Damage Value Of Crystal Blade", 5).getInt(); 
		damageGlacial = config.get(damage, "Damage Value Of Glacial Blade", 6).getInt(); 
		damageAether = config.get(damage, "Damage Value Of Aether's Guard", 8).getInt(); 
		damageWither = config.get(damage, "Damage Value Of Withers Bane", 8).getInt(); 
		damageAdmin = config.get(damage, "Damage Value Of Adminium Ark", 99999).getInt(); 
		
		String durability = "Durability Values";
		durabilityDawnStar = config.get(durability, "Durability Value Of DawnStar", 1286).getInt();  
		durabilityVampiric = config.get(durability, "Durability Value Of Vampiric Blade", 100).getInt();  
		durabilityGladiolus = config.get(durability, "Durability Value Of Gladiolus", 645).getInt();  
		durabilityDraconic = config.get(durability, "Durability Value Of Draconic Blade", 1080).getInt();  
		durabilityEnder = config.get(durability, "Durability Value Of Eye End Blade", 1580).getInt();  
		durabilityCrystal = config.get(durability, "Durability Value Of Crystal Blade", 570).getInt();   
		durabilityGlacial = config.get(durability, "Durability Value Of Glacial Blade", 680).getInt();  
		durabilityAether = config.get(durability, "Durability Value Of Aether's Guard", 1796).getInt();  
		durabilityWither = config.get(durability, "Durability Value Of Withers Bane", 1869).getInt();  
		durabilityAdmin = config.get(durability, "Durability Value Of Adminium Ark", 9999999).getInt();  
		
		String enchant = "Enchantability Values";
		enchantDawnStar = config.get(enchant, "Enchantability Of DawnStar", 12).getInt();  
		enchantVampiric = config.get(enchant, "Enchantability Of Vampiric Blade", 12).getInt();  
		enchantGladiolus = config.get(enchant, "Enchantability Of Gladiolus", 16).getInt();  
		enchantDraconic = config.get(enchant, "Enchantability Of Draconic Blade", 12).getInt();  
		enchantEnder = config.get(enchant, "Enchantability Of Eye End Blade", 18).getInt();  
		enchantCrystal = config.get(enchant, "Enchantability Of Crystal Blade", 7).getInt();
		enchantGlacial = config.get(enchant, "Enchantability Of Glacial Blade", 16).getInt();  
		enchantAether = config.get(enchant, "Enchantability Of Aether's Guard", 18).getInt();  
		enchantWither = config.get(enchant, "Enchantability Of Withers Bane", 18).getInt();  
		enchantAdmin = config.get(enchant, "Enchantability Of Adminium Ark", 999).getInt();  
		
		String harvest = "Harvest Values";
		harvestDawnStar = config.get(harvest, "Harvest Level Of DawnStar", 3).getInt();  
		harvestVampiric = config.get(harvest, "Harvest Level Of Vampiric Blade", 3).getInt();  
		harvestGladiolus = config.get(harvest, "Harvest Level Of Gladiolus", 2).getInt();  
		harvestDraconic = config.get(harvest, "Harvest Level Of Draconic Blade", 3).getInt();  
		harvestEnder = config.get(harvest, "Harvest Level Of Eye End Blade", 4).getInt();  
		harvestCrystal = config.get(harvest, "Harvest Level Of Crystal Blade", 1).getInt();    
		harvestGlacial = config.get(harvest, "Harvest Level Of Glacial Blade", 2).getInt();  
		harvestAether = config.get(harvest, "Harvest Level Of Aether's Guard", 4).getInt();  
		harvestWither = config.get(harvest, "Harvest Level Of Withers Bane", 4).getInt();  
		harvestAdmin = config.get(harvest, "Harvest Level Of Adminium Ark", 999).getInt();  
		
		String efficient = "Efficiency Values";
		efficientDawnStar = config.get(efficient, "Efficiency  Of DawnStar", 8).getInt();  
		efficientVampiric = config.get(efficient, "Efficiency  Of Vampiric Blade", 8).getInt();  
		efficientGladiolus = config.get(efficient, "Efficiency  Of Gladiolus", 6).getInt();  
		efficientDraconic = config.get(efficient, "Efficiency  Of Draconic Blade", 8).getInt();  
		efficientEnder = config.get(efficient, "Efficiency  Of Eye End Blade", 9).getInt();  
		efficientCrystal = config.get(efficient, "Efficiency  Of Crystal Blade", 4).getInt();  
		efficientGlacial = config.get(efficient, "Efficiency  Of Glacial Blade", 6).getInt();  
		efficientAether = config.get(efficient, "Efficiency  Of Aether's Guard", 9).getInt();  
		efficientWither = config.get(efficient, "Efficiency  Of Withers Bane", 9).getInt();  
		efficientAdmin = config.get(efficient, "Efficiency  Of Adminium Ark", 999).getInt();  

		String repair = "Repair Items";
		repairDawnStar = config.get(repair, "Repair Item For DawnStar", "blaze_rod").getString();  
		repairVampiric = config.get(repair, "Repair Item For Vampiric Blade", "redstone").getString();  
		repairGladiolus = config.get(repair, "Repair Item For Gladiolus", "vine").getString();  
		repairDraconic = config.get(repair, "Repair Item For Draconic Blade", "diamond").getString();  
		repairEnder = config.get(repair, "Repair Item For Eye End Blade", "ender_eye").getString();  
		repairCrystal = config.get(repair, "Repair Item For Crystal Blade", "quartz").getString();  
		repairGlacial = config.get(repair, "Repair Item For Glacial Blade", "packed_ice").getString();  
		repairAether = config.get(repair, "Repair Item For Aether's Guard", "glowstone").getString();  
		repairWither = config.get(repair, "Repair Item For Withers Bane", "soul_sand").getString();  
		repairAdmin = config.get(repair, "Repair Item For Adminium Ark", "bedrock").getString();  
		
		String crafting = "Crafting Options";
		craftingDawnStar = config.get(crafting, "Should the  DawnStar Be Craftable?", true).getBoolean(true);  
		craftingVampiric = config.get(crafting, "Should the  Vampiric Blade Be Craftable?", true).getBoolean(true);  
		craftingGladiolus = config.get(crafting, "Should the  Gladiolus Be Craftable?", true).getBoolean(true);  
		craftingDraconic = config.get(crafting, "Should the  Draconic Blade Be Craftable?", true).getBoolean(true);  
		craftingEnder = config.get(crafting, "Should the  Eye End Blade Be Craftable?", true).getBoolean(true);  
		craftingCrystal = config.get(crafting, "Should the  Crystal Blade Be Craftable?", true).getBoolean(true);  
		craftingGlacial = config.get(crafting, "Should the  Glacial Blade Be Craftable?", true).getBoolean(true);  
		craftingAether = config.get(crafting, "Should the  Aether's Guard Be Craftable?", true).getBoolean(true);  
		craftingWither = config.get(crafting, "Should the  Withers Bane Be Craftable?", true).getBoolean(true);  
		craftingAdmin = config.get(crafting, "Should the  Adminium Ark Be Craftable?", true).getBoolean(true);  
		
		String ignite = "Enchantment: Ignite";
		igniteEnabled = config.get(ignite, "Should the Ignite enchantment be available?", true).getBoolean(true);
		igniteID = config.get(ignite, "Enchantment ID for Ignite", 130).getInt();
		igniteDamage = config.get(ignite, "How much base damage the ignite effect has", 2).getInt();
		igniteBoom = config.get(ignite, "Should the ignite effect cause creepers to go boom?", true).getBoolean(true);
		
		String spark = "Enchantment: Spark";
		sparkEnabled = config.get(spark, "Should the Spark enchantment be available?", true).getBoolean(true);
		sparkID = config.get(ignite, "Enchantment ID for Spark", 131).getInt();
		sparkDamage = config.get(spark, "How much is the base damage for the Spark enchantment", 3).getInt() ;
		sparkRange = config.get(spark, "How close do mobs have to be to be effected by the spark effect", 2.4).getDouble(3.5d);
		
		String feast = "Enchantment: Feast";
		feastEnabled = config.get(feast, "Should the Feast enchantment be available?", true).getBoolean(true);
		feastID = config.get(feast, "Enchantment ID for Feast", 132).getInt();
		feastMin = config.get(feast, "What is the minimum amount of durability that should be restored per level?", 0).getInt();
		feastMax = config.get(feast, "What is the maximum amount of durability that should be restored per kevel?", 3).getInt();
		
		String vitality = "Enchantment: Vitality";
		vitalityEnabled = config.get(vitality, "Should the Vitality enchantment be available?", true).getBoolean(true);
		vitalityID = config.get(vitality, "Enchantment ID for Vitality", 133).getInt();
		vitalityDamage = config.get(vitality, "How much damage should the Vitality enchantment do to the item?", 256).getInt();
		vitalityRegenTime = config.get(vitality, "How long should the regen effect last per level?", 60).getInt();
		vitalityRegenLevel = config.get(vitality, "What level of regen should be applied?", 0).getInt();
		vitalityHeartsTime = config.get(vitality, "How long should the extra hearts last per level?", 60).getInt();
		vitalityHeartsLevel = config.get(vitality, "What level of the hearts should be applied?", 1).getInt();
		vitalityHealTime = config.get(vitality, "How long should the heal effect last", 1).getInt();
		vitalityHealLevel = config.get(vitality, "What level of heal effect should be applied?", 0).getInt();
		
		String venom = "Enchantment: Venom Aspect";
		venomEnabled = config.get(venom, "Should the Venom enchantment be available?", true).getBoolean(true);
		venomID = config.get(venom, "Enchantment ID for Venom Aspect", 134).getInt();
		venomTime = config.get(venom, "How long should the venom last per level?", 20).getInt();
		venomLevel = config.get(venom, "What level of poison should be applied?", 1).getInt();
		
		String absorb = "Enchantment: Absorb";
		absorbEnabled = config.get(absorb, "Should the Absorb Enchantment be available?", true).getBoolean(true);
		absorbID = config.get(absorb, "Enchantment ID for Absorb", 135).getInt();
		absorbChance = config.get(absorb, "The percent chance this effect will trigger", 0.05).getDouble(0.05);
		absorbSaturation = config.get(absorb, "The multiplier for the saturation given", 0.4).getDouble(0.4);
		absorbMin = config.get(absorb, "Minimum food restored", 0).getInt();
		absorbMax = config.get(absorb, "Maximum food restored", 2).getInt();
		
		String keenEdge = "Enchantment: Keen Edge";
		keenEdgeEnabled = config.get(keenEdge, "Should the Keen Edge Enchantment be available?", true).getBoolean(true);
		keenEdgeID = config.get(keenEdge, "Enchantment ID for Keen Edge", 136).getInt();
		
		String scorn = "Enchantment: Scorn";
		scornEnabled = config.get(scorn, "Should the Scorn Enchantment be available?", true).getBoolean(true);
		scornID = config.get(scorn, "Enchantment ID for Scorn", 137).getInt();
		scornMultiplier = config.get(scorn, "Scorn damage multiplier", 2).getInt();
		
		String enderPulse = "Enchantment: Ender Pulse";
		enderPulseEnabled = config.get(enderPulse, "Should the Ender Pulse Enchantment be available?", true).getBoolean(true);
		enderPulseID = config.get(enderPulse, "Enchantment ID for Ender Pulse", 138).getInt();
		enderPulseFallDamage = config.get(enderPulse, "How much fall damage should be given?", 1).getInt();
		enderPulseItemDamage = config.get(enderPulse,  "How much damage should be done to the item?", 50).getInt();
		enderPulseRange = config.get(enderPulse, "How much range per level?", 18).getInt();
		
		String enderAura = "Enchantment: Ender Aura";
		enderAuraEnabled = config.get(enderAura, "Should the Ender Aura Enchantment be available?", true).getBoolean(true);
		enderAuraID = config.get(enderAura, "Enchantment ID for Ender Aura", 139).getInt();
		enderAuraChance = config.get(enderAura, "How often should this effect activate", 0.15).getDouble(0.15);
		enderAuraRange = config.get(enderAura, "What should the range for this effect be?", 32).getInt();
		
		String greed = "Enchantment: Greed";
		greedEnabled = config.get(greed, "Should the Greed Enchantment be available?", true).getBoolean(true);
		greedID = config.get(greed, "Enchantment ID for Greed", 140).getInt();
		greedChance = config.get(greed, "How often should the bonus be given?", 0.07).getDouble(0.07);
		greedMin = config.get(greed, "Minimum amount of exp given by the effect", 1).getInt();
		greedMax = config.get(greed, "Maximum amount of exp given by the effect", 3).getInt();
		
		String wisdom = "Enchantment: Wisdom";
		wisdomEnabled = config.get(wisdom, "Should the wisdom Enchantment be available?", true).getBoolean(true);
		wisdomID = config.get(wisdom, "Enchantment ID for Wisdom", 141).getInt();
		wisdomChance = config.get(wisdom, "How often should the exp be multiplied?", 0.15).getDouble(0.15);
		wisdomMultiplier = config.get(wisdom, "How many times should the wisdom effect multiply dropped exp?", 2).getInt();
		
		String frozen = "Enchantment: Frozen";
		frozenEnabled = config.get(frozen, "Should the Frozen Enchantment be available?", true).getBoolean(true);
		frozenID = config.get(frozen, "Enchantment ID for Frozen", 142).getInt();
		frozenTime = config.get(frozen, "How long the effect should last, per level", 60).getInt();
		frozenLevel = config.get(frozen, "What level of this effect should be applied per level", 1).getInt();
		
		String frost = "Enchantment: Frost Wave";
		frostEnabled = config.get(frost, "Should the Frost Wave Enchantment be available?", true).getBoolean(true);
		frostID = config.get(frost, "Enchantment ID for FrostWave", 143).getInt();
		frostRange = config.get(frost, "How many blocks should the effect reach?", 2.5).getDouble(2.5);
		frostTime = config.get(frost, "How long will the effect last?", 30).getInt();
		frostLevel = config.get(frost, "What level will the effect be?", 1).getInt();
		
		String ascension = "Enchantment: Ascension";
		ascensionEnabled = config.get(ascension, "Should the Ascension Enchantment be available?", true).getBoolean(true);
		ascensionID = config.get(ascension, "Enchantment ID for Ascension", 144).getInt();
		ascensionBase = config.get(ascension, "What is the base distance for this effect?", 0.45).getDouble(0.45);
		
		String descension = "Enchantment: Descension";
		descensionEnabled = config.get(descension, "Should the Descension Enchantment be available?", true).getBoolean(true);
		descensionID = config.get(descension, "Enchantment ID for Descension", 145).getInt();
		descensionFloat = config.get(descension, "How much resistance should the effect give the player", 0.6).getDouble(0.6);
		descensionFall = config.get(descension, "How much fall distance should be applied", 0).getDouble(0);
		descensionShift = config.get(descension, "Should the effect only work when shifting?", true).getBoolean(true);
		
		String shadows = "Enchantment: Shadows";
		shadowsEnabled = config.get(shadows, "Should the Shadows Enchantment be available?", true).getBoolean(true);
		shadowsID = config.get(shadows, "Enchantment ID for Shadows", 146).getInt();
		shadowsTime = config.get(shadows, "How long should blindness last per level?", 30).getInt();
		shadowsLevel = config.get(shadows, "What level of the effect should be applied per effect level?", 1).getInt();
		shadowsWitherChance = config.get(shadows, "How often shout the witther effect be applied?",  0.12).getDouble(0.12);
		shadowsWitherTime = config.get(shadows, "How long should the wither effect last per level",  20).getInt();
		shadowsWitherLevel = config.get(shadows, "What level of wither effect should be applied?", 1).getInt();
		
		String decay = "Enchantment: Decay";
		decayEnabled = config.get(decay, "Should the Decay Enchantment be available?", true).getBoolean(true);
		decayID = config.get(decay, "Enchantment ID for Decay", 147).getInt();
		decayTime = config.get(decay, "How long should the effect last per level", 75).getInt();
		decayLevel = config.get(decay, "What level of wither should be applied", 1).getInt();
		
		String stealth = "Enchantment: Stealth";
		stealthEnabled = config.get(stealth, "Should the Stealth Enchantment be available?", true).getBoolean(true);
		stealthID = config.get(stealth, "Enchantment ID for Stealth", 148).getInt();
		stealthVanilla = config.get(stealth, "Should this effect be available in vanilla?", false).getBoolean(false);
		
		String extinction = "Enchantment: Extinction";
		extinctionEnabled = config.get(extinction, "Should the Extinction Enchantment be available?", true).getBoolean(true);
		extinctionID = config.get(extinction, "Enchantment ID for Extinction", 149).getInt();
		extinctionVanilla = config.get(extinction, "Should this effect be available in vanilla?", false).getBoolean(false);
		config.save();
	}
}