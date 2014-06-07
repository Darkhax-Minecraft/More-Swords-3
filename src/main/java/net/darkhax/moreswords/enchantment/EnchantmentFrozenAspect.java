package net.darkhax.moreswords.enchantment;

import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentFrozenAspect extends EnchantmentCore {

	protected EnchantmentFrozenAspect(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

		super(id, weight, unlocalizedName, minLevel, maxLevel, item);
		MinecraftForge.EVENT_BUS.register(this);
	}

	/**
	 * Slows down the mob for three second * ench level. The strength is equal to ench level.
	 */
	@SubscribeEvent
	public void onEntityHit(AttackEntityEvent event) {

		if (isLiving(event.target)) {
			
			if (isValidPlayer(event.entityLiving)) {
				
				ItemStack stack = event.entityPlayer.getHeldItem();
				((EntityLiving) event.target).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, cfg.frozenTime * level(stack), cfg.frozenLevel * level(stack)));
			}
		}
	}
}