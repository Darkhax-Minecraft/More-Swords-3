package net.darkhax.moreswords.handler;

import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.item.SwordItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHandler {
    
    public RecipeHandler() {
    
        if (ConfigurationHandler.itemsCraftable) {
            
            createItemRecipe("dawnstar", new Object[] { "xyz", "yzy", "ayx", Character.valueOf('x'), Items.blaze_powder, Character.valueOf('y'), Items.fire_charge, Character.valueOf('z'), Items.magma_cream, Character.valueOf('a'), Items.blaze_rod });
            createItemRecipe("vampiric", new Object[] { " xy", "zyx", "az ", Character.valueOf('x'), Items.iron_ingot, Character.valueOf('y'), Items.redstone, Character.valueOf('z'), Blocks.obsidian, Character.valueOf('a'), Items.stick });
            createItemRecipe("gladiolus", new Object[] { " xy", "zax", "bz ", Character.valueOf('x'), Blocks.leaves, Character.valueOf('y'), Blocks.vine, Character.valueOf('z'), Blocks.sapling, Character.valueOf('a'), new ItemStack(Blocks.red_flower, 1, 1), Character.valueOf('b'), Items.stick });
            createItemRecipe("draconic", new Object[] { " xy", "zax", "bz ", Character.valueOf('x'), Items.iron_ingot, Character.valueOf('y'), Items.redstone, Character.valueOf('z'), new ItemStack(Items.dye, 1, 4), Character.valueOf('a'), Items.diamond, Character.valueOf('b'), Items.stick });
            createItemRecipe("ender", new Object[] { " xy", "zax", "bz ", Character.valueOf('x'), Items.ender_pearl, Character.valueOf('y'), Blocks.obsidian, Character.valueOf('z'), Items.diamond, Character.valueOf('a'), Items.ender_eye, Character.valueOf('b'), Items.stick });
            createItemRecipe("crystal", new Object[] { " xx", "yzx", "ay ", Character.valueOf('x'), Blocks.glass, Character.valueOf('y'), Items.quartz, Character.valueOf('z'), Blocks.glass_pane, Character.valueOf('a'), Items.stick });
            createItemRecipe("glacial", new Object[] { " xy", "xyx", "zx ", Character.valueOf('x'), Blocks.ice, Character.valueOf('y'), Blocks.packed_ice, Character.valueOf('z'), Items.stick });
            createItemRecipe("aether", new Object[] { "abc", "bcd", "eda", Character.valueOf('a'), Items.feather, Character.valueOf('b'), Items.diamond, Character.valueOf('c'), Blocks.glowstone, Character.valueOf('d'), Items.iron_ingot, Character.valueOf('e'), Items.stick });
            createItemRecipe("wither", new Object[] { " xx", "yzx", "ay ", Character.valueOf('x'), Blocks.soul_sand, Character.valueOf('y'), Items.quartz, Character.valueOf('z'), Items.nether_star, Character.valueOf('a'), Items.stick });
            createItemRecipe("admin", new Object[] { " xx", "yzx", "ay ", Character.valueOf('x'), Blocks.bedrock, Character.valueOf('y'), Blocks.end_portal_frame, Character.valueOf('z'), Blocks.command_block, Character.valueOf('a'), Items.stick });
        }
    }
    
    public void createItemRecipe (String swordName, Object[] recipe) {
    
        if (MoreSwords.swordTypes.get(swordName).isCraftable)
            ;
        GameRegistry.addShapedRecipe(new ItemStack(SwordItems.getSwordFromRegistry(swordName)), recipe);
    }
}
