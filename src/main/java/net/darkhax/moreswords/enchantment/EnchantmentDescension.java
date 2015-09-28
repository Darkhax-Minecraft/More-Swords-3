package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
        
        if (isValidUser(event.player)) {
            
            ItemStack stack = event.player.getHeldItem();
            
            if (ConfigurationHandler.descensionShift && event.player.isSneaking())
                playerGlide(event.player);
                
            else if (!ConfigurationHandler.descensionShift)
                playerGlide(event.player);
                
            else
                return;
        }
    }
    
    /**
     * Attempts to make a player glide slowly.
     * 
     * @param player: The player that will be told to glide.
     */
    public void playerGlide (EntityPlayer player) {
        
        if (!player.onGround) {
            
            if (player.motionY < 0.0D) {
                
                player.motionY *= 0.6D;
                player.fallDistance = (float) (player.fallDistance * ConfigurationHandler.descensionFall);
            }
        }
    }
}