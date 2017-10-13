package net.darkhax.moreswords.handler;

import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.items.ItemSwordBase;
import net.darkhax.moreswords.materials.SwordMaterial;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EffectHandler {

    @SubscribeEvent
    public void onItemUsed(PlayerInteractEvent.RightClickItem event) {

    	if (event.getItemStack().getItem() instanceof ItemSwordBase) {
    		
    		final ItemSwordBase sword = (ItemSwordBase) event.getItemStack().getItem();
    		sword.getMaterial().getAwakening().onHolderRightClick(event.getEntityPlayer(), event.getItemStack());
    	}
    }
    
	@SubscribeEvent
	public void onToolBreak(PlayerDestroyItemEvent event) {
		
		if (event.getOriginal().getItem() instanceof ItemSwordBase) {
			
			
			final ItemSwordBase sword = (ItemSwordBase) event.getOriginal().getItem();
			event.getEntityPlayer().inventory.addItemStackToInventory(sword.getMaterial().getBrokenItem().copy());
		}
	}
	
	@SubscribeEvent
	public void onLivingHurt(LivingHurtEvent event) {
		
		if (event.getSource().getTrueSource() instanceof EntityPlayer) {
			
			final EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
			
			for (SwordMaterial material : MoreSwords.MATERIALS.values()) {
				
				if (material.isPlayerHolding(player)) {
					
					material.getAwakening().onHolderAttack(player, event.getEntityLiving(), player.getHeldItemMainhand(), event);
					break;
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onLivingKilled(LivingDeathEvent event) {
		
		if (event.getSource().getTrueSource() instanceof EntityPlayer) {
			
			final EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
			
			for (SwordMaterial material : MoreSwords.MATERIALS.values()) {
				
				if (material.isPlayerHolding(player)) {
					
					material.getAwakening().onHolderKill(player, event.getEntityLiving(), player.getHeldItemMainhand());
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
