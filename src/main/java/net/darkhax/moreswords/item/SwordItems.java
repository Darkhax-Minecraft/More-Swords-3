package net.darkhax.moreswords.item;

import java.util.HashMap;
import java.util.Random;

import net.darkhax.moreswords.util.Constants;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SwordItems {
    
    public static HashMap<String, Item> swordList = new HashMap();
    
    public static Item swordDawmStar = new ItemBaseSword("dawnstar");
    public static Item swordVampiric = new ItemBaseSword("vampiric");
    public static Item swordGladiolus = new ItemBaseSword("gladiolus");
    public static Item swordDraconic = new ItemBaseSword("draconic");
    public static Item swordEnder = new ItemBaseSword("ender");
    public static Item swordCrystal = new ItemBaseSword("crystal");
    public static Item swordGlacial = new ItemBaseSword("glacial");
    public static Item swordAether = new ItemBaseSword("aether");
    public static Item swordWither = new ItemBaseSword("wither");
    public static Item swordLux = new ItemBaseSword("lux");
    public static Item swordAdmin = new ItemBaseSword("admin");
    
    /**
     * Registers a sword item with the sword list, and the games item registry.
     * 
     * @param item: The Item object being registered.
     */
    public static void registerSwordItem (Item item) {
        
        ItemBaseSword sword = (ItemBaseSword) item;
        GameRegistry.registerItem(item, sword.swordName, Constants.ID);
        swordList.put(sword.swordName, item);
    }
    
    /**
     * Retrieves a random sword item from the swordList.
     */
    public static Item getRandomSword () {
        
        Random rnd = new Random();
        Object[] values = SwordItems.swordList.values().toArray();
        return (Item) values[rnd.nextInt(values.length)];
    }
}