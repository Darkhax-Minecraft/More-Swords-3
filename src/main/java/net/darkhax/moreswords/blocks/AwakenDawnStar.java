package net.darkhax.moreswords.blocks;

import net.darkhax.moreswords.util.Utils;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class AwakenDawnStar {

    public AwakenDawnStar(boolean enabled) {

        if (enabled)
            MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onEntityHit(AttackEntityEvent event) {

        if (event.entity instanceof EntityFireball) {

            event.entity.setDead();
            Utils.markStackAsAwakened(event.entityPlayer.getHeldItem());
        }
    }
}
