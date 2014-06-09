package net.darkhax.moreswords.enchantment;

import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentDecay extends EnchantmentCore {

	protected EnchantmentDecay(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

		super(id, weight, unlocalizedName, minLevel, maxLevel, item);
		MinecraftForge.EVENT_BUS.register(this);
	}

	/**
	 * Gives target wither damage for 75 ticks
	 */
	@SubscribeEvent
	public void onEntityHit(AttackEntityEvent event) {

		if (isLiving(event.target)) {
			
			if (isValidPlayer(event.entityLiving)) {
				
				ItemStack stack = event.entityPlayer.getHeldItem();
				((EntityLiving) event.target).addPotionEffect(new PotionEffect(Potion.wither.id, cfg.decayTime * level(stack), cfg.decayLevel));
			}
		}
	}
}