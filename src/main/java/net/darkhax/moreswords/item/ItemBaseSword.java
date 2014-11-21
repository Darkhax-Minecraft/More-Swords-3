package net.darkhax.moreswords.item;

import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.util.EnumMoreSwords;
import net.darkhax.moreswords.util.Utils;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBaseSword extends ItemSword {

    public final String swordName;

    public ItemBaseSword(String swordName) {

        super(generateToolMaterials(swordName));
        this.swordName = swordName;
        this.setTextureName("moreswords:sword_" + swordName);
        this.setUnlocalizedName("msm." + swordName);
        this.setCreativeTab(MoreSwords.tabSwords);
    }

    /**
     * Creates an EnumToolMaterial using values from an EnumMoreSwords
     * 
     * @param swordName : Name of the sword for lookup.
     * @return EnumToolMaterial: Enum for tool properties.
     */
    public static Item.ToolMaterial generateToolMaterials(String swordName) {

        EnumMoreSwords sword = EnumMoreSwords.getType(swordName);
        Item.ToolMaterial material = EnumHelper.addToolMaterial(swordName, sword.swordHarvestLevel, sword.swordDurability, sword.swordEfficiency, sword.swordDamage - 4, sword.swordEnchantability);

        if (ConfigurationHandler.itemsRepairable) {

            material.customCraftingMaterial = sword.swordRepairItem;
        }

        return material;
    }

    public static class ItemGlowSword extends ItemBaseSword {

        public static IIcon[] iconArray;

        public ItemGlowSword(String swordName) {

            super(swordName);
        }

        @Override
        @SideOnly(Side.CLIENT)
        public void registerIcons(IIconRegister register) {

            iconArray = new IIcon[2];
            iconArray[0] = register.registerIcon("moreswords:" + "sword_lux_off");
            iconArray[1] = register.registerIcon("moreswords:" + "sword_lux_on");
        }

        @Override
        @SideOnly(Side.CLIENT)
        public IIcon getIconIndex(ItemStack stack) {

            if (stack != null) {

                Utils.prepareStackTag(stack);
                NBTTagCompound stackTag = stack.stackTagCompound;

                if (stackTag.hasKey("LightStatus")) {

                    IIcon icon = iconArray[stackTag.getBoolean("LightStatus") ? 1 : 0];
                    this.itemIcon = icon;
                    return icon;
                }
            }

            return iconArray[0];
        }

        @Override
        public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

            Utils.prepareStackTag(stack);
            NBTTagCompound tag = stack.getTagCompound();
            boolean isOn = tag.getBoolean("LightStatus");

            tag.setBoolean("LightStatus", (isOn) ? false : true);
            return true;
        }
    }
}