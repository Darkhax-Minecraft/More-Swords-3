package net.darkhax.moreswords.handler;

import net.darkhax.moreswords.enchantment.EnchantmentBase;
import net.darkhax.moreswords.util.Utils;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentBookHandler {

    public EnchantmentBookHandler(boolean enabled) {

        if (enabled && !Loader.isModLoaded("wawla")) {

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