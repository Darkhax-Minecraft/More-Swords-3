package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.item.Items;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;

public class Enchantments {

	static int basic = 15;
	static int advanced = 30;
	
	public static final Enchantment ignite = new EnchantmentCore(60, basic, "msm.ignite", 1, 3, Items.swordDawmStar);
	public static final Enchantment descent = new EnchantmentCore(61, advanced, "msm.descent", 1, 1, Items.swordDawmStar);
}
