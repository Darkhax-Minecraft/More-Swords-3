package net.darkhax.moreswords.enchantment;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EnchantmentKeenEdge extends EnchantmentCore {

	protected EnchantmentKeenEdge(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {

		super(id, weight, unlocalizedName, minLevel, maxLevel, item);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void onEntityHit(AttackEntityEvent event) {

		if (isLiving(event.target)) {
			
			if (isValidPlayer(event.entityLiving)) {
				
				ItemStack stack = event.entityPlayer.getHeldItem();
				int enchLevel = EnchantmentHelper.getEnchantmentLevel(this.effectId, stack) * 1;
				EntityLiving living = (EntityLiving) event.target;
				
				System.out.println("damange: " + enchLevel);
				living.attackEntityFrom(DamageSource.magic, enchLevel);
			}
		}
	}
}