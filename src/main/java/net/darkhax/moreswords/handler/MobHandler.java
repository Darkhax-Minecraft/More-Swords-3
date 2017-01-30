package net.darkhax.moreswords.handler;

import net.darkhax.moreswords.item.SwordItems;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MobHandler {
    
    @SubscribeEvent
    public void onEnemySpawn (EntityJoinWorldEvent event) {
        
        if (ConfigurationHandler.enabledSpawning && event.getEntity() instanceof EntityLiving) {
            
            Math.random();
            
            EntityLiving living = (EntityLiving) event.getEntity();
            
            if (living.getEntityData() != null && !living.getEntityData().hasKey("spawned")) {
                
                if (event.getEntity() instanceof EntityZombie && ConfigurationHandler.zombieSwords)
                    setEntityToHoldSwords(living, ConfigurationHandler.zombieChance);
                    
                if (event.getEntity() instanceof EntitySkeleton && ConfigurationHandler.skeletonSwords)
                    setEntityToHoldSwords(living, ConfigurationHandler.skeletonChance);
                    
                if (event.getEntity() instanceof EntityPigZombie && ConfigurationHandler.pigSwords)
                    setEntityToHoldSwords(living, ConfigurationHandler.pigChance);
            }
        }
    }
    
    /**
     * Sets an entity to hold equipped an item in their hand.
     * 
     * @param entity: The entity to hold the item.
     * @param odds: The odds that this will succeed.
     */
    public void setEntityToHoldSwords (EntityLiving entity, double odds) {
        
        if (SwordItems.swordList.size() > 0) {
            
            ItemStack stack = new ItemStack(SwordItems.getRandomSword());
            EnumHand hand = EnumHand.MAIN_HAND;
            
            if (stack != null && stack.getItem() != SwordItems.swordAdmin && Math.random() < odds)
                entity.setHeldItem(hand, stack);
        }
        
        entity.getEntityData().setBoolean("spawned", true);
    }
}
