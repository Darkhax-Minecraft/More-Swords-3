package net.darkhax.moreswords.blocks;

import java.util.List;

import org.apache.commons.lang3.text.WordUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.item.SwordItems;
import net.darkhax.moreswords.util.Utils;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ItemBlockCompactSword extends ItemBlock {

	public ItemBlockCompactSword(Block block) {

		super(block);
		setHasSubtypes(true);
		this.setCreativeTab(MoreSwords.tabSwords);
	}

	@Override
	public int getMetadata(int meta) {

		return meta;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack) {

		int i = itemStack.getItemDamage();

		if (i < 0 || i >= SwordItems.swordList.size()) {

			i = 0;
		}

		return super.getUnlocalizedName() + "." + SwordItems.swordList.get(i).swordName;
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
		
		Utils.wrapStringToList(StatCollector.translateToLocal("description.msm.unused"), 38, false, list);
	}
}