package net.darkhax.moreswords.enchantment;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EnchantmentFrozenAspect extends EnchantmentBase {
    
    protected EnchantmentFrozenAspect(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
    }
    
    /**
     * Slows down the mob for three second * ench level. The strength is equal to ench level.
     */
    @Override
    public void onEntityDamaged (EntityLivingBase user, Entity target, int level) {
        
        if (isValidPlayer(user)) {
            
            ItemStack stack = user.getHeldItem();
            ((EntityLiving) target).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, cfg.frozenTime * level(stack), cfg.frozenLevel * level(stack)));
        }
    }
}