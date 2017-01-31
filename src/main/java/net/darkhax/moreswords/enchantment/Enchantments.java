package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.item.SwordItems;
import net.minecraft.enchantment.Enchantment;

public class Enchantments {
    
    static int basic = 5;
    static int advanced = 1;
    
    public Enchantments() {
        
        if (ConfigurationHandler.enabledEnchant) {
            
            if (ConfigurationHandler.igniteEnabled)
                new EnchantmentIgnite(Enchantment.Rarity.VERY_RARE, "ignite", 1, 3, SwordItems.swordDawmStar);
                
            if (ConfigurationHandler.sparkEnabled)
                new EnchantmentSpark(Enchantment.Rarity.VERY_RARE, "spark", 1, 1, SwordItems.swordDawmStar);
                
            if (ConfigurationHandler.feastEnabled)
                new EnchantmentFeast(Enchantment.Rarity.UNCOMMON, "feast", 1, 3, SwordItems.swordVampiric);
                
            if (ConfigurationHandler.vitalityEnabled)
                new EnchantmentVitality(Enchantment.Rarity.VERY_RARE, "vitality", 1, 1, SwordItems.swordVampiric);
                
            if (ConfigurationHandler.venomEnabled)
                new EnchantmentVenomousAspect(Enchantment.Rarity.UNCOMMON, "venomAspect", 1, 3, SwordItems.swordGladiolus);
                
            if (ConfigurationHandler.absorbEnabled)
                new EnchantmentAbsorb(Enchantment.Rarity.VERY_RARE, "absorb", 1, 1, SwordItems.swordGladiolus);
                
            if (ConfigurationHandler.keenEdgeEnabled)
                new EnchantmentKeenEdge(Enchantment.Rarity.UNCOMMON, "keenEdge", 1, 3, SwordItems.swordDraconic);
                
            if (ConfigurationHandler.scornEnabled)
                new EnchantmentScorn(Enchantment.Rarity.VERY_RARE, "scorn", 1, 1, SwordItems.swordDraconic);
                
            if (ConfigurationHandler.enderPulseEnabled)
                new EnchantmentEnderPulse(Enchantment.Rarity.UNCOMMON, "enderPulse", 1, 3, SwordItems.swordEnder);
                
            if (ConfigurationHandler.enderAuraEnabled)
                new EnchantmentEnderAura(Enchantment.Rarity.VERY_RARE, "enderAura", 1, 1, SwordItems.swordEnder);
                
            if (ConfigurationHandler.greedEnabled)
                new EnchantmentGreed(Enchantment.Rarity.UNCOMMON, "greed", 1, 3, SwordItems.swordCrystal);
                
            if (ConfigurationHandler.wisdomEnabled)
                new EnchantmentWisdom(Enchantment.Rarity.VERY_RARE, "wisdom", 1, 1, SwordItems.swordCrystal);
                
            if (ConfigurationHandler.frozenEnabled)
                new EnchantmentFrozenAspect(Enchantment.Rarity.UNCOMMON, "frozenAspect", 1, 3, SwordItems.swordGlacial);
                
            if (ConfigurationHandler.frostEnabled)
                new EnchantmentFrostWave(Enchantment.Rarity.VERY_RARE, "frostWave", 1, 1, SwordItems.swordGlacial);
                
            if (ConfigurationHandler.ascensionEnabled)
                new EnchantmentAscension(Enchantment.Rarity.UNCOMMON, "ascension", 1, 3, SwordItems.swordAether);
                
            if (ConfigurationHandler.descensionEnabled)
                new EnchantmentDescension(Enchantment.Rarity.VERY_RARE, "descension", 1, 1, SwordItems.swordAether);
                
            if (ConfigurationHandler.shadowsEnabled)
                new EnchantmentShadows(Enchantment.Rarity.UNCOMMON, "shadows", 1, 3, SwordItems.swordWither);
                
            if (ConfigurationHandler.decayEnabled)
                new EnchantmentDecay(Enchantment.Rarity.VERY_RARE, "decay", 1, 1, SwordItems.swordWither);
                
            if (ConfigurationHandler.stealthEnabled)
                new EnchantmentStealth(Enchantment.Rarity.VERY_RARE, "stealth", 1, 1, SwordItems.swordAdmin);
                
            if (ConfigurationHandler.extinctionEnabled)
                new EnchantmentExtinction(Enchantment.Rarity.VERY_RARE, "extinction", 1, 1, SwordItems.swordAdmin);
        }
    }
}
