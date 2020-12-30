package twilight_magical.minecraft_forge_modding.super_world_gem.tools;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemTool;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper; //EnumHelper = Forge Add Object Extension [Minecraft Object Settings] | Forge 添加对象扩展 [Minecraft 对象设定]
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

//import ClassData.TwilightMagical.MinecraftForgeMod.SuperWorldGem.tools.*;
//import ClassData.TwilightMagical.MinecraftForgeMod.SuperWorldGem.SuperWorldGemMod;

//import ClassData.TwilightMagical.MinecraftForgeMod.SuperWorldGem.tools.*;

public class Tool_SuperWorldGemMod extends Item {
	
	/*--------------------------------------------------------------------------------------------------------------------------------------------------------
	 * EnumHelper.addToolMaterial(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability);
	 * 以上是我们所引用的Forge类函数。如果您在此处出现一个错误，请手动导入代码 [import net.minecraftforge.common.util.EnumHelper;]
	 * This are the Forge class functions we reference. If you get an error here, manually import the code [import net.minecraftforge.common.util.EnumHelper;]
	 * 
	 * 变量： name >>> 材料名称
	 * 变量： harvestLevel >>> 您所设定的工具能够正常开采的硬度等级（比如黑曜石矿为3、钻石矿为2、铁矿为1）
	 * 变量：  maxUses >>> 该工具的耐久度（木质工具为59、钻石工具为1561）
	 * 变量： efficiency >>> 使用该工具开采的速度，您可以根据如下数据进行大概地判断（木质工具：2.0F，钻石工具为8.0F）
	 * 变量： damage >>> 该工具对实体所造成的伤害值，具体计算公式如下（damage value+4）÷2
	 * 变量： enchantability >>> 容易吸引附魔的值，此处不确定（石头为5、钻石为10、金为22）
	 * 
	 * Variable: name >>> material name
     * Variable: harvestLevel >>> The hardness level at which you have set the tool for normal mining (eg 3 for obsidian, 2 for diamond and 1 for iron)
     * Variable: maxUses >>> The durability of the tool (59 for wood tools, 1561 for diamond tools)
     * Variable: efficiency >>> The speed at which the tool is mined can be approximated based on the following data (wood tool: 2.0F, diamond tool: 8.0F)
     * Variable: damage >>> The tool damage caused by the entity value, the specific formula is as follows (damage value + 4) ÷ 2
     * Variable: enchantability >>> Easily attract the value of enchant, here is not sure (stone 5, diamond 10, gold 22)
	 *--------------------------------------------------------------------------------------------------------------------------------------------------------*/

	/*
	static {
		Item.ToolMaterial UNIVERSALSPUERWORLDGEM = EnumHelper.addToolMaterial("UNIVERSALSPUERWORLDGEM", 16, 0, 64.0F, 10240.0F, 1024);
		Item.ToolMaterial SPUERWORLDTOPHUGESWORD = EnumHelper.addToolMaterial("SPUERWORLDTOPHUGESWORD", 16, 0, 8.0F, 10240000.0F, 4);
		Item.ToolMaterial SPUERWORLDTOPSWORD = EnumHelper.addToolMaterial("SPUERWORLDTOPSWORD", 16, 51200, 16.0F, 10240000.0F, 8);
		Item.ToolMaterial SPUERWORLDTOPPICKAXE = EnumHelper.addToolMaterial("SPUERWORLDTOPPICKAXE",16, 102400, 10240000.0F, 2560000.0F, 32);
		Item.ToolMaterial SPUERWORLDTOPAXE = EnumHelper.addToolMaterial("SPUERWORLDTOPAXE", 16, 102400, 5120000.0F, 5120000.0F, 16);
		Item.ToolMaterial SPUERWORLDTOPSHOVEL = EnumHelper.addToolMaterial("SPUERWORLDTOPSHOVEL", 16, 25600, 2560000.0F, 1280000.0F, 16);
	}
	*/

	//Create a Minecraft item object named "TopSuperWorldGemItem"
	//创建一个Minecraft物品对象，名称为“TopSuperWorldGemItem”
	
	public static Item TopSuperWorldGemItem;
	
	//public static Item TopSuperWorldHugeSword;
	//public static Item TopSuperWorldSword;
	//public static Item TopSuperWorldPickaxe;
	//public static Item TopSuperWorldAxe;
	//public static Item TopSuperWorldShovel;
	//public static Item TopSuperWorldBlockBreaker;

	
	public static void createItemTools() {
		
		//GameRegistry.registerItem(ItemObject = new LoadItemObjectNewClassFileName("GameDisplayItemName"),"GameInternalItemObjectStringName");
		
		GameRegistry.registerItem(TopSuperWorldGemItem = new LoadTopSuperWorldGemItem("TopSuperWorldGemItem"),"TopSuperWorldGemItem");
		
		GameRegistry.registerItem(LoadTopSuperWorldHugeSword.TopSuperWorldHugeSword, "TopSuperWorldHugeSword");
		GameRegistry.registerItem(LoadTopSuperWorldSword.TopSuperWorldSword, "TopSuperWorldSword");
		GameRegistry.registerItem(LoadTopSuperWorldPickaxe.TopSuperWorldPickaxe, "TopSuperWorldPickaxe");
		GameRegistry.registerItem(LoadTopSuperWorldAxe.TopSuperWorldAxe, "TopSuperWorldAxe");
		GameRegistry.registerItem(LoadTopSuperWorldShovel.TopSuperWorldShovel, "TopSuperWorldShovel");
		GameRegistry.registerItem(LoadTopSuperWorldBlockBreaker.TopSuperWorldBlockBreaker, "TopSuperWorldBlockBreaker");

	}

}
