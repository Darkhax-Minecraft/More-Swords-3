package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.util.Config;
import net.darkhax.moreswords.util.Utils;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentSpark extends EnchantmentCore {

	protected EnchantmentSpark(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

		super(id, weight, unlocalizedName, minLevel, maxLevel, item);
		MinecraftForge.EVENT_BUS.register(this);
	}

	/**
	 * Sets mobs that are 2.4 blocks away on fire for 3 ticks. 
	 */
	@SubscribeEvent
	public void onEntityHit(AttackEntityEvent event) {

		if (isLiving(event.target)) {
			
			if (isValidPlayer(event.entityPlayer)) {
				
				EntityLiving living = (EntityLiving) event.target;
				for (int i = 0; i < living.worldObj.loadedEntityList.size(); i++) {
					
					if (living.worldObj.loadedEntityList.get(i) != living) {
						
						if (living.worldObj.loadedEntityList.get(i) instanceof EntityLiving) {

							if (Utils.isEntityWithinRange(living, (EntityLiving) living.worldObj.loadedEntityList.get(i), cfg.sparkRange)) {

								EntityLiving closeEntity = (EntityLiving) living.worldObj.loadedEntityList.get(i);
								closeEntity.setFire(cfg.sparkDamage);
							}
						}
					}
				}
			}
		}
	}
}