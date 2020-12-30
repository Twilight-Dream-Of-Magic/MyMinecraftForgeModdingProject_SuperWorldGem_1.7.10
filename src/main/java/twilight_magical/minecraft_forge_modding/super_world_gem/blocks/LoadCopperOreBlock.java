package twilight_magical.minecraft_forge_modding.super_world_gem.blocks;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class LoadCopperOreBlock extends Block {
	
	public LoadCopperOreBlock(String unlocalizedName, Material material, float hardness, float resistance) {
		super(material);
		this.setBlockName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(hardness);
		this.setBlockTextureName("super_world_gem_forge_mod:(Cu) Copper Ore - [SuperWorldGemMod]");
		this.setHarvestLevel("pickaxe",1);
		this.setHarvestLevel("SPUERWORLDTOPPICKAXE",4);
		this.setHarvestLevel("SPUERWORLDTOPBLOCKBREAKER", 8);
	}

	public LoadCopperOreBlock(String unlocalizedName, float hardness, float resistance) {
	    this(unlocalizedName, Material.rock, hardness, resistance);
	    
	    // 硬度值 4.0f = 1 second（使用Minecraft钻石镐，摧毁一个方块的平均的时间）
	    // 硬度浮点值=使用手摧毁方块浮点值
	    // Hardness 4.0f value = 1 second (Use Minecraft Diamond Pickaxe, destroy an average time of one cube)
	    // Hardness float value = Use your hand to break the block floating point value

	}
	
	public LoadCopperOreBlock(String unlocalizedName) {
		this(unlocalizedName, 12.0f, 0.25f);
	}

}
