package twilight_magical.minecraft_forge_modding.super_world_gem.crafts.recipe;

import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

import net.minecraft.util.ResourceLocation;

import net.minecraftforge.common.*;
import net.minecraftforge.common.util.EnumHelper;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import twilight_magical.minecraft_forge_modding.super_world_gem.blocks.Block_SuperWorldGemMod;
import twilight_magical.minecraft_forge_modding.super_world_gem.items.Item_SuperWorldGemMod;
import twilight_magical.minecraft_forge_modding.super_world_gem.tools.Tool_SuperWorldGemMod;

public class Recipe_SuperWorldGemMod 
{
	
	public static void createRecipe() 
	{
		ItemStack RecipeItem_ArcticIceBall = new ItemStack(Item_SuperWorldGemMod.ArcticIceBall,1);
		GameRegistry.addShapedRecipe
		(
		
				RecipeItem_ArcticIceBall, new Object[]
				{
						"012", "345", "678", 
				         Character.valueOf('0'), new ItemStack(Blocks.packed_ice, 1), 
				         Character.valueOf('1'), new ItemStack(Blocks.ice, 1), 
				         Character.valueOf('2'), new ItemStack(Blocks.packed_ice, 1),
				         Character.valueOf('3'), new ItemStack(Blocks.ice, 1),
				         Character.valueOf('4'), new ItemStack(Blocks.snow, 1), 
				         Character.valueOf('5'), new ItemStack(Blocks.ice, 1),
				         Character.valueOf('6'), new ItemStack(Blocks.packed_ice,1), 
				         Character.valueOf('7'), new ItemStack(Blocks.ice, 1), 
				         Character.valueOf('8'), new ItemStack(Blocks.packed_ice, 1)
				}
	    );
		
		ItemStack RecipeBlock_HellFireCoalBlock = new ItemStack(Block_SuperWorldGemMod.HellFireCoalBlock,1);
		GameRegistry.addShapedRecipe
		(
		
				RecipeBlock_HellFireCoalBlock, new Object[]
				{
						"012", "345", "678", 
						Character.valueOf('0'), new ItemStack(Items.blaze_powder, 1), 
						Character.valueOf('1'), new ItemStack(Items.lava_bucket, 1), 
						Character.valueOf('2'), new ItemStack(Items.blaze_powder, 1), 
						Character.valueOf('3'), new ItemStack(Items.fire_charge, 1), 
						Character.valueOf('4'), new ItemStack(Blocks.coal_block, 1), 
						Character.valueOf('5'), new ItemStack(Items.fire_charge, 1), 
						Character.valueOf('6'), new ItemStack(Items.flint_and_steel, 1), 
						Character.valueOf('7'), new ItemStack(Items.lava_bucket, 1), 
						Character.valueOf('8'), new ItemStack(Items.flint_and_steel, 1)
				}
	    );
		
		ItemStack RecipeItem_TopSuperWorldBlockBreaker = new ItemStack(Tool_SuperWorldGemMod.TopSuperWorldBlockBreaker,1);
		GameRegistry.addRecipe
		(
			RecipeItem_TopSuperWorldBlockBreaker, new Object[]
			{
				"012", "345", "678",
				Character.valueOf('0'), new ItemStack(Block_SuperWorldGemMod.SuperWorldGemBlock, 1),
				Character.valueOf('1'), new ItemStack(Blocks.end_stone, 1),
				Character.valueOf('2'), new ItemStack(Block_SuperWorldGemMod.SuperWorldGemBlock, 1),
				Character.valueOf('3'), new ItemStack(Blocks.beacon, 1),
				Character.valueOf('4'), new ItemStack(Tool_SuperWorldGemMod.TopSuperWorldPickaxe, 1),
				Character.valueOf('5'), new ItemStack(Blocks.beacon, 1),
				Character.valueOf('6'), new ItemStack(Blocks.obsidian, 1),
				Character.valueOf('7'), new ItemStack(Item_SuperWorldGemMod.SuperWorldAlloyIngot, 1),
				Character.valueOf('8'), new ItemStack(Blocks.obsidian, 1), 
			}
		);

		ItemStack RecipeItem_MixedMineralBlockCrystallization = new ItemStack(Item_SuperWorldGemMod.MixedMineralBlockCrystallization, 1);
		GameRegistry.addShapelessRecipe
		(
		
				RecipeItem_MixedMineralBlockCrystallization, new Object[]
				{
					new ItemStack(Block_SuperWorldGemMod.MixedMineralBlock, 1), new ItemStack(Block_SuperWorldGemMod.HellFireCoalBlock, 1)
				}
	    );
		
		ItemStack RecipeItem_MonsterBlockCrystallization = new ItemStack(Item_SuperWorldGemMod.MonsterBlockCrystallization, 1);
		GameRegistry.addShapelessRecipe
		(
		
				RecipeItem_MonsterBlockCrystallization, new Object[]
				{
					new ItemStack(Block_SuperWorldGemMod.MonsterBlock, 1), new ItemStack(Item_SuperWorldGemMod.ArcticIceBall, 1)
				}
	    );
		
	}

}
