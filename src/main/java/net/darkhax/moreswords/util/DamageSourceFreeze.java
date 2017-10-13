package net.darkhax.moreswords.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public class DamageSourceFreeze extends EntityDamageSource {

	public DamageSourceFreeze(Entity entity) {
		
		super("msm.freeze", entity);
		this.setDamageBypassesArmor();
		this.setDamageIsAbsolute();
	}
	
	@Override
    public ITextComponent getDeathMessage(EntityLivingBase entity) {
		
		return new TextComponentTranslation("death.attack.msm.freeze", entity.getName());
	}
}
