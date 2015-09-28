package net.darkhax.moreswords.enchantment;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EnchantmentShadows extends EnchantmentBase {
    
    protected EnchantmentShadows(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
    }
    
    /**
     * Gives a mob 1.5 seconds of blindness. Has a 15% per level chance to cause wither damage.
     */
    @Override
    public void onEntityDamaged (EntityLivingBase user, Entity target, int level) {
        
        if (isValidPlayer(user)) {
            
            ItemStack stack = user.getHeldItem();
            ((EntityLiving) target).addPotionEffect(new PotionEffect(Potion.blindness.id, cfg.shadowsTime * level(stack), cfg.shadowsLevel));
            
            if (Math.random() < (cfg.shadowsWitherChance * level(stack)))
                ((EntityLiving) target).addPotionEffect(new PotionEffect(Potion.wither.id, (int) (cfg.shadowsWitherTime * level(stack)), cfg.shadowsWitherLevel));
        }
    }
}