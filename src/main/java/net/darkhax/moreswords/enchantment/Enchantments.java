package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.item.SwordItems;
import net.darkhax.moreswords.util.Config;
import net.minecraft.enchantment.Enchantment;

public class Enchantments {

	static int basic = 5;
	static int advanced = 1;
	static Config cfg;
	
	public static final Enchantment ignite = new EnchantmentIgnite(cfg.igniteID, basic, "ignite", 1, 3, SwordItems.swordDawmStar);
	public static final Enchantment spark = new EnchantmentSpark(cfg.sparkID, advanced, "spark", 1, 1, SwordItems.swordDawmStar);
	public static final Enchantment feast = new EnchantmentFeast(cfg.feastID, basic, "feast", 1, 3, SwordItems.swordVampiric);
	public static final Enchantment vitality = new EnchantmentVitality(cfg.vitalityID, advanced, "vitality", 1, 1, SwordItems.swordVampiric);
	public static final Enchantment venomAspect = new EnchantmentVenomousAspect(cfg.venomID, basic, "venomAspect", 1, 3, SwordItems.swordGladiolus);
	public static final Enchantment absorb = new EnchantmentAbsorb(cfg.absorbID, advanced, "absorb", 1, 1, SwordItems.swordGladiolus);
	public static final Enchantment keenEdge = new EnchantmentKeenEdge(cfg.keenEdgeID, basic, "keenEdge", 1, 3, SwordItems.swordDraconic);
	public static final Enchantment scorn = new EnchantmentScorn(cfg.scornID, advanced, "scorn", 1, 1, SwordItems.swordDraconic);
	public static final Enchantment enderPulse = new EnchantmentEnderPulse(cfg.enderPulseID, basic, "enderPulse", 1, 3, SwordItems.swordEnder);
	public static final Enchantment enderAura = new EnchantmentEnderAura(cfg.enderAuraID, advanced, "enderAura", 1, 1, SwordItems.swordEnder);
	public static final Enchantment greed = new EnchantmentGreed(cfg.greedID, basic, "greed", 1, 3, SwordItems.swordCrystal);
	public static final Enchantment wisdom = new EnchantmentWisdom(cfg.wisdomID, advanced, "wisdom", 1, 1, SwordItems.swordCrystal);
	public static final Enchantment frozenAspect = new EnchantmentFrozenAspect(cfg.frozenID, basic, "frozenAspect", 1, 3, SwordItems.swordGlacial);
	public static final Enchantment frostWave = new EnchantmentFrostWave(cfg.frostID, advanced, "frostWave", 1, 1, SwordItems.swordGlacial);
	public static final Enchantment ascension = new EnchantmentAscension(cfg.ascensionID, basic, "ascension", 1, 3, SwordItems.swordAether);
	public static final Enchantment descension = new EnchantmentDescension(cfg.descensionID, advanced, "descension", 1, 1, SwordItems.swordAether);
	public static final Enchantment decay = new EnchantmentCore(188, basic, "decay", 1, 3, SwordItems.swordWither);
	public static final Enchantment wither2 = new EnchantmentCore(189, advanced, "wither2", 1, 1, SwordItems.swordWither);
	public static final Enchantment stealth = new EnchantmentCore(190, basic, "stealth", 1, 3, SwordItems.swordAdmin);
	public static final Enchantment admin1 = new EnchantmentCore(191, advanced, "admin", 1, 1, SwordItems.swordAdmin);
}
