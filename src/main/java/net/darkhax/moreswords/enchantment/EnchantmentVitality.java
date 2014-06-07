package net.darkhax.moreswords.enchantment;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentVitality extends EnchantmentCore {

	protected EnchantmentVitality(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

		super(id, weight, unlocalizedName, minLevel, maxLevel, item);
		MinecraftForge.EVENT_BUS.register(this);
	}

	/**
	 * Consumes 150 divided by the enchantment level out of the durability of 
	 * the tool, gives the wielder regeneration for 3 seconds multiplied by the
	 * enchantment level, gives a 4 heart health boost for 3 seconds multiplied by
	 * the enchantment level and a low level instant health boost for 0.05 seconds.
	 */
	@SubscribeEvent
	public void onItemUsed(PlayerInteractEvent event) {
		
		if ((event.action.equals(PlayerInteractEvent.Action.RIGHT_CLICK_AIR))) { 
			
			if (isValidPlayer(event.entityPlayer)) {
				
				ItemStack stack = event.entityPlayer.getHeldItem();
				EntityPlayer player = event.entityPlayer;
				int enchLevel = level(stack);
				
	            player.getHeldItem().damageItem(cfg.vitalityDamage, player);
	            player.addPotionEffect(new PotionEffect(Potion.regeneration.id, cfg.vitalityRegenTime * enchLevel, cfg.vitalityRegenLevel));   
	            player.addPotionEffect(new PotionEffect(Potion.field_76434_w.id, cfg.vitalityHeartsTime * enchLevel, cfg.vitalityHeartsLevel));
	            player.addPotionEffect(new PotionEffect(Potion.heal.id, cfg.vitalityHealTime, cfg.vitalityHealLevel));
	            
	            stack.damageItem(150 / enchLevel, player);
			}
		}
	}
}