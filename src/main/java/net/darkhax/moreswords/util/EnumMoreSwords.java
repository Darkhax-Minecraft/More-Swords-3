package net.darkhax.moreswords.util;

import net.minecraft.item.Item;

public enum EnumMoreSwords {

    DAWNSTAR("dawnStar", Config.damageDawnStar, Config.durabilityDawnStar, Config.enchantDawnStar, Config.harvestDawnStar, Config.efficientDawnStar, Config.repairDawnStar, Config.craftingDawnStar),
    VAMPIRIC("vampiric", Config.damageVampiric, Config.durabilityVampiric, Config.enchantVampiric, Config.harvestVampiric, Config.efficientVampiric, Config.repairVampiric, Config.craftingVampiric),
    GLADIOLUS("gladiolus", Config.damageGladiolus, Config.durabilityGladiolus, Config.enchantGladiolus, Config.harvestGladiolus, Config.efficientGladiolus, Config.repairGladiolus, Config.craftingGladiolus),
    DRACONIC("draconic", Config.damageDraconic, Config.durabilityDraconic, Config.enchantDraconic, Config.harvestDraconic, Config.efficientDraconic, Config.repairDraconic, Config.craftingDraconic),
    ENDER("ender", Config.damageEnder, Config.durabilityEnder, Config.enchantEnder, Config.harvestEnder, Config.efficientEnder, Config.repairEnder, Config.craftingEnder),
    CRYSTAL("crystal", Config.damageCrystal, Config.durabilityCrystal, Config.enchantCrystal, Config.harvestCrystal, Config.efficientCrystal, Config.repairCrystal, Config.craftingCrystal),
    INFINITY("infinity", Config.damageInfinity, Config.durabilityInfinity, Config.enchantInfinity, Config.harvestInfinity, Config.efficientInfinity, Config.repairInfinity, Config.craftingInfinity),
    GLACIAL("glacial", Config.damageGlacial, Config.durabilityGlacial, Config.enchantGlacial, Config.harvestGlacial, Config.efficientGlacial, Config.repairGlacial, Config.craftingGlacial),
    AETHER("aether", Config.damageAether, Config.durabilityAether, Config.enchantAether, Config.harvestAether, Config.efficientAether, Config.repairAether, Config.craftingAether),
    WITHER("wither", Config.damageWither, Config.durabilityWither, Config.enchantWither, Config.harvestWither, Config.efficientWither, Config.repairWither, Config.craftingWither),
    ADMIN("admin", Config.damageAdmin, Config.durabilityAdmin, Config.enchantAdmin, Config.harvestAdmin, Config.efficientAdmin, Config.repairAdmin, Config.craftingAdmin)
    ;

    /**
     * @param repairMaterial: name of the item used to repair the sword.
     */
    
    /**
     * Creates An enum type similar to tool material but for use with ItemCoreSword.
     * @param name: A name used to identify the sword by.
     * @param damage: The damage value for a sword.
     * @param durability: The durability value for a sword.
     * @param enchant: The enchantability value for a sword.
     * @param harvest: The level this tool can harvest.
     * @param efficient: How fast this tool breaks blocks.
     * @param repairMaterial: Item used to repair in anvil.
     * @param isCraftable: Is this item craftable.
     */
    private EnumMoreSwords(String name, int damage, int durability, int enchant, int harvest, int efficient, String repairMaterial, boolean isCraftable) {
        
    	this.swordName = name;
    	this.swordDamage = damage;
    	this.swordDurability = durability;
    	this.swordEnchantability = enchant;
    	this.swordHarvestLevel = harvest;
    	this.swordEfficiency = efficient;
    	this.swordRepairItem = repairMaterial;
    }

    public String swordName;
    public int swordDamage;
    public int swordDurability;
    public int swordEnchantability;
    public int swordHarvestLevel;
    public int swordEfficiency;
    public String swordRepairItem;

    /**
     * Get a swordType from the list of enums.
     * @param name: The name of the sword being looked up.
     * @return EnumMoreSwords: An instance of the enum based off of the name.
     */
    public static EnumMoreSwords getType(String name) {

        for(EnumMoreSwords swordType : values()) {

            if(swordType.swordName.equalsIgnoreCase(name)) {

                return swordType;
            }
        }

        Reference.LOGGER.info("There was an error when attempting to look up " + name);
        return null;
    }

    /**
     * Grabs a damage value from a swordType.
     * @param name: the name of the swordType.
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
     * @param name: the name of the swordType.
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
     * @param name: the name of the swordType
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
     * @param name: the name for the swordType
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
     * @param name: the name for the swordType
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
     * @param name: name of the swordType.
     * @return Item: the item used for tool repair.
     */
    public static Item getRepairItem(String name) {
    	
    	EnumMoreSwords swordType = getType(name);
    	
    	if (swordType != null) {
    		
    		return (Item) Item.itemRegistry.getObject(swordType.swordRepairItem);
    	}
    	
    	return null;
    }
}