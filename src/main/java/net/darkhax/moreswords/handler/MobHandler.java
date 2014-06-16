package net.darkhax.moreswords.handler;

import net.darkhax.moreswords.item.SwordItems;
import net.darkhax.moreswords.util.Config;
import net.darkhax.moreswords.util.Reference;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class MobHandler {

	Config cfg;
	
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
				
				if (event.entity instanceof EntityZombie && cfg.zombieSwords)
					setEntityToHoldSwords(living, cfg.zombieChance);
				
				if (event.entity instanceof EntitySkeleton && cfg.skeletonSwords)
					setEntityToHoldSwords(living, cfg.skeletonChance);
				
				if (event.entity instanceof EntityPigZombie && cfg.pigSwords)
					setEntityToHoldSwords(living, cfg.pigChance);
			}
		}
	}
	
	public void setEntityToHoldSwords(EntityLiving entity, double odds) {
		
		if (Math.random() < odds) {
			
			entity.setCurrentItemOrArmor(0, new ItemStack(SwordItems.swordList.get(Reference.RND.nextIntII(0, SwordItems.swordList.size()-2))));
		}
		
		entity.getEntityData().setBoolean("spawned", true);
	}
}
