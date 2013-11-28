package net.darkhax.moreswords.lib;

import java.io.File;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.Configuration;

public class Config {

	public Configuration config;
	
	public static String values = "Block/Item ID values";
	
	public static int swordDawnStarID;
	public static int swordVampiricID;
	public static int swordGladiolusID;
	public static int swordDraconicID;
	public static int swordEnderID;
	public static int swordCrystalID;
	public static int swordInfinityID;
	public static int swordGlacialID;
	public static int swordAetherID;
	public static int swordWitherID;
	public static int swordAdminID;
	
	public Config(File configFile) {
		
		config = new Configuration(configFile);
		config.load();
		generateConfig();
		config.save();	
	}
	
	void generateConfig() {
		
		swordDawnStarID = config.get(values, "Dawn Star Item ID", 13400).getInt();
		swordVampiricID = config.get(values, "Vampiric Blade Item ID", 13401).getInt();
		swordGladiolusID = config.get(values, "Gladiolus Item ID", 13402).getInt();
		swordDraconicID = config.get(values, "Draconic Blade Item ID", 13403).getInt();
		swordEnderID = config.get(values, "Eye End Item ID", 13404).getInt();
		swordCrystalID = config.get(values, "Crystal Sword Item ID", 13405).getInt();
		swordInfinityID = config.get(values, "Infinity Sword Item ID", 13406).getInt();
		swordGlacialID = config.get(values, "Glacial Blade Item ID", 13407).getInt();
		swordAetherID = config.get(values, "Aether's Guard Item ID", 13408).getInt();
		swordWitherID = config.get(values, "Wither's Bane Item ID", 13409).getInt();
		swordAdminID = config.get(values, "Adminium Ark Item ID", 13410).getInt();
	}
}