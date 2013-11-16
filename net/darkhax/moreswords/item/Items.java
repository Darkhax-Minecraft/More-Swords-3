package net.darkhax.moreswords.item;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;

public class Items {

	public static Item swordDawmStar;
	public static Item swordVampiric;
	public static Item swordGladiolus;
	public static Item swordDraconic;
	public static Item swordEnder;
	public static Item swordCrystal;
	public static Item swordInfinity;
	public static Item swordGlacial;
	public static Item swordAether;
	public static Item swordWither;
	public static Item swordAdmin;
	
	public Items() {
		
		addItems();
	}
	
	void addItems() {
		
		swordDawmStar = new ItemCoreSword(13400, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.dawnstar");
		swordVampiric = new ItemCoreSword(13401, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.vampiric");
		swordGladiolus = new ItemCoreSword(13402, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.gladiolus");
		swordDraconic = new ItemCoreSword(13403, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.draconic");
		swordEnder = new ItemCoreSword(13404, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.ender");
		swordCrystal = new ItemCoreSword(13405, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.crystal");
		swordInfinity = new ItemCoreSword(13406, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.infinity");
		swordGlacial = new ItemCoreSword(13407, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.glacial");
		swordAether = new ItemCoreSword(13408, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.aether");
		swordWither = new ItemCoreSword(13409, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.wither");
		swordAdmin = new ItemCoreSword(13410, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.admin");
	}
}
