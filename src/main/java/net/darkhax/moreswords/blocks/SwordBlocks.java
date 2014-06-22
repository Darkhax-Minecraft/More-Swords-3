package net.darkhax.moreswords.blocks;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class SwordBlocks {

    public static Block blockCompact = new BlockCompactSword();

    public SwordBlocks() {

        GameRegistry.registerBlock(blockCompact, ItemBlockCompactSword.class, "compactSwordBlock");
    }
}
