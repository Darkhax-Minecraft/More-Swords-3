package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchantmentIgnite extends EnchantmentBase {
    
    protected EnchantmentIgnite(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
    }
    
    @Override
    public void onEntityDamaged (EntityLivingBase user, Entity target, int level) {
        
        if (isValidUser(user)) {
            
            ItemStack stack = user.getHeldItem();
            target.setFire(ConfigurationHandler.igniteDamage * getLevel(stack));
            
            if (target instanceof EntityCreeper && ConfigurationHandler.igniteBoom) {
                
                EntityCreeper creeper = (EntityCreeper) target;
                creeper.getDataWatcher().updateObject(18, Byte.valueOf((byte) 1));
            }
        }
    }
}