package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.util.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchantmentGreed extends EnchantmentBase {
    
    protected EnchantmentGreed(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
    }
    
    @Override
    public void onEntityDamaged (EntityLivingBase user, Entity target, int level) {
        
        if (isValidUser(user)) {
            
            ItemStack stack = user.getHeldItem();
            EntityLiving living = (EntityLiving) target;
            
            if (Math.random() < (ConfigurationHandler.greedChance * getLevel(stack)) && !living.worldObj.isRemote)
                living.worldObj.spawnEntityInWorld(new EntityXPOrb(living.worldObj, living.posX, living.posY, living.posZ, Utils.nextIntII(ConfigurationHandler.greedMin, ConfigurationHandler.greedMax)));
        }
    }
}