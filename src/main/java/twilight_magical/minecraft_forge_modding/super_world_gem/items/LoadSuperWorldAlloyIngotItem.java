package twilight_magical.minecraft_forge_modding.super_world_gem.items;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class LoadSuperWorldAlloyIngotItem extends Item {
	
	public  LoadSuperWorldAlloyIngotItem(String unlocalizedName) {
			super();
			this.setTextureName("super_world_gem_forge_mod:Super World Alloy Ingot - [MinecraftGameMod]");
			this.setUnlocalizedName(unlocalizedName);
			this.setMaxStackSize(16);
			this.setCreativeTab(CreativeTabs.tabMaterials);
	}

}
