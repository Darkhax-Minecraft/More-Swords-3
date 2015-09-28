package net.darkhax.moreswords.proxy;

import net.darkhax.moreswords.item.SwordItems;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.client.FMLClientHandler;

public class ClientProxy extends CommonProxy {
    
    @Override
    public void registerSidedEvents () {
    
    }
    
    @Override
    public void registerRenders () {
        
        for (String name : SwordItems.swordList.keySet()) {
            
            System.out.println(name);
            ModelBakery.addVariantName(SwordItems.swordList.get(name), "msm3:" + name);
            FMLClientHandler.instance().getClient().getRenderItem().getItemModelMesher().register(SwordItems.swordList.get(name), 0, new ModelResourceLocation("msm3:" + name, "inventory"));
        }
    }
}