package twilight_magical.minecraft_forge_modding.super_world_gem.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class LoadTopSuperWorldShovel extends Item
{
	
	public static Item TopSuperWorldShovel;
	
	static int setHarvestLevel = 16; // harvest level
	
	static
	{
	    ToolMaterial SPUERWORLDTOPSHOVEL = EnumHelper.addToolMaterial("SPUERWORLDTOPSHOVEL", 16, 25600, 2560000.0F, 1280000F, 16);
		TopSuperWorldShovel = new ItemSpade(SPUERWORLDTOPSHOVEL)
		{
			public Set<String> getToolClasses(ItemStack stack)
			{
				HashMap<String, Integer> returnValue = new HashMap<String, Integer>();
				returnValue.put("shovel", setHarvestLevel);
				returnValue.put("SPUERWORLDTOPSHOVEL",setHarvestLevel);
				return returnValue.keySet();
			}
		}.setTextureName("super_world_gem_forge_mod:WorldTopShovel").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabTools).setUnlocalizedName("TopSuperWorldShovel").setMaxDamage(25600);
		//Item.itemRegistry.addObject(454, "TopSuperWorldShovel", TopSuperWorldShovel);
	}
	
	/*
	public LoadTopSuperWorldShovel(String unlocalizedName) {
		super(0.0F,SPUERWORLDTOPSHOVEL,new HashSet());
		Tool_SpuerWorldGemMod.TopSuperWorldShovel = new ItemSpade(SPUERWORLDTOPSHOVEL);
		
		// Resource Library Path:assets\[Resource Library Name]\textures\items
		// Current Resource Library Name:super_world_gem
		// Warning! Resource Library Name Can Not Be Capital Letters!
		
		//资源库路径：assets\[Resource Library Name]\textures\items
		//当前资源库名称：super_world_gem
		// 警告！ 资源库名称不能是大写字母！
		this.setTextureName("super_world_gem_forge_mod:WorldTopShovel"); 
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setUnlocalizedName(unlocalizedName);
		
		//Add this object object to multiple tool properties. And convert it to a tool object.
		//将这个物品对象，添加多个工具属性。并转换为工具物品对象。
		this.setHarvestLevel("shovel",16);
		this.setHarvestLevel("SPUERWORLDTOPSHOVEL",16);
		this.setMaxDamage(25600); //Set the maximum durability, the 0 value is never damaged 设置最大耐久度,值为0的话即为永不损坏
	}
	*/

}
