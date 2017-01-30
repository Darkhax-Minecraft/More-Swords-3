package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EnchantmentVenomousAspect extends EnchantmentBase {
    
    protected EnchantmentVenomousAspect(Enchantment.Rarity rarity, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(rarity, unlocalizedName, minLevel, maxLevel, item);
    }
    
    @Override
    public void onEntityDamaged (EntityLivingBase user, Entity target, int level) {
        
        if (isValidUser(user)) {
            
            ItemStack stack = user.getHeldItemMainhand();
            ((EntityLiving) target).addPotionEffect(new PotionEffect(Potion.getPotionById(19), ConfigurationHandler.venomTime * getLevel(stack), ConfigurationHandler.venomLevel));
        }
    }
}