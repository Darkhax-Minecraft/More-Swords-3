package net.darkhax.moreswords;

import java.util.List;

import net.darkhax.moreswords.item.SwordItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabMoreSwords extends CreativeTabs {

    CreativeTabMoreSwords(String name) {

        super(name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void displayAllReleventItems(List items) {

        super.displayAllReleventItems(items);
        this.addEnchantmentBooksToList(items, new EnumEnchantmentType[] { MoreSwords.enumSwords });
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {

        return SwordItems.swordAdmin;
    }
}