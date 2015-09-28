package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EnchantmentDescension extends EnchantmentBase {
    
    protected EnchantmentDescension(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
        FMLCommonHandler.instance().bus().register(this);
    }
    
    @SubscribeEvent
    public void onUpdate (TickEvent.PlayerTickEvent event) {
        
        if (isValidUser(event.player) && ((ConfigurationHandler.descensionShift && event.player.isSneaking()) || !ConfigurationHandler.descensionShift))
            playerGlide(event.player);
    }
    
    @Override
    public boolean isValidUser (Entity entity) {
        
        return (entity instanceof EntityPlayer && ((EntityLivingBase) entity).getHeldItem() != null && getLevel(((EntityPlayer) entity).getHeldItem()) > 0);
    }
    
    /**
     * A basic utility method to cause a player to glide, and reduce their fall distance.
     * 
     * @param player: The player to do this for.
     */
    public void playerGlide (EntityPlayer player) {
        
        if (!player.onGround && player.motionY < 0.0D) {
            
            player.motionY *= 0.6D;
            player.fallDistance = (float) (player.fallDistance * ConfigurationHandler.descensionFall);
        }
    }
}