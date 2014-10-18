package net.darkhax.moreswords.plugins;

import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.handler.ConfigurationHandler;
import net.darkhax.moreswords.item.SwordItems;
import net.darkhax.moreswords.util.Constants;
import net.darkhax.moreswords.util.EnumMoreSwords;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
                createPartCastingMaterial(data);
                createAndAddSmelteryMelting(data);
                createPartBuilderMaterial(data);
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

        System.out.println("Added: " + "msm.fluid." + data.swordName);
        Fluid swordFluid = new Fluid("msm.fluid." + data.swordName);
        FluidRegistry.registerFluid(swordFluid);
        Block swordFluidBlock = new BlockSwordFluid(swordFluid, data.swordName).setBlockName("msm." + data.swordName);
        GameRegistry.registerBlock(swordFluidBlock, "msm.fluid." + data.swordName);
        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("MaterialId", ConfigurationHandler.initialIDRange + data.ordinal());
        tag.setString("FluidName", "msm.fluid." + data.swordName);
        tag.setInteger("Amount", 144);
        FMLInterModComms.sendRuntimeMessage(Constants.MOD_ID, "TConstruct", "addPartCastingMaterial", tag);
    }

    public static void createPartBuilderMaterial(EnumMoreSwords data) {

        NBTTagCompound tag = new NBTTagCompound();
        ItemStack swordStack = new ItemStack(SwordItems.swordList.get(data.swordName));
        ItemStack shard = new ItemStack(Items.beef);
        tag.setInteger("MaterialId", ConfigurationHandler.initialIDRange + data.ordinal());
        tag.setInteger("Value", 1);
        NBTTagCompound itemTag = new NBTTagCompound();
        NBTTagCompound shardTag = new NBTTagCompound();
        swordStack.writeToNBT(itemTag);
        shard.writeToNBT(shardTag);
        tag.setTag("Item", itemTag);
        tag.setTag("Shard", shardTag);
        FMLInterModComms.sendRuntimeMessage(Constants.MOD_ID, "TConstruct", "addPartBuilderMaterial", tag);
    }

    public static void createAndAddSmelteryMelting(EnumMoreSwords data) {

        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("FluidName", "msm.fluid." + data.swordName);
        tag.setInteger("Amount", 4000);
        ItemStack swordStack = new ItemStack(SwordItems.swordList.get(data.swordName));
        ItemStack swordBlock = new ItemStack(Blocks.iron_block);
        NBTTagCompound itemTag = new NBTTagCompound();
        NBTTagCompound blockTag = new NBTTagCompound();
        swordStack.writeToNBT(itemTag);
        swordBlock.writeToNBT(blockTag);
        tag.setTag("Item", itemTag);
        tag.setTag("Block", blockTag);
        tag.setInteger("Temperature", 75);//data.swordDurability / 10);
        FMLInterModComms.sendRuntimeMessage(Constants.MOD_ID, "TConstruct", "addSmelteryMelting", tag);
    }

    public static class BlockSwordFluid extends BlockFluidClassic {

        @SideOnly(Side.CLIENT)
        protected IIcon stillIcon;

        @SideOnly(Side.CLIENT)
        protected IIcon flowingIcon;

        protected String fluidName;

        public BlockSwordFluid(Fluid fluid, String fluidName) {

            super(fluid, Material.lava);
            this.fluidName = fluidName;
            setCreativeTab(MoreSwords.tabSwords);
        }

        @Override
        public IIcon getIcon(int side, int meta) {

            return (side == 0 || side == 1) ? stillIcon : flowingIcon;
        }

        @SideOnly(Side.CLIENT)
        @Override
        public void registerBlockIcons(IIconRegister register) {

            stillIcon = register.registerIcon("moreswords:fluid_" + fluidName + "_still");
            flowingIcon = register.registerIcon("moreswords:fluid_" + fluidName + "_slowing");
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
