package twilight_magical.minecraft_forge_modding.super_world_gem.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

//import ClassData.TwilightMagical.MinecraftForgeMod.SuperWorldGem.blocks.*;
//import ClassData.TwilightMagical.MinecraftForgeMod.SuperWorldGem.SuperWorldGemMod;

public class Block_SuperWorldGemMod {
	
	//Create a Minecraft object named "MixedMineralBlock"
	//创建一个Minecraft方块对象，名称为“MixedMineralBlock”
	public static Block MixedMineralBlock;
	public static Block MonsterBlock;
	public static Block HellFireCoalBlock;
	
	public static Block SuperWorldGemBlock;
	public static Block SuperWorldAetherGemBlock;
	public static Block DangerToxicBlock;
	public static Block UnstableNuke;
	
	public static Block SilverOre;
	public static Block AluminiumOre;
	public static Block CopperOre;
	public static Block AtannumOre;
	public static Block TitaniumOre;
	public static Block ZincOre;
	
	
	//Minecraft Games Use [Forge Mod Loader] to register these block objects
	//Minecraft 游戏 使用[Forge Mod Loader]注册这些方块对象
	public static void createBlocks() {
		
		//setLightLevel(1.0f) 调整这个方块对象，设置为1格亮度发光！应用在Minecraft游戏中
		//setLightLevel(1.0f) Adjust this square object, set to 1 grid brightness glow! Used in Minecraft games
		GameRegistry.registerBlock(MixedMineralBlock = new LoadMixedMineralBlock("MixedMineralBlock").setLightLevel(0.0f),"MixedMineralBlock"); 
		GameRegistry.registerBlock(MonsterBlock = new LoadMonsterBlock("MonsterBlock").setLightLevel(0.0f),"MonsterBlock");
		GameRegistry.registerBlock(HellFireCoalBlock = new LoadHellFireCoalBlock("HellFireCoalBlock").setLightLevel(1.0f),"HellFireCoalBlock");
		
		GameRegistry.registerBlock(SuperWorldGemBlock = new LoadSuperWorldGemBlock("SuperWorldGemBlock").setLightLevel(0.0f),"SuperWorldGemBlock");
		GameRegistry.registerBlock(SuperWorldAetherGemBlock = new LoadSuperWorldAetherGemBlock("SuperWorldAetherGemBlock").setLightLevel(1.0f),"SuperWorldAetherGemBlock");
		GameRegistry.registerBlock(DangerToxicBlock = new LoadDangerToxicBlock("DangerToxicBlock").setLightLevel(0.0f),"DangerToxicBlock");
		GameRegistry.registerBlock(UnstableNuke = new LoadUnstableNuke("UnstableNuke").setLightLevel(0.0f),"UnstableNuke");
		
		GameRegistry.registerBlock(SilverOre = new LoadSilverOreBlock("SilverOre").setLightLevel(0.5f),"SilverOre");
		GameRegistry.registerBlock(AluminiumOre = new LoadAluminiumOreBlock("AluminiumOre").setLightLevel(0.5f),"AluminiumOre");
		GameRegistry.registerBlock(CopperOre = new LoadCopperOreBlock("CopperOre").setLightLevel(0.0f),"CopperOre");
		GameRegistry.registerBlock(AtannumOre = new LoadAtannumOreBlock("AtannumOre").setLightLevel(0.1f),"AtannumOre");
		GameRegistry.registerBlock(TitaniumOre = new LoadTitaniumOreBlock("TitaniumOre").setLightLevel(0.75f),"TitaniumOre");
		GameRegistry.registerBlock(ZincOre = new LoadZincOreBlock("ZincOre").setLightLevel(0.25f),"ZincOre");
		
		
	}

}
