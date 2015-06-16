package net.darkhax.moreswords.util;


public class SwordType {
    
    public String swordName;
    public int swordDamage;
    public int swordDurability;
    public int swordEnchantability;
    public int swordHarvestLevel;
    public int swordEfficiency;
    public String swordRepairItem;
    public int swordColor;
    public boolean isCraftable;
    
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
    public SwordType(String name, int damage, int durability, int enchant, int harvest, int efficient, String repairMaterial, boolean isCraftable, int color) {
    
        this.swordName = name;
        this.swordDamage = damage;
        this.swordDurability = durability;
        this.swordEnchantability = enchant;
        this.swordHarvestLevel = harvest;
        this.swordEfficiency = efficient;
        this.swordRepairItem = repairMaterial;
        this.swordColor = color;
        this.isCraftable = isCraftable;
    }
    
    /**
     * Retrieves the name for the sword.
     * 
     * @return String: The value of the swordName field.
     */
    public String getSwordName () {
    
        return swordName;
    }
    
    /**
     * Sets the name for a sword.
     * 
     * @param swordName: The new name for the sword.
     */
    public void setSwordName (String swordName) {
    
        this.swordName = swordName;
    }
    
    /**
     * Retrieves the damage for this sword.
     * 
     * @return int: The damage this sword should deal, as an integer. (5 = 2.5 hearts)
     */
    public int getSwordDamage () {
    
        return swordDamage;
    }
    
    /**
     * Sets the damage for the sword.
     * 
     * @param swordDamage: The new damage value for the sword. (5 = 2.5 hearts)
     */
    public void setSwordDamage (int swordDamage) {
    
        this.swordDamage = swordDamage;
    }
    
    /**
     * Retrieves the durability for the sword.
     * 
     * @return int: The durability value for the sword.
     */
    public int getSwordDurability () {
    
        return swordDurability;
    }
    
    /**
     * Sets the durability value for the sword.
     * 
     * @param swordDurability: The new value for the sword durability.
     */
    public void setSwordDurability (int swordDurability) {
    
        this.swordDurability = swordDurability;
    }
    
    /**
     * Retrieves the enchantability for the sword.
     * 
     * @return int: The enchantability for the sword.
     */
    public int getSwordEnchantability () {
    
        return swordEnchantability;
    }
    
    /**
     * Sets the enchantability for the sword.
     * 
     * @param swordEnchantability: The new enchantability value for the sword.
     */
    public void setSwordEnchantability (int swordEnchantability) {
    
        this.swordEnchantability = swordEnchantability;
    }
    
    /**
     * Retrieves the harvest level for the sword. Not really used in vanilla, mainly for
     * compatibility with other mods.
     * 
     * @return int: The harvest level of the sword.
     */
    public int getSwordHarvestLevel () {
    
        return swordHarvestLevel;
    }
    
    /**
     * Sets the harvest level for the sword. Not really used in vanilla, mainly for
     * compatibility with other mods.
     * 
     * @param swordHarvestLevel: The new harvest level for the sword.
     */
    public void setSwordHarvestLevel (int swordHarvestLevel) {
    
        this.swordHarvestLevel = swordHarvestLevel;
    }
    
    /**
     * Retrieves the efficiency of the sword. Not really used in vanilla, mainly for
     * compatibility with other mods.
     * 
     * @return int: The efficiency for the sword.
     */
    public int getSwordEfficiency () {
    
        return swordEfficiency;
    }
    
    /**
     * Sets the efficiency for the sword.
     * 
     * @param swordEfficiency: The new efficiency value for the sword.
     */
    public void setSwordEfficiency (int swordEfficiency) {
    
        this.swordEfficiency = swordEfficiency;
    }
    
    /**
     * Retrieves the String id for the ItemStack used to repair the sword in an anvil.
     * 
     * @return String: An ItemStack containing the item used to repair the sword.
     */
    public String getSwordRepairItem () {
    
        return swordRepairItem;
    }
    
    /**
     * Sets the String id for the ItemStack used for repairing the sword in an anvil.
     * 
     * @param swordRepairItem: The new repair ItemStack.
     */
    public void setSwordRepairItem (String swordRepairItem) {
    
        this.swordRepairItem = swordRepairItem;
    }
    
    /**
     * Retrieves the color for the sword. This is mainly used in mod compatibility, such as
     * tinkers construct.
     * 
     * @return int: An integer representation of the color for the sword.
     */
    public int getSwordColor () {
    
        return swordColor;
    }
    
    /**
     * Sets the color for the sword. This is mainly used in mod compatibility, such as tinkers
     * construct.
     * 
     * @param swordColor: The new color for the sword.
     */
    public void setSwordColor (int swordColor) {
    
        this.swordColor = swordColor;
    }
    
    /**
     * Checks if the sword should be craftable or not.
     * 
     * @return boolean: Should the sword be craftable.
     */
    public boolean isCraftable () {
    
        return isCraftable;
    }
    
    /**
     * Sets whether or not the sword can be crafted.
     * 
     * @param craftable: Should the sword be craftable.
     */
    public void setCraftable (boolean craftable) {
    
        this.isCraftable = craftable;
    }
}
