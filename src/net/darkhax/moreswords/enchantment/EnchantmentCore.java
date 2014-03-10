package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.MoreSwords;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class EnchantmentCore extends Enchantment {

	int maxLevel;
	int minLevel;
	Item item;

	/**
	 * @param id: ID for the enchantment being added.
	 * @param weight: How often the enchantment shows up.
	 * @param unlocalizedName: Name for the enchantment. (unlocalized)
	 * @param minLevel: The lowest possible level of enchantment.
	 * @param maxLevel: The highest possible level of enchantment.
	 * @param item: item that can get this enchantment. Books added by default.
	 */
	protected EnchantmentCore(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

		super(id, weight, MoreSwords.enumSwords);
		this.name = "msm." + unlocalizedName;
		this.minLevel = minLevel;
		this.maxLevel = maxLevel;
		this.item = item;
	}

	public int getMinLevel() {

		return this.minLevel;
	}

	public int getMaxLevel() {

		return this.maxLevel;
	}

	public boolean canApplyAtEnchantingTable(ItemStack stack) {

		if (stack.getItem() == this.item | stack.getItem() == Items.book) {

			return true;
		}

		else
			return false;
	}

	public boolean canApply(ItemStack stack) {

		if (stack.getItem() instanceof ItemSword
				| stack.getItem() == Items.book) {

			return true;
		}

		else
			return false;
	}

	public int getMinEnchantability(int par1) {

		return 10 + 20 * (par1 - 1);
	}

	public int getMaxEnchantability(int par1) {

		return super.getMinEnchantability(par1) + 50;
	}
}