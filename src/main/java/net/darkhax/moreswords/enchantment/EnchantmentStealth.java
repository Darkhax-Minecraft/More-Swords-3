package net.darkhax.moreswords.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentStealth extends EnchantmentBase {

    protected EnchantmentStealth(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Sets the player invisible without the use of a potion effect.
     */
    @SubscribeEvent
    public void onItemUsed(PlayerInteractEvent event) {

        if ((event.action.equals(PlayerInteractEvent.Action.RIGHT_CLICK_AIR))) {

            if (isValidPlayer(event.entityPlayer)) {

                ItemStack stack = event.entityPlayer.getHeldItem();

                if (!event.entityPlayer.isInvisible())
                    event.entityPlayer.setInvisible(true);

                else
                    event.entityPlayer.setInvisible(false);
            }
        }
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {

        return cfg.stealthVanilla;
    }

    @Override
    public boolean isAllowedOnBooks() {

        return cfg.stealthVanilla;
    }

    @Override
    public boolean canApply(ItemStack stack) {

        return cfg.stealthVanilla;
    }

    @Override
    public boolean canApplyTogether(Enchantment par1Enchantment) {

        return cfg.stealthVanilla;
    }
}