package twilight_magical.minecraft_forge_modding.super_world_gem.items;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class LoadMonsterBlockCrystallizationItem extends Item {
	
	public LoadMonsterBlockCrystallizationItem(String unlocalizedName) {
		super();
		this.setTextureName("super_world_gem_forge_mod:MonsterBlockCrystallization");
		this.setUnlocalizedName(unlocalizedName);
		this.setMaxStackSize(4);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

}
