package net.darkhax.moreswords.item;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.util.Constants;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;

public class ItemBaseSword extends ItemSword {
    
    public final String swordName;
    
    public ItemBaseSword(String swordName) {
        
        super(generateToolMaterials(swordName));
        this.swordName = swordName;
        this.setUnlocalizedName("msm." + swordName);
        this.setCreativeTab(Constants.TAB_SWORDS);
        SwordItems.registerSwordItem(this);
    }
    
    /**
     * Generates a ToolMaterial from a SwordMaterial. The SwordMaterial is retrieved based on
     * the provided name.
     * 
     * @param swordName: The name of the sword material type.
     * @return ToolMaterial: A ToolMaterial which can be used for a new ItemSword.
     */
    public static Item.ToolMaterial generateToolMaterials (String swordName) {
        
        SwordMaterial sword = SwordMaterial.getType(swordName);
        Item.ToolMaterial material = EnumHelper.addToolMaterial(swordName, sword.swordHarvestLevel, sword.swordDurability, sword.swordEfficiency, sword.swordDamage - 4, sword.swordEnchantability);
        
        if (ConfigurationHandler.itemsRepairable)
            material.customCraftingMaterial = sword.swordRepairItem;
            
        return material;
    }
    
    public static enum SwordMaterial {
        
        DAWNSTAR("dawnstar", ConfigurationHandler.damageDawnStar, ConfigurationHandler.durabilityDawnStar, ConfigurationHandler.enchantDawnStar, ConfigurationHandler.harvestDawnStar, ConfigurationHandler.efficientDawnStar, ConfigurationHandler.repairDawnStar, ConfigurationHandler.craftingDawnStar, 13390336),
        VAMPIRIC("vampiric", ConfigurationHandler.damageVampiric, ConfigurationHandler.durabilityVampiric, ConfigurationHandler.enchantVampiric, ConfigurationHandler.harvestVampiric, ConfigurationHandler.efficientVampiric, ConfigurationHandler.repairVampiric, ConfigurationHandler.craftingVampiric, 9371648),
        GLADIOLUS("gladiolus", ConfigurationHandler.damageGladiolus, ConfigurationHandler.durabilityGladiolus, ConfigurationHandler.enchantGladiolus, ConfigurationHandler.harvestGladiolus, ConfigurationHandler.efficientGladiolus, ConfigurationHandler.repairGladiolus, ConfigurationHandler.craftingGladiolus, 20992),
        DRACONIC("draconic", ConfigurationHandler.damageDraconic, ConfigurationHandler.durabilityDraconic, ConfigurationHandler.enchantDraconic, ConfigurationHandler.harvestDraconic, ConfigurationHandler.efficientDraconic, ConfigurationHandler.repairDraconic, ConfigurationHandler.craftingDraconic, 4671441),
        ENDER("ender", ConfigurationHandler.damageEnder, ConfigurationHandler.durabilityEnder, ConfigurationHandler.enchantEnder, ConfigurationHandler.harvestEnder, ConfigurationHandler.efficientEnder, ConfigurationHandler.repairEnder, ConfigurationHandler.craftingEnder, 2386759),
        CRYSTAL("crystal", ConfigurationHandler.damageCrystal, ConfigurationHandler.durabilityCrystal, ConfigurationHandler.enchantCrystal, ConfigurationHandler.harvestCrystal, ConfigurationHandler.efficientCrystal, ConfigurationHandler.repairCrystal, ConfigurationHandler.craftingCrystal, 13434828),
        GLACIAL("glacial", ConfigurationHandler.damageGlacial, ConfigurationHandler.durabilityGlacial, ConfigurationHandler.enchantGlacial, ConfigurationHandler.harvestGlacial, ConfigurationHandler.efficientGlacial, ConfigurationHandler.repairGlacial, ConfigurationHandler.craftingGlacial, 6737151),
        AETHER("aether", ConfigurationHandler.damageAether, ConfigurationHandler.durabilityAether, ConfigurationHandler.enchantAether, ConfigurationHandler.harvestAether, ConfigurationHandler.efficientAether, ConfigurationHandler.repairAether, ConfigurationHandler.craftingAether, 6750207),
        WITHER("wither", ConfigurationHandler.damageWither, ConfigurationHandler.durabilityWither, ConfigurationHandler.enchantWither, ConfigurationHandler.harvestWither, ConfigurationHandler.efficientWither, ConfigurationHandler.repairWither, ConfigurationHandler.craftingWither, 657930),
        // LuxBrand("lux", ConfigurationHandler.damageLuxBrand,
        // ConfigurationHandler.durabilityLuxBrand, ConfigurationHandler.enchantLuxBrand,
        // ConfigurationHandler.harvestLuxBrand, ConfigurationHandler.efficientLuxBrand,
        // ConfigurationHandler.repairLuxBrand, ConfigurationHandler.craftingLuxBrand,
        // 11564112),
        ADMIN("admin", ConfigurationHandler.damageAdmin, ConfigurationHandler.durabilityAdmin, ConfigurationHandler.enchantAdmin, ConfigurationHandler.harvestAdmin, ConfigurationHandler.efficientAdmin, ConfigurationHandler.repairAdmin, ConfigurationHandler.craftingAdmin, 3342336);
        
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
        private SwordMaterial(String name, int damage, int durability, int enchant, int harvest, int efficient, String repairMaterial, boolean isCraftable, int color) {
            
            this.swordName = name;
            this.swordDamage = damage;
            this.swordDurability = durability;
            this.swordEnchantability = enchant;
            this.swordHarvestLevel = harvest;
            this.swordEfficiency = efficient;
            this.swordRepairItem = getRepairItem(repairMaterial);
            this.swordColor = color;
        }
        
        public String swordName;
        public int swordDamage;
        public int swordDurability;
        public int swordEnchantability;
        public int swordHarvestLevel;
        public int swordEfficiency;
        public Item swordRepairItem;
        public int swordColor;
        
        /**
         * Get a swordType from the list of enums.
         * 
         * @param name : The name of the sword being looked up.
         * @return EnumMoreSwords: An instance of the enum based off of the name.
         */
        public static SwordMaterial getType (String name) {
            
            for (SwordMaterial swordType : values()) {
                
                if (swordType.swordName.equalsIgnoreCase(name)) {
                    
                    return swordType;
                }
            }
            
            Constants.LOGGER.info("There was an error when attempting to look up " + name);
            return null;
        }
        
        /**
         * Grabs a damage value from a swordType.
         * 
         * @param name : the name of the swordType.
         * @return int: The damage value for the swordType.
         */
        public static int getDamage (String name) {
            
            SwordMaterial swordType = getType(name);
            
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
        public static int getDurability (String name) {
            
            SwordMaterial swordType = getType(name);
            
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
        public static int getEnchantability (String name) {
            
            SwordMaterial swordType = getType(name);
            
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
        public static int getHarvestLevel (String name) {
            
            SwordMaterial swordType = getType(name);
            
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
        public static int getEfficiency (String name) {
            
            SwordMaterial swordType = getType(name);
            
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
        public static Item getRepairItem (String name) {
            
            Item item = Item.itemRegistry.getObject(new ResourceLocation(name));
            
            if (item == null)
                item = Item.getItemFromBlock((Block) Block.blockRegistry.getObject(new ResourceLocation(name)));
                
            if (item != null)
                return item;
                
            Constants.LOGGER.info("Null was provided for repair material. There may be issues. " + name);
            return null;
        }
    }
}