package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.util.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EnchantmentFrostWave extends EnchantmentBase {

    protected EnchantmentFrostWave(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
    }

    /**
     * Slows mobs down that are within 2.5 blocks of the target mob.
     */
    @Override
    public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {

        if (isValidPlayer(user)) {

            EntityLiving living = (EntityLiving) target;
            for (int i = 0; i < living.worldObj.loadedEntityList.size(); i++) {

                if (living.worldObj.loadedEntityList.get(i) != living) {

                    if (living.worldObj.loadedEntityList.get(i) instanceof EntityLiving) {

                        if (Utils.isEntityWithinRange(living, (EntityLiving) living.worldObj.loadedEntityList.get(i), cfg.frostRange)) {

                            EntityLiving closeEntity = (EntityLiving) living.worldObj.loadedEntityList.get(i);
                            closeEntity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, cfg.frostTime, cfg.frostLevel));
                        }
                    }
                }
            }
        }
    }
}