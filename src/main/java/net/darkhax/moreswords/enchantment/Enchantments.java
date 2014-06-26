package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.item.SwordItems;

public class Enchantments {

    static int basic = 5;
    static int advanced = 1;
    static ConfigurationHandler cfg;

    public Enchantments(Boolean shouldLoad) {

        if (shouldLoad) {

            if (cfg.igniteEnabled)
                new EnchantmentIgnite(cfg.igniteID, basic, "ignite", 1, 3, SwordItems.swordDawmStar);

            if (cfg.sparkEnabled)
                new EnchantmentSpark(cfg.sparkID, advanced, "spark", 1, 1, SwordItems.swordDawmStar);

            if (cfg.feastEnabled)
                new EnchantmentFeast(cfg.feastID, basic, "feast", 1, 3, SwordItems.swordVampiric);

            if (cfg.vitalityEnabled)
                new EnchantmentVitality(cfg.vitalityID, advanced, "vitality", 1, 1, SwordItems.swordVampiric);

            if (cfg.venomEnabled)
                new EnchantmentVenomousAspect(cfg.venomID, basic, "venomAspect", 1, 3, SwordItems.swordGladiolus);

            if (cfg.absorbEnabled)
                new EnchantmentAbsorb(cfg.absorbID, advanced, "absorb", 1, 1, SwordItems.swordGladiolus);

            if (cfg.keenEdgeEnabled)
                new EnchantmentKeenEdge(cfg.keenEdgeID, basic, "keenEdge", 1, 3, SwordItems.swordDraconic);

            if (cfg.scornEnabled)
                new EnchantmentScorn(cfg.scornID, advanced, "scorn", 1, 1, SwordItems.swordDraconic);

            if (cfg.enderPulseEnabled)
                new EnchantmentEnderPulse(cfg.enderPulseID, basic, "enderPulse", 1, 3, SwordItems.swordEnder);

            if (cfg.enderAuraEnabled)
                new EnchantmentEnderAura(cfg.enderAuraID, advanced, "enderAura", 1, 1, SwordItems.swordEnder);

            if (cfg.greedEnabled)
                new EnchantmentGreed(cfg.greedID, basic, "greed", 1, 3, SwordItems.swordCrystal);

            if (cfg.wisdomEnabled)
                new EnchantmentWisdom(cfg.wisdomID, advanced, "wisdom", 1, 1, SwordItems.swordCrystal);

            if (cfg.frozenEnabled)
                new EnchantmentFrozenAspect(cfg.frozenID, basic, "frozenAspect", 1, 3, SwordItems.swordGlacial);

            if (cfg.frostEnabled)
                new EnchantmentFrostWave(cfg.frostID, advanced, "frostWave", 1, 1, SwordItems.swordGlacial);

            if (cfg.ascensionEnabled)
                new EnchantmentAscension(cfg.ascensionID, basic, "ascension", 1, 3, SwordItems.swordAether);

            if (cfg.descensionEnabled)
                new EnchantmentDescension(cfg.descensionID, advanced, "descension", 1, 1, SwordItems.swordAether);

            if (cfg.shadowsEnabled)
                new EnchantmentShadows(cfg.shadowsID, basic, "shadows", 1, 3, SwordItems.swordWither);

            if (cfg.decayEnabled)
                new EnchantmentDecay(cfg.decayID, advanced, "decay", 1, 1, SwordItems.swordWither);

            if (cfg.stealthEnabled)
                new EnchantmentStealth(cfg.stealthID, advanced, "stealth", 1, 1, SwordItems.swordAdmin);

            if (cfg.extinctionEnabled)
                new EnchantmentExtinction(cfg.extinctionID, advanced, "extinction", 1, 1, SwordItems.swordAdmin);
        }
    }
}
