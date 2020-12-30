package twilight_magical.minecraft_forge_modding.super_world_gem.items;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;


public class LoadArcticIceBallItem extends Item {
	
	public  LoadArcticIceBallItem(String unlocalizedName) {
		super();
		this.setTextureName("super_world_gem_forge_mod:ArcticIceBall");
		this.setUnlocalizedName(unlocalizedName);
		this.setMaxStackSize(8);
		this.setCreativeTab(CreativeTabs.tabMaterials);
    }

}
