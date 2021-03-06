package twilight_magical.minecraft_forge_modding.super_world_gem.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LoadSuperWorldAetherGemBlock extends Block {
	
	public LoadSuperWorldAetherGemBlock(String unlocalizedName, Material material, float hardness, float resistance) {
		super(material);
		this.setBlockName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(hardness);
		this.setBlockTextureName("super_world_gem_forge_mod:SuperWorldAetherGemBlock");
		this.setHarvestLevel("pickaxe",4);
		this.setHarvestLevel("SPUERWORLDTOPPICKAXE",8);
		this.setHarvestLevel("SPUERWORLDTOPBLOCKBREAKER", 8);
	}

	public LoadSuperWorldAetherGemBlock(String unlocalizedName, float hardness, float resistance) {
	    this(unlocalizedName, Material.rock, hardness, resistance);

	}
	
	public LoadSuperWorldAetherGemBlock(String unlocalizedName) {
		this(unlocalizedName, 600.0f, 256.0f);
	}

}
