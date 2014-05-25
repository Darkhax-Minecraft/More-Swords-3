package net.darkhax.moreswords.util;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

	public static String damage = "Damage Values";
	public static String durability = "Durability Values";
	public static String enchant = "Enchantability Values";
	public static String harvest = "Harvest Levels";
	public static String efficient = "Efficiency Values";
	public static String repair = "Repair Items";
	public static String crafting = "Disable Crafting Recipes";
	public static String enchantsID = "Enchantment ID Values";
	public static String effects = "Enchantment Effects";
	
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
	
	public static int igniteDamage;
	public static boolean igniteBoom;
	public static int sparkDamage;
	public static double sparkRange;
	
	public Config(File configFile) {
		
		Configuration config = new Configuration(configFile);
		config.load();
		
		damageDawnStar = config.get(damage, "Damage Value Of Dawns Star", 100).getInt(); 
		damageVampiric = config.get(damage, "Damage Value Of Vampiric Blade", 100).getInt(); 
		damageGladiolus = config.get(damage, "Damage Value Of Gladiolus", 100).getInt(); 
		damageDraconic = config.get(damage, "Damage Value Of Draconic Blade", 100).getInt(); 
		damageEnder = config.get(damage, "Damage Value Of Eye End Blade", 100).getInt(); 
		damageCrystal = config.get(damage, "Damage Value Of Crystal Blade", 100).getInt(); 
		damageInfinity = config.get(damage, "Damage Value Of Infinity Blade", 100).getInt(); 
		damageGlacial = config.get(damage, "Damage Value Of Glacial Blade", 100).getInt(); 
		damageAether = config.get(damage, "Damage Value Of Aether's Guard", 100).getInt(); 
		damageWither = config.get(damage, "Damage Value Of Withers Bane", 100).getInt(); 
		damageAdmin = config.get(damage, "Damage Value Of Adminium Ark", 100).getInt(); 
		
		durabilityDawnStar = config.get(durability, "Durability Value Of DawnStar", 100).getInt();  
		durabilityVampiric = config.get(durability, "Durability Value Of Vampiric Blade", 100).getInt();  
		durabilityGladiolus = config.get(durability, "Durability Value Of Gladiolus", 100).getInt();  
		durabilityDraconic = config.get(durability, "Durability Value Of Draconic Blade", 100).getInt();  
		durabilityEnder = config.get(durability, "Durability Value Of Eye End Blade", 100).getInt();  
		durabilityCrystal = config.get(durability, "Durability Value Of Crystal Blade", 100).getInt();  
		durabilityInfinity = config.get(durability, "Durability Value Of Infinity Blade", 100).getInt();  
		durabilityGlacial = config.get(durability, "Durability Value Of Glacial Blade", 100).getInt();  
		durabilityAether = config.get(durability, "Durability Value Of Aether's Guard", 100).getInt();  
		durabilityWither = config.get(durability, "Durability Value Of Withers Bane", 100).getInt();  
		durabilityAdmin = config.get(durability, "Durability Value Of Adminium Ark", 100).getInt();  
		
		enchantDawnStar = config.get(enchant, "Enchantability Of DawnStar", 100).getInt();  
		enchantVampiric = config.get(enchant, "Enchantability Of Vampiric Blade", 100).getInt();  
		enchantGladiolus = config.get(enchant, "Enchantability Of Gladiolus", 100).getInt();  
		enchantDraconic = config.get(enchant, "Enchantability Of Draconic Blade", 100).getInt();  
		enchantEnder = config.get(enchant, "Enchantability Of Eye End Blade", 100).getInt();  
		enchantCrystal = config.get(enchant, "Enchantability Of Crystal Blade", 100).getInt();  
		enchantInfinity = config.get(enchant, "Enchantability Of Infinity Blade", 100).getInt();  
		enchantGlacial = config.get(enchant, "Enchantability Of Glacial Blade", 100).getInt();  
		enchantAether = config.get(enchant, "Enchantability Of Aether's Guard", 100).getInt();  
		enchantWither = config.get(enchant, "Enchantability Of Withers Bane", 100).getInt();  
		enchantAdmin = config.get(enchant, "Enchantability Of Adminium Ark", 100).getInt();  
		
		harvestDawnStar = config.get(harvest, "Harvest Level Of DawnStar", 100).getInt();  
		harvestVampiric = config.get(harvest, "Harvest Level Of Vampiric Blade", 100).getInt();  
		harvestGladiolus = config.get(harvest, "Harvest Level Of Gladiolus", 100).getInt();  
		harvestDraconic = config.get(harvest, "Harvest Level Of Draconic Blade", 100).getInt();  
		harvestEnder = config.get(harvest, "Harvest Level Of Eye End Blade", 100).getInt();  
		harvestCrystal = config.get(harvest, "Harvest Level Of Crystal Blade", 100).getInt();  
		harvestInfinity = config.get(harvest, "Harvest Level Of Infinity Blade", 100).getInt();  
		harvestGlacial = config.get(harvest, "Harvest Level Of Glacial Blade", 100).getInt();  
		harvestAether = config.get(harvest, "Harvest Level Of Aether's Guard", 100).getInt();  
		harvestWither = config.get(harvest, "Harvest Level Of Withers Bane", 100).getInt();  
		harvestAdmin = config.get(harvest, "Harvest Level Of Adminium Ark", 100).getInt();  
		
		efficientDawnStar = config.get(efficient, "Efficiency  Of DawnStar", 100).getInt();  
		efficientVampiric = config.get(efficient, "Efficiency  Of Vampiric Blade", 100).getInt();  
		efficientGladiolus = config.get(efficient, "Efficiency  Of Gladiolus", 100).getInt();  
		efficientDraconic = config.get(efficient, "Efficiency  Of Draconic Blade", 100).getInt();  
		efficientEnder = config.get(efficient, "Efficiency  Of Eye End Blade", 100).getInt();  
		efficientCrystal = config.get(efficient, "Efficiency  Of Crystal Blade", 100).getInt();  
		efficientInfinity = config.get(efficient, "Efficiency  Of Infinity Blade", 100).getInt();  
		efficientGlacial = config.get(efficient, "Efficiency  Of Glacial Blade", 100).getInt();  
		efficientAether = config.get(efficient, "Efficiency  Of Aether's Guard", 100).getInt();  
		efficientWither = config.get(efficient, "Efficiency  Of Withers Bane", 100).getInt();  
		efficientAdmin = config.get(efficient, "Efficiency  Of Adminium Ark", 100).getInt();  
		
		repairDawnStar = config.get(repair, "Repair Item For DawnStar", "none").getString();  
		repairVampiric = config.get(repair, "Repair Item For Vampiric Blade", "none").getString();  
		repairGladiolus = config.get(repair, "Repair Item For Gladiolus", "none").getString();  
		repairDraconic = config.get(repair, "Repair Item For Draconic Blade", "none").getString();  
		repairEnder = config.get(repair, "Repair Item For Eye End Blade", "none").getString();  
		repairCrystal = config.get(repair, "Repair Item For Crystal Blade", "none").getString();  
		repairInfinity = config.get(repair, "Repair Item For Infinity Blade", "none").getString();  
		repairGlacial = config.get(repair, "Repair Item For Glacial Blade", "none").getString();  
		repairAether = config.get(repair, "Repair Item For Aether's Guard", "none").getString();  
		repairWither = config.get(repair, "Repair Item For Withers Bane", "none").getString();  
		repairAdmin = config.get(repair, "Repair Item For Adminium Ark", "none").getString();  
		
		craftingDawnStar = config.get(crafting, "Should the  DawnStar Be Craftable?", true).getBoolean(true);  
		craftingVampiric = config.get(crafting, "Should the  Vampiric Blade Be Craftable?", true).getBoolean(true);  
		craftingGladiolus = config.get(crafting, "Should the  Gladiolus Be Craftable?", true).getBoolean(true);  
		craftingDraconic = config.get(crafting, "Should the  Draconic Blade Be Craftable?", true).getBoolean(true);  
		craftingEnder = config.get(crafting, "Should the  Eye End Blade Be Craftable?", true).getBoolean(true);  
		craftingCrystal = config.get(crafting, "Should the  Crystal Blade Be Craftable?", true).getBoolean(true);  
		craftingInfinity = config.get(crafting, "Should the  Infinity Blade Be Craftable?", true).getBoolean(true);  
		craftingGlacial = config.get(crafting, "Should the  Glacial Blade Be Craftable?", true).getBoolean(true);  
		craftingAether = config.get(crafting, "Should the  Aether's Guard Be Craftable?", true).getBoolean(true);  
		craftingWither = config.get(crafting, "Should the  Withers Bane Be Craftable?", true).getBoolean(true);  
		craftingAdmin = config.get(crafting, "Should the  Adminium Ark Be Craftable?", true).getBoolean(true);  
		
		igniteDamage = config.get(effects, "How much base damage the ignite effect has", 2).getInt();
		igniteBoom = config.get(effects, "Should the ignite effect cause creepers to go boom?", true).getBoolean(true);
		sparkDamage = config.get(effects, "How much is the base damage for the Spark enchantment", 3).getInt() ;
		sparkRange = config.get(effects, "How close do mobs have to be to be effected by the spark effect", 3.5).getDouble(3.5d);
		
		config.save();
	}
}