package twilight_magical.minecraft_forge_modding.super_world_gem.items;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

//import ClassData.TwilightMagical.MinecraftForgeMod.SuperWorldGem.items.*;
//import ClassData.TwilightMagical.MinecraftForgeMod.SuperWorldGem.SuperWorldGemMod;

public class Item_SuperWorldGemMod extends Item {
	
	public static Item SilverIngot;
	public static Item AluminiumIngot;
	public static Item CopperIngot;
	public static Item AtannumIngot;
	public static Item TitaniumIngot;
	public static Item ZincIngot;
	public static Item SuperWorldAlloyIngot;
	
	public static Item MixedMineralBlockCrystallization;
	public static Item MonsterBlockCrystallization;
	
	public static Item ArcticIceBall;
	public static Item DivineLightCream;
	public static Item ExtremelyUnstableToxicLiquid;
	public static Item SkeletonArchersSoul;
	
	//Minecraft Games Use [Forge Mod Loader] to register these item objects
	//Minecraft 游戏 使用[Forge Mod Loader]注册这些物品对象
	public static void createItems() {
		
		GameRegistry.registerItem(SilverIngot = new LoadSilverIngotItem("SilverIngot"),"SilverIngot");
		GameRegistry.registerItem(AluminiumIngot = new LoadAluminiumIngotItem("AluminiumIngot"),"AluminiumIngot");
		GameRegistry.registerItem(CopperIngot = new LoadCopperIngotItem("CopperIngot"),"CopperIngot");
		GameRegistry.registerItem(AtannumIngot = new LoadAtannumIngotItem("AtannumIngot"),"AtannumIngot");
		GameRegistry.registerItem(TitaniumIngot = new LoadTitaniumIngotItem("TitaniumIngot"),"TitaniumIngot");
		GameRegistry.registerItem(ZincIngot = new LoadZincIngotItem("ZincIngot"),"ZincIngot");
		GameRegistry.registerItem(SuperWorldAlloyIngot = new LoadSuperWorldAlloyIngotItem("SuperWorldAlloyIngot"),"SuperWorldAlloyIngot");
		
		GameRegistry.registerItem(MixedMineralBlockCrystallization = new LoadMixedMineralBlockCrystallizationItem("MixedMineralBlockCrystallization"),"MixedMineralBlockCrystallization");
		GameRegistry.registerItem(MonsterBlockCrystallization = new LoadMonsterBlockCrystallizationItem("MonsterBlockCrystallization"),"MonsterBlockCrystallization");
		
		GameRegistry.registerItem(ArcticIceBall = new LoadArcticIceBallItem("ArcticIceBall"),"ArcticIceBall");
		GameRegistry.registerItem(DivineLightCream = new LoadDivineLightCreamItem("DivineLightCream"),"DivineLightCream");
		GameRegistry.registerItem(ExtremelyUnstableToxicLiquid = new LoadExtremelyUnstableToxicLiquid("ExtremelyUnstableToxicLiquid"),"ExtremelyUnstableToxicLiquid");
		GameRegistry.registerItem(SkeletonArchersSoul = new LoadSkeletonArchersSoulItem("SkeletonArchersSoul"),"SkeletonArchersSoul");
		
	}

}
