package net.darkhax.moreswords.item;

import java.util.UUID;

import com.google.common.collect.Multimap;

import net.darkhax.moreswords.MoreSwords;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ItemCoreSword extends ItemSword {

	protected static final UUID player = UUID.fromString("5D6F0BA2-1186-46AC-B896-C61C5CEE99CC");
	
	public ItemCoreSword(int id, EnumToolMaterial material) {
	
		super(id, material);
		this.setCreativeTab(MoreSwords.tabSwords);
	}
	
	/* Test code
    public Multimap getItemAttributeModifiers() {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.maxHealth.getAttributeUnlocalizedName(), new AttributeModifier(player, "potion.healthBoost", 23, 0));
        return multimap;
    }
    */
}
