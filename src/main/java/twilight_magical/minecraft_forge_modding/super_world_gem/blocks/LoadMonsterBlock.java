package twilight_magical.minecraft_forge_modding.super_world_gem.blocks;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LoadMonsterBlock extends Block{
	
	public LoadMonsterBlock(String unlocalizedName, Material material, float hardness, float resistance) {
		super(material);
		this.setBlockName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(hardness);
		this.setBlockTextureName("super_world_gem_forge_mod:MonsterBlock");
		this.setHarvestLevel("shovel",8);
		this.setHarvestLevel("pickaxe",8);
		this.setHarvestLevel("SPUERWORLDTOPSHOVEL",8);
		this.setHarvestLevel("SPUERWORLDTOPPICKAXE",8);
		this.setHarvestLevel("SPUERWORLDTOPBLOCKBREAKER", 8);
	}

	public LoadMonsterBlock(String unlocalizedName, float hardness, float resistance) {
	    this(unlocalizedName, Material.rock, hardness, resistance);

	}
	
	public LoadMonsterBlock(String unlocalizedName) {
		this(unlocalizedName, 48.0f, 0.05f);
	}
}

