package net.darkhax.moreswords.enchantment;

import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentShadows extends EnchantmentBase {
    
    protected EnchantmentShadows(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, String item) {
    
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    /**
     * Gives a mob 1.5 seconds of blindness. Has a 15% per level chance to cause wither damage.
     */
    @SubscribeEvent
    public void onEntityHit (AttackEntityEvent event) {
    
        if (isLiving(event.target)) {
            
            if (isValidPlayer(event.entityLiving)) {
                
                ItemStack stack = event.entityPlayer.getHeldItem();
                ((EntityLiving) event.target).addPotionEffect(new PotionEffect(Potion.blindness.id, cfg.shadowsTime * level(stack), cfg.shadowsLevel));
                
                if (Math.random() < (cfg.shadowsWitherChance * level(stack))) {
                    
                    ((EntityLiving) event.target).addPotionEffect(new PotionEffect(Potion.wither.id, (int) (cfg.shadowsWitherTime * level(stack)), cfg.shadowsWitherLevel));
                }
            }
        }
    }
}