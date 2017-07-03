package net.darkhax.moreswords.items;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Multimap;

import net.darkhax.bookshelf.item.ItemSubType;
import net.darkhax.bookshelf.registry.IVariant;
import net.darkhax.bookshelf.util.StackUtils;
import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.awakening.AwakenDawnStar;
import net.darkhax.moreswords.awakening.Awakening;
import net.darkhax.moreswords.materials.SwordMaterial;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemInertSword extends ItemSubType implements IVariant {
    
    public ItemInertSword () {
        
        super(MoreSwords.MATERIALS.keySet().toArray(new String[MoreSwords.MATERIALS.size()]));
        this.setMaxStackSize(1);
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        
        tooltip.add(I18n.format("misc.moreswords.progress", getSwordMaterial(stack).getAwakening().getAwakenProgress(stack, StackUtils.prepareStackTag(stack))));
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
    
    public SwordMaterial getSwordMaterial(ItemStack stack) {
        
        return MoreSwords.MATERIALS.get(this.getVariant()[stack.getMetadata()]);
    }
}