package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentStealth extends EnchantmentBase {
    
    protected EnchantmentStealth(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public void onItemUsed (PlayerInteractEvent event) {
        
        if (isValidUser(event.getEntityPlayer()) && (event.equals(PlayerInteractEvent.Action.RIGHT_CLICK_AIR)))
            event.getEntityPlayer().setInvisible(event.getEntityPlayer().isInvisible());
    }
    
    @Override
    public boolean canApplyAtEnchantingTable (ItemStack stack) {
        
        return ConfigurationHandler.stealthVanilla;
    }
    
    @Override
    public boolean isAllowedOnBooks () {
        
        return ConfigurationHandler.stealthVanilla;
    }
    
    @Override
    public boolean canApply (ItemStack stack) {
        
        return ConfigurationHandler.stealthVanilla;
    }
    
    @Override
    public boolean canApplyTogether (Enchantment par1Enchantment) {
        
        return ConfigurationHandler.stealthVanilla;
    }
    
    @Override
    public boolean isValidUser (Entity entity) {
        
        return (entity instanceof EntityPlayer && ((EntityLivingBase) entity).getHeldItemMainhand() != null && getLevel(((EntityPlayer) entity).getHeldItemMainhand()) > 0);
    }
}