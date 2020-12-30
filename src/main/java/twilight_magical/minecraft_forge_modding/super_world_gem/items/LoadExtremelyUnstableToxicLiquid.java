package twilight_magical.minecraft_forge_modding.super_world_gem.items;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class LoadExtremelyUnstableToxicLiquid extends Item {
	
	public  LoadExtremelyUnstableToxicLiquid(String unlocalizedName) {
		super();
		this.setTextureName("super_world_gem_forge_mod:ExtremelyUnstableToxicLiquid");
		this.setUnlocalizedName(unlocalizedName);
		this.setMaxStackSize(16);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

}
