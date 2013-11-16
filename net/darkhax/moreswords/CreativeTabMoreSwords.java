package net.darkhax.moreswords;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;

import net.darkhax.moreswords.item.Items;
import net.darkhax.moreswords.lib.EnumManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.Item;

public class CreativeTabMoreSwords extends CreativeTabs {
        
    CreativeTabMoreSwords(int id, String name) {
    	
        super(id, name);
    }

    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex() {
    	
        return Items.swordAdmin.itemID;
    }

    @SideOnly(Side.CLIENT)
    public void displayAllReleventItems(List items) {
    	
        super.displayAllReleventItems(items);
        this.addEnchantmentBooksToList(items, new EnumEnchantmentType[] {EnumManager.enumSwords});
    }
}