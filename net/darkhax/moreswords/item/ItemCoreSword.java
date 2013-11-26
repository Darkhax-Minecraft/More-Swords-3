package net.darkhax.moreswords.item;

import java.util.UUID;

import com.google.common.collect.Multimap;

import net.darkhax.moreswords.MoreSwords;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ItemCoreSword extends ItemSword {

	protected static final UUID player = UUID.fromString("91AEAA56-376B-4498-935B-2F7F68070635");
	
	public ItemCoreSword(int id, EnumToolMaterial material) {
	
		super(id, material);
		this.setCreativeTab(MoreSwords.tabSwords);
	}
}
