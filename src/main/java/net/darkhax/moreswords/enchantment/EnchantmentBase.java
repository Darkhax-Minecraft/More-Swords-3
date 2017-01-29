package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.util.Constants;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class EnchantmentBase extends Enchantment {
    
    /**
     * The maximum level that this enchantment can be found at.
     */
    private int maxLevel;
    
    /**
     * The lowest level that this enchantment can be found at.
     */
    private int minLevel;
    
    /**
     * A special Item that the enchantment is bound to. By default, this enchantment can only
     * be applied to its bound Item.
     */
    private Item item;
    
    /**
     * Constructs a new EnchantmentBase object which is a basic wrapper for the vanilla
     * Enchantment object. This wrapper has some specific logic to help with certain tasks.
     * 
     * @param id: A unique numeric ID for the enchantment. The vanilla range is 0-255.
     * @param weight: The weight for this enchantment. A larger value will make the enchantment
     *            show up more often.
     * @param unlocalizedName: A localization key to use when setting the name of this
     *            enchantment.
     * @param minLevel: The lowest possible level that the enchantment can be found at.
     * @param maxLevel: The highest possible level that the enchantment can be found at.
     * @param item: A special Item that this enchantment is bound to. By default, only this
     *            Item can make use of this enchantment.
     */
    protected EnchantmentBase(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, new ResourceLocation("msm:" + unlocalizedName), weight, Constants.ENCH_TYPE_SWORDS);
        this.name = "msm." + unlocalizedName;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.item = item;
        addToBookList(this);
    }
    
    @Override
    public int getMinLevel () {
        
        return this.minLevel;
    }
    
    @Override
    public int getMaxLevel () {
        
        return this.maxLevel;
    }
    
    @Override
    public boolean canApplyAtEnchantingTable (ItemStack stack) {
        
        return (!ConfigurationHandler.privateEnchant || stack.getItem() == this.item || stack.getItem() == Items.BOOK);
    }
    
    @Override
    public boolean canApply (ItemStack stack) {
        
        return (!ConfigurationHandler.privateEnchant || stack.getItem() == this.item || stack.getItem() == Items.BOOK);
    }
    
    @Override
    public int getMinEnchantability (int level) {
        
        return super.getMinEnchantability(level) + this.getMinEnchantability(level);
    }
    
    @Override
    public int getMaxEnchantability (int level) {
        
        return super.getMaxEnchantability(level) - this.getMinEnchantability(level);
    }
    
    /**
     * A basic check to see if an entity is a valid user of this enchantment effect. A valid
     * user is a user which extends EntityLivingBase, and has a valid held item. That held item
     * must also have this enchantment on it. This check is on a local level, and makes use of
     * information available in the enchantment instance.
     * 
     * @param entity: An instance of the entity to check against.
     * @return boolean: True if the entity can use this enchantment, false if they can not.
     */
    public boolean isValidUser (Entity entity) {
        
        return (entity instanceof EntityLivingBase && ((EntityLivingBase) entity).getHeldItemMainhand() != null && getLevel(((EntityLivingBase) entity).getHeldItemMainhand()) > 0);
    }
    
    /**
     * A simple way to grab the current level of this enchantment from an ItemStack.
     * 
     * @param stack: The instance of ItemStack to check for this enchantment.
     * @return int: The level of this enchantment which is currently on the provided ItemStack.
     *         If the stack does not have this enchantment, 0 will be returned.
     */
    public int getLevel (ItemStack stack) {
        
        return EnchantmentHelper.getEnchantmentLevel(this.effectId, stack);
    }
}