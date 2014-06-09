package net.darkhax.moreswords.enchantment;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class EnchantmentDescension extends EnchantmentBase {

	protected EnchantmentDescension(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

		super(id, weight, unlocalizedName, minLevel, maxLevel, item);
		FMLCommonHandler.instance().bus().register(this);
	}

	@SubscribeEvent
	public void onUpdate(TickEvent.PlayerTickEvent event) {

		if (isValidPlayer(event.player)) {

			ItemStack stack = event.player.getHeldItem();

			if (cfg.descensionShift && event.player.isSneaking())
				playerGlide(event.player);

			else if (!cfg.descensionShift)
				playerGlide(event.player);

			else
				return;
		}
	}

	public void playerGlide(EntityPlayer player) {

		if (!player.onGround) {

			if (player.motionY < 0.0D) {

				player.motionY *= 0.6D;
				player.fallDistance = (float) (player.fallDistance * cfg.descensionFall);
			}
		}
	}
}