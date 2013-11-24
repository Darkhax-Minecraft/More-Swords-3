package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.item.Items;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;

public class Enchantments {

	static int basic = 15;
	static int advanced = 30;
	
	public static final Enchantment ignite = new EnchantmentCore(60, basic, 1, 3, Items.swordDawmStar);
}
