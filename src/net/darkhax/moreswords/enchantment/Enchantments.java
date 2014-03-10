package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.item.SwordItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;

public class Enchantments {

	static int basic = 5;
	static int advanced = 1;
	
	public static final Enchantment ignite = new EnchantmentIgnite(170, basic, "ignite", 1, 3, SwordItems.swordDawmStar);
	public static final Enchantment descent = new EnchantmentCore(171, advanced, "descent", 1, 1, SwordItems.swordDawmStar);
	public static final Enchantment feast = new EnchantmentFeast(172, basic, "feast", 1, 3, SwordItems.swordVampiric);
	public static final Enchantment vitality = new EnchantmentCore(173, advanced, "vitality", 1, 1, SwordItems.swordVampiric);
	public static final Enchantment venomAspect = new EnchantmentCore(174, basic, "venomAspect", 1, 3, SwordItems.swordGladiolus);
	public static final Enchantment growth = new EnchantmentCore(175, advanced, "growth", 1, 1, SwordItems.swordGladiolus);
	public static final Enchantment keenEdge = new EnchantmentCore(176, basic, "keenEdge", 1, 3, SwordItems.swordDraconic);
	public static final Enchantment restoration = new EnchantmentCore(177, advanced, "restoration", 1, 1, SwordItems.swordDraconic);
	public static final Enchantment enderPulse = new EnchantmentCore(178, basic, "enderPulse", 1, 3, SwordItems.swordEnder);
	public static final Enchantment enderSlash = new EnchantmentCore(179, advanced, "enderSlash", 1, 1, SwordItems.swordEnder);
	public static final Enchantment greed = new EnchantmentCore(180, basic, "greed", 1, 3, SwordItems.swordCrystal);
	public static final Enchantment wisdom = new EnchantmentCore(181, advanced, "wisdom", 1, 1, SwordItems.swordCrystal);
	public static final Enchantment infinity1 = new EnchantmentCore(182, basic, "infinity1", 1, 3, SwordItems.swordInfinity);
	public static final Enchantment infinity2 = new EnchantmentCore(183, advanced, "infinity2", 1, 1, SwordItems.swordInfinity);
	public static final Enchantment frozenAspect = new EnchantmentCore(184, basic, "frozenAspect", 1, 3, SwordItems.swordGlacial);
	public static final Enchantment glacial2 = new EnchantmentCore(185, advanced, "glacial2", 1, 1, SwordItems.swordGlacial);
	public static final Enchantment ascension = new EnchantmentCore(186, basic, "ascension", 1, 3, SwordItems.swordAether);
	public static final Enchantment aether2 = new EnchantmentCore(187, advanced, "aether2", 1, 1, SwordItems.swordAether);
	public static final Enchantment decay = new EnchantmentCore(188, basic, "decay", 1, 3, SwordItems.swordWither);
	public static final Enchantment wither2 = new EnchantmentCore(189, advanced, "wither2", 1, 1, SwordItems.swordWither);
	public static final Enchantment stealth = new EnchantmentCore(190, basic, "stealth", 1, 3, SwordItems.swordAdmin);
	public static final Enchantment admin1 = new EnchantmentCore(191, advanced, "admin", 1, 1, SwordItems.swordAdmin);
}
