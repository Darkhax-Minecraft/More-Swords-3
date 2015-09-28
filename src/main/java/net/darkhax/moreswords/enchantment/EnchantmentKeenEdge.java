package net.darkhax.moreswords.enchantment;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.item.Item;

public class EnchantmentKeenEdge extends EnchantmentBase {
    
    protected EnchantmentKeenEdge(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
    }
    
    /**
     * Deals extra damage to a mob on hit equal to that of the enchantment.
     */
    @Override
    public float calcDamageByCreature (int level, EnumCreatureAttribute creature) {
        
        return (float) (level * 1.75);
    }
}