package net.darkhax.moreswords.addons.jei;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IVanillaRecipeFactory;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.materials.SwordMaterial;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class JEIPluginMSM implements IModPlugin {
    
    public static final String CATEGORY_AWAKENING = MoreSwords.MODID + ".awakening";
    
    @Override
    public void register (IModRegistry registry) {
        
        for (SwordMaterial material : MoreSwords.MATERIALS.values()) {
            
            registry.addIngredientInfo(material.getInertItem(), ItemStack.class, "description.msm." + material.getName() + ".awakening");
            registry.addIngredientInfo(material.getBrokenItem(), ItemStack.class, "description.msm.broken");
            registry.addIngredientInfo(new ItemStack(material.getAwakenedItem()), ItemStack.class, "description.msm." + material.getName() + ".awakened");
            
            System.out.println("description.msm." + material.getName() + ".awakening=");
            System.out.println("description.msm." + material.getName() + ".awakened=");
            
            // Anvil Stuff
            addRepairAnvilRecipe(registry, material.getRepairStack(), new ItemStack(material.getAwakenedItem()));
            addAnvilRecipe(registry, material.getBrokenItem(), material.getRepairStack(), new ItemStack(material.getAwakenedItem(), 1, material.getMaxUses() - material.getMaxUses() / 4));
        }
    }
    
    public void addRepairAnvilRecipe(IModRegistry registry, ItemStack repairMaterial, ItemStack ingredient) {
        
        IVanillaRecipeFactory vanillaRecipeFactory = registry.getJeiHelpers().getVanillaRecipeFactory();

        ItemStack damaged1 = ingredient.copy();
        damaged1.setItemDamage(damaged1.getMaxDamage());
        ItemStack damaged2 = ingredient.copy();
        damaged2.setItemDamage(damaged2.getMaxDamage() * 3 / 4);
        ItemStack damaged3 = ingredient.copy();
        damaged3.setItemDamage(damaged3.getMaxDamage() * 2 / 4);

        IRecipeWrapper repairWithMaterial = vanillaRecipeFactory.createAnvilRecipe(damaged1, Collections.singletonList(repairMaterial), Collections.singletonList(damaged2));
        IRecipeWrapper repairWithSame = vanillaRecipeFactory.createAnvilRecipe(damaged2, Collections.singletonList(damaged2), Collections.singletonList(damaged3));
        registry.addRecipes(ImmutableList.of(repairWithMaterial, repairWithSame), VanillaRecipeCategoryUid.ANVIL);
    }
    
    public void addAnvilRecipe(IModRegistry registry, ItemStack left, ItemStack right, ItemStack output) {
        
        IVanillaRecipeFactory vanillaRecipeFactory = registry.getJeiHelpers().getVanillaRecipeFactory();
        IRecipeWrapper recipe = vanillaRecipeFactory.createAnvilRecipe(left, Collections.singletonList(right), Collections.singletonList(output));
        registry.addRecipes(ImmutableList.of(recipe), VanillaRecipeCategoryUid.ANVIL);
    }
}