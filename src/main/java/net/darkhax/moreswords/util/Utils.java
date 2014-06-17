package net.darkhax.moreswords.util;

import java.awt.FontMetrics;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.text.WordUtils;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;

public class Utils {

	/**
	 * Checks if an entity is within X range of another entity.
	 * @param source: The source entity.
	 * @param target: The entity being compared.
	 * @param range: The acceptable block range.
	 * @return true if target is within the range of the source and not the same entity.
	 */
	public static boolean isEntityWithinRange(Entity source, Entity target, double range) {

		if (isEntityWithinRange(target, source.posX, source.posY, source.posZ, range)) {

			if (source != target) {

				return true;
			}
		}

		return false;
	}

	/**
	 * Checks if an entity is within X range of given coordinates.
	 * @param target: The target entity.
	 * @param x: The source X coord.
	 * @param y: The source Y coord.
	 * @param z: The source Z coord.
	 * @param range: Acceptable range of distance between entity and position.
	 * @return true if entity is within distance.
	 */
	public static boolean isEntityWithinRange(Entity target, double x, double y, double z, double range) {

		double disX = Math.abs(x - target.posX);
		double disY = Math.abs(y - target.posY);
		double disZ = Math.abs(z - target.posZ);

		if ((disX + disY + disZ < range)) {

			return true;
		}

		return false;
	}

	/**
	 * Prepares an ItemStack with a tag compound if one is not already on the tag.
	 * @param stack: The ItemStack being used.
	 */
	public static ItemStack prepareStackTag(ItemStack stack) {

		if (!stack.hasTagCompound())
			stack.setTagCompound(new NBTTagCompound());

		return stack;
	}

	/**
	 * Returns how much damage an item will initially do to an entity.
	 * @param stack: ItemStack being checked.
	 */
	public static double getItemWeaponDamage(ItemStack stack) {

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
	 * @param world: The world
	 * @param player: The player
	 * @param length: A cap on the distance
	 * @return MovingObjectPosition
	 */
	public static MovingObjectPosition rayTrace(World world, EntityPlayer player, int length) {

		Vec3 var4 = world.getWorldVec3Pool().getVecFromPool(player.posX, player.posY + player.getEyeHeight(), player.posZ);
		Vec3 var5 = player.getLookVec();
		Vec3 var6 = var4.addVector(var5.xCoord * length, var5.yCoord * length, var5.zCoord * length);
		return world.rayTraceBlocks(var4, var6);
	}
	
	/**
	 * Wraps a string into multiple parts based on a line limit. This is then added to an existing list.
	 * This is to be used with things such as item descriptions.
	 * @param string: The string to split.
	 * @param lnlength: The length of the lines.
	 * @param wrapLongWords: Should words longer than the line length be split?
	 * @param list: The list that these are being added to. 
	 * @return List: the list provided. 
	 */
	public static List wrapStringToList(String string, int lnlength, boolean wrapLongWords, List list) {
		
		String description[] = WordUtils.wrap(string, lnlength, null, wrapLongWords).split("\\r\\n");
		
		for (int i = 0; i < description.length; i++) {
			
			list.add(description[i]);
		}
		
		return list;
	}
	
	/**
	 * Returns a list of all the enchantments on an item under the StoredEnchantments
	 * tag. This is basically for getting enchantments from an enchantment book.
	 * @param stack: The stack being read.
	 * @return Enchantment[]: a list of all the enchantments on the item stack.
	 */
	public static Enchantment[] getStoredEnchantmentsFromStack(ItemStack stack) {
		
		prepareStackTag(stack);
		NBTTagCompound tag = stack.stackTagCompound;
		NBTTagList list = tag.getTagList("StoredEnchantments", 10);
		Enchantment[] ench = new Enchantment[list.tagCount()];
		
		for (int i = 0; i < list.tagCount(); i++) {
			
			ench[i] = Enchantment.enchantmentsList[list.getCompoundTagAt(i).getShort("id")];
		}
		
		return ench;
	}
}