package net.darkhax.moreswords.awakening;

import net.darkhax.bookshelf.util.MathsUtils;
import net.darkhax.bookshelf.util.NBTUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AwakenDraconic extends Awakening {

    private static final String TAG_DRAGON_DAMAGE = "DragonDamage";
    private final int requiredDamage = 100;

    @Override
    public int getAwakenProgress (EntityLivingBase entity, ItemStack stack, NBTTagCompound tag) {

        return MathsUtils.getPercentage(NBTUtils.getAmount(stack, TAG_DRAGON_DAMAGE), this.requiredDamage);
    }

    @SubscribeEvent
    public void onRightClick (EntityInteract event) {

        final EntityLivingBase living = event.getEntityLiving();

        // Checks if the entity being right clicked is an ender crystal.
        if (event.getTarget() instanceof EntityEnderCrystal) {

            final EntityEnderCrystal crystal = (EntityEnderCrystal) event.getTarget();

            // Explodes the crystal, if successful it will give bonus.
            if (!crystal.isDead && crystal.attackEntityFrom(DamageSource.causeMobDamage(event.getEntityLiving()), 1f)) {

                crystal.setDead();

                // Updates amount of damage dealt.
                NBTUtils.increment(living.getHeldItemMainhand(), TAG_DRAGON_DAMAGE, 10);

                // Awakens the held item, if possible.
                if (this.canAwaken(living, living.getHeldItemMainhand())) {

                    this.awaken(living);
                }
            }
        }
    }

    @SubscribeEvent
    public void onLivingHurt (LivingHurtEvent event) {

        final Entity source = event.getSource().getTrueSource();

        // Checks if dragon is hurt
        if (event.getEntity() instanceof EntityDragon && source instanceof EntityLivingBase) {

            final EntityLivingBase living = (EntityLivingBase) source;

            // Checks if the held item is valid
            if (this.isValidItem(living.getHeldItemMainhand())) {

                // Updates amount of damage dealt.
                NBTUtils.increment(living.getHeldItemMainhand(), TAG_DRAGON_DAMAGE, (int) event.getAmount());

                // Awakens the held item, if possible.
                if (this.canAwaken(living, living.getHeldItemMainhand())) {

                    this.awaken(living);
                }
            }
        }
    }
}
