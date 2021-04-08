package twilight_magical.minecraft_forge_modding.super_world_gem.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LoadTopSuperWorldGemItem extends ItemTool
{
	
	protected LoadTopSuperWorldGemItem(Item.ToolMaterial material, String unlocalizedName) 
	{
		super(0.0F, material, new HashSet());
		
		//super(0.0f,UNIVERSALSPUERWORLDGEM,HashSet());
		
		// Resource Library Path:assets\[Resource Library Name]\textures\items
		// Current Resource Library Name:super_world_gem
		// Warning! Resource Library Name Can Not Be Capital Letters!
		
		//资源库路径：assets\[Resource Library Name]\textures\items
		//当前资源库名称：super_world_gem
		// 警告！ 资源库名称不能是大写字母！
		this.setTextureName("super_world_gem_forge_mod:TopSuperWorldGemItem"); 
		this.setMaxStackSize(8);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setUnlocalizedName(unlocalizedName);
		
		//Add this object object to multiple tool properties. And convert it to a tool object.
		//将这个物品对象，添加多个工具属性。并转换为工具物品对象。
		this.setHarvestLevel("pickaxe",8);
		this.setHarvestLevel("axe",8);
		this.setHarvestLevel("shovel",8);
		this.setHarvestLevel("sword",8);
		this.setHarvestLevel("UNIVERSALSPUERWORLDGEM", 5);
		this.setMaxDamage(0); //Set the maximum durability, the 0 value is never damaged 设置最大耐久度,值为0的话即为永不损坏
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List list, boolean par4) {
		list.add("My master");
		list.add("You are already a god!");
	}
	
	//LanguageRegistry.addName(TopSuperWorldGemItem, "TopSuperWorldGemItem");
}
