package net.darkhax.moreswords.item;

import java.util.ArrayList;
import java.util.List;

import net.darkhax.moreswords.util.Reference;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class SwordItems {

    public static List<ItemBaseSword> swordList = new ArrayList<ItemBaseSword>();

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

        registerItem(swordDawmStar);
        registerItem(swordVampiric);
        registerItem(swordGladiolus);
        registerItem(swordDraconic);
        registerItem(swordEnder);
        registerItem(swordCrystal);
        registerItem(swordGlacial);
        registerItem(swordAether);
        registerItem(swordWither);
        registerItem(swordAdmin);
        // registerItem(swordHoliday);
    }

    public void registerItem(Item item) {

        ItemBaseSword sword = (ItemBaseSword) item;
        GameRegistry.registerItem(item, sword.swordName, Reference.MOD_ID);
        swordList.add(sword);
    }
}