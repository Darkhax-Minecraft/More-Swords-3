package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.util.Utils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

public class EnchantmentAbsorb extends EnchantmentBase {
    
    protected EnchantmentAbsorb(Enchantment.Rarity rarity, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(rarity, unlocalizedName, minLevel, maxLevel, item);
    }
    
    @Override
    public void onEntityDamaged (EntityLivingBase user, Entity target, int level) {
        
        if (isValidUser(user) && Utils.percentChance(ConfigurationHandler.absorbChance)) {
            
            EntityPlayer player = (EntityPlayer) user;
            player.getHeldItemMainhand();
            int food = Utils.nextIntII(ConfigurationHandler.absorbMin, ConfigurationHandler.absorbMax);
            float saturation = (float) (ConfigurationHandler.absorbSaturation * food);
            player.getFoodStats().addStats(food, saturation);
        }
    }
    
    @Override
    public boolean isValidUser (Entity entity) {
        
        return (entity instanceof EntityPlayer && ((EntityLivingBase) entity).getHeldItemMainhand() != null && getLevel(((EntityPlayer) entity).getHeldItemMainhand()) > 0);
    }
}