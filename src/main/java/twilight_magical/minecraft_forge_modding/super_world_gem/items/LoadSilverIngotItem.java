package twilight_magical.minecraft_forge_modding.super_world_gem.items;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class LoadSilverIngotItem extends Item {
	
	public LoadSilverIngotItem(String unlocalizedName) {
		super();
		this.setTextureName("super_world_gem_forge_mod:(Ag) Silver Ingot - [SuperWorldGemMod]");
		this.setUnlocalizedName(unlocalizedName);
		this.setMaxStackSize(64);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

}
