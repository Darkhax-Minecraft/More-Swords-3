package net.darkhax.moreswords.item;

import java.util.HashMap;

import net.darkhax.moreswords.util.Constants;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class SwordItems {
    
    public static HashMap<String, Item> swordList = new HashMap();
    public static String[] swordNames = { "dawnstar", "vampiric", "gladiolus", "draconic", "ender", "crystal", "glacial", "aether", "wither", "admin" };
    
    public SwordItems() {
    
        for (int pos = 0; pos < swordNames.length; pos++)
            generateNewSword(swordNames[pos]);
    }
    
    public static void generateNewSword (String swordName) {
    
        ItemBaseSword sword = new ItemBaseSword(swordName);
        GameRegistry.registerItem(sword, swordName);
        swordList.put(swordName, sword);
    }
    
    public static Item getSwordFromRegistry (String swordName) {
    
        Item sword = swordList.get(swordName);
        
        if (sword != null)
            return sword;
        
        else
            return swordList.get("admin");
    }
    
    public static Item getRandomSword () {
    
        Object[] values = SwordItems.swordList.values().toArray();
        return (Item) values[Constants.RANDOM.nextInt(values.length)];
    }
}