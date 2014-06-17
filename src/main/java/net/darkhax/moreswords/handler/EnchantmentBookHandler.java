package net.darkhax.moreswords.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.darkhax.moreswords.enchantment.EnchantmentBase;
import net.darkhax.moreswords.util.Utils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

public class EnchantmentBookHandler {

	public EnchantmentBookHandler(boolean enabled) {
		
		if (enabled) {
			
			MinecraftForge.EVENT_BUS.register(this);
		}
	}
	
	@SubscribeEvent
	public void onInfoDisplayed(ItemTooltipEvent event) {
		
		if (event.showAdvancedItemTooltips) {
			
			if (event.itemStack.getItem() instanceof ItemEnchantedBook) {
				
				Enchantment[] enchlist = Utils.getStoredEnchantmentsFromStack(event.itemStack);
				for (int i = 0; i < enchlist.length; i++) {
					
					if (enchlist[i] instanceof EnchantmentBase) {
						
						Utils.wrapStringToList(StatCollector.translateToLocal("description." + enchlist[i].getName()), 38, false, event.toolTip);
					}
				}
			}
		}
	}
}