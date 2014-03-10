package net.darkhax.moreswords.enchantment;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.darkhax.moreswords.lib.Reference;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;

public class EnchantmentFeast extends EnchantmentCore {

	protected EnchantmentFeast(int id, int weight, String unlocalizedName, int minLevel, int maxLevel, Item item) {
		
		super(id, weight, unlocalizedName, minLevel, maxLevel, item);
		MinecraftForge.EVENT_BUS.register(this);
	}
}
