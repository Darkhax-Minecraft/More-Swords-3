package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.util.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchantmentGreed extends EnchantmentBase {
    
    protected EnchantmentGreed(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
    }
    
    /**
     * Drops a bonus of experience orbs where the mob is. The effect will activate about 7% of
     * the time. The chances of this effect being activated increase with every level of the
     * effect.The amount dropped is a range between two numbers, by default 1-3. Note that this
     * effect will still work even if the mob is not killed.
     */
    @Override
    public void onEntityDamaged (EntityLivingBase user, Entity target, int level) {
        
        if (isValidPlayer(user)) {
            
            ItemStack stack = user.getHeldItem();
            EntityLiving living = (EntityLiving) target;
            
            if (Math.random() < (cfg.greedChance * level(stack)))
                if (!living.worldObj.isRemote)
                    living.worldObj.spawnEntityInWorld(new EntityXPOrb(living.worldObj, living.posX, living.posY, living.posZ, Utils.nextIntII(cfg.greedMin, cfg.greedMax)));
        }
    }
}