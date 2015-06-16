package net.darkhax.moreswords.util;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;

public class Utilities {
    
    /**
     * Checks if an entity is within X range of another entity.
     * 
     * @param source : The source entity.
     * @param target : The entity being compared.
     * @param range : The acceptable block range.
     * @return true if target is within the range of the source and not the same entity.
     */
    public static boolean isEntityWithinRange (Entity source, Entity target, double range) {
    
        if (source != target)
            return isEntityWithinRange(target, source.posX, source.posY, source.posZ, range);
        
        return false;
    }
    
    /**
     * Checks if an entity is within X range of given coordinates.
     * 
     * @param target : The target entity.
     * @param x : The source X coord.
     * @param y : The source Y coord.
     * @param z : The source Z coord.
     * @param range : Acceptable range of distance between entity and position.
     * @return true if entity is within distance.
     */
    public static boolean isEntityWithinRange (Entity target, double x, double y, double z, double range) {
    
        double disX = Math.abs(x - target.posX);
        double disY = Math.abs(y - target.posY);
        double disZ = Math.abs(z - target.posZ);
        return (disX + disY + disZ < range);
    }
    
    /**
     * Prepares an ItemStack with a tag compound if one is not already on the tag.
     * 
     * @param stack : The ItemStack being used.
     */
    public static ItemStack prepareStackTag (ItemStack stack) {
    
        if (!stack.hasTagCompound())
            stack.setTagCompound(new NBTTagCompound());
        
        return stack;
    }
    
    /**
     * Returns how much damage an item will initially do to an entity.
     * 
     * @param stack : ItemStack being checked.
     */
    public static double getItemWeaponDamage (ItemStack stack) {
    
        Multimap multimap = stack.getAttributeModifiers();
        if (multimap.containsKey(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName())) {
            
            if (multimap.get(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName()).toArray().length > 0) {
                
                if (multimap.get(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName()).toArray()[0] instanceof AttributeModifier) {
                    
                    AttributeModifier weaponModifier = (AttributeModifier) multimap.get(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName()).toArray()[0];
                    return weaponModifier.getAmount();
                }
            }
        }
        
        return 1;
    }
    
    /**
     * @param world : The world
     * @param player : The player
     * @param length : A cap on the distance
     * @return MovingObjectPosition
     */
    public static MovingObjectPosition rayTrace (World world, EntityPlayer player, int length) {
    
        Vec3 vec1 = Vec3.createVectorHelper(player.posX, player.posY + player.getEyeHeight(), player.posZ);
        Vec3 vec2 = player.getLookVec();
        Vec3 vec3 = vec1.addVector(vec2.xCoord * length, vec2.yCoord * length, vec2.zCoord * length);
        return world.rayTraceBlocks(vec1, vec3);
    }
    
    /**
     * Prepares the stack with a new tag compound if one does not exist. The awakenment tag on
     * the item is then set to true.
     * 
     * @param stack : Instance of the item stack being awakened.
     * @return ItemStack: same instance of the item stack being provided.
     */
    public static ItemStack markStackAsAwakened (ItemStack stack) {
    
        prepareStackTag(stack);
        NBTTagCompound tag = stack.stackTagCompound;
        tag.setBoolean("awakened", true);
        return stack;
    }
    
    /**
     * Retrieves a random integer between the two specified values. The specified values are
     * also possible outputs.
     * 
     * @param min: The lowest possible value.
     * @param max: The highest possible value.
     * @return int: A random integer between the min and the max. Both the min and the max are
     *         included as possible outcomes.
     */
    public static int nextIntII (int min, int max) {
    
        return Constants.RANDOM.nextInt(max - min + 1) + min;
    }
    
    /**
     * Creates an ItemStack using a string based implementation of a string.
     * 
     * @param name: The string based id of the item.
     * @return ItemStack: An ItemStack containing the item/block associated with the string
     *         based id. If no associated item/block as found, fire is returned.
     */
    public static ItemStack getItemFromString (String name) {
    
        if (Item.itemRegistry.getObject(name) != null)
            return new ItemStack((Item) Item.itemRegistry.getObject(name));
        
        else if (Block.blockRegistry.getObject(name) != null)
            return new ItemStack(Item.getItemFromBlock((Block) Block.blockRegistry.getObject(name)));
        
        return new ItemStack(Blocks.fire);
    }
}