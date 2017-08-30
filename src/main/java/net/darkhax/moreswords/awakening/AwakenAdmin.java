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

        return entity instanceof EntityPlayer && this.isValidItem(entity.getHeldItemMainhand()) ? ((EntityPlayer) entity).capabilities.isCreativeMode ? 100 : 0 : 0;
    }

    @SubscribeEvent
    public void onLivingUpdate (LivingUpdateEvent event) {

        if (event.getEntityLiving() instanceof EntityPlayer) {

            final EntityPlayer player = (EntityPlayer) event.getEntityLiving();

            // Checks if the player is in creative mode, and sneaking.
            if (!player.isDead && this.isValidItem(player.getHeldItemMainhand()) && player.capabilities.isCreativeMode && player.isSneaking()) {

                this.awaken(event.getEntityLiving());
            }
        }
    }
}
