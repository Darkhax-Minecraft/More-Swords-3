package net.darkhax.moreswords.handler;

import net.darkhax.moreswords.item.SwordItems;
import net.darkhax.moreswords.util.RandomUtils;
import net.darkhax.moreswords.util.Reference;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class MobHandler {

	public MobHandler(Boolean status) {
		
		if (status) {
			
			MinecraftForge.EVENT_BUS.register(this);
		}
	}
	
	@SubscribeEvent
	public void onEnemySpawn(EntityJoinWorldEvent event) {
		
		if (event.entity instanceof EntityLiving) {
			
			double rand = Math.random();
			
			EntityLiving living = (EntityLiving) event.entity;
			
			if (!living.getEntityData().hasKey("spawned")) {
				
				if (event.entity instanceof EntityZombie) {
					
					living.setCurrentItemOrArmor(0, new ItemStack(SwordItems.swordList.get(Reference.RND.nextIntII(0, SwordItems.swordList.size()-1))));
					living.getEntityData().setBoolean("spawned", true);
				}
			}
		}
	}
	
	public void setEntityToHoldSwords(EntityLiving entity) {
		
	}
}
