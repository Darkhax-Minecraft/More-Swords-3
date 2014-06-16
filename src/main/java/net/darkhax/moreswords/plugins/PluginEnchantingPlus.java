package net.darkhax.moreswords.plugins;

import net.darkhax.moreswords.enchantment.EnchantmentBase;
import net.darkhax.moreswords.util.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.common.event.FMLInterModComms;

/**
 * Added support for e+, it's not really working so it's been put on the back burner. 
 */
public class PluginEnchantingPlus {

	public PluginEnchantingPlus(Boolean enabled) {
		
		if (enabled) {
			
			for (Enchantment enchant:EnchantmentBase.enchantments) {
				
				NBTTagCompound ench = new NBTTagCompound();
				ench.setString("Name", enchant.getName());
				ench.setString("Description", StatCollector.translateToLocal("description.msm.enchantment" + enchant.getName().substring(16)));
				FMLInterModComms.sendRuntimeMessage(Reference.MOD_ID, "eplus", "enchant-tooltip", ench);
			}
		}
	}
}