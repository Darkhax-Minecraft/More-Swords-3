package net.darkhax.moreswords.awakening;

import net.darkhax.bookshelf.util.MathsUtils;
import net.darkhax.bookshelf.util.NBTUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AwakenWither extends Awakening {

    private static final String TAG_WITHER_DAMAGE = "WietherDamage";
    private final int requiredDamage = 100;

    @Override
    public int getAwakenProgress (EntityLivingBase entity, ItemStack stack, NBTTagCompound tag) {

        return MathsUtils.getPercentage(NBTUtils.getAmount(stack, TAG_WITHER_DAMAGE), this.requiredDamage);
    }

    @SubscribeEvent
    public void onLivingHurt (LivingHurtEvent event) {

        final Entity source = event.getSource().getTrueSource();

        // Checks if dragon is hurt
        if (event.getEntity() instanceof EntityWither && source instanceof EntityLivingBase) {

            final EntityLivingBase living = (EntityLivingBase) source;

            // Checks if the held item is valid
            if (this.isValidItem(living.getHeldItemMainhand())) {

                // Updates amount of damage dealt.
                NBTUtils.increment(living.getHeldItemMainhand(), TAG_WITHER_DAMAGE, (int) event.getAmount());

                // Awakens the held item, if possible.
                if (this.canAwaken(living, living.getHeldItemMainhand())) {

                    this.awaken(living);
                }
            }
        }
    }
}
