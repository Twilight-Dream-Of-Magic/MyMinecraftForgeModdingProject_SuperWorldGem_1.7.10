package twilight_magical.minecraft_forge_modding.super_world_gem.core;

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

/**
 * 1.7.10 coremod entry point.
 *
 * The transformer patches exactly one place: ForgeHooks.blockStrength(),
 * immediately after the hardness float has been read from the Block.
 */
@IFMLLoadingPlugin.MCVersion("1.7.10")
@IFMLLoadingPlugin.Name("SuperWorldGemLivingHardnessCore")
@IFMLLoadingPlugin.TransformerExclusions({
		"twilight_magical.minecraft_forge_modding.super_world_gem.core"
})
public class SuperWorldGemCorePlugin implements IFMLLoadingPlugin
{
	@Override
	public String[] getASMTransformerClass()
	{
		return new String[] {
				"twilight_magical.minecraft_forge_modding.super_world_gem.core.ForgeHooksHardnessTransformer"
		};
	}

	@Override
	public String getModContainerClass()
	{
		return null;
	}

	@Override
	public String getSetupClass()
	{
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data)
	{
	}

	@Override
	public String getAccessTransformerClass()
	{
		return null;
	}
}
