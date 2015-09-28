package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentVitality extends EnchantmentBase {
    
    protected EnchantmentVitality(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    /**
     * Consumes 150 divided by the enchantment level out of the durability of the tool, gives
     * the wielder regeneration for 3 seconds multiplied by the enchantment level, gives a 4
     * heart health boost for 3 seconds multiplied by the enchantment level and a low level
     * instant health boost for 0.05 seconds.
     */
    @SubscribeEvent
    public void onItemUsed (PlayerInteractEvent event) {
        
        if ((event.action.equals(PlayerInteractEvent.Action.RIGHT_CLICK_AIR))) {
            
            if (isValidUser(event.entityPlayer)) {
                
                ItemStack stack = event.entityPlayer.getHeldItem();
                EntityPlayer player = event.entityPlayer;
                int enchLevel = getLevel(stack);
                
                if (stack.getItem().isDamageable()) {
                    
                    player.getHeldItem().damageItem(ConfigurationHandler.vitalityDamage / enchLevel, player);
                    player.addPotionEffect(new PotionEffect(Potion.regeneration.id, ConfigurationHandler.vitalityRegenTime * enchLevel, ConfigurationHandler.vitalityRegenLevel));
                    player.addPotionEffect(new PotionEffect(Potion.absorption.id, ConfigurationHandler.vitalityHeartsTime * enchLevel, ConfigurationHandler.vitalityHeartsLevel));
                    player.addPotionEffect(new PotionEffect(Potion.heal.id, ConfigurationHandler.vitalityHealTime, ConfigurationHandler.vitalityHealLevel));
                }
            }
        }
    }
}