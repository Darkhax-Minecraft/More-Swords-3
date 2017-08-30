package net.darkhax.moreswords.awakening;

import net.darkhax.bookshelf.util.MathsUtils;
import net.darkhax.bookshelf.util.NBTUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AwakenEnder extends Awakening {

    private static final String TAG_ENDER_KILLS = "EnderKills";

    private final int requiredKills = 100;

    @Override
    public int getAwakenProgress (EntityLivingBase entity, ItemStack stack, NBTTagCompound tag) {

        return MathsUtils.getPercentage(NBTUtils.getAmount(stack, TAG_ENDER_KILLS), this.requiredKills);
    }

    @SubscribeEvent
    public void onMobKilled (LivingDeathEvent event) {

        final Entity source = event.getSource().getTrueSource();
        final Entity target = event.getEntityLiving();

        // Only counts ender kills. (enderman, shulkers, endermites)
        if (source instanceof EntityLivingBase && (target instanceof EntityEnderman || target instanceof EntityShulker || target instanceof EntityEndermite)) {

            final EntityLivingBase living = (EntityLivingBase) source;

            // Makes sure the player has the right held item.
            if (this.isValidItem(living.getHeldItemMainhand())) {

                // Adds one ender kill
                NBTUtils.increment(living.getHeldItemMainhand(), TAG_ENDER_KILLS, 1);

                // Awakens the item
                if (this.canAwaken(living, living.getHeldItemMainhand())) {

                    this.awaken(living);
                }
            }
        }
    }
}