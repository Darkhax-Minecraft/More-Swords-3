package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.util.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchantmentFeast extends EnchantmentBase {
    
    protected EnchantmentFeast(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
    }
    
    /**
     * The feast enchantment will repair damage equal to 0-3 per level on the sword.
     */
    @Override
    public void onEntityDamaged (EntityLivingBase user, Entity target, int level) {
        
        if (isValidPlayer(user)) {
            
            double d = Math.random();
            ItemStack stack = user.getHeldItem();
            
            if (d < (cfg.feastChance * level(stack))) {
                
                int repair = Utils.nextIntII(cfg.feastMin, cfg.feastMax) * level(stack);
                stack.damageItem(-repair, user);
            }
        }
    }
}