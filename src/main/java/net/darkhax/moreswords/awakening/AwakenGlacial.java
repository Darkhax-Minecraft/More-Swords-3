package net.darkhax.moreswords.awakening;

import net.darkhax.bookshelf.util.MathsUtils;
import net.darkhax.bookshelf.util.NBTUtils;
import net.darkhax.moreswords.util.DamageSourceFreeze;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AwakenGlacial extends Awakening {

    private static String TAG_SLOW_DAMAGE = "SlowDamage";
    private final int requiredDamage = 100;

    @Override
    public void onHolderTick(EntityPlayer holder, ItemStack stack) {
    	
    	holder.getActivePotionMap().remove(MobEffects.SLOWNESS);
    }
    
    @Override
    public void onHolderAttack(EntityPlayer holder, EntityLivingBase victim, ItemStack stack, LivingHurtEvent event) {
    	
    	victim.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 20 * 20, 1, false, false));
    	victim.attackEntityFrom(new DamageSourceFreeze(holder), 4f);
    	
    	for (EntityLivingBase entity : holder.getEntityWorld().getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(victim.getPosition()).grow(2.5))) {
    		
    		if (entity != holder && entity != victim) {
    			
    			if (!isInvalidTarget(holder, entity)) {
    				
    				entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, MathsUtils.nextIntInclusive(5, 10) * 20, 0, false, false));
    				victim.attackEntityFrom(new DamageSourceFreeze(holder), 1f);
    			}
    		}
    	}
    }
    
    @Override
    public int getAwakenProgress (EntityLivingBase entity, ItemStack stack, NBTTagCompound tag) {

        return MathsUtils.getPercentage(NBTUtils.getAmount(stack, TAG_SLOW_DAMAGE), this.requiredDamage);
    }

    @SubscribeEvent
    public void onLivingHurt (LivingHurtEvent event) {

        final Entity source = event.getSource().getTrueSource();

        if (source instanceof EntityLivingBase) {

            final EntityLivingBase living = (EntityLivingBase) source;

            // Checks if the held item is valid and the attacker is slowed
            if (this.isValidItem(living.getHeldItemMainhand()) && living.isPotionActive(MobEffects.SLOWNESS)) {

                // Updates amount of damage dealt.
                NBTUtils.increment(living.getHeldItemMainhand(), TAG_SLOW_DAMAGE, (int) event.getAmount());

                // Awakens the held item, if possible.
                if (this.canAwaken(living, living.getHeldItemMainhand())) {

                    this.awaken(living);
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
