package twilight_magical.minecraft_forge_modding.super_world_gem.items;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class LoadSkeletonArchersSoulItem extends Item {
	
	public  LoadSkeletonArchersSoulItem(String unlocalizedName) {
		super();
		this.setTextureName("super_world_gem_forge_mod:SkeletonArchresSoul");
		this.setUnlocalizedName(unlocalizedName);
		this.setMaxStackSize(32);
		this.setCreativeTab(CreativeTabs.tabMaterials);
    }

}
