package net.darkhax.moreswords.client.gui;

import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;

public class GuiFactoryMoreSwords implements IModGuiFactory {
    
    @Override
    public void initialize (Minecraft minecraftInstance) {
    
    }
    
    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass () {
        
        return GuiConfigMoreSwords.class;
    }
    
    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories () {
        
        return null;
    }
    
    @Override
    public RuntimeOptionGuiHandler getHandlerFor (RuntimeOptionCategoryElement element) {
        
        return null;
    }
}
