package net.darkhax.moreswords.item;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import net.darkhax.moreswords.MoreSwords;
import net.darkhax.moreswords.block.BlockFlowingSword;
import net.darkhax.moreswords.lib.Config;
import net.darkhax.moreswords.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

public class SwordItems {
	
	List<Item> swordList = new ArrayList<Item>();
	
	public static Item swordDawmStar = new ItemCoreSword("dawnStar");
	public static Item swordVampiric = new ItemCoreSword("vampiric");
	public static Item swordGladiolus = new ItemCoreSword("gladiolus");
	public static Item swordDraconic = new ItemCoreSword("draconic");
	public static Item swordEnder = new ItemCoreSword("ender");
	public static Item swordCrystal = new ItemCoreSword("crystal");
	public static Item swordInfinity = new ItemCoreSword("infinity");
	public static Item swordGlacial = new ItemCoreSword("glacial");
	public static Item swordAether = new ItemCoreSword("aether");
	public static Item swordWither = new ItemCoreSword("wither");
	public static Item swordAdmin = new ItemCoreSword("admin");
   
	public SwordItems() {
		
		registerItem(swordDawmStar);
		registerItem(swordVampiric);
		registerItem(swordGladiolus);
		registerItem(swordDraconic);
		registerItem(swordEnder);
		registerItem(swordCrystal);
		registerItem(swordInfinity);
		registerItem(swordGlacial);
		registerItem(swordAether);
		registerItem(swordWither);
		registerItem(swordAdmin);
	}
	
	public void registerItem(Item item) {
		
		GameRegistry.registerItem(item, item.getUnlocalizedName(), Reference.MOD_ID);
		swordList.add(item);
	}
}