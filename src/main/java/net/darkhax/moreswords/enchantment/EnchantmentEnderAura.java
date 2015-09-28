package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.util.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentEnderAura extends EnchantmentBase {
    
    protected EnchantmentEnderAura(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    /**
     * Has a 15% chance of warping the player to the next nearest entity within 32 blocks.
     * Note: Entity may not be friendly :)
     */
    @SubscribeEvent
    public void onEntityHit (LivingHurtEvent event) {
        
        double d = Math.random();
        if (d < (ConfigurationHandler.enderAuraChance)) {
            
            if (isValidUser(event.entityLiving)) {
                
                EntityPlayer living = (EntityPlayer) event.entityLiving;
                attemptWarp(living);
            }
        }
    }
    
    /**
     * Attempts to warp the player to a random position.
     * 
     * @param living: The player being warped.
     */
    public void attemptWarp (EntityPlayer living) {
        
        Entity target = (Entity) living.worldObj.loadedEntityList.get(Utils.nextIntII(1, living.worldObj.loadedEntityList.size() - 1));
        
        if (target instanceof EntityLiving) {
            
            if (Utils.isEntityWithinRange(living, target, ConfigurationHandler.enderAuraRange)) {
                
                living.setPositionAndUpdate(target.posX, target.posY, target.posZ);
                return;
            }
        }
        
        attemptWarp(living);
    }
}