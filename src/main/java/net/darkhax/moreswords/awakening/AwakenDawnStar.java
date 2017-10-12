package net.darkhax.moreswords.awakening;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import net.darkhax.bookshelf.util.MathsUtils;
import net.darkhax.bookshelf.util.NBTUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AwakenDawnStar extends Awakening {

    private static final String TAG_FIREBALL = "FireBalls";
    private final int requiredFireballs = 10;
    private final Set<EntityLargeFireball> trackedFireballs = new HashSet<>();

    @Override
    public int getAwakenProgress (EntityLivingBase player, ItemStack stack, NBTTagCompound tag) {

        return MathsUtils.getPercentage(NBTUtils.getAmount(stack, TAG_FIREBALL), this.requiredFireballs);
    }
    
    @Override
    public void onHolderTick(EntityPlayer holder, ItemStack stack) {
    	
    	// Gives the valid holder fire resistance
    	holder.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 10, 1, false, false));
    }
    
    @Override
    public void onHolderAttack(EntityPlayer holder, EntityLivingBase victim, ItemStack stack, LivingHurtEvent event) {
    	
    	final int fireTime = MathHelper.floor(event.getAmount() / 2f);
    	
    	// Does half of the damage in fire damage
    	victim.setFire(fireTime);
		
    	// All mobs in 2.5 block radius.
    	for (Entity entity : holder.getEntityWorld().getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(victim.getPosition()).grow(2.5))) {
    		
    		if (entity != holder && entity != victim) {
    			
    			if (!isInvalidTarget(holder, entity)) {
    				
        			// Does 25% of the damage as fire to nearby mobs of the same type.
        			entity.setFire(Math.max(2, fireTime / 2));
    			}
    		}
    	}
    }

    @SubscribeEvent
    public void onEntityJoinWorld (EntityJoinWorldEvent event) {

        // Adds valid fireballs to the tracked fireball list
        if (event.getEntity() instanceof EntityLargeFireball) {

            final EntityLargeFireball fireball = (EntityLargeFireball) event.getEntity();

            if (fireball.shootingEntity instanceof EntityGhast) {

                this.trackedFireballs.add(fireball);
            }
        }
    }

    @SubscribeEvent
    public void onServerTick (TickEvent.ServerTickEvent event) {

        final Iterator<EntityLargeFireball> it = this.trackedFireballs.iterator();

        while (it.hasNext()) {

            final EntityLargeFireball fireball = it.next();

            // Removes bad fireballs from the system.
            if (fireball == null || fireball.isDead) {

                it.remove();
            }

            // Checks if a player hit the fireball.
            else if (fireball.shootingEntity instanceof EntityPlayer) {

                final EntityPlayer player = (EntityPlayer) fireball.shootingEntity;

                // Makes sure the player has the right held item.
                if (!player.isDead && this.isValidItem(player.getHeldItemMainhand())) {

                    NBTUtils.increment(player.getHeldItemMainhand(), TAG_FIREBALL, 1);
                    fireball.setDead();
                    it.remove();

                    // Awakens the item
                    if (this.canAwaken(player, player.getHeldItemMainhand())) {

                        this.awaken(player);
                    }
                }
            }
        }
    }
    
    public static boolean isInvalidTarget(EntityLivingBase owner, Entity victim) {
    	
    	// True for pets owned by the attacker.
    	if (victim instanceof IEntityOwnable && ((IEntityOwnable) victim).getOwner() == owner) {
    		
    		return true;
    	}
    	
    	// Checks if they share a team
    	if (victim.isOnSameTeam(owner)) {
    		
    		return true;
    	}
    	
    	return false;
    }
}
