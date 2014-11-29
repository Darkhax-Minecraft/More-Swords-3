package net.darkhax.moreswords.enchantment;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchantmentIgnite extends EnchantmentBase {

    protected EnchantmentIgnite(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
    }

    /**
     * The ignite enchantment will do fire damage to a mob equal to that of the effect. If the mob is a
     * creeper he will explode.
     */
    @Override
    public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {

        if (isValidPlayer(user)) {

            ItemStack stack = user.getHeldItem();
            target.setFire(cfg.igniteDamage * level(stack));

            if (target instanceof EntityCreeper && cfg.igniteBoom) {

                EntityCreeper creeper = (EntityCreeper) target;
                creeper.getDataWatcher().updateObject(18, Byte.valueOf((byte) 1));
            }
        }
    }
}