package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.util.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EnchantmentShadows extends EnchantmentBase {
    
    protected EnchantmentShadows(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
    }
    
    @Override
    public void onEntityDamaged (EntityLivingBase user, Entity target, int level) {
        
        if (isValidUser(user)) {
            
            ItemStack stack = user.getHeldItemMainhand();
            ((EntityLiving) target).addPotionEffect(new PotionEffect(Potion.getPotionById(15), ConfigurationHandler.shadowsTime * getLevel(stack), ConfigurationHandler.shadowsLevel));
            
            if (Utils.percentChance(ConfigurationHandler.shadowsWitherChance * getLevel(stack)))
                ((EntityLiving) target).addPotionEffect(new PotionEffect(Potion.getPotionById(20), (int) (ConfigurationHandler.shadowsWitherTime * getLevel(stack)), ConfigurationHandler.shadowsWitherLevel));
        }
    }
}