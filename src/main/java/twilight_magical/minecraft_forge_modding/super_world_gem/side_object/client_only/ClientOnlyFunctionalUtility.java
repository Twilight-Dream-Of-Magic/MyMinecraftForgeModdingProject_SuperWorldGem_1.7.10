package twilight_magical.minecraft_forge_modding.super_world_gem.side_object.client_only;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

import net.minecraft.client.model.ModelRenderer;

import net.minecraft.entity.EntityLivingBase;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.util.IRegistry;
import net.minecraft.util.ResourceLocation;

import net.minecraft.world.World;
import twilight_magical.minecraft_forge_modding.super_world_gem.SuperWorldGemMod;
import twilight_magical.minecraft_forge_modding.super_world_gem.blocks.Block_SuperWorldGemMod;
import twilight_magical.minecraft_forge_modding.super_world_gem.items.Item_SuperWorldGemMod;
import twilight_magical.minecraft_forge_modding.super_world_gem.side_object.ComplexClientProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientOnlyFunctionalUtility extends ComplexClientProxy {
	
	public static String modid = SuperWorldGemMod.MODID;

}
