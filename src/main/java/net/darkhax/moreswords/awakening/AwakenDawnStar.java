package net.darkhax.moreswords.awakening;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import net.darkhax.bookshelf.util.MathsUtils;
import net.darkhax.bookshelf.util.NBTUtils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AwakenDawnStar extends Awakening {

    private static final String TAG_FIREBALL = "FireBalls";
    private final int requiredFireballs = 10;
    private final Set<EntityLargeFireball> trackedFireballs = new HashSet<>();

    @Override
    public int getAwakenProgress (EntityLivingBase player, ItemStack stack, NBTTagCompound tag) {

        return MathsUtils.getPercentage(NBTUtils.getAmount(stack, TAG_FIREBALL), this.requiredFireballs);
    }

    @SubscribeEvent
    public void onEntityJoinWorld (EntityJoinWorldEvent event) {

        // Adds valid fireballs to the tracked fireball list
        if (event.getEntity() instanceof EntityLargeFireball) {

            final EntityLargeFireball fireball = (EntityLargeFireball) event.getEntity();

            if (fireball.shootingEntity instanceof EntityGhast) {

                this.trackedFireballs.add(fireball);
            }
        }
    }

    @SubscribeEvent
    public void onServerTick (TickEvent.ServerTickEvent event) {

        final Iterator<EntityLargeFireball> it = this.trackedFireballs.iterator();

        while (it.hasNext()) {

            final EntityLargeFireball fireball = it.next();

            // Removes bad fireballs from the system.
            if (fireball == null || fireball.isDead) {

                it.remove();
            }

            // Checks if a player hit the fireball.
            else if (fireball.shootingEntity instanceof EntityPlayer) {

                final EntityPlayer player = (EntityPlayer) fireball.shootingEntity;

                // Makes sure the player has the right held item.
                if (!player.isDead && this.isValidItem(player.getHeldItemMainhand())) {

                    NBTUtils.increment(player.getHeldItemMainhand(), TAG_FIREBALL, 1);
                    fireball.setDead();
                    it.remove();

                    // Awakens the item
                    if (this.canAwaken(player, player.getHeldItemMainhand())) {

                        this.awaken(player);
                    }
                }
            }
        }
    }
}
