package twilight_magical.minecraft_forge_modding.super_world_gem.items;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class LoadMixedMineralBlockCrystallizationItem extends Item {
	
	public LoadMixedMineralBlockCrystallizationItem(String unlocalizedName) {
		super();
		this.setTextureName("super_world_gem_forge_mod:MixedMineralCrystallization");
		this.setUnlocalizedName(unlocalizedName);
		this.setMaxStackSize(4);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

}
