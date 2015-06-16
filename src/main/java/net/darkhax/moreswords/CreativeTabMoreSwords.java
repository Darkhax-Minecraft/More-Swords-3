package net.darkhax.moreswords;

import java.util.List;

import net.darkhax.moreswords.item.SwordItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabMoreSwords extends CreativeTabs {
    
    CreativeTabMoreSwords(int id, String name) {
    
        super(id, name);
    }
    
    @SideOnly(Side.CLIENT)
    public void displayAllReleventItems (List items) {
    
        super.displayAllReleventItems(items);
        this.addEnchantmentBooksToList(items, new EnumEnchantmentType[] { MoreSwords.enumSwords });
    }
    
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem () {
    
        return SwordItems.swordList.get("dawnstar");
    }
}