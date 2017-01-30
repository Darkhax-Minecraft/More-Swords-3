package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.util.Utils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;

public class EnchantmentScorn extends EnchantmentBase {
    
    protected EnchantmentScorn(Enchantment.Rarity rarity, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(rarity, unlocalizedName, minLevel, maxLevel, item);
    }
    
    @Override
    public void onEntityDamaged (EntityLivingBase user, Entity target, int level) {
        
        if (isValidUser(user) && user.dimension != 0)
            target.attackEntityFrom(DamageSource.magic, (float) (Utils.getItemWeaponDamage(user.getHeldItemMainhand()) * 2));
    }
}