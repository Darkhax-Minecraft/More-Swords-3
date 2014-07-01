package net.darkhax.moreswords.util;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public enum EnumMoreSwords {

    DAWNSTAR("dawnStar", ConfigurationHandler.damageDawnStar, ConfigurationHandler.durabilityDawnStar, ConfigurationHandler.enchantDawnStar, ConfigurationHandler.harvestDawnStar, ConfigurationHandler.efficientDawnStar, ConfigurationHandler.repairDawnStar, ConfigurationHandler.craftingDawnStar), VAMPIRIC("vampiric", ConfigurationHandler.damageVampiric, ConfigurationHandler.durabilityVampiric, ConfigurationHandler.enchantVampiric, ConfigurationHandler.harvestVampiric, ConfigurationHandler.efficientVampiric, ConfigurationHandler.repairVampiric, ConfigurationHandler.craftingVampiric), GLADIOLUS("gladiolus", ConfigurationHandler.damageGladiolus, ConfigurationHandler.durabilityGladiolus, ConfigurationHandler.enchantGladiolus, ConfigurationHandler.harvestGladiolus, ConfigurationHandler.efficientGladiolus, ConfigurationHandler.repairGladiolus, ConfigurationHandler.craftingGladiolus), DRACONIC("draconic", ConfigurationHandler.damageDraconic, ConfigurationHandler.durabilityDraconic, ConfigurationHandler.enchantDraconic, ConfigurationHandler.harvestDraconic, ConfigurationHandler.efficientDraconic, ConfigurationHandler.repairDraconic, ConfigurationHandler.craftingDraconic), ENDER("ender", ConfigurationHandler.damageEnder, ConfigurationHandler.durabilityEnder, ConfigurationHandler.enchantEnder, ConfigurationHandler.harvestEnder, ConfigurationHandler.efficientEnder, ConfigurationHandler.repairEnder, ConfigurationHandler.craftingEnder), CRYSTAL("crystal", ConfigurationHandler.damageCrystal, ConfigurationHandler.durabilityCrystal, ConfigurationHandler.enchantCrystal, ConfigurationHandler.harvestCrystal, ConfigurationHandler.efficientCrystal, ConfigurationHandler.repairCrystal, ConfigurationHandler.craftingCrystal), GLACIAL("glacial", ConfigurationHandler.damageGlacial, ConfigurationHandler.durabilityGlacial, ConfigurationHandler.enchantGlacial, ConfigurationHandler.harvestGlacial, ConfigurationHandler.efficientGlacial, ConfigurationHandler.repairGlacial, ConfigurationHandler.craftingGlacial), AETHER("aether", ConfigurationHandler.damageAether, ConfigurationHandler.durabilityAether, ConfigurationHandler.enchantAether, ConfigurationHandler.harvestAether, ConfigurationHandler.efficientAether, ConfigurationHandler.repairAether, ConfigurationHandler.craftingAether), WITHER("wither", ConfigurationHandler.damageWither, ConfigurationHandler.durabilityWither, ConfigurationHandler.enchantWither, ConfigurationHandler.harvestWither, ConfigurationHandler.efficientWither, ConfigurationHandler.repairWither, ConfigurationHandler.craftingWither), ADMIN("admin", ConfigurationHandler.damageAdmin, ConfigurationHandler.durabilityAdmin, ConfigurationHandler.enchantAdmin, ConfigurationHandler.harvestAdmin, ConfigurationHandler.efficientAdmin, ConfigurationHandler.repairAdmin, ConfigurationHandler.craftingAdmin), HOLIDAY("holiday", ConfigurationHandler.damageHoliday, ConfigurationHandler.durabilityHoliday, ConfigurationHandler.enchantHoliday, ConfigurationHandler.harvestHoliday, ConfigurationHandler.efficientHoliday, ConfigurationHandler.repairHoliday, ConfigurationHandler.craftingHoliday);

    /**
     * Creates An enum type similar to tool material but for use with ItemCoreSword.
     * 
     * @param name : A name used to identify the sword by.
     * @param damage : The damage value for a sword.
     * @param durability : The durability value for a sword.
     * @param enchant : The enchantability value for a sword.
     * @param harvest : The level this tool can harvest.
     * @param efficient : How fast this tool breaks blocks.
     * @param repairMaterial : Item used to repair in anvil.
     * @param isCraftable : Is this item craftable.
     */
    private EnumMoreSwords(String name, int damage, int durability, int enchant, int harvest, int efficient, String repairMaterial, boolean isCraftable) {

        this.swordName = name;
        this.swordDamage = damage;
        this.swordDurability = durability;
        this.swordEnchantability = enchant;
        this.swordHarvestLevel = harvest;
        this.swordEfficiency = efficient;
        this.swordRepairItem = getRepairItem(repairMaterial);
    }

    public String swordName;
    public int swordDamage;
    public int swordDurability;
    public int swordEnchantability;
    public int swordHarvestLevel;
    public int swordEfficiency;
    public Item swordRepairItem;

    /**
     * Get a swordType from the list of enums.
     * 
     * @param name : The name of the sword being looked up.
     * @return EnumMoreSwords: An instance of the enum based off of the name.
     */
    public static EnumMoreSwords getType(String name) {

        for (EnumMoreSwords swordType : values()) {

            if (swordType.swordName.equalsIgnoreCase(name)) {

                return swordType;
            }
        }

        Reference.LOGGER.info("There was an error when attempting to look up " + name);
        return null;
    }

    /**
     * Grabs a damage value from a swordType.
     * 
     * @param name : the name of the swordType.
     * @return int: The damage value for the swordType.
     */
    public static int getDamage(String name) {

        EnumMoreSwords swordType = getType(name);

        if (swordType != null) {

            return swordType.swordDamage;
        }

        return -1;
    }

    /**
     * Grabs a durability value from a swordType.
     * 
     * @param name : the name of the swordType.
     * @return int: the durability value for the swordType.
     */
    public static int getDurability(String name) {

        EnumMoreSwords swordType = getType(name);

        if (swordType != null) {

            return swordType.swordDurability;
        }

        return -1;
    }

    /**
     * Grabs an enchantability value from a swordType.
     * 
     * @param name : the name of the swordType
     * @return int: the enchantability value for the swordType.
     */
    public static int getEnchantability(String name) {

        EnumMoreSwords swordType = getType(name);

        if (swordType != null) {

            return swordType.swordEnchantability;
        }

        return -1;
    }

    /**
     * Grabs a harvest level from a swordType.
     * 
     * @param name : the name for the swordType
     * @return int: the harvest level for the swordType.
     */
    public static int getHarvestLevel(String name) {

        EnumMoreSwords swordType = getType(name);

        if (swordType != null) {

            return swordType.swordHarvestLevel;
        }

        return -1;
    }

    /**
     * Grabs an efficiency value from a swordType.
     * 
     * @param name : the name for the swordType
     * @return int: the efficiency value.
     */
    public static int getEfficiency(String name) {

        EnumMoreSwords swordType = getType(name);

        if (swordType != null) {

            return swordType.swordEfficiency;
        }

        return -1;
    }

    /**
     * Grabs an item used for tool repair.
     * 
     * @param name : name of the swordType.
     * @return Item: the item used for tool repair.
     */
    public static Item getRepairItem(String name) {

        if (Item.itemRegistry.getObject(name) != null) {

            return (Item) Item.itemRegistry.getObject(name);
        }

        else if (Block.blockRegistry.getObject(name) != null) {

            return Item.getItemFromBlock((Block) Block.blockRegistry.getObject(name));
        }

        Reference.LOGGER.info("Null was provided for repair material. There may be issues. " + name);
        return null;
    }
}