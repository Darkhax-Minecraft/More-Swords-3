package net.darkhax.moreswords.enchantment;

import java.util.List;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentExtinction extends EnchantmentCore {

	protected EnchantmentExtinction(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

		super(id, weight, unlocalizedName, minLevel, maxLevel, item);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onEntityHit(AttackEntityEvent event) {

		if (isValidPlayer(event.entityPlayer)) {

			ItemStack stack = event.entityLiving.getHeldItem();

			for (Entity entity : (List<Entity>) event.entityPlayer.worldObj.loadedEntityList) {

				if (!entity.getClass().equals(event.entityPlayer.getClass())) {

					if (entity.getClass().equals(event.target.getClass())) {

						entity.setDead();
					}
				}
			}
		}
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {

		return cfg.extinctionVanilla;
	}

	@Override
	public boolean isAllowedOnBooks() {

		return cfg.extinctionVanilla;
	}

	@Override
	public boolean canApply(ItemStack stack) {

		return cfg.extinctionVanilla;
	}

	@Override
	public boolean canApplyTogether(Enchantment par1Enchantment) {

		return cfg.extinctionVanilla;
	}
}