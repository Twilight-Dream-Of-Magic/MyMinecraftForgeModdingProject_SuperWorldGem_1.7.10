package twilight_magical.minecraft_forge_modding.super_world_gem.side_object;

import net.minecraft.client.Minecraft;
import net.minecraft.client.LoadingScreenRenderer;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityOtherPlayerMP;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.model.AdvancedModelLoader;

import twilight_magical.minecraft_forge_modding.super_world_gem.armors.Armor_SuperWorldGemMod;
import twilight_magical.minecraft_forge_modding.super_world_gem.blocks.Block_SuperWorldGemMod;
import twilight_magical.minecraft_forge_modding.super_world_gem.crafts.Crafts_SuperWorldGemMod;
import twilight_magical.minecraft_forge_modding.super_world_gem.items.Item_SuperWorldGemMod;
import twilight_magical.minecraft_forge_modding.super_world_gem.side_object.client_only.ClientOnlyFunctionalUtility;
import twilight_magical.minecraft_forge_modding.super_world_gem.tools.Tool_SuperWorldGemMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

//Minecraft Forge Physical Client

/**
 * @author Minecraft Game This Modules Creator: Twilight_Magical
 */

@SideOnly(Side.CLIENT)
public class ComplexClientProxy extends PALCommonProxy {

	@Override
	public void preInit()
	{
		/*
		 * Run before anything else. Read your config, create blocks, items, etc, and register them with the GameRegistry
		 */
		
		//ComplexClientProxy Preparatory Initializing
		
		Item_SuperWorldGemMod.createItems();
		Block_SuperWorldGemMod.createBlocks();
		Tool_SuperWorldGemMod.createItemTools();
		Armor_SuperWorldGemMod.createItemArmors();
		//ClientRegisterItem.loadingRegistered_CustomTexture_Locations();
	}

	@Override
    public void init()
	{
		/*
		 * Do your mod setup. Build whatever data structures you care about. Register recipes,
		 * send FMLInterModComms messages to other mods.
		 */
    	
		//ComplexClientProxy Initializing
    	
    	Crafts_SuperWorldGemMod.makeCraftingTable();
    }

	@Override
    public void postInit()
	{
		/*
		 * Handle interaction with other mods, complete your setup based on this.
		 */
    	
		//ComplexClientProxy Later Initializing (CommonProxy Post Initializing)
    }
    
    @Override
    public boolean playerIsInCreativeMode(EntityPlayer player) 
    {
        if (player instanceof EntityPlayerMP) 
        {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
            return entityPlayerMP.theItemInWorldManager.isCreative();
        } 
        else if (player instanceof EntityPlayerSP) 
        {
            return Minecraft.getMinecraft().playerController.isInCreativeMode();
        }
        
        return false;
    }
    
    @Override
    public boolean isDedicatedServer() 
    {
    	
    	return false;
    }
	
}
