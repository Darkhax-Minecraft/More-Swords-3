package net.darkhax.moreswords.item;

import net.darkhax.moreswords.lib.Config;
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
		
		swordDawmStar = new ItemCoreSword(Config.swordDawnStarID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.dawnstar");
		swordVampiric = new ItemCoreSword(Config.swordVampiricID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.vampiric");
		swordGladiolus = new ItemCoreSword(Config.swordGladiolusID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.gladiolus");
		swordDraconic = new ItemCoreSword(Config.swordDraconicID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.draconic");
		swordEnder = new ItemCoreSword(Config.swordEnderID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.ender");
		swordCrystal = new ItemCoreSword(Config.swordCrystalID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.crystal");
		swordInfinity = new ItemCoreSword(Config.swordInfinityID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.infinity");
		swordGlacial = new ItemCoreSword(Config.swordGlacialID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.glacial");
		swordAether = new ItemCoreSword(Config.swordAetherID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.aether");
		swordWither = new ItemCoreSword(Config.swordWitherID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.wither");
		swordAdmin = new ItemCoreSword(Config.swordAdminID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.admin");
	}
}
