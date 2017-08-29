package net.darkhax.moreswords.awakening;

import net.darkhax.bookshelf.util.MathsUtils;
import net.darkhax.bookshelf.util.StackUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AwakenAether extends Awakening {

    private final int requiredKills = 10;

    @Override
    public int getAwakenProgress (EntityLivingBase entity, ItemStack stack, NBTTagCompound tag) {

        return MathsUtils.getPercentage(tag.getInteger("kills"), this.requiredKills);
    }

    @SubscribeEvent
    public void onLivingKilled (LivingDeathEvent event) {

        final Entity source = event.getSource().getTrueSource();

        if (source instanceof EntityLivingBase && !source.isDead) {

            final EntityLivingBase livingSource = (EntityLivingBase) source;

            if (this.isValidItem(livingSource.getHeldItemMainhand()) && !event.getEntity().onGround && !livingSource.onGround) {

                final NBTTagCompound tag = StackUtils.prepareStackTag(livingSource.getHeldItemMainhand());
                tag.setInteger("kills", tag.getInteger("kills") + 1);

                if (this.canAwaken(livingSource, livingSource.getHeldItemMainhand())) {

                    this.awaken(livingSource);
                }
            }
        }
    }
}
