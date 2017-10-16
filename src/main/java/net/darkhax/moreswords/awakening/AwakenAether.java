package net.darkhax.moreswords.awakening;

import net.darkhax.bookshelf.util.MathsUtils;
import net.darkhax.bookshelf.util.NBTUtils;
import net.darkhax.bookshelf.util.PlayerUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AwakenAether extends Awakening {

    private static final String TAG_FALL_DISTANCE = "FallDistance";
    private final int requiredFallDistance = 256;

    @Override
    public int getAwakenProgress (EntityLivingBase entity, ItemStack stack, NBTTagCompound tag) {

        return MathsUtils.getPercentage(NBTUtils.getAmount(stack, TAG_FALL_DISTANCE), this.requiredFallDistance);
    }

    @Override
    public void onHolderTick (EntityPlayer holder, ItemStack stack) {

        if (holder.isSneaking() && holder.fallDistance > 0) {

            holder.motionY = -0.2;
        }
    }

    @Override
    public void onHolderAttack (EntityPlayer holder, EntityLivingBase victim, ItemStack stack, LivingHurtEvent event) {

        victim.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 5, 25, false, false));
    }

    @SubscribeEvent
    public void onLivingFall (LivingFallEvent event) {

        if (PlayerUtils.isPlayerReal(event.getEntity())) {

            final EntityPlayer player = (EntityPlayer) event.getEntity();

            if (this.getMaterial().isPlayerHolding(player)) {

                event.setDamageMultiplier(0);
                event.setCanceled(true);
            }

            else if (this.isValidItem(player.getHeldItemMainhand()) && event.getDistance() > 5f) {

                NBTUtils.increment(player.getHeldItemMainhand(), TAG_FALL_DISTANCE, (int) event.getDistance());

                if (this.canAwaken(player, player.getHeldItemMainhand())) {

                    this.awaken(player);
                }
            }
        }
    }
}
