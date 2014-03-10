package net.darkhax.moreswords.item;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.lib.EnumMoreSwords;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class ItemCoreSword extends ItemSword {
	
	private final String swordName;

	public ItemCoreSword(String swordName) {
		
		super(generateToolMaterials(swordName));
		this.swordName = swordName;
		this.setTextureName("moreswords:sword_" + swordName);
		this.setUnlocalizedName("msm."+ swordName);
		this.setCreativeTab(MoreSwords.tabSwords);
	}
	
	/**
	 * Creates an EnumToolMaterial using values from an EnumMoreSwords
	 * @param swordName: Name of the sword for lookup.
	 * @return EnumToolMaterial: Enum for tool properties.
	 */
	public static Item.ToolMaterial generateToolMaterials(String swordName) {
		
		EnumMoreSwords sword = EnumMoreSwords.getType(swordName);
		return EnumHelper.addToolMaterial(swordName, sword.swordHarvestLevel, sword.swordDurability, sword.swordEfficiency, sword.swordDamage - 4, sword.swordEnchantability);
	}
}