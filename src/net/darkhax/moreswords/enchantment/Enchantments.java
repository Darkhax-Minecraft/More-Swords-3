package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.item.Items;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;

public class Enchantments {

	static int basic = 5;
	static int advanced = 1;
	
	public static final Enchantment ignite = new EnchantmentCore(60, basic, "msm.ignite", 1, 3, Items.swordDawmStar);
	public static final Enchantment descent = new EnchantmentCore(61, advanced, "msm.descent", 1, 1, Items.swordDawmStar);
	public static final Enchantment feast = new EnchantmentCore(62, basic, "msm.feast", 1, 3, Items.swordVampiric);
	public static final Enchantment vitality = new EnchantmentCore(63, advanced, "msm.vitality", 1, 1, Items.swordVampiric);
	public static final Enchantment venomAspect = new EnchantmentCore(64, basic, "msm.venomAspect", 1, 3, Items.swordGladiolus);
	public static final Enchantment growth = new EnchantmentCore(65, advanced, "msm.growth", 1, 1, Items.swordGladiolus);
	public static final Enchantment keenEdge = new EnchantmentCore(66, basic, "msm.keenEdge", 1, 3, Items.swordDraconic);
	public static final Enchantment restoration = new EnchantmentCore(67, advanced, "msm.restoration", 1, 1, Items.swordDraconic);
	public static final Enchantment enderPulse = new EnchantmentCore(68, basic, "msm.enderPulse", 1, 3, Items.swordEnder);
	public static final Enchantment enderSlash = new EnchantmentCore(69, advanced, "msm.enderSlash", 1, 1, Items.swordEnder);
	public static final Enchantment greed = new EnchantmentCore(70, basic, "msm.greed", 1, 3, Items.swordCrystal);
	public static final Enchantment wisdom = new EnchantmentCore(71, advanced, "msm.wisdom", 1, 1, Items.swordCrystal);
	public static final Enchantment infinity1 = new EnchantmentCore(72, basic, "msm.infinity1", 1, 3, Items.swordInfinity);
	public static final Enchantment infinity2 = new EnchantmentCore(73, advanced, "msm.infinity2", 1, 1, Items.swordInfinity);
	public static final Enchantment frozenAspect = new EnchantmentCore(74, basic, "msm.frozenAspect", 1, 3, Items.swordGlacial);
	public static final Enchantment glacial2 = new EnchantmentCore(75, advanced, "msm.glacial2", 1, 1, Items.swordGlacial);
	public static final Enchantment ascension = new EnchantmentCore(76, basic, "msm.ascension", 1, 3, Items.swordAether);
	public static final Enchantment aether2 = new EnchantmentCore(77, advanced, "msm.aether2", 1, 1, Items.swordAether);
	public static final Enchantment decay = new EnchantmentCore(78, basic, "msm.decay", 1, 3, Items.swordWither);
	public static final Enchantment wither2 = new EnchantmentCore(79, advanced, "msm.wither2", 1, 1, Items.swordWither);
	public static final Enchantment stealth = new EnchantmentCore(80, basic, "msm.stealth", 1, 3, Items.swordAdmin);
	public static final Enchantment admin1 = new EnchantmentCore(81, advanced, "msm.admin", 1, 1, Items.swordAdmin);
}
