package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.util.Utils;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentFrostWave extends EnchantmentCore {

	protected EnchantmentFrostWave(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

		super(id, weight, unlocalizedName, minLevel, maxLevel, item);
		MinecraftForge.EVENT_BUS.register(this);
	}

	/**
	 * Slows mobs down that are within 2.5 blocks of the target mob.
	 */
	@SubscribeEvent
	public void onEntityHit(AttackEntityEvent event) {

		if (isLiving(event.target)) {

			if (isValidPlayer(event.entityPlayer)) {

				EntityLiving living = (EntityLiving) event.target;
				for (int i = 0; i < living.worldObj.loadedEntityList.size(); i++) {

					if (living.worldObj.loadedEntityList.get(i) != living) {

						if (living.worldObj.loadedEntityList.get(i) instanceof EntityLiving) {

							if (Utils.isEntityWithinRange(living, (EntityLiving) living.worldObj.loadedEntityList.get(i), cfg.frostRange)) {

								EntityLiving closeEntity = (EntityLiving) living.worldObj.loadedEntityList.get(i);
								closeEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, cfg.frostTime, cfg.frostLevel));
							}
						}
					}
				}
			}
		}
	}
}