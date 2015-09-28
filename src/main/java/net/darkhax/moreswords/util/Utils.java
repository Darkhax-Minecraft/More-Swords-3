package net.darkhax.moreswords.util;

import java.util.Random;

import com.google.common.collect.Multimap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class Utils {

    /**
     * Checks if an entity is within X range of another entity.
     * 
     * @param source: The source entity.
     * @param target: The entity being compared.
     * @param range: The acceptable block range.
     */
    public static boolean isEntityWithinRange(Entity source, Entity target, double range) {

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
    public static boolean isEntityWithinRange(Entity target, double x, double y, double z, double range) {

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
    public static ItemStack prepareStackTag(ItemStack stack) {

        if (!stack.hasTagCompound())
            stack.setTagCompound(new NBTTagCompound());

        return stack;
    }

    /**
     * Creates a MovingObjectPosition based on an EntityPlayer object, allows for limited range.
     * 
     * @param player: The instance of a player which is being used.
     * @param length: A limit placed on the range. Normal reach is 4.5.
     */
    public static MovingObjectPosition rayTrace(EntityPlayer player, int length) {

        if (player != null) {

            Vec3 vec1 = new Vec3(player.posX, player.posY + player.getEyeHeight(), player.posZ);
            Vec3 vec2 = player.getLookVec();
            Vec3 vec3 = vec1.addVector(vec2.xCoord * length, vec2.yCoord * length, vec2.zCoord * length);

            return player.worldObj.rayTraceBlocks(vec1, vec3);
        }

        return null;
    }

    /**
     * Retrieves the damage value for a specific ItemStack. This will take the base damage of an item
     * along with any special damage attributes associated with the item. Most items will do just 1
     * damage. May have some wild and fun affects :)
     * 
     * @param stack: The ItemStack that you would like to retrieve the information from.
     */
    public static double getItemWeaponDamage(ItemStack stack) {

        Multimap multimap = stack.getAttributeModifiers();
        if (multimap.containsKey(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName()))
            if (multimap.get(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName()).toArray().length > 0)
                if (multimap.get(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName()).toArray()[0] instanceof AttributeModifier) {

                    AttributeModifier weaponModifier = (AttributeModifier) multimap.get(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName()).toArray()[0];
                    return weaponModifier.getAmount();
                }

        return 1;
    }

    /**
     * Prepares the stack with a new tag compound if one does not exist. The awakenment tag on the item
     * is then set to true.
     * 
     * @param stack: Instance of the item stack being awakened.
     */
    public static ItemStack markStackAsAwakened(ItemStack stack) {

        prepareStackTag(stack);
        NBTTagCompound tag = stack.getTagCompound();
        tag.setBoolean("awakened", true);
        return stack;
    }

    public static class RandomUtils extends Random {

        /**
         * Returns a random value between the two provided integers. Both the minimum and maximum value
         * are possible results.
         * 
         * @param min: The smallest possible value.
         * @param max: The largest possible value.
         */
        public int nextIntII(int min, int max) {

            return nextInt(max - min + 1) + min;
        }
    }

}