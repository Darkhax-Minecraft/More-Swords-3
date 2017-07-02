package net.darkhax.moreswords.items;

import com.google.common.collect.Multimap;

import net.darkhax.bookshelf.item.ItemSubType;
import net.darkhax.bookshelf.registry.IVariant;
import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.materials.SwordMaterial;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemInertSword extends ItemSubType implements IVariant {
    
    public ItemInertSword () {
        
        super(MoreSwords.MATERIALS.keySet().toArray(new String[MoreSwords.MATERIALS.size()]));
        this.setMaxStackSize(1);
    }
    
    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers (EntityEquipmentSlot equipmentSlot) {
        
        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
        
        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
            
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 2d, 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2.4000000953674316D, 0));
        }
        
        return multimap;
    }
}