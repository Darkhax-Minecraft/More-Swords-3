package net.darkhax.moreswords.enchantment;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.lib.Utils;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class EnchantmentSpark extends EnchantmentCore {

	protected EnchantmentSpark(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

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

					for (int i = 0; i < living.worldObj.loadedEntityList.size(); i++) {

						if (living.worldObj.loadedEntityList.get(i) instanceof EntityLiving) {

							if (Utils.isEntityWithinRange(living, event.entityLiving, 3.5d)) {

								EntityLiving closeEntity = (EntityLiving) living.worldObj.loadedEntityList.get(i);
								closeEntity.setFire(1);
							}
						}
					}
				}
			}
		}
	}
}