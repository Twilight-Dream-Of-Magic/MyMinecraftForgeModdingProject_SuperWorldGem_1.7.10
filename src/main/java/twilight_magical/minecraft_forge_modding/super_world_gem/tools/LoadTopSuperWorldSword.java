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


public class LoadTopSuperWorldSword extends Item
{
	static final ToolMaterial SPUERWORLDTOPSWORD = EnumHelper.addToolMaterial("SUPERWORLDTOPSWORD", 16, 51200, 16F, 7680000F, 8);
	public static Item TopSuperWorldSword;
	static int HarvestLevelValue = 16; // harvest level
	
	static
	{
		TopSuperWorldSword = new ItemSword(SPUERWORLDTOPSWORD)
		{
			public Set<String> getToolClasses(ItemStack stack)
			{
				HashMap<String, Integer> returnValue = new HashMap<String, Integer>();
				returnValue.put("sword", HarvestLevelValue);
				returnValue.put("SPUERWORLDTOPSWORD", HarvestLevelValue);
				return returnValue.keySet();
			}
		}.setTextureName("super_world_gem_forge_mod:WorldTopSword").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabTools).setUnlocalizedName("TopSuperWorldSword").setMaxDamage(51200);
		//Item.itemRegistry.addObject(451, "TopSuperWorldSword", TopSuperWorldSword);
	}
}



/*
public class LoadTopSuperWorldSword extends ItemTool
{
	static int HarvestLevelValue = 16; // harvest level
	
	public LoadTopSuperWorldSword(Item.ToolMaterial material, String unlocalizedName)
	{
		super(0.0F, material, new HashSet());
		
		// Resource Library Path:assets\[Resource Library Name]\textures\items
		// Current Resource Library Name:super_world_gem
		// Warning! Resource Library Name Can Not Be Capital Letters!
		
		//资源库路径：assets\[Resource Library Name]\textures\items
		//当前资源库名称：super_world_gem
		// 警告！ 资源库名称不能是大写字母！
		this.setTextureName("super_world_gem_forge_mod:WorldTopSword"); 
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabCombat);
		this.setUnlocalizedName(unlocalizedName);
		
		//Add this object object to multiple tool properties. And convert it to a tool object.
		//将这个物品对象，添加多个工具属性。并转换为工具物品对象。
		this.setHarvestLevel("sword", HarvestLevelValue);
		this.setHarvestLevel("SPUERWORLDTOPSWORD", HarvestLevelValue);
		this.setMaxDamage(51200); //Set the maximum durability, the 0 value is never damaged 设置最大耐久度,值为0的话即为永不损坏
	}

}
*/
