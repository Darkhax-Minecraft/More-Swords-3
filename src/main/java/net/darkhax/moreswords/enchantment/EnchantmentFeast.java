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

	@SubscribeEvent
	public void onEntityHit(AttackEntityEvent event) {

		if (event.target instanceof EntityLiving) {

			EntityLiving living = (EntityLiving) event.target;

			if (event.entityLiving.getHeldItem() != null) {

				ItemStack stack = event.entityLiving.getHeldItem();
				int enchLevel = EnchantmentHelper.getEnchantmentLevel(this.effectId, stack);

				if (enchLevel > 0) {

					int repair = Reference.RND.nextIntII(0, 3) * enchLevel;

					stack.damageItem(-repair, event.entityLiving);
				}
			}
		}
	}
}