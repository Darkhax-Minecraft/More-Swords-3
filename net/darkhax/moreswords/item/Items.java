package net.darkhax.moreswords.item;

import net.darkhax.moreswords.lib.Config;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;

public class Items {
	
	public static Item swordDawmStar = new ItemCoreSword(Config.swordDawnStarID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.dawnstar");
	public static Item swordVampiric = new ItemCoreSword(Config.swordVampiricID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.vampiric");
	public static Item swordGladiolus = new ItemCoreSword(Config.swordGladiolusID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.gladiolus");
	public static Item swordDraconic = new ItemCoreSword(Config.swordDraconicID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.draconic");
	public static Item swordEnder = new ItemCoreSword(Config.swordEnderID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.ender");
	public static Item swordCrystal = new ItemCoreSword(Config.swordCrystalID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.crystal");
	public static Item swordInfinity = new ItemCoreSword(Config.swordInfinityID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.infinity");
	public static Item swordGlacial = new ItemCoreSword(Config.swordGlacialID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.glacial");
	public static Item swordAether = new ItemCoreSword(Config.swordAetherID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.aether");
	public static Item swordWither = new ItemCoreSword(Config.swordWitherID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.wither");
	public static Item swordAdmin = new ItemCoreSword(Config.swordAdminID, EnumToolMaterial.EMERALD).setUnlocalizedName("msm.admin");
	
	public Items() {
		
	}
}