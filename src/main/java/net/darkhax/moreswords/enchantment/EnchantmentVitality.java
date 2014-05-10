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

	@SubscribeEvent
	public void onItemUsed(PlayerInteractEvent event) {
		
		if ((event.action.equals(PlayerInteractEvent.Action.RIGHT_CLICK_AIR))) { 
			
			if (isValidPlayer(event.entityPlayer)) {
				
				ItemStack stack = event.entityPlayer.getHeldItem();
				EntityPlayer player = event.entityPlayer;
				int enchLevel = EnchantmentHelper.getEnchantmentLevel(this.effectId, stack);
				
		        if (enchLevel >= 1) {
		        	
		            player.getHeldItem().damageItem(250, player);
		            player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 40 * enchLevel, 0));   
		            player.addPotionEffect(new PotionEffect(Potion.field_76434_w.id, 60 * enchLevel, 1));
		        }
			}
		}
	}
}