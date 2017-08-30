package net.darkhax.moreswords.awakening;

import net.darkhax.bookshelf.util.MathsUtils;
import net.darkhax.bookshelf.util.NBTUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AwakenCrystal extends Awakening {

    private static final String TAG_EXPERIENCE = "Experience";
    private final int requiredExp = 170;

    @Override
    public int getAwakenProgress (EntityLivingBase entity, ItemStack stack, NBTTagCompound tag) {

        return MathsUtils.getPercentage(NBTUtils.getAmount(stack, TAG_EXPERIENCE), this.requiredExp);
    }

    @SubscribeEvent
    public void onPlayerPickupEXP (PlayerPickupXpEvent event) {

        if (!event.getOrb().isDead && this.isValidItem(event.getEntityPlayer().getHeldItemMainhand())) {

            event.setCanceled(true);
            event.getOrb().setDead();
            NBTUtils.increment(event.getEntityPlayer().getHeldItemMainhand(), TAG_EXPERIENCE, event.getOrb().xpValue);

            if (this.canAwaken(event.getEntityPlayer(), event.getEntityPlayer().getHeldItemMainhand())) {

                this.awaken(event.getEntityPlayer());
            }
        }
    }
}
