package twilight_magical.minecraft_forge_modding.super_world_gem.side_object;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import twilight_magical.minecraft_forge_modding.super_world_gem.side_object.server_only.ServerOnlyModuleUtility;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

//Minecraft Forge Physical Server

/**
 * @author Minecraft Game This Modules Creator: Twilight_Magical
 */

@SideOnly(Side.SERVER)
public class DedicatedServerProxy extends PALCommonProxy {


	@Override
	public void preInit()
	{ 
		/*
		 * Run before anything else. Read your config, create blocks, items, etc, and register them with the GameRegistry
		 */
		
		//DedicatedServerProxy Preparatory Initializing
	}
	
	@Override
	public void init()
	{
		/*
		 * Do your mod setup. Build whatever data structures you care about. Register recipes,
		 * send FMLInterModComms messages to other mods.
		 */
		
		//DedicatedServerProxy Initializing
	}
	
	@Override
	public void postInit()
	{
		/*
		 * Handle interaction with other mods, complete your setup based on this.
		 */
		
		//DedicatedServerProxy Later Initializing (CommonProxy Post Initializing)
	} 
	
	@Override
	public boolean playerIsInCreativeMode(EntityPlayer player)
	{
		if (player instanceof EntityPlayerMP)
		{
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
            return entityPlayerMP.theItemInWorldManager.isCreative();
        }
		else
		{
	        return false;
		}
	}
	
	@Override
	public boolean isDedicatedServer() 
	{
		
		return true;
	}
    
}
