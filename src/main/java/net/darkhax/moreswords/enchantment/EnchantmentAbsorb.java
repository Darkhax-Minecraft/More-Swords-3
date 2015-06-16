package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.util.Utilities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentAbsorb extends EnchantmentBase {
    
    protected EnchantmentAbsorb(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
    
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    /**
     * This enchantment has a 5% chance to restore hunger points.
     */
    @SubscribeEvent
    public void onEntityHit (AttackEntityEvent event) {
    
        double d = Math.random();
        
        if (d < cfg.absorbChance) {
            
            if (isValidPlayer(event.entityPlayer)) {
                
                ItemStack stack = event.entityPlayer.getHeldItem();
                int food = Utilities.nextIntII(cfg.absorbMin, cfg.absorbMax);
                float saturation = (float) (cfg.absorbSaturation * food);
                event.entityPlayer.getFoodStats().addStats(food, saturation);
                
                if (event.entityPlayer.worldObj.isRemote)
                    event.entityPlayer.worldObj.playSoundAtEntity(event.entityPlayer, "random.burp", 0.5F, event.entityPlayer.worldObj.rand.nextFloat() * 0.1F + 0.9F);
            }
        }
    }
}