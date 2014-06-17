package net.darkhax.moreswords.blocks;

import java.util.List;

import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.item.SwordItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCompactSword extends Block {
	
	private IIcon[] iconArray;

	public BlockCompactSword() {	
		
		super(Material.iron);
		this.setCreativeTab(MoreSwords.tabSwords);
	}
	
	@Override
	public int damageDropped(int meta) {
		
		return meta;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int par1, int par2) {
		
		return this.iconArray[par2 % this.iconArray.length];
	}

	@SideOnly(Side.CLIENT)
	@Override
    public void registerBlockIcons(IIconRegister ir) {
		
        this.iconArray = new IIcon[SwordItems.swordList.size()];

        for (int i = 0; i < this.iconArray.length; ++i) {
        	
            this.iconArray[i] = ir.registerIcon("moreswords:block_" + SwordItems.swordList.get(i).swordName);
        }
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list){
		
		for (int i = 0; i < SwordItems.swordList.size(); ++i) {
			
			list.add(new ItemStack(block, 1, i));
		}
	}
}