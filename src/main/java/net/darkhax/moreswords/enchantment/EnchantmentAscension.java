package net.darkhax.moreswords.enchantment;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
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

	@SubscribeEvent
	public void onEntityHit(AttackEntityEvent event) {

		if (isLiving(event.target)) {
			
			if (isValidPlayer(event.entityLiving)) {
				
				ItemStack stack = event.entityPlayer.getHeldItem();
				double Y = EnchantmentHelper.getEnchantmentLevel(Enchantments.ascension.effectId, stack) * 1;
				event.target.setVelocity(0, Y, 0);
			}
		}
	}
}