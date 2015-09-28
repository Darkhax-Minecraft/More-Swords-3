package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.item.SwordItems;

public class Enchantments {
    
    static int basic = 5;
    static int advanced = 1;
    
    public Enchantments() {
        
        if (ConfigurationHandler.enabledEnchant) {
            
            if (ConfigurationHandler.igniteEnabled)
                new EnchantmentIgnite(ConfigurationHandler.igniteID, basic, "ignite", 1, 3, SwordItems.swordDawmStar);
                
            if (ConfigurationHandler.sparkEnabled)
                new EnchantmentSpark(ConfigurationHandler.sparkID, advanced, "spark", 1, 1, SwordItems.swordDawmStar);
                
            if (ConfigurationHandler.feastEnabled)
                new EnchantmentFeast(ConfigurationHandler.feastID, basic, "feast", 1, 3, SwordItems.swordVampiric);
                
            if (ConfigurationHandler.vitalityEnabled)
                new EnchantmentVitality(ConfigurationHandler.vitalityID, advanced, "vitality", 1, 1, SwordItems.swordVampiric);
                
            if (ConfigurationHandler.venomEnabled)
                new EnchantmentVenomousAspect(ConfigurationHandler.venomID, basic, "venomAspect", 1, 3, SwordItems.swordGladiolus);
                
            if (ConfigurationHandler.absorbEnabled)
                new EnchantmentAbsorb(ConfigurationHandler.absorbID, advanced, "absorb", 1, 1, SwordItems.swordGladiolus);
                
            if (ConfigurationHandler.keenEdgeEnabled)
                new EnchantmentKeenEdge(ConfigurationHandler.keenEdgeID, basic, "keenEdge", 1, 3, SwordItems.swordDraconic);
                
            if (ConfigurationHandler.scornEnabled)
                new EnchantmentScorn(ConfigurationHandler.scornID, advanced, "scorn", 1, 1, SwordItems.swordDraconic);
                
            if (ConfigurationHandler.enderPulseEnabled)
                new EnchantmentEnderPulse(ConfigurationHandler.enderPulseID, basic, "enderPulse", 1, 3, SwordItems.swordEnder);
                
            if (ConfigurationHandler.enderAuraEnabled)
                new EnchantmentEnderAura(ConfigurationHandler.enderAuraID, advanced, "enderAura", 1, 1, SwordItems.swordEnder);
                
            if (ConfigurationHandler.greedEnabled)
                new EnchantmentGreed(ConfigurationHandler.greedID, basic, "greed", 1, 3, SwordItems.swordCrystal);
                
            if (ConfigurationHandler.wisdomEnabled)
                new EnchantmentWisdom(ConfigurationHandler.wisdomID, advanced, "wisdom", 1, 1, SwordItems.swordCrystal);
                
            if (ConfigurationHandler.frozenEnabled)
                new EnchantmentFrozenAspect(ConfigurationHandler.frozenID, basic, "frozenAspect", 1, 3, SwordItems.swordGlacial);
                
            if (ConfigurationHandler.frostEnabled)
                new EnchantmentFrostWave(ConfigurationHandler.frostID, advanced, "frostWave", 1, 1, SwordItems.swordGlacial);
                
            if (ConfigurationHandler.ascensionEnabled)
                new EnchantmentAscension(ConfigurationHandler.ascensionID, basic, "ascension", 1, 3, SwordItems.swordAether);
                
            if (ConfigurationHandler.descensionEnabled)
                new EnchantmentDescension(ConfigurationHandler.descensionID, advanced, "descension", 1, 1, SwordItems.swordAether);
                
            if (ConfigurationHandler.shadowsEnabled)
                new EnchantmentShadows(ConfigurationHandler.shadowsID, basic, "shadows", 1, 3, SwordItems.swordWither);
                
            if (ConfigurationHandler.decayEnabled)
                new EnchantmentDecay(ConfigurationHandler.decayID, advanced, "decay", 1, 1, SwordItems.swordWither);
                
            if (ConfigurationHandler.stealthEnabled)
                new EnchantmentStealth(ConfigurationHandler.stealthID, advanced, "stealth", 1, 1, SwordItems.swordAdmin);
                
            if (ConfigurationHandler.extinctionEnabled)
                new EnchantmentExtinction(ConfigurationHandler.extinctionID, advanced, "extinction", 1, 1, SwordItems.swordAdmin);
        }
    }
}
