package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;

public class EnchantmentWisdom extends EnchantmentBase {
    
    protected EnchantmentWisdom(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
    }
    
    @Override
    public void onEntityDamaged (EntityLivingBase user, Entity target, int level) {
        
        if (isValidUser(user)) {
            
            EntityPlayer player = (EntityPlayer) user;
            float damage = (float) ((player.experienceLevel / ConfigurationHandler.wisdomLevel) * ConfigurationHandler.wisdomMultiplier);
            
            if (ConfigurationHandler.wisodmShouldCap && damage > ConfigurationHandler.wisdomCap)
                damage = (float) ConfigurationHandler.wisdomCap;
                
            target.attackEntityFrom(DamageSource.magic, damage);
        }
    }
    
    @Override
    public boolean isValidUser (Entity entity) {
        
        return (entity instanceof EntityPlayer && ((EntityLivingBase) entity).getHeldItemMainhand() != null && getLevel(((EntityPlayer) entity).getHeldItemMainhand()) > 0);
    }
}