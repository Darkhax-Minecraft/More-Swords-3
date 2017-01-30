package net.darkhax.moreswords.util;

import com.google.common.collect.Multimap;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class Utils {
    
    /**
     * Checks if an entity is within X range of another entity.
     * 
     * @param source: The source entity.
     * @param target: The entity being compared.
     * @param range: The acceptable block range.
     */
    public static boolean isEntityWithinRange (Entity source, Entity target, double range) {
        
        if (isEntityWithinRange(target, source.posX, source.posY, source.posZ, range)) {
            
            if (source != target)
                return true;
        }
        
        return false;
    }
    
    /**
     * Checks if an entity is within X range of given coordinates.
     * 
     * @param target: The target entity.
     * @param x: The source X coord.
     * @param y: The source Y coord.
     * @param z: The source Z coord.
     * @param range: Acceptable range of distance between entity and position.
     */
    public static boolean isEntityWithinRange (Entity target, double x, double y, double z, double range) {
        
        double disX = Math.abs(x - target.posX);
        double disY = Math.abs(y - target.posY);
        double disZ = Math.abs(z - target.posZ);
        
        if ((disX + disY + disZ < range))
            return true;
            
        return false;
    }
    
    /**
     * Prepares an ItemStack with a tag compound if one is not already on the tag.
     * 
     * @param stack: The ItemStack being used.
     */
    public static ItemStack prepareStackTag (ItemStack stack) {
        
        if (!stack.hasTagCompound())
            stack.setTagCompound(new NBTTagCompound());
            
        return stack;
    }
    
    /**
     * Creates a MovingObjectPosition based on an EntityPlayer object, allows for limited
     * range.
     * @param <MovingObjectPosition>
     * 
     * @param player: The instance of a player which is being used.
     * @param length: A limit placed on the range. Normal reach is 4.5.
     */
    public static <MovingObjectPosition> MovingObjectPosition rayTrace (EntityPlayer player, int length) {
        
        if (player != null) {
            
            Vec3d vec1 = new Vec3d(player.posX, player.posY + player.getEyeHeight(), player.posZ);
            net.minecraft.util.math.Vec3d vec2 = player.getLookVec();
            Vec3d vec3 = vec1.addVector(vec2.xCoord * length, vec2.yCoord * length, vec2.zCoord * length);
            
            return (MovingObjectPosition) player.world.rayTraceBlocks(vec1, vec3);
        }
        
        return null;
    }
    
    /**
     * Retrieves the damage value for a specific ItemStack. This will take the base damage of
     * an item along with any special damage attributes associated with the item. Most items
     * will do just 1 damage. May have some wild and fun affects :)
     * 
     * @param stack: The ItemStack that you would like to retrieve the information from.
     */
    public static double getItemWeaponDamage (ItemStack stack) {
        
    	//TODO Potential Problem
        Multimap<String, ?> multimap = stack.getAttributeModifiers(EntityEquipmentSlot.MAINHAND);
        if (multimap.containsKey(SharedMonsterAttributes.ATTACK_DAMAGE.getName()))
            if (multimap.get(SharedMonsterAttributes.ATTACK_DAMAGE.getName()).toArray().length > 0)
                if (multimap.get(SharedMonsterAttributes.ATTACK_DAMAGE.getName()).toArray()[0] instanceof AttributeModifier) {
                    
                    AttributeModifier weaponModifier = (AttributeModifier) multimap.get(SharedMonsterAttributes.ATTACK_DAMAGE.getName()).toArray()[0];
                    return weaponModifier.getAmount();
                }
                
        return 1;
    }
    
    /**
     * Prepares the stack with a new tag compound if one does not exist. The awakenment tag on
     * the item is then set to true.
     * 
     * @param stack: Instance of the item stack being awakened.
     */
    public static ItemStack markStackAsAwakened (ItemStack stack) {
        
        prepareStackTag(stack);
        NBTTagCompound tag = stack.getTagCompound();
        tag.setBoolean("awakened", true);
        return stack;
    }
    
    /**
     * Returns a random value between the two provided integers. Both the minimum and maximum
     * value are possible results.
     * 
     * @param min: The smallest possible value.
     * @param max: The largest possible value.
     */
    public static int nextIntII (int min, int max) {
        
        return Constants.RND.nextInt(max - min + 1) + min;
    }
    
    /**
     * Easy way to calculate whether an outcome succeeds or not. Very basic calculation, uses
     * Math.random() to generate a random random double. If that double is less than or equal
     * to the provided percentage, then the event was successful. If the random double is
     * greater than the percent chance, then it failed.
     * 
     * @param chance: The percent chance of this outcome being true. 1 represents 100% while 0
     *            represents 0%. 0.8 would represent 80%.
     * @return boolean: The outcome of the event, true is a success and false is a failure.
     */
    public static boolean percentChance (double chance) {
        
        return (Math.random() <= chance);
    }
}