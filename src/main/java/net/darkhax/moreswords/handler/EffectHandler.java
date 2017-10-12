package net.darkhax.moreswords.handler;

import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.materials.SwordMaterial;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EffectHandler {

	@SubscribeEvent
	public void onLivingHurt(LivingHurtEvent event) {
		
		if (event.getSource().getTrueSource() instanceof EntityPlayer) {
			
			final EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
			
			for (SwordMaterial material : MoreSwords.MATERIALS.values()) {
				
				if (material.isPlayerHolding(player)) {
					
					material.getAwakening().onHolderAttack(player, event.getEntityLiving(), event.getAmount(), player.getHeldItemMainhand());
					break;
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		
		if (event.getEntityLiving() instanceof EntityPlayer) {
			
			final EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			
			for (SwordMaterial material : MoreSwords.MATERIALS.values()) {
				
				if (material.isPlayerHolding(player)) {
					
					material.getAwakening().onHolderTick(player, player.getHeldItemMainhand());
					break;
				}
			}
		}
	}
}
