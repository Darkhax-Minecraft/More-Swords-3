package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.util.Constants;
import net.darkhax.moreswords.util.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchantmentAbsorb extends EnchantmentBase {
    
    protected EnchantmentAbsorb(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
    }
    
    /**
     * This enchantment has a 5% chance to restore hunger points.
     */
    @Override
    public void onEntityDamaged (EntityLivingBase user, Entity target, int level) {
        
        if (isValidPlayer(user)) {
            
            double d = Math.random();
            
            if (d < cfg.absorbChance) {
                
                EntityPlayer player = (EntityPlayer) user;
                ItemStack stack = player.getHeldItem();
                int food = Utils.nextIntII(cfg.absorbMin, cfg.absorbMax);
                float saturation = (float) (cfg.absorbSaturation * food);
                player.getFoodStats().addStats(food, saturation);
            }
        }
    }
}