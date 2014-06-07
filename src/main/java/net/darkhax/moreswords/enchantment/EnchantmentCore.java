package net.darkhax.moreswords.enchantment;

import java.util.Random;

import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.util.Config;
import net.darkhax.moreswords.util.RandomUtils;
import net.darkhax.moreswords.util.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class EnchantmentCore extends Enchantment {

	public static Config cfg;
	protected Random rand = new Random();;
	protected  RandomUtils rnd = Reference.RND;
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

		if (stack.getItem() instanceof ItemSword | stack.getItem() == Items.book) {

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
	
	/**
	 * Checks to see if the entity is an instance of EntityLiving
	 * @param entity: The entity being checked. 
	 */
	public boolean isLiving(Entity entity) {
		
		if (entity instanceof EntityLiving) {
			
			return true;
		}
		
		return false;
	}
	
	/**
	 * Checks to see if a player is valid. This is done by seeing if 
	 * they are an instance of EntityPlayer, currently holding an item
	 * and if that item has the current enchantment or not. 
	 * @param entity: The entity being checked. 
	 */
	public boolean isValidPlayer(Entity entity) {
		
		if (entity instanceof EntityPlayer) {
			
			if (((EntityPlayer) entity).getHeldItem() != null) {
				
				if (level(((EntityPlayer) entity).getHeldItem()) > 0) {
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Returns the current level of this enchantment on the item. 
	 * @param stack: ItemStack being checked. 
	 */
	public int level(ItemStack stack) {
		
		return EnchantmentHelper.getEnchantmentLevel(this.effectId, stack);
	}
}