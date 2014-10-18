package net.darkhax.moreswords.pedestal;

import net.darkhax.moreswords.MoreSwords;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockPedestal extends BlockContainer {

    protected BlockPedestal() {

        super(Material.rock);
        this.setBlockName("soulStatue");
        this.setBlockTextureName("stone");
        this.setCreativeTab(MoreSwords.tabSwords);
        this.setLightOpacity(0);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
        this.setHardness(3.0f);
        this.setResistance(6.0f);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack) {

        TileEntityPedestal tile = (TileEntityPedestal) world.getTileEntity(x, y, z);
        tile.setDirection(MathHelper.floor_double((double) ((living.rotationYaw * 4F) / 360F) + 0.5D) & 3);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {

        return new TileEntityPedestal();
    }

    @Override
    public boolean renderAsNormalBlock() {

        return false;
    }

    @Override
    public boolean isOpaqueCube() {

        return false;
    }

    @Override
    public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z) {

        return world.setBlock(x, y, z, Blocks.air);
    }
}