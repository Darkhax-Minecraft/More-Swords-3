package net.darkhax.moreswords.enchantment;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchantmentAscension extends EnchantmentBase {
    
    protected EnchantmentAscension(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
    }
    
    /**
     * The Ascension Enchantment will knock hit entities up into the air. Motion is 0.45
     * multiplied by enchantment level.
     */
    @Override
    public void onEntityDamaged (EntityLivingBase user, Entity target, int level) {
        
        if (isValidPlayer(user)) {
            
            ItemStack stack = user.getHeldItem();
            double Y = level(stack) * cfg.ascensionBase;
            target.motionY = Y;
        }
    }
}