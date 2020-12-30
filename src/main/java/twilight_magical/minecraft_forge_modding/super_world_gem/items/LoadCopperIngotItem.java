package twilight_magical.minecraft_forge_modding.super_world_gem.items;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class LoadCopperIngotItem extends Item {
	
	public LoadCopperIngotItem(String unlocalizedName) {
	
	super();
	this.setTextureName("super_world_gem_forge_mod:(Cu) Copper Ingot - [SuperWorldGemMod");
	this.setUnlocalizedName(unlocalizedName);
	this.setMaxStackSize(64);
	this.setCreativeTab(CreativeTabs.tabMaterials);
	}

}
