package net.darkhax.moreswords.handler;

import net.darkhax.moreswords.item.ItemBaseSword;
import net.darkhax.moreswords.item.SwordItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHandler {

    ConfigurationHandler cfg;
    SwordItems swords;
    Items items;
    Blocks blocks;

    public RecipeHandler(Boolean status) {

    	FMLCommonHandler.instance().bus().register(this);
        if (status) {

            createItemRecipe(new ItemStack(swords.swordDawmStar), new Object[] { "xyz", "yzy", "ayx", Character.valueOf('x'), items.blaze_powder, Character.valueOf('y'), items.fire_charge, Character.valueOf('z'), items.magma_cream, Character.valueOf('a'), items.blaze_rod }, cfg.craftingDawnStar);
            createItemRecipe(new ItemStack(swords.swordVampiric), new Object[] { " xy", "zyx", "az ", Character.valueOf('x'), items.iron_ingot, Character.valueOf('y'), items.redstone, Character.valueOf('z'), blocks.obsidian, Character.valueOf('a'), items.stick }, cfg.craftingVampiric);
            createItemRecipe(new ItemStack(swords.swordGladiolus), new Object[] { " xy", "zax", "bz ", Character.valueOf('x'), blocks.leaves, Character.valueOf('y'), blocks.vine, Character.valueOf('z'), blocks.sapling, Character.valueOf('a'), new ItemStack(blocks.red_flower, 1, 1), Character.valueOf('b'), items.stick }, cfg.craftingGladiolus);
            createItemRecipe(new ItemStack(swords.swordDraconic), new Object[] { " xy", "zax", "bz ", Character.valueOf('x'), items.iron_ingot, Character.valueOf('y'), items.redstone, Character.valueOf('z'), new ItemStack(items.dye, 1, 4), Character.valueOf('a'), items.diamond, Character.valueOf('b'), items.stick }, cfg.craftingDraconic);
            createItemRecipe(new ItemStack(swords.swordEnder), new Object[] { " xy", "zax", "bz ", Character.valueOf('x'), items.ender_pearl, Character.valueOf('y'), blocks.obsidian, Character.valueOf('z'), items.diamond, Character.valueOf('a'), items.ender_eye, Character.valueOf('b'), items.stick }, cfg.craftingDraconic);
            createItemRecipe(new ItemStack(swords.swordCrystal), new Object[] { " xx", "yzx", "ay ", Character.valueOf('x'), blocks.glass, Character.valueOf('y'), items.quartz, Character.valueOf('z'), blocks.glass_pane, Character.valueOf('a'), items.stick }, cfg.craftingCrystal);
            createItemRecipe(new ItemStack(swords.swordGlacial), new Object[] { " xy", "xyx", "zx ", Character.valueOf('x'), blocks.ice, Character.valueOf('y'), blocks.packed_ice, Character.valueOf('z'), items.stick }, cfg.craftingGlacial);
            createItemRecipe(new ItemStack(swords.swordAether), new Object[] { "abc", "bcd", "eda", Character.valueOf('a'), Items.feather, Character.valueOf('b'), items.diamond, Character.valueOf('c'), Blocks.glowstone, Character.valueOf('d'), Items.iron_ingot, Character.valueOf('e'), Items.stick }, cfg.craftingAether);
            createItemRecipe(new ItemStack(swords.swordWither), new Object[] { " xx", "yzx", "ay ", Character.valueOf('x'), blocks.soul_sand, Character.valueOf('y'), items.quartz, Character.valueOf('z'), items.nether_star, Character.valueOf('a'), items.stick }, cfg.craftingWither);
            createItemRecipe(new ItemStack(swords.swordAdmin), new Object[] { " xx", "yzx", "ay ", Character.valueOf('x'), blocks.bedrock, Character.valueOf('y'), blocks.end_portal_frame, Character.valueOf('z'), blocks.command_block, Character.valueOf('a'), items.stick }, cfg.craftingAdmin);
            createItemRecipe(new ItemStack(swords.swordHoliday), new Object[] { " xy", "xyx", "zx ", Character.valueOf('x'), items.fireworks, Character.valueOf('y'), blocks.wool, Character.valueOf('z'), items.stick}, cfg.craftingHoliday);
        }
    }

    void createItemRecipe(ItemStack output, Object[] recipe, boolean craftable) {

        if (craftable) {

            GameRegistry.addShapedRecipe(output, recipe);
        }
    }
    
    @SubscribeEvent
    public void onItemCrafted(ItemCraftedEvent event) {
    	
    	System.out.println("Item has been crafted");
    	if (event.crafting != null && event.crafting.getItem() instanceof ItemBaseSword)
    		//SwordData.checkForOngoingEvent(event.crafting);
    		System.out.println("");
    	
    	else 
    		event.crafting.setStackDisplayName("Somethings wrong");
    }
}
