package net.darkhax.moreswords.item;

import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.lib.EnumMoreSwords;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
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