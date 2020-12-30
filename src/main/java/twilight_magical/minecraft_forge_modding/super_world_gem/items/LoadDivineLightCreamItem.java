package twilight_magical.minecraft_forge_modding.super_world_gem.items;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;


public class LoadDivineLightCreamItem extends Item {
	
	public  LoadDivineLightCreamItem(String unlocalizedName) {
		super();
		this.setTextureName("super_world_gem_forge_mod:DivineLightCream");
		this.setUnlocalizedName(unlocalizedName);
		this.setMaxStackSize(8);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

}
