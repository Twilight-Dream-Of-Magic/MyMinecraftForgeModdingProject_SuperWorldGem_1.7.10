package twilight_magical.minecraft_forge_modding.super_world_gem.items;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class LoadZincIngotItem extends Item {
	
	public LoadZincIngotItem(String unlocalizedName) {
		super();
		this.setTextureName("super_world_gem_forge_mod:(Zn) Zinc Ingot - [SuperWorldGemMod]");
		this.setUnlocalizedName(unlocalizedName);
		this.setMaxStackSize(64);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

}
