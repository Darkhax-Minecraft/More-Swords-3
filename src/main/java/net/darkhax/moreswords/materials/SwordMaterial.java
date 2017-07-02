package net.darkhax.moreswords.materials;

import java.util.HashMap;
import java.util.Map;

import net.darkhax.bookshelf.util.StackUtils;
import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

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
    private ToolMaterial material;
    
    public SwordMaterial (String name, Quality type, int maxUses, float damage, ItemStack repair, Speed speed) {
        
        this(name, type.harvestLevel, maxUses, type.efficiency, damage, type.enchantability, repair, type, speed.getSpeed());
    }
    
    private SwordMaterial (String name, int harvestLevel, int maxUses, float efficiency, float damageVsEntity, int enchantability, ItemStack repair, Quality type, double speed) {
        
        this.name = name;
        
        final Configuration config = ConfigurationHandler.config;
        
        this.harvestLevel = config.getInt("HarvestLevel", name, harvestLevel, 0, Integer.MAX_VALUE, "The harvest level for the " + " sword");
        this.maxUses = config.getInt("Durability", name, maxUses, 1, Integer.MAX_VALUE, "The durability level for the " + "s word");
        this.efficiency = config.getFloat("Efficiency", name, efficiency, 0f, Float.MAX_VALUE, "The efficiency for the " + " sword");
        this.damageVsEntity = config.getFloat("Damage", name, damageVsEntity, 3, Float.MAX_VALUE, "The damage for the " + " sword") - 4f;
        this.enchantability = config.getInt("Enchantability", name, enchantability, 0, Integer.MAX_VALUE, "The enchantability modifier for the " + " sword");
        this.repair = config.getString("Repair", name, StackUtils.writeStackToString(repair), "The item used to repair the " + " sword. format is itemid#meta where meta is optional.");
        this.speed = (double) config.getFloat("WeaponSpeed", name, (float) speed, 0f, 1024f, "The weapon speed of the " + name + " sword.");
        this.type = type;
        MoreSwords.MATERIALS.put(name, this);
    }
    
    public ToolMaterial toToolMaterial () {
        
        if (this.material == null) {
            
            this.material = EnumHelper.addToolMaterial("MSM_" + this.name.toUpperCase(), this.harvestLevel, this.maxUses, this.efficiency, this.damageVsEntity, this.enchantability);
            this.material.setRepairItem(StackUtils.createStackFromString(this.repair));
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
        
        return type;
    }
    
    public double getSpeed () {
        
        return speed;
    }
}