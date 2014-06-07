package net.darkhax.moreswords.enchantment;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentIgnite extends EnchantmentCore {

	protected EnchantmentIgnite(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

		super(id, weight, unlocalizedName, minLevel, maxLevel, item);
		MinecraftForge.EVENT_BUS.register(this);
	}

	/**
	 * The ignite enchantment will do fire damage to a mob
	 * equal to that of the effect. If the mob is a creeper
	 * he will explode. 
	 */
	@SubscribeEvent
	public void onEntityHit(AttackEntityEvent event) {

		if (isLiving(event.target)) {
			
			if (isValidPlayer(event.entityPlayer)) {
				
				ItemStack stack = event.entityLiving.getHeldItem();
				event.target.setFire(cfg.igniteDamage * level(stack));

				if (event.target instanceof EntityCreeper && cfg.igniteBoom) {

					EntityCreeper creeper = (EntityCreeper) event.target;
					creeper.getDataWatcher().updateObject(18, Byte.valueOf((byte) 1));
				}
			}
		}
	}
}