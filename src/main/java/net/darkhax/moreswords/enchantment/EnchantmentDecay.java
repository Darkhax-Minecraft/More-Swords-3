package net.darkhax.moreswords.enchantment;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class EnchantmentDecay extends EnchantmentBase {

    protected EnchantmentDecay(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
    }

    /**
     * Gives target wither damage for 75 ticks.
     */
    @Override
    public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {

        if (isValidPlayer(user)) {

            ItemStack stack = user.getHeldItem();
            ((EntityLiving) target).addPotionEffect(new PotionEffect(Potion.wither.id, cfg.decayTime * level(stack), cfg.decayLevel));
        }
    }
}