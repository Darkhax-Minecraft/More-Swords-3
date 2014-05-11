package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.lib.Utils;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentScorn extends EnchantmentCore {

	protected EnchantmentScorn(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

		super(id, weight, unlocalizedName, minLevel, maxLevel, item);
		MinecraftForge.EVENT_BUS.register(this);
	}

	/**
	 * Deals double damage to entities if the player is not in 
	 * the surface world. 
	 */
	@SubscribeEvent
	public void onEntityHit(AttackEntityEvent event) {

		if (isLiving(event.target)) {
			
			if (isValidPlayer(event.entityPlayer)) {
				
				if (event.entityPlayer.dimension != 0) {
				
					ItemStack stack = event.entityPlayer.getHeldItem();
					event.target.attackEntityFrom(DamageSource.generic, (float) (Utils.getItemWeaponDamage(stack) * 2));
				}
			}
		}
	}
}