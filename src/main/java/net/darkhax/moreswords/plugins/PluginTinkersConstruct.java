package net.darkhax.moreswords.plugins;

import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.util.EnumMoreSwords;
import net.darkhax.moreswords.util.Reference;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.event.FMLInterModComms;

public class PluginTinkersConstruct {

    public PluginTinkersConstruct(boolean enabled) {
        
        if (enabled) {
            
            for (EnumMoreSwords data : EnumMoreSwords.values()) {
                
                createMaterial(data);
                createPartCastingMaterial(data);
            }
        }
    }

    public static void createMaterial(EnumMoreSwords data) {

        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("Name", "msm." + data.swordName);
        tag.setInteger("Id", ConfigurationHandler.initialIDRange + data.ordinal());
        tag.setInteger("HarvestLevel", data.swordHarvestLevel);
        tag.setInteger("Durability", data.swordDurability / 2);
        tag.setInteger("MiningSpeed", data.swordEfficiency);
        tag.setInteger("Attack", data.swordDamage / 2);
        tag.setFloat("HandleModifier", data.swordDurability / 1000);
        tag.setInteger("Color", data.swordColor);       
        FMLInterModComms.sendRuntimeMessage(Reference.MOD_ID, "TConstruct", "addMaterial", tag);
    }
    
    public static void createPartCastingMaterial(EnumMoreSwords data) {
        
        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("MaterialId", ConfigurationHandler.initialIDRange + data.ordinal());
        tag.setString("FluidName", "msm.fluid." + data.swordName);
        FMLInterModComms.sendRuntimeMessage(Reference.MOD_ID, "TConstruct", "addPartCastingMaterial", tag);
    }
}
