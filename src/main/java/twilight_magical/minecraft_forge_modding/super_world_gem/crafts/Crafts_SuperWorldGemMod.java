package twilight_magical.minecraft_forge_modding.super_world_gem.crafts;

import twilight_magical.minecraft_forge_modding.super_world_gem.crafts.recipe.*;
import twilight_magical.minecraft_forge_modding.super_world_gem.crafts.smelt.*;

public class Crafts_SuperWorldGemMod 
{
	
	public static void makeCraftingTable () 
	{
		
		Recipe_SuperWorldGemMod.createRecipe();
		Smelt_SuperWorldGemMod.createSmelts();
	}

}
