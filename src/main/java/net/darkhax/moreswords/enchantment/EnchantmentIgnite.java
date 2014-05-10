package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.lib.Config;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
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

	@SubscribeEvent
	public void onEntityHit(AttackEntityEvent event) {

		if (event.target instanceof EntityLiving) {

			EntityLiving living = (EntityLiving) event.target;

			if (event.entityLiving.getHeldItem() != null) {

				ItemStack stack = event.entityLiving.getHeldItem();
				int enchLevel = EnchantmentHelper.getEnchantmentLevel(this.effectId, stack);

				if (enchLevel > 0) {

					living.setFire(Config.igniteDamage * enchLevel);

					if (living instanceof EntityCreeper && Config.igniteBoom) {

						EntityCreeper creeper = (EntityCreeper) living;
						creeper.getDataWatcher().updateObject(18, Byte.valueOf((byte) 1));
					}
				}
			}
		}
	}
}