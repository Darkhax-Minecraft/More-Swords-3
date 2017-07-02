package net.darkhax.moreswords.materials;

public enum Quality {
    
    BASIC(1, 5, 4f),
    UNCOMMON(2, 10, 6f),
    RARE(3, 15, 8f),
    EPIC(4, 20, 10f);
    
    public final int harvestLevel;
    public final int enchantability;
    public final float efficiency;
    
    Quality (int harvest, int enchant, float efficiency) {
        
        this.harvestLevel = harvest;
        this.enchantability = enchant;
        this.efficiency = efficiency;
    }
}