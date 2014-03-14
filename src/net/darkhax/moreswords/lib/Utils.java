package net.darkhax.moreswords.lib;

import java.util.List;
import java.util.Random;

import net.darkhax.moreswords.MoreSwords;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

public class Utils {

	/**
	 * Creates a list of all the entities in the world of an existing entity.
	 * Depricated because redundant and not needed.
	 * @param entity: An existing entity to grab world info from.
	 * @return A list of all entities in the world.
	 */
	@Deprecated
	public List getWorldEntities(Entity entity) {

		if (entity.worldObj != null) {

			return entity.worldObj.loadedEntityList;
		}

		return null;
	}

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
}
