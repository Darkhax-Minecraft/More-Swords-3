package net.darkhax.moreswords.enchantment;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentGreed extends EnchantmentBase {

    protected EnchantmentGreed(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Drops a bonus of experience orbs where the mob is. The effect will activate about 7% of the time.
     * The chances of this effect being activated increase with every level of the effect.The amount
     * dropped is a range between two numbers, by default 1-3. Note that this effect will still work even
     * if the mob is not killed.
     */
    @SubscribeEvent
    public void onEntityHit(AttackEntityEvent event) {

        if (isLiving(event.target)) {

            if (isValidPlayer(event.entityLiving)) {

                ItemStack stack = event.entityPlayer.getHeldItem();
                EntityLiving living = (EntityLiving) event.target;

                if (Math.random() < (cfg.greedChance * level(stack))) {

                    if (!living.worldObj.isRemote) {

                        living.worldObj.spawnEntityInWorld(new EntityXPOrb(living.worldObj, living.posX, living.posY, living.posZ, rnd.nextIntII(cfg.greedMin, cfg.greedMax)));
                    }
                }
            }
        }
    }
}