package net.darkhax.moreswords.enchantment;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentFeast extends EnchantmentBase {

	protected EnchantmentFeast(int id, int weight, String unlocalizedName,
			int minLevel, int maxLevel, Item item) {

		super(id, weight, unlocalizedName, minLevel, maxLevel, item);
		MinecraftForge.EVENT_BUS.register(this);
	}

	/**
	 * The feast enchantment will repair damage equal to 0-3 per level on the
	 * sword.
	 */
	@SubscribeEvent
	public void onEntityHit(AttackEntityEvent event) {

		if (isLiving(event.entityLiving)) {

			if (isValidPlayer(event.entityPlayer)) {

				ItemStack stack = event.entityPlayer.getHeldItem();
				int repair = rnd.nextIntII(cfg.feastMin, cfg.feastMax)
						* level(stack);
				stack.damageItem(-repair, event.entityLiving);
			}
		}
	}
}