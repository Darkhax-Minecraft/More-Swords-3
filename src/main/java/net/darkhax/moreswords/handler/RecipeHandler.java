package net.darkhax.moreswords.handler;

import net.darkhax.moreswords.item.SwordItems;
import net.darkhax.moreswords.util.Constants;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {
    
    public RecipeHandler() {
        
        if (ConfigurationHandler.itemsCraftable) {
            
            createItemRecipe(new ItemStack(SwordItems.swordDawmStar), new Object[] { "xyz", "yzy", "ayx", Character.valueOf('x'), Items.blaze_powder, Character.valueOf('y'), Items.fire_charge, Character.valueOf('z'), Items.magma_cream, Character.valueOf('a'), Items.blaze_rod }, ConfigurationHandler.craftingDawnStar);
            createItemRecipe(new ItemStack(SwordItems.swordVampiric), new Object[] { " xy", "zyx", "az ", Character.valueOf('x'), Items.iron_ingot, Character.valueOf('y'), Items.redstone, Character.valueOf('z'), Blocks.obsidian, Character.valueOf('a'), Items.stick }, ConfigurationHandler.craftingVampiric);
            createItemRecipe(new ItemStack(SwordItems.swordGladiolus), new Object[] { " xy", "zax", "bz ", Character.valueOf('x'), Blocks.leaves, Character.valueOf('y'), Blocks.vine, Character.valueOf('z'), Blocks.sapling, Character.valueOf('a'), new ItemStack(Blocks.red_flower, 1, 1), Character.valueOf('b'), Items.stick }, ConfigurationHandler.craftingGladiolus);
            createItemRecipe(new ItemStack(SwordItems.swordDraconic), new Object[] { " xy", "zax", "bz ", Character.valueOf('x'), Items.iron_ingot, Character.valueOf('y'), Items.redstone, Character.valueOf('z'), new ItemStack(Items.dye, 1, 4), Character.valueOf('a'), Items.diamond, Character.valueOf('b'), Items.stick }, ConfigurationHandler.craftingDraconic);
            createItemRecipe(new ItemStack(SwordItems.swordEnder), new Object[] { " xy", "zax", "bz ", Character.valueOf('x'), Items.ender_pearl, Character.valueOf('y'), Blocks.obsidian, Character.valueOf('z'), Items.diamond, Character.valueOf('a'), Items.ender_eye, Character.valueOf('b'), Items.stick }, ConfigurationHandler.craftingDraconic);
            createItemRecipe(new ItemStack(SwordItems.swordCrystal), new Object[] { " xx", "yzx", "ay ", Character.valueOf('x'), Blocks.glass, Character.valueOf('y'), Items.quartz, Character.valueOf('z'), Blocks.glass_pane, Character.valueOf('a'), Items.stick }, ConfigurationHandler.craftingCrystal);
            createItemRecipe(new ItemStack(SwordItems.swordGlacial), new Object[] { " xy", "xyx", "zx ", Character.valueOf('x'), Blocks.ice, Character.valueOf('y'), Blocks.packed_ice, Character.valueOf('z'), Items.stick }, ConfigurationHandler.craftingGlacial);
            createItemRecipe(new ItemStack(SwordItems.swordAether), new Object[] { "abc", "bcd", "eda", Character.valueOf('a'), Items.feather, Character.valueOf('b'), Items.diamond, Character.valueOf('c'), Blocks.glowstone, Character.valueOf('d'), Items.iron_ingot, Character.valueOf('e'), Items.stick }, ConfigurationHandler.craftingAether);
            createItemRecipe(new ItemStack(SwordItems.swordWither), new Object[] { " xx", "yzx", "ay ", Character.valueOf('x'), Blocks.soul_sand, Character.valueOf('y'), Items.quartz, Character.valueOf('z'), Items.nether_star, Character.valueOf('a'), Items.stick }, ConfigurationHandler.craftingWither);
            createItemRecipe(new ItemStack(SwordItems.swordAdmin), new Object[] { " xx", "yzx", "ay ", Character.valueOf('x'), Blocks.bedrock, Character.valueOf('y'), Blocks.end_portal_frame, Character.valueOf('z'), Blocks.command_block, Character.valueOf('a'), Items.stick }, ConfigurationHandler.craftingAdmin);
        }
    }
    
    /**
     * Adds an item recipe, that can be disabled. This reduces the amount of if statements.
     * 
     * @param output: The output stack that will be created by the recipe.
     * @param recipe: An Object array that represents the crafting recipe.
     * @param craftable: Can this item be crafted? This should be hooked up to a config.
     */
    private void createItemRecipe (ItemStack output, Object[] recipe, boolean craftable) {
        
        if (craftable)
            GameRegistry.addShapedRecipe(output, recipe);
            
        else
            Constants.LOGGER.info("Recipe for " + output.getDisplayName() + " has been disabled in the configuration.");
    }
}
