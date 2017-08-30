package net.darkhax.moreswords.awakening;

import net.darkhax.bookshelf.util.MathsUtils;
import net.darkhax.bookshelf.util.NBTUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AwakenVampiric extends Awakening {

    private static final String TAG_VAMP_Kills = "VampireKills";
    private final int requiredKills = 10;

    @Override
    public int getAwakenProgress (EntityLivingBase entity, ItemStack stack, NBTTagCompound tag) {

        return MathsUtils.getPercentage(NBTUtils.getAmount(stack, TAG_VAMP_Kills), this.requiredKills);
    }

    @SubscribeEvent
    public void onMobKilled (LivingDeathEvent event) {

        final Entity source = event.getSource().getTrueSource();

        // Prevents non-hostile mobs from counting.
        if (source instanceof EntityLivingBase && event.getEntity() instanceof IMob) {

            final EntityLivingBase living = (EntityLivingBase) source;

            // Makes sure the player has the right held item. And only one health.
            if (living.getHealth() <= 1f && !living.isDead && this.isValidItem(living.getHeldItemMainhand())) {

                // Adds one vampiric kill
                NBTUtils.increment(living.getHeldItemMainhand(), TAG_VAMP_Kills, 1);

                // Awakens the item
                if (this.canAwaken(living, living.getHeldItemMainhand())) {

                    this.awaken(living);
                }
            }
        }
    }
}
