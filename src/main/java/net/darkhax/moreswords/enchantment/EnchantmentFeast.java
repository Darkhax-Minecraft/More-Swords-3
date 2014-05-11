package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.lib.Reference;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentFeast extends EnchantmentCore {

	protected EnchantmentFeast(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

		super(id, weight, unlocalizedName, minLevel, maxLevel, item);
		MinecraftForge.EVENT_BUS.register(this);
	}

	/**
	 * The feast enchantment will repair damage equal to
	 * 0-3 per level on the sword. 
	 */
	@SubscribeEvent
	public void onEntityHit(AttackEntityEvent event) {

		if (isLiving(event.entityPlayer)) {
			
			if (isValidPlayer(event.entityPlayer)) {
				
				ItemStack stack = event.entityPlayer.getHeldItem();
				int repair = Reference.RND.nextIntII(0, 3) * level(stack);
				stack.damageItem(-repair, event.entityLiving);
			}
		}	
	}
}