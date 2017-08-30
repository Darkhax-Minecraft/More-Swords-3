package net.darkhax.moreswords.awakening;

import net.darkhax.bookshelf.util.MathsUtils;
import net.darkhax.bookshelf.util.NBTUtils;
import net.darkhax.bookshelf.util.PlayerUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AwakenAether extends Awakening {

    private static final String TAG_FALL_DISTANCE = "FallDistance";
    private final int requiredFallDistance = 256;

    @Override
    public int getAwakenProgress (EntityLivingBase entity, ItemStack stack, NBTTagCompound tag) {

        return MathsUtils.getPercentage(NBTUtils.getAmount(stack, TAG_FALL_DISTANCE), this.requiredFallDistance);
    }

    @SubscribeEvent
    public void onLivingFall (LivingFallEvent event) {

        if (PlayerUtils.isPlayerReal(event.getEntity()) && event.getDistance() > 5f) {

            final EntityPlayer player = (EntityPlayer) event.getEntity();

            if (this.isValidItem(player.getHeldItemMainhand())) {

                NBTUtils.increment(player.getHeldItemMainhand(), TAG_FALL_DISTANCE, (int) event.getDistance());

                if (this.canAwaken(player, player.getHeldItemMainhand())) {

                    this.awaken(player);
                }
            }
        }
    }
}
