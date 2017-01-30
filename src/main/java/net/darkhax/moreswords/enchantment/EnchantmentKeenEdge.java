package net.darkhax.moreswords.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.item.Item;

public class EnchantmentKeenEdge extends EnchantmentBase {
    
    protected EnchantmentKeenEdge(Enchantment.Rarity rarity, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(rarity, unlocalizedName, minLevel, maxLevel, item);
    }
    
    @Override
    public float calcDamageByCreature (int level, EnumCreatureAttribute creature) {
        
        return (float) (level * 1.75);
    }
}