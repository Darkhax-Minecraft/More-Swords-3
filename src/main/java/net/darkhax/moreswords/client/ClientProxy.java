package net.darkhax.moreswords.client;

import net.darkhax.moreswords.common.CommonProxy;
import net.darkhax.moreswords.item.SwordItems;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.FMLClientHandler;

public class ClientProxy extends CommonProxy {
    
    @Override
    public void registerSidedEvents () {
    
    }
    
    @Override
    public void registerRenders () {
    	
        for (String name : SwordItems.swordList.keySet()) {
            
            ModelLoader.setCustomModelResourceLocation(SwordItems.swordList.get(name), 0, new ModelResourceLocation("msm3:" + name, "inventory"));
        }
    }
}