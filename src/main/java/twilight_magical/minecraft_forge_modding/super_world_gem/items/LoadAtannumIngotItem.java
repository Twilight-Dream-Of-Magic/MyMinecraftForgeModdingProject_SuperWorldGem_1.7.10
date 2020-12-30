package twilight_magical.minecraft_forge_modding.super_world_gem.items;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class LoadAtannumIngotItem extends Item {
	
	public LoadAtannumIngotItem(String unlocalizedName) {
		super();
		this.setTextureName("super_world_gem_forge_mod:(Sn) Atannum Ingot - [SuperWorldGemMod]");
		this.setUnlocalizedName(unlocalizedName);
		this.setMaxStackSize(64);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

}
