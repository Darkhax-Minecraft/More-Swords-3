package net.darkhax.moreswords.handler;

import net.darkhax.bookshelf.util.PlayerUtils;
import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.items.ItemSwordBase;
import net.darkhax.moreswords.materials.SwordMaterial;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EffectHandler {
	
	@SubscribeEvent
	public void onItemPickedUp(EntityItemPickupEvent event) {
		
		if (PlayerUtils.isPlayerReal(event.getEntityPlayer())) {
			
			if (event.getEntityPlayer().getHeldItemMainhand().getItem() instanceof ItemSwordBase) {
				
				ItemSwordBase sword = (ItemSwordBase) event.getEntityPlayer().getHeldItemMainhand().getItem();
				sword.getMaterial().getAwakening().onHolderPickup(event.getEntityPlayer(), event);
			}
		}
	}
	
    @SubscribeEvent
    public void onMobDrops(LivingDropsEvent event) {
    	
        if (event.getSource().getTrueSource() instanceof EntityPlayer) {
			
			final EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
			
			if (player.getHeldItemMainhand().getItem() instanceof ItemSwordBase) {
				
				ItemSwordBase sword = (ItemSwordBase) player.getHeldItemMainhand().getItem();
				sword.getMaterial().getAwakening().onHolderGetsDrops(player, event);
			}
		}
    }
    
    @SubscribeEvent
    public void onItemUsed(PlayerInteractEvent.RightClickBlock event) {

    	if (event.getItemStack().getItem() instanceof ItemSwordBase) {
    		
    		final ItemSwordBase sword = (ItemSwordBase) event.getItemStack().getItem();
    		sword.getMaterial().getAwakening().onHolderRightClick(event.getEntityPlayer(), event.getItemStack(), true);
    	}
    }
    
    @SubscribeEvent
    public void onItemUsed(PlayerInteractEvent.RightClickItem event) {

    	if (event.getItemStack().getItem() instanceof ItemSwordBase) {
    		
    		final ItemSwordBase sword = (ItemSwordBase) event.getItemStack().getItem();
    		sword.getMaterial().getAwakening().onHolderRightClick(event.getEntityPlayer(), event.getItemStack(), false);
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
