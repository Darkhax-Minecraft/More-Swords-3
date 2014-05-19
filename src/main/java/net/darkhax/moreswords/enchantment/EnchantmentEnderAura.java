package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.lib.Reference;
import net.darkhax.moreswords.lib.Utils;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentEnderAura extends EnchantmentCore {

	protected EnchantmentEnderAura(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

		super(id, weight, unlocalizedName, minLevel, maxLevel, item);
		MinecraftForge.EVENT_BUS.register(this);
	}

	/**
	 * Has a 1 in 80 chance of 
	 */
	@SubscribeEvent
	public void onEntityHit(LivingHurtEvent event) {

		if (isValidPlayer(event.entityLiving)) {
			
			EntityPlayer living = (EntityPlayer) event.entityLiving;
			
			attemptWarp(living);
		}
	}
	
	public void attemptWarp(EntityPlayer living) {
		
		Entity target = (Entity) living.worldObj.loadedEntityList.get(Reference.RND.nextIntII(1, living.worldObj.loadedEntityList.size() - 1));
		
		if (isLiving(target)) {
			
			if (Utils.isEntityWithinRange(living, target, 32.0d)) {
				
				living.setPositionAndUpdate(target.posX, target.posY, target.posZ);
				return;
			}
		}
		
		attemptWarp(living);
	}
}