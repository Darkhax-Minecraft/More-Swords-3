package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
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
    
    @Override
    public void onEntityDamaged (EntityLivingBase user, Entity target, int level) {
        
        if (isValidUser(user)) {
            
            ItemStack stack = user.getHeldItemMainhand();
            ((EntityLiving) target).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, ConfigurationHandler.frozenTime * getLevel(stack), ConfigurationHandler.frozenLevel * getLevel(stack)));
        }
    }
}