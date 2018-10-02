package net.darkhax.moreswords.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CreativeTabMoreSwords extends CreativeTabs {

    public CreativeTabMoreSwords () {

        super("moreswords");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack createIcon () {

        return new ItemStack(Items.DIAMOND_SWORD);
    }
}