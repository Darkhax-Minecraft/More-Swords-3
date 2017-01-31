package net.darkhax.moreswords.client;

import net.darkhax.moreswords.common.CommonProxy;
import net.darkhax.moreswords.item.SwordItems;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

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