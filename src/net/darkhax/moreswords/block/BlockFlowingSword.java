package net.darkhax.moreswords.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.lib.Reference;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;

public class BlockFlowingSword extends BlockLiquid {

	private IIcon iconStill;
	private IIcon iconFlowing;
	private String liquidName;

	public BlockFlowingSword(String liquidName) {

		super(Material.water);
		this.setHardness(1337);
		this.setLightOpacity(1);
		this.liquidName = liquidName;
		this.setCreativeTab(MoreSwords.tabSwords);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {

		this.iconStill = ir.registerIcon(Reference.TEXTURE_DOMAIN + this.liquidName + "_still");
		this.iconFlowing = ir.registerIcon(Reference.TEXTURE_DOMAIN + this.liquidName + "_flow");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {

		if (side == 0 || side == 1) {

			return this.iconStill;
		}

		return this.iconFlowing;
	}
}