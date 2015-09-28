package net.darkhax.moreswords.enchantment;

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
        
        if (isValidPlayer(user)) {
            
            EntityPlayer player = (EntityPlayer) user;
            float damage = (float) ((player.experienceLevel / cfg.wisdomLevel) * cfg.wisdomMultiplier);
            
            if (cfg.wisodmShouldCap && damage > cfg.wisdomCap)
                damage = (float) cfg.wisdomCap;
                
            target.attackEntityFrom(DamageSource.magic, damage);
        }
    }
}