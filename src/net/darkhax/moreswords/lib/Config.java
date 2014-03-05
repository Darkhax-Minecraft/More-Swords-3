package net.darkhax.moreswords.lib;

import java.io.File;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.Configuration;

public class Config {

	public static Configuration config;

	public Config(Configuration configFile) {

		config = configFile;
	}

	public static String values = "Block/Item ID values";
	public static String enchants = "Enchantment ID Values";

	// Item Values
	public static int swordDawnStarID = config.get(values, "Dawn Star Item ID", 13400).getInt();
	public static int swordVampiricID = config.get(values, "Vampiric Blade Item ID", 13401).getInt();
	public static int swordGladiolusID = config.get(values, "Gladiolus Item ID", 13402).getInt();
	public static int swordDraconicID = config.get(values, "Draconic Blade Item ID", 13403).getInt();
	public static int swordEnderID = config.get(values, "Eye End Item ID", 13404).getInt();
	public static int swordCrystalID = config.get(values, "Crystal sword Item ID", 13405).getInt();
	public static int swordInfinityID = config.get(values, "Infinity sword Item ID", 13406).getInt();
	public static int swordGlacialID = config.get(values, "Glacial Blade Item ID", 13407).getInt();
	public static int swordAetherID = config.get(values, "Aether's Guard Item ID", 13408).getInt();
	public static int swordWitherID = config.get(values, "Wither's Bane Item ID", 13409).getInt();
	public static int swordAdminID = config.get(values, "Adminium Ark Item ID", 13410).getInt();

}