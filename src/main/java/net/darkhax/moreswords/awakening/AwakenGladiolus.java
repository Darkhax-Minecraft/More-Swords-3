package net.darkhax.moreswords.awakening;

import net.darkhax.bookshelf.util.MathsUtils;
import net.darkhax.bookshelf.util.NBTUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AwakenGladiolus extends Awakening {

    private static String TAG_POISON_DAMAGE = "PoisonDamage";
    private final int requiredDamage = 100;

    @Override
    public int getAwakenProgress (EntityLivingBase entity, ItemStack stack, NBTTagCompound tag) {

        return MathsUtils.getPercentage(NBTUtils.getAmount(stack, TAG_POISON_DAMAGE), this.requiredDamage);
    }

    @SubscribeEvent
    public void onLivingHurt (LivingHurtEvent event) {

        final Entity source = event.getSource().getTrueSource();

        if (source instanceof EntityLivingBase) {

            final EntityLivingBase living = (EntityLivingBase) source;

            // Checks if the held item is valid and the attacker is poisoned
            if (this.isValidItem(living.getHeldItemMainhand()) && living.isPotionActive(MobEffects.POISON)) {

                // Updates amount of damage dealt.
                NBTUtils.increment(living.getHeldItemMainhand(), TAG_POISON_DAMAGE, (int) event.getAmount());

                // Awakens the held item, if possible.
                if (this.canAwaken(living, living.getHeldItemMainhand())) {

                    this.awaken(living);
                }
            }
        }
    }
}
