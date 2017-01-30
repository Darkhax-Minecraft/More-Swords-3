package net.darkhax.moreswords.enchantment;

import java.util.List;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchantmentExtinction extends EnchantmentBase {
    
    protected EnchantmentExtinction(Enchantment.Rarity rarity, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(rarity, unlocalizedName, minLevel, maxLevel, item);
    }
    
    @Override
    public void onEntityDamaged (EntityLivingBase user, Entity target, int level) {
        
        if (isValidUser(user))
            for (Entity entity : (List<Entity>) user.world.loadedEntityList)
                if (!entity.getClass().equals(user.getClass()) && entity.getClass().equals(target.getClass()))
                    entity.setDead();
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