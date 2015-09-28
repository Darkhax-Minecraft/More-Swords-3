package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.util.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentEnderAura extends EnchantmentBase {
    
    protected EnchantmentEnderAura(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public void onEntityHit (LivingHurtEvent event) {
        
        if (isValidUser(event.entityLiving) && Utils.percentChance(ConfigurationHandler.enderAuraChance))
            attemptWarp(event.entityLiving);
    }
    
    /**
     * Attempts to warp an entity to another entity within range to them.
     * 
     * @param living: The entity you want to warp.
     */
    public void attemptWarp (EntityLivingBase living) {
        
        Entity target = (Entity) living.worldObj.loadedEntityList.get(Utils.nextIntII(1, living.worldObj.loadedEntityList.size() - 1));
        
        if (target instanceof EntityLiving && Utils.isEntityWithinRange(living, target, ConfigurationHandler.enderAuraRange)) {
            
            living.setPositionAndUpdate(target.posX, target.posY, target.posZ);
            return;
        }
        
        attemptWarp(living);
    }
}