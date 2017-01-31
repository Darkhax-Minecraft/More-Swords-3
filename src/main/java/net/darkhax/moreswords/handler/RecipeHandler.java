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
            
            createItemRecipe(new ItemStack(SwordItems.swordDawmStar), new Object[] { "xyz", "yzy", "ayx", Character.valueOf('x'), Items.BLAZE_POWDER, Character.valueOf('y'), Items.FIRE_CHARGE, Character.valueOf('z'), Items.MAGMA_CREAM, Character.valueOf('a'), Items.BLAZE_ROD }, ConfigurationHandler.craftingDawnStar);
            createItemRecipe(new ItemStack(SwordItems.swordVampiric), new Object[] { " xy", "zyx", "az ", Character.valueOf('x'), Items.IRON_INGOT, Character.valueOf('y'), Items.REDSTONE, Character.valueOf('z'), Blocks.OBSIDIAN, Character.valueOf('a'), Items.STICK }, ConfigurationHandler.craftingVampiric);
            createItemRecipe(new ItemStack(SwordItems.swordGladiolus), new Object[] { " xy", "zax", "bz ", Character.valueOf('x'), Blocks.LEAVES, Character.valueOf('y'), Blocks.VINE, Character.valueOf('z'), Blocks.SAPLING, Character.valueOf('a'), new ItemStack(Blocks.RED_FLOWER, 1, 1), Character.valueOf('b'), Items.STICK }, ConfigurationHandler.craftingGladiolus);
            createItemRecipe(new ItemStack(SwordItems.swordDraconic), new Object[] { " xy", "zax", "bz ", Character.valueOf('x'), Items.IRON_INGOT, Character.valueOf('y'), Items.REDSTONE, Character.valueOf('z'), new ItemStack(Items.DYE, 1, 4), Character.valueOf('a'), Items.DIAMOND, Character.valueOf('b'), Items.STICK }, ConfigurationHandler.craftingDraconic);
            createItemRecipe(new ItemStack(SwordItems.swordEnder), new Object[] { " xy", "zax", "bz ", Character.valueOf('x'), Items.ENDER_PEARL, Character.valueOf('y'), Blocks.OBSIDIAN, Character.valueOf('z'), Items.DIAMOND, Character.valueOf('a'), Items.ENDER_EYE, Character.valueOf('b'), Items.STICK }, ConfigurationHandler.craftingDraconic);
            createItemRecipe(new ItemStack(SwordItems.swordCrystal), new Object[] { " xx", "yzx", "ay ", Character.valueOf('x'), Blocks.GLASS, Character.valueOf('y'), Items.QUARTZ, Character.valueOf('z'), Blocks.GLASS_PANE, Character.valueOf('a'), Items.STICK }, ConfigurationHandler.craftingCrystal);
            createItemRecipe(new ItemStack(SwordItems.swordGlacial), new Object[] { " xy", "xyx", "zx ", Character.valueOf('x'), Blocks.GLASS, Character.valueOf('y'), Blocks.PACKED_ICE, Character.valueOf('z'), Items.STICK }, ConfigurationHandler.craftingGlacial);
            createItemRecipe(new ItemStack(SwordItems.swordAether), new Object[] { "abc", "bcd", "eda", Character.valueOf('a'), Items.FEATHER, Character.valueOf('b'), Items.DIAMOND, Character.valueOf('c'), Blocks.GLOWSTONE, Character.valueOf('d'), Items.IRON_INGOT, Character.valueOf('e'), Items.STICK }, ConfigurationHandler.craftingAether);
            createItemRecipe(new ItemStack(SwordItems.swordWither), new Object[] { " xx", "yzx", "ay ", Character.valueOf('x'), Blocks.SOUL_SAND, Character.valueOf('y'), Items.QUARTZ, Character.valueOf('z'), Items.NETHER_STAR, Character.valueOf('a'), Items.STICK }, ConfigurationHandler.craftingWither);
            createItemRecipe(new ItemStack(SwordItems.swordAdmin), new Object[] { " xx", "yzx", "ay ", Character.valueOf('x'), Blocks.BEDROCK, Character.valueOf('y'), Blocks.END_PORTAL_FRAME, Character.valueOf('z'), Blocks.COMMAND_BLOCK, Character.valueOf('a'), Items.STICK }, ConfigurationHandler.craftingAdmin);
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
