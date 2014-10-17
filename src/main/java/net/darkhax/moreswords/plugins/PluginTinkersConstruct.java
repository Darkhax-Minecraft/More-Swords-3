package net.darkhax.moreswords.plugins;

import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.item.SwordItems;
import net.darkhax.moreswords.util.Constants;
import net.darkhax.moreswords.util.EnumMoreSwords;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PluginTinkersConstruct {

    public PluginTinkersConstruct(boolean enabled) {

        if (enabled) {

            for (EnumMoreSwords data : EnumMoreSwords.values()) {

                createMaterial(data);
                createAndRegisterFluids(data);
                createPartCastingMaterial(data);
                // createPartBuilderMaterial(data);
                Item recipe = (Item) Item.itemRegistry.getObject("modid:itemID");
            }
        }
    }

    public static void createMaterial(EnumMoreSwords data) {

        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("Name", "msm." + data.swordName);
        tag.setInteger("Id", ConfigurationHandler.initialIDRange + data.ordinal());
        tag.setInteger("HarvestLevel", data.swordHarvestLevel);
        tag.setInteger("Durability", data.swordDurability / 2);
        tag.setInteger("MiningSpeed", data.swordEfficiency);
        tag.setInteger("Attack", data.swordDamage / 2);
        tag.setFloat("HandleModifier", data.swordDurability / 1000);
        tag.setInteger("Color", data.swordColor);
        FMLInterModComms.sendRuntimeMessage(Constants.MOD_ID, "TConstruct", "addMaterial", tag);
    }

    public static void createPartCastingMaterial(EnumMoreSwords data) {

        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("MaterialId", ConfigurationHandler.initialIDRange + data.ordinal());
        tag.setString("FluidName", "msm.fluid." + data.swordName);
        FMLInterModComms.sendRuntimeMessage(Constants.MOD_ID, "TConstruct", "addPartCastingMaterial", tag);
    }

    public static void createPartBuilderMaterial(EnumMoreSwords data) {

        System.out.println("Sword List here: " + SwordItems.swordList.toString());
        NBTTagCompound tag = new NBTTagCompound();
        ItemStack swordStack = new ItemStack(SwordItems.swordList.get(data.swordName));
        tag.setInteger("MaterialId", ConfigurationHandler.initialIDRange + data.ordinal());
        tag.setInteger("Value", 1);
        NBTTagCompound itemTag = new NBTTagCompound();
        swordStack.writeToNBT(itemTag);
        tag.setTag("Item", itemTag);
        FMLInterModComms.sendRuntimeMessage(Constants.MOD_ID, "TConstruct", "addPartBuilderMaterial", tag);
    }

    public static void createAndRegisterFluids(EnumMoreSwords data) {

        Fluid swordFluid = new Fluid("msm.fluid." + data.swordName);
        FluidRegistry.registerFluid(swordFluid);
        Block swordFluidBlock = new BlockSwordFluid(swordFluid, "msm.fluid." + data.swordName).setBlockName("msm." + data.swordName);
        GameRegistry.registerBlock(swordFluidBlock, "msm.fluid." + data.swordName);
    }

    public static class BlockSwordFluid extends BlockFluidClassic {

        @SideOnly(Side.CLIENT)
        protected IIcon stillIcon;

        @SideOnly(Side.CLIENT)
        protected IIcon flowingIcon;

        protected String fluidName;

        public BlockSwordFluid(Fluid fluid, String fluidName) {

            super(fluid, Material.water);
            setCreativeTab(MoreSwords.tabSwords);
        }

        @Override
        public IIcon getIcon(int side, int meta) {

            return (side == 0 || side == 1) ? stillIcon : flowingIcon;
        }

        @SideOnly(Side.CLIENT)
        @Override
        public void registerBlockIcons(IIconRegister register) {

            stillIcon = register.registerIcon("modid:fluid_" + fluidName + "_still");
            flowingIcon = register.registerIcon("modid:fluid_" + fluidName + "_slowing");
        }

        @Override
        public boolean canDisplace(IBlockAccess world, int x, int y, int z) {

            if (world.getBlock(x, y, z).getMaterial().isLiquid())
                return false;

            return super.canDisplace(world, x, y, z);
        }

        @Override
        public boolean displaceIfPossible(World world, int x, int y, int z) {

            if (world.getBlock(x, y, z).getMaterial().isLiquid())
                return false;

            return super.displaceIfPossible(world, x, y, z);
        }
    }
}
