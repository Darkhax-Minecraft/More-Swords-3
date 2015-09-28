package net.darkhax.moreswords.enchantment;

import java.util.List;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchantmentExtinction extends EnchantmentBase {
    
    protected EnchantmentExtinction(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
    }
    
    /**
     * Kills all instances of the target entity in the world.
     */
    @Override
    public void onEntityDamaged (EntityLivingBase user, Entity target, int level) {
        
        if (isValidUser(user)) {
            
            ItemStack stack = user.getHeldItem();
            
            for (Entity entity : (List<Entity>) user.worldObj.loadedEntityList) {
                
                if (!entity.getClass().equals(user.getClass())) {
                    
                    if (entity.getClass().equals(target.getClass()))
                        entity.setDead();
                }
            }
        }
    }
    
    @Override
    public boolean canApplyAtEnchantingTable (ItemStack stack) {
        
        return ConfigurationHandler.extinctionVanilla;
    }
    
    @Override
    public boolean isAllowedOnBooks () {
        
        return ConfigurationHandler.extinctionVanilla;
    }
    
    @Override
    public boolean canApply (ItemStack stack) {
        
        return ConfigurationHandler.extinctionVanilla;
    }
    
    @Override
    public boolean canApplyTogether (Enchantment par1Enchantment) {
        
        return ConfigurationHandler.extinctionVanilla;
    }
}