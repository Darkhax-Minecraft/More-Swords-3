package net.darkhax.moreswords.enchantment;

import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.util.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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
    
    @SubscribeEvent
    public void onItemUsed (PlayerInteractEvent event) {
        
        if ((event.action.equals(PlayerInteractEvent.EntityInteractSpecific.RIGHT_CLICK_AIR))) {
            
            if (isValidUser(event.getEntityPlayer())) {
                
                ItemStack stack = event.getEntityPlayer().getHeldItemMainhand();
                EntityPlayer player = event.getEntityPlayer();
                int distance = getLevel(stack) * ConfigurationHandler.enderPulseRange;
                MovingObjectPosition position = Utils.rayTrace(player, length);
                
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
    
    @Override
    public boolean isValidUser (Entity entity) {
        
        return (entity instanceof EntityPlayer && ((EntityLivingBase) entity).getHeldItemMainhand() != null && getLevel(((EntityPlayer) entity).getHeldItemMainhand()) > 0);
    }
}