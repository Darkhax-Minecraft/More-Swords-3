package net.darkhax.moreswords.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.util.Utils;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;

public class ItemSwordIngots extends Item {
	
	public static IIcon[] iconArray;
	
	public ItemSwordIngots() {
		
		this.setCreativeTab(MoreSwords.tabSwords);
		this.hasSubtypes = true;
	}
	
	@Override
    public String getUnlocalizedName(ItemStack stack) {
    	
        return "item.msm.ingot." + SwordItems.swordList.get(stack.getItemDamage()).swordName;
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {

        iconArray = new IIcon[SwordItems.swordList.size()];

        for (int i = 0; i < iconArray.length; ++i) {

            iconArray[i] = register.registerIcon("moreswords:" + "ingot_" + SwordItems.swordList.get(i).swordName);
        }
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconIndex(ItemStack stack) {
		
        return iconArray[stack.getItemDamage()];
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list) {

        for (int i = 0; i < SwordItems.swordList.size(); i++) {
        	
            list.add(new ItemStack(SwordItems.ingots, 1, i));
        }
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
		
		Utils.wrapStringToList(StatCollector.translateToLocal("description.msm.unused"), 38, false, list);
	}
}