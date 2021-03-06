package twilight_magical.minecraft_forge_modding.super_world_gem.crafts.smelt;

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
import twilight_magical.minecraft_forge_modding.super_world_gem.blocks.Block_SuperWorldGemMod;
import twilight_magical.minecraft_forge_modding.super_world_gem.items.Item_SuperWorldGemMod;
import twilight_magical.minecraft_forge_modding.super_world_gem.tools.Tool_SuperWorldGemMod;

public class Smelt_SuperWorldGemMod 
{
	
	public static void createSmelts() 
	{
		GameRegistry.addSmelting(Items.nether_star, new ItemStack(Item_SuperWorldGemMod.ArcticIceBall), 1024.0f);
	}

}
