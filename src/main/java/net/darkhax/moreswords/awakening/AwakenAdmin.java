package net.darkhax.moreswords.awakening;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AwakenAdmin extends Awakening {

    @Override
    public int getAwakenProgress (EntityLivingBase entity, ItemStack stack, NBTTagCompound tag) {

        return entity instanceof EntityPlayer ? ((EntityPlayer) entity).capabilities.isCreativeMode ? 100 : 0 : 0;
    }

    @SubscribeEvent
    public void onLivingUpdate (LivingUpdateEvent event) {

        if (event.getEntityLiving() instanceof EntityPlayer && !event.getEntityLiving().isDead && this.isValidItem(event.getEntityLiving().getHeldItemMainhand())) {

            this.awaken(event.getEntityLiving());
        }
    }
}
