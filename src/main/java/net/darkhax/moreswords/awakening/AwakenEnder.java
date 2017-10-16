package net.darkhax.moreswords.awakening;

import net.darkhax.bookshelf.util.MathsUtils;
import net.darkhax.bookshelf.util.NBTUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AwakenEnder extends Awakening {

    private static final String TAG_ENDER_KILLS = "EnderKills";

    private final int requiredKills = 100;

    @Override
    public void onHolderRightClick (EntityPlayer holder, ItemStack stack, boolean isBlock) {

        final RayTraceResult position = MathsUtils.rayTrace(holder, 128d);

        if (position != null && position.typeOfHit == RayTraceResult.Type.BLOCK) {

            double x = position.hitVec.x;
            double y = position.hitVec.y;
            double z = position.hitVec.z;

            switch (position.sideHit) {
                case DOWN:
                    y--;
                    break;
                case UP:
                    y++;
                    break;
                case NORTH:
                    z--;
                    break;
                case SOUTH:
                    z++;
                    break;
                case WEST:
                    x--;
                    break;
                case EAST:
                    x++;
                    break;
                default:
                    y++;
            }

            holder.setPositionAndUpdate(x, y, z);
            stack.damageItem(10, holder);
            holder.attackEntityFrom(DamageSource.FALL, 1f);
        }
    }

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