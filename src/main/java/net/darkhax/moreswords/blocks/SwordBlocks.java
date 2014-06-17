package net.darkhax.moreswords.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class SwordBlocks {

	public static Block blockCompact = new BlockCompactSword();
	
	public SwordBlocks() {
		
		GameRegistry.registerBlock(blockCompact, ItemBlockCompactSword.class, "compactSwordBlock");  
	}
}
