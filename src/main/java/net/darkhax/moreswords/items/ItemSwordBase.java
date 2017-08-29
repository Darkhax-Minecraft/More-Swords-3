package net.darkhax.moreswords.items;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import com.google.common.collect.Multimap;

import net.darkhax.moreswords.materials.SwordMaterial;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemSword;

public class ItemSwordBase extends ItemSword {

    private final SwordMaterial material;

    public ItemSwordBase (SwordMaterial material) {

        super(material.toToolMaterial());
        this.material = material;
    }

    @Override
    public Multimap<String, AttributeModifier> getItemAttributeModifiers (EntityEquipmentSlot equipmentSlot) {

        final Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {

            this.replaceModifier(multimap, SharedMonsterAttributes.ATTACK_SPEED, ATTACK_SPEED_MODIFIER, this.material.getSpeed() - 4d);
        }

        return multimap;
    }

    private void replaceModifier (Multimap<String, AttributeModifier> attributes, IAttribute attribute, UUID id, double value) {

        final Collection<AttributeModifier> modifiers = attributes.get(attribute.getName());
        final Optional<AttributeModifier> modifierOptional = modifiers.stream().filter(modifier -> modifier.getID().equals(id)).findFirst();

        if (modifierOptional.isPresent()) {

            final AttributeModifier modifier = modifierOptional.get();
            modifiers.remove(modifier);
            modifiers.add(new AttributeModifier(modifier.getID(), modifier.getName(), value, modifier.getOperation()));
        }
    }
}
