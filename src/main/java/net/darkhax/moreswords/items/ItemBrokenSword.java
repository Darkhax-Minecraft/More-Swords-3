package net.darkhax.moreswords.items;

import java.util.List;

import javax.annotation.Nullable;

import net.darkhax.bookshelf.item.ItemSubType;
import net.darkhax.bookshelf.registry.IVariant;
import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.materials.SwordMaterial;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBrokenSword extends ItemSubType implements IVariant {

    public ItemBrokenSword () {

        super(MoreSwords.MATERIALS.keySet().toArray(new String[MoreSwords.MATERIALS.size()]));
        this.setMaxStackSize(1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {

        final SwordMaterial material = this.getSwordMaterial(stack);
        
        if (material != null) {
            
            tooltip.add("Repair with: " + material.getRepairStack().getDisplayName());
        }
    }

    public SwordMaterial getSwordMaterial (ItemStack stack) {

        return MoreSwords.MATERIALS.get(this.getVariant()[stack.getMetadata()]);
    }
}