package net.darkhax.moreswords.enchantment;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentAscension extends EnchantmentCore {

	protected EnchantmentAscension(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

		super(id, weight, unlocalizedName, minLevel, maxLevel, item);
		MinecraftForge.EVENT_BUS.register(this);
	}

	/**
	 * The Ascension Enchantment will knock hit entities up into the
	 * air. Motion is 0.45 multiplied by enchantment level. 
	 */
	@SubscribeEvent
	public void onEntityHit(AttackEntityEvent event) {

		if (isLiving(event.target)) {
			
			if (isValidPlayer(event.entityLiving)) {
				
				ItemStack stack = event.entityPlayer.getHeldItem();
				double Y = level(stack) * cfg.ascensionBase;
				event.target.motionY = Y;
			}
		}
	}
}