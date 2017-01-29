package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.util.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchantmentFeast extends EnchantmentBase {
    
    protected EnchantmentFeast(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
    }
    
    @Override
    public void onEntityDamaged (EntityLivingBase user, Entity target, int level) {
        
        if (isValidUser(user)) {
            
            ItemStack stack = user.getHeldItemMainhand();
            
            if (Utils.percentChance(ConfigurationHandler.feastChance * getLevel(stack))) {
                
                int repair = Utils.nextIntII(ConfigurationHandler.feastMin, ConfigurationHandler.feastMax) * getLevel(stack);
                stack.damageItem(-repair, user);
            }
        }
    }
}