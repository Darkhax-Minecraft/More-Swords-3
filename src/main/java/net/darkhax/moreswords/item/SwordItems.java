package net.darkhax.moreswords.item;

import java.util.HashMap;

import net.darkhax.moreswords.util.Constants;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class SwordItems {

    // public static List<ItemBaseSword> swordList = new ArrayList<ItemBaseSword>();
    public static HashMap<String, Item> swordList = new HashMap(50);

    public static Item swordDawmStar = new ItemBaseSword("dawnStar");
    public static Item swordVampiric = new ItemBaseSword("vampiric");
    public static Item swordGladiolus = new ItemBaseSword("gladiolus");
    public static Item swordDraconic = new ItemBaseSword("draconic");
    public static Item swordEnder = new ItemBaseSword("ender");
    public static Item swordCrystal = new ItemBaseSword("crystal");
    public static Item swordGlacial = new ItemBaseSword("glacial");
    public static Item swordAether = new ItemBaseSword("aether");
    public static Item swordWither = new ItemBaseSword("wither");
    public static Item swordAdmin = new ItemBaseSword("admin");

    // public static Item swordHoliday = new ItemBaseSword("holiday");

    public SwordItems() {

        registerSwordItem(swordDawmStar);
        registerSwordItem(swordVampiric);
        registerSwordItem(swordGladiolus);
        registerSwordItem(swordDraconic);
        registerSwordItem(swordEnder);
        registerSwordItem(swordCrystal);
        registerSwordItem(swordGlacial);
        registerSwordItem(swordAether);
        registerSwordItem(swordWither);
        registerSwordItem(swordAdmin);
        // registerItem(swordHoliday);
    }

    public void registerSwordItem(Item item) {

        ItemBaseSword sword = (ItemBaseSword) item;
        GameRegistry.registerItem(item, sword.swordName, Constants.MOD_ID);
        swordList.put(sword.swordName, item);
    }
}