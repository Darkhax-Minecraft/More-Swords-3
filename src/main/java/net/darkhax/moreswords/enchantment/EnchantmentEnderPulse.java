package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.util.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentEnderPulse extends EnchantmentBase {
    
    protected EnchantmentEnderPulse(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
        
        super(id, weight, unlocalizedName, minLevel, maxLevel, item);
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    /**
     * Teleports the player where they are looking on right click, provided that space is
     * within 18 multiplied by enchantment level blocks away. Damages the held item by 50 and
     * gives the player 1 fall damage.
     */
    @SubscribeEvent
    public void onItemUsed (PlayerInteractEvent event) {
        
        if ((event.action.equals(PlayerInteractEvent.Action.RIGHT_CLICK_AIR))) {
            
            if (isValidUser(event.entityPlayer)) {
                
                ItemStack stack = event.entityPlayer.getHeldItem();
                EntityPlayer player = event.entityPlayer;
                int distance = getLevel(stack) * ConfigurationHandler.enderPulseRange;
                MovingObjectPosition position = Utils.rayTrace(player, distance);
                
                if ((position != null) && (position.typeOfHit == MovingObjectType.BLOCK)) {
                    
                    int x = position.getBlockPos().getX();
                    int y = position.getBlockPos().getY();
                    int z = position.getBlockPos().getZ();
                    
                    switch (position.sideHit.getIndex()) {
                        // Down
                        case 0:
                            y--;
                            break;
                        // Up
                        case 1:
                            y++;
                            break;
                        // North
                        case 2:
                            z--;
                            break;
                        // South
                        case 3:
                            z++;
                            break;
                        // West
                        case 4:
                            x--;
                            break;
                        // East
                        case 5:
                            x++;
                            break;
                        default:
                            y++;
                    }
                    
                    stack.damageItem(ConfigurationHandler.enderPulseItemDamage, player);
                    player.setPositionAndUpdate(x, y, z);
                    player.attackEntityFrom(DamageSource.fall, ConfigurationHandler.enderPulseFallDamage);
                }
            }
        }
    }
}