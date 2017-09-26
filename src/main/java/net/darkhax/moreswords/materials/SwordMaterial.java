package net.darkhax.moreswords.materials;

import net.darkhax.bookshelf.util.StackUtils;
import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.awakening.Awakening;
import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;

public class SwordMaterial {

    private final String name;
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float damageVsEntity;
    private final int enchantability;
    private final String repair;
    private final Quality type;
    private final double speed;
    private final Awakening awakening;

    private ToolMaterial material;
    private int meta;
    private Item awakenedItem;
    private ItemStack inertItem;
    private ItemStack brokenItem;
    private ItemStack repairStack;

    public SwordMaterial (String name, Quality type, int maxUses, float damage, ItemStack repair, Speed speed, Awakening awakening) {

        this(name, type.harvestLevel, maxUses, type.efficiency, damage, type.enchantability, repair, type, speed.getSpeed(), awakening);
    }

    private SwordMaterial (String name, int harvestLevel, int maxUses, float efficiency, float damageVsEntity, int enchantability, ItemStack repair, Quality type, double speed, Awakening awakening) {

        this.name = name;

        final Configuration config = ConfigurationHandler.config;

        this.harvestLevel = config.getInt("HarvestLevel", name, harvestLevel, 0, Integer.MAX_VALUE, "The harvest level for the " + " sword");
        this.maxUses = config.getInt("Durability", name, maxUses, 1, Integer.MAX_VALUE, "The durability level for the " + "s word");
        this.efficiency = config.getFloat("Efficiency", name, efficiency, 0f, Float.MAX_VALUE, "The efficiency for the " + " sword");
        this.damageVsEntity = config.getFloat("Damage", name, damageVsEntity, 3, Float.MAX_VALUE, "The damage for the " + " sword") - 4f;
        this.enchantability = config.getInt("Enchantability", name, enchantability, 0, Integer.MAX_VALUE, "The enchantability modifier for the " + " sword");
        this.repair = config.getString("Repair", name, StackUtils.writeStackToString(repair), "The item used to repair the " + " sword. format is itemid#meta where meta is optional.");
        this.speed = config.getFloat("WeaponSpeed", name, (float) speed, 0f, 1024f, "The weapon speed of the " + name + " sword.");
        this.awakening = awakening;
        this.awakening.setSwordMaterial(this);
        MinecraftForge.EVENT_BUS.register(this.awakening);
        this.type = type;
        MoreSwords.MATERIALS.put(name, this);
    }

    public ToolMaterial toToolMaterial () {

        if (this.material == null) {

            this.material = EnumHelper.addToolMaterial("MSM_" + this.name.toUpperCase(), this.harvestLevel, this.maxUses, this.efficiency, this.damageVsEntity, this.enchantability);
            
            this.repairStack = StackUtils.createStackFromString(this.repair);
            this.material.setRepairItem(this.repairStack);
        }

        return this.material;
    }

    public ToolMaterial getMaterial () {

        return this.material;
    }

    public String getName () {

        return this.name;
    }

    public int getHarvestLevel () {

        return this.harvestLevel;
    }

    public int getMaxUses () {

        return this.maxUses;
    }

    public float getEfficiency () {

        return this.efficiency;
    }

    public float getDamageVsEntity () {

        return this.damageVsEntity;
    }

    public int getEnchantability () {

        return this.enchantability;
    }

    public String getRepair () {

        return this.repair;
    }

    public Quality getType () {

        return this.type;
    }

    public double getSpeed () {

        return this.speed;
    }

    public int getMeta () {

        return this.meta;
    }

    public void setMeta (int meta) {

        this.meta = meta;
    }

    public Item getAwakenedItem () {

        return this.awakenedItem;
    }

    public void setAwakenedItem (Item awakenedItem) {

        this.awakenedItem = awakenedItem;
    }

    public ItemStack getInertItem () {

        return this.inertItem;
    }

    public void setInertItem (ItemStack inertItem) {

        this.inertItem = inertItem;
    }
    
    public void setBrokenItem (ItemStack inertItem) {

        this.brokenItem = inertItem;
    }
    
    public Awakening getAwakening () {

        return this.awakening;
    }

    public ItemStack getBrokenItem () {
        
        return brokenItem;
    }

    public ItemStack getRepairStack () {
        
        return repairStack;
    }
}