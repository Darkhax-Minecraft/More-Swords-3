package net.darkhax.moreswords.awakening;

import net.darkhax.moreswords.items.ItemInertSword;
import net.darkhax.moreswords.materials.SwordMaterial;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;

public abstract class Awakening {
    
    private SwordMaterial material;
    
    public abstract int getAwakenProgress(ItemStack stack, NBTTagCompound tag);
    public abstract boolean canAwaken (ItemStack stack);
    
    public void awaken(EntityLivingBase entity) {
        
        if (!entity.getHeldItemMainhand().isEmpty()) {
            
            ItemStack held = entity.getHeldItemMainhand();
            ItemStack stack = new ItemStack(this.material.getAwakenedItem());
            
            stack.setTagCompound(held.getTagCompound());
            entity.setHeldItem(EnumHand.MAIN_HAND, stack);
        }
    }
    
    public boolean isValidItem(ItemStack stack) {
        
        return stack != null && !stack.isEmpty() && stack.getItem() instanceof ItemInertSword && stack.getMetadata() == material.getMeta();
    }
    
    public void setSwordMaterial(SwordMaterial material) {
        
        this.material = material;
    }
}