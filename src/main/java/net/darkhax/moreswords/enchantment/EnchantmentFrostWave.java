package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.util.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EnchantmentFrostWave extends EnchantmentBase {
    
    protected EnchantmentFrostWave(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
    }
    
    @Override
    public void onEntityDamaged (EntityLivingBase user, Entity target, int level) {
        
        if (isValidUser(user)) {
            
            EntityLivingBase living = (EntityLivingBase) target;
            
            for (int i = 0; i < living.world.loadedEntityList.size(); i++)
                if (living.world.loadedEntityList.get(i) != living && living.world.loadedEntityList.get(i) instanceof EntityLiving && Utils.isEntityWithinRange(living, (EntityLiving) living.world.loadedEntityList.get(i), ConfigurationHandler.frostRange))
                    ((EntityLiving) living.world.loadedEntityList.get(i)).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, ConfigurationHandler.frostTime, ConfigurationHandler.frostLevel));
        }
    }
}