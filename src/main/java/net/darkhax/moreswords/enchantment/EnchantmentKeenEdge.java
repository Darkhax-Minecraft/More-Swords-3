package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.util.Utils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentKeenEdge extends EnchantmentBase {
    
    protected EnchantmentKeenEdge(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
    
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    /**
     * Deals extra damage to a mob on hit equal to that of the enchantment.
     */
    @SubscribeEvent
    public void onEntityHit (AttackEntityEvent event) {
    
        if (isLiving(event.target)) {
            
            if (isValidPlayer(event.entityLiving)) {
                
                ItemStack stack = event.entityPlayer.getHeldItem();
                event.target.attackEntityFrom(DamageSource.magic, (float) (level(stack) + Utils.getItemWeaponDamage(stack)));
            }
        }
    }
}