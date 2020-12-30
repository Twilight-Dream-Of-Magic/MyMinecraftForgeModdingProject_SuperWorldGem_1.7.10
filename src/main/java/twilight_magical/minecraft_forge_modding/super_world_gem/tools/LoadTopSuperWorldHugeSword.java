package twilight_magical.minecraft_forge_modding.super_world_gem.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class LoadTopSuperWorldHugeSword extends Item
{
	
	public static Item TopSuperWorldHugeSword;
	
	static int setHarvestLevel = 16; // harvest level
	
	static
	{
		ToolMaterial SPUERWORLDTOPHUGESWORD = EnumHelper.addToolMaterial("SPUERWORLDTOPHUGESWORD", 16, 0, 8F, 10240000F, 4);
		TopSuperWorldHugeSword = new ItemSword(SPUERWORLDTOPHUGESWORD)
		{
			public Set<String> getToolClasses(ItemStack stack)
			{
				HashMap<String, Integer> returnValue = new HashMap<String, Integer>();
				returnValue.put("sword", setHarvestLevel);
				returnValue.put("SPUERWORLDTOPHUGESWORD", setHarvestLevel);
				return returnValue.keySet();
			}
		}.setTextureName("super_world_gem_forge_mod:WorldTopHugeSword").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabTools).setUnlocalizedName("TopSuperWorldHugeSword").setMaxDamage(0);
		//Item.itemRegistry.addObject(450, "TopSuperWorldHugeSword", TopSuperWorldHugeSword);
	}
	
	/*
	public LoadTopSuperWorldHugeSword(String unlocalizedName) {
		super(0.0F,SPUERWORLDTOPHUGESWORD,new HashSet());
		Tool_SpuerWorldGemMod.TopSuperWorldHugeSword = new ItemSword(SPUERWORLDTOPHUGESWORD);
		
		// Resource Library Path:assets\[Resource Library Name]\textures\items
		// Current Resource Library Name:super_world_gem
		// Warning! Resource Library Name Can Not Be Capital Letters!
		
		//资源库路径：assets\[Resource Library Name]\textures\items
		//当前资源库名称：super_world_gem
		// 警告！ 资源库名称不能是大写字母！
		this.setTextureName("super_world_gem_forge_mod:WorldTopHugeSword"); 
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setUnlocalizedName(unlocalizedName);
		
		//Add this object object to multiple tool properties. And convert it to a tool object.
		//将这个物品对象，添加多个工具属性。并转换为工具物品对象。
		this.setHarvestLevel("sword",16);
		this.setHarvestLevel("SPUERWORLDTOPHUGESWORD", 16);
		this.setMaxDamage(0); //Set the maximum durability, the 0 value is never damaged 设置最大耐久度,值为0的话即为永不损坏
	}
	*/

}
