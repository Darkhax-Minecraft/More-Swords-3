package net.darkhax.moreswords.awakening;

import net.darkhax.bookshelf.util.StackUtils;
import net.darkhax.moreswords.items.ItemInertSword;
import net.darkhax.moreswords.materials.SwordMaterial;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public abstract class Awakening {

    private SwordMaterial material;

    public abstract int getAwakenProgress (EntityLivingBase livingSource, ItemStack stack, NBTTagCompound tag);

    public boolean canAwaken (EntityLivingBase livingSource, ItemStack stack) {

        return this.getAwakenProgress(livingSource, stack, StackUtils.prepareStackTag(stack)) >= 100;
    }

    public void awaken (EntityLivingBase entity) {

        if (!entity.getHeldItemMainhand().isEmpty()) {

            final ItemStack held = entity.getHeldItemMainhand();
            final ItemStack stack = new ItemStack(this.material.getAwakenedItem());

            stack.setTagCompound(held.getTagCompound());
            entity.setHeldItem(EnumHand.MAIN_HAND, stack);
        }
    }

    public boolean isValidItem (ItemStack stack) {

        return stack != null && !stack.isEmpty() && stack.getItem() instanceof ItemInertSword && stack.getMetadata() == this.material.getMeta();
    }

    public void setSwordMaterial (SwordMaterial material) {

        this.material = material;
    }
    
    public SwordMaterial getMaterial() {
    	
    	return this.material;
    }
    
    public void onHolderTick(EntityPlayer holder, ItemStack stack) {
    	
    }
    
    public void onHolderAttack(EntityPlayer holder, EntityLivingBase victim, ItemStack stack, LivingHurtEvent event) {
    	
    }
    
    public void onHolderKill(EntityPlayer holder, EntityLivingBase victim, ItemStack stack) {
    	
    }
    
    public void onHolderRightClick(EntityPlayer holder, ItemStack stack, boolean isBlock) {
    	
    }
    
    public void onHolderGetsDrops(EntityPlayer holder, LivingDropsEvent event) {
    	
    }
    
    public void onHolderPickup(EntityPlayer holder, EntityItemPickupEvent event) {
    	
    }
}