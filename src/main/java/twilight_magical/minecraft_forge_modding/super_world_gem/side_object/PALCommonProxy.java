package twilight_magical.minecraft_forge_modding.super_world_gem.side_object;

import net.minecraft.tileentity.TileEntity;
import twilight_magical.minecraft_forge_modding.super_world_gem.blocks.Block_SuperWorldGemMod;
import twilight_magical.minecraft_forge_modding.super_world_gem.items.Item_SuperWorldGemMod;
import twilight_magical.minecraft_forge_modding.super_world_gem.side_object.client_only.ClientOnlyFunctionalUtility;
import twilight_magical.minecraft_forge_modding.super_world_gem.side_object.server_only.ServerOnlyModuleUtility;
import twilight_magical.minecraft_forge_modding.super_world_gem.tools.Tool_SuperWorldGemMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

import cpw.mods.fml.common.registry.GameRegistry;
/**
 * @author Forge Mapping And Modding Of Minecraft Game This Modules Modder Creator: Twilight_Magical
 */
public abstract class PALCommonProxy implements ModProxyInterface {
	
	//PAL = 物理与逻辑
	//PAL = Physical And Logic
	//Common Proxy 共同代理
	//Abstract Class Template 抽象的类模板
	
	abstract public boolean playerIsInCreativeMode(EntityPlayer player);


	/*
	 * is this a dedicated server?
	 * @return true if this is a dedicated server, false otherwise
	 */
	abstract public boolean isDedicatedServer();
	
	/*
	// Not use @Override
	public void preInit(FMLPreInitializationEvent PAL_Event) {
	// Warning!
	// Here, you can not write any method of Minecraft Forge initialization event
	// Java code will conflict and then crash!
	// 警告！
	// 在这里，不能编写Minecraft Forge初始化事件的任何方法
	// Java代码将冲突，然后崩溃！
	}

	// Not use @Override
    public void init(FMLInitializationEvent PAL_Event) {
	// Warning!
	// Here, you can not write any method of Minecraft Forge initialization event
	// Java code will conflict and then crash!
	// 警告！
	// 在这里，不能编写Minecraft Forge初始化事件的任何方法
	// Java代码将冲突，然后崩溃！
    }

    // Not use @Override
    public void postInit(FMLPostInitializationEvent PAL_Event) {
	// Warning!
	// Here, you can not write any method of Minecraft Forge initialization event
	// Java code will conflict and then crash!
	// 警告！
	// 在这里，不能编写Minecraft Forge初始化事件的任何方法
	// Java代码将冲突，然后崩溃！
    }
    */
}