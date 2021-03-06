package twilight_magical.minecraft_forge_modding.super_world_gem.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;


public class LoadTopSuperWorldAxe extends Item {

	public static final Item.ToolMaterial SUPERWORLDTOPAXE = EnumHelper.addToolMaterial("SUPERWORLDTOPAXE", 16, 102400, 5120000F, 5120000F, 16);
	public static Item TopSuperWorldAxe = new ItemToolTopSuperWorldAxe(SUPERWORLDTOPAXE, "TopSuperWorldAxe");
	static int HarvestLevelValue = 16; // harvest level
	
	//static
	//{
	//	TopSuperWorldAxe = new ItemAxe(SPUERWORLDTOPAXE)
	//	{
	//		public Set<String> getToolClasses(ItemStack stack)
	//		{
	//			HashMap<String, Integer> returnValue = new HashMap<String, Integer>();
	//			returnValue.put("axe", HarvestLevelValue);
	//			returnValue.put("SPUERWORLDTOPAXE", HarvestLevelValue);
	//			return returnValue.keySet();
	//		}
	//	}.setTextureName("super_world_gem_forge_mod:WorldTopAxe").setMaxStackSize(1).setCreativeTab(CreativeTabs.tabTools).setUnlocalizedName("TopSuperWorldAxe").setMaxDamage(102400);
	//	//Item.itemRegistry.addObject(453, "TopSuperWorldAxe", TopSuperWorldAxe);
	//}
	
	public static class ItemToolTopSuperWorldAxe extends ItemAxe {

		//protected float efficiencyOnProperMaterial = 128.0F;
		
		//Array of blocks the tool has extra effect against.
		//private Block[] blocksEffectiveAgainst = blocksEffectiveAgainstValue;
		
		//Damage versus entities
		//private float damageVsEntity;
    	
    	//The material this tool is made from.
		protected Item.ToolMaterial toolMaterial;
		
		protected ItemToolTopSuperWorldAxe(Item.ToolMaterial material, String unlocalizedName)
		{
          //TopSuperWorldAxe = new ItemTool(0.0f, SPUERWORLDTOPAXE, null);
			
		  // Resource Library Path:assets\[Resource Library Name]\textures\items
		  // Current Resource Library Name:super_world_gem
		  // Warning! Resource Library Name Can Not Be Capital Letters!
			
		  //资源库路径：assets\[Resource Library Name]\textures\items
		  //当前资源库名称：super_world_gem
		  // 警告！ 资源库名称不能是大写字母！
		  super(material);
		  this.setTextureName("super_world_gem_forge_mod:WorldTopAxe"); 
    	  this.setUnlocalizedName(unlocalizedName);
    	  
    	  this.toolMaterial = material;
  		  //this.damageVsEntity = 0.0f + EnumMaterial.getDamageVsEntity();
          //this.blocksEffectiveAgainst = ArrayOfBlock;
  		  //this.efficiencyOnProperMaterial = EnumMaterial.getEfficiencyOnProperMaterial();
			
		  this.setMaxStackSize(1);
		  this.setCreativeTab(CreativeTabs.tabTools);
			
		  //Add this object object to multiple tool properties. And convert it to a tool object.
		  //将这个物品对象，添加多个工具属性。并转换为工具物品对象。
		  this.setHarvestLevel("axe", HarvestLevelValue);
		  this.setHarvestLevel("SPUERWORLDTOPAXE", HarvestLevelValue);
		  this.setMaxDamage(102400); //Set the maximum durability, the 0 value is never damaged 设置最大耐久度,值为0的话即为永不损坏
		}
		
	}

}




/*
public class LoadTopSuperWorldAxe extends ItemTool
{
	
	static int HarvestLevelValue = 16; // harvest level
	
	protected LoadTopSuperWorldAxe(Item.ToolMaterial material, String unlocalizedName)
	{
      //Tool_SpuerWorldGemMod.TopSuperWorldAxe = new ItemTool(0.0f, SPUERWORLDTOPAXE, null);
		
	  // Resource Library Path:assets\[Resource Library Name]\textures\items
	  // Current Resource Library Name:super_world_gem
	  // Warning! Resource Library Name Can Not Be Capital Letters!
		
	  //资源库路径：assets\[Resource Library Name]\textures\items
	  //当前资源库名称：super_world_gem
	  // 警告！ 资源库名称不能是大写字母！
	  super(0.0F, material, new HashSet());
	  this.setTextureName("super_world_gem_forge_mod:WorldTopAxe"); 
	  this.setUnlocalizedName(unlocalizedName);
	  
	  this.toolMaterial = material;
	  //this.damageVsEntity = 0.0f + EnumMaterial.getDamageVsEntity();
      //this.blocksEffectiveAgainst = ArrayOfBlock;
	  //this.efficiencyOnProperMaterial = EnumMaterial.getEfficiencyOnProperMaterial();
		
	  this.setMaxStackSize(1);
	  this.setCreativeTab(CreativeTabs.tabTools);
		
	  //Add this object object to multiple tool properties. And convert it to a tool object.
	  //将这个物品对象，添加多个工具属性。并转换为工具物品对象。
	  this.setHarvestLevel("axe",HarvestLevelValue);
	  this.setHarvestLevel("SPUERWORLDTOPAXE",HarvestLevelValue);
	  this.setMaxDamage(102400); //Set the maximum durability, the 0 value is never damaged 设置最大耐久度,值为0的话即为永不损坏
	}
}
*/