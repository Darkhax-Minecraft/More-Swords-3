package net.darkhax.moreswords;

import java.util.List;

import net.darkhax.moreswords.item.SwordItems;
import net.darkhax.moreswords.util.Constants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabMoreSwords extends CreativeTabs {
    
    public CreativeTabMoreSwords() {
        
        super("moreSwords");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void displayAllRelevantItems(List<ItemStack> items) {
        
        super.displayAllRelevantItems(items);
        this.addEnchantmentBooksToList(items, new EnumEnchantmentType[] { Constants.ENCH_TYPE_SWORDS });
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem () {
        
        return SwordItems.swordAdmin;
    }
}