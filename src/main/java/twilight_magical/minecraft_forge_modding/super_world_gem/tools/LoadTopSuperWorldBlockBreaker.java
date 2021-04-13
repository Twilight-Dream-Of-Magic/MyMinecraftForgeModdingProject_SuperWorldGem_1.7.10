package twilight_magical.minecraft_forge_modding.super_world_gem.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import net.minecraft.item.Item.ToolMaterial;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.util.ResourceLocation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;

import net.minecraft.world.World;

import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.util.EnumHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;

public class LoadTopSuperWorldBlockBreaker extends Item
{
	
	/***
	 * 	//EnumHelper.addToolMaterial
	 *	public static ToolMaterial addToolMaterial(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability)
	 *	{
	 *   	return addEnum(ToolMaterial.class, name, harvestLevel, maxUses, efficiency, damage, enchantability);
	 *	}
	 * 
	 ***/
	
	private static final Item.ToolMaterial SUPERWORLDTOPBLOCKBREAKER = EnumHelper.addToolMaterial("SUPERWORLDTOPBLOCKBREAKER", LoadTopSuperWorldBlockBreaker.getThisToolHarvestLevel(), 20480000, 51200000.0F, 20480000F, 0);
	
	private static final int THIS_TOOLHARVEST_LEVEL = 32; // Set custom tool the harvest level
	@SuppressWarnings("unused")
	public static int getThisToolHarvestLevel()
	{
		return THIS_TOOLHARVEST_LEVEL;
	}
	
	public static final Set<Block> allowedPlayerHarvest_hardcoreBlocksEffectiveAgainstValue = Sets.newHashSet(new Block[]
	{
		Blocks.bedrock, Blocks.command_block, Blocks.end_portal_frame,Blocks.monster_egg, Blocks.mob_spawner
		//From the impossible to destroy the unbreakable block, give the resistance to destroy the effect of efficiency?
		//来自不可能破坏的不易碎块，给予的抵抗破坏效率的效果 ？ 
		//This Is Allow Player To Harvest Of List For The Unbreakable Cube
	});
	
	public static final Set<Block> bannedPlayerHarvest_easyBlocksEffectiveValue = Sets.newHashSet(new Block[]
	{
		Blocks.air, Blocks.fire, Blocks.lava, Blocks.water, Blocks.portal, Blocks.end_portal, Blocks.flowing_lava, Blocks.flowing_water, Blocks.cake
		//From the possible to destroy the breakable block?
		//来自可能破坏的易碎块 ？ 
		//This Is Not Allow Player To Harvest Of List For The Breakable Cube
	});
	
	public static Item TopSuperWorldBlockBreaker = new ItemToolSuperWorldBlockBreaker(0.0f, SUPERWORLDTOPBLOCKBREAKER, allowedPlayerHarvest_hardcoreBlocksEffectiveAgainstValue);
	
	//private static final ResourceLocation textureLocation = new ResourceLocation("super_world_gem_forge_mod:textures/items/WorldBedrockTheDead.gif");
	//TextureManager myTextureManager = Minecraft.getMinecraft().getTextureManager();
	//IResourceManager myResourceManager = Minecraft.getMinecraft().getResourceManager();
	//ITextureObject myITextureObject = myTextureManager.getTexture(textureLocation);
	
	
	public static class ItemToolSuperWorldBlockBreaker extends ItemTool
	{
		public static Set<Block> BlocksEffectiveValue;
				
		public ItemStack itemStack = new ItemStack(this);
		
		//Damage versus entities
		private float damageVsEntity = 16.0f; //Can set public
			   
		//The material this tool is made from.
		protected ToolMaterial thisToolMaterial; //Can set public
		
		//This tool efficiency on the proper material
		protected final float eOnPM_Speed = 51200000.0F; //Can set public
		protected float efficiencyOnProperMaterial = eOnPM_Speed; //Can set public

		/*
		 * Living-tool state.
		 *
		 * The old design already tried to use reverse/overflow data to cross the
		 * excavation boundary.  Keep that idea literal: this specific ItemStack owns
		 * a harvest level which grows while it is pressing against negative hardness.
		 * It starts at the original level 32 and doubles once per world tick until
		 * Java int overflow really happens.  Overflow is remembered in NBT.
		 */
		private static final String NBT_LIVING_HARVEST_LEVEL = "SWG_LivingHarvestLevel";
		private static final String NBT_LIVING_HARVEST_OVERFLOW = "SWG_LivingHarvestOverflow";
		private static final String NBT_LIVING_HARVEST_LAST_TICK = "SWG_LivingHarvestLastTick";

		/*
		 * Once the level has really overflowed, negative hardness is no longer
		 * accepted as an absolute stop for this tool.  We do NOT modify the Block.
		 * We only replace the hardness value observed by ForgeHooks.blockStrength
		 * for this one calculation.
		 *
		 * 27 * tool efficiency makes the post-boundary mining intentionally slow:
		 * with the original 51,200,000 efficiency it is roughly one minute of
		 * continuous vanilla mining before a hardness-boundary block breaks.
		 */
		private static final float HARDNESS_BOUNDARY_RESISTANCE_MULTIPLIER = 27.0F;

		private HashMap<String, Integer> toolClasses = new HashMap<String, Integer>();
		public String toolClass = "SPUERWORLDTOPBLOCKBREAKER";
		
		public float getThisEfficiencyOnProperMaterial()
		{
			return this.efficiencyOnProperMaterial;
		}

		private NBTTagCompound getOrCreateLivingToolTag(ItemStack stack)
		{
			if(stack.getTagCompound() == null)
			{
				stack.setTagCompound(new NBTTagCompound());
			}
			return stack.getTagCompound();
		}

		/**
		 * Raw, private harvest level owned by this exact ItemStack.  This is not the
		 * block's hardness and it is not the player's break speed.
		 */
		public int getLivingHarvestLevel(ItemStack stack)
		{
			NBTTagCompound tag = this.getOrCreateLivingToolTag(stack);
			if(!tag.hasKey(NBT_LIVING_HARVEST_LEVEL))
			{
				tag.setInteger(NBT_LIVING_HARVEST_LEVEL, getThisToolHarvestLevel());
			}
			return tag.getInteger(NBT_LIVING_HARVEST_LEVEL);
		}

		public boolean hasLivingHarvestOverflowed(ItemStack stack)
		{
			NBTTagCompound tag = this.getOrCreateLivingToolTag(stack);
			return tag.getBoolean(NBT_LIVING_HARVEST_OVERFLOW);
		}

		/**
		 * Grow once per world tick.  The overflow is a real signed-int wrap:
		 * 32 -> 64 -> ... -> 1073741824 -> -2147483648.
		 */
		private void growLivingHarvestLevel(ItemStack stack, World world)
		{
			NBTTagCompound tag = this.getOrCreateLivingToolTag(stack);

			if(tag.getBoolean(NBT_LIVING_HARVEST_OVERFLOW))
			{
				return;
			}

			long now = world.getTotalWorldTime();
			if(tag.hasKey(NBT_LIVING_HARVEST_LAST_TICK) && tag.getLong(NBT_LIVING_HARVEST_LAST_TICK) == now)
			{
				return;
			}
			tag.setLong(NBT_LIVING_HARVEST_LAST_TICK, now);

			int currentLevel = this.getLivingHarvestLevel(stack);
			int nextLevel = currentLevel << 1; // intentionally allow Java int overflow
			tag.setInteger(NBT_LIVING_HARVEST_LEVEL, nextLevel);

			if(currentLevel > 0 && nextLevel < 0)
			{
				tag.setBoolean(NBT_LIVING_HARVEST_OVERFLOW, true);
			}
		}

		/**
		 * Called only from the ForgeHooks hardness interception.
		 *
		 * The actual Block keeps its original hardness forever.  Bedrock still says
		 * -1.0F when queried normally.  The living tool merely changes the value that
		 * this single Forge block-strength calculation is allowed to observe.
		 */
		public float transformObservedHardness(ItemStack stack, Block block, EntityPlayer player, World world,
				int x, int y, int z, float originalHardness)
		{
			if(originalHardness >= 0.0F)
			{
				return originalHardness;
			}

			// Preserve the old explicit "hardcore block" design instead of silently
			// turning this item into a universal admin delete wand.
			if(!allowedPlayerHarvest_hardcoreBlocksEffectiveAgainstValue.contains(block))
			{
				return originalHardness;
			}

			this.growLivingHarvestLevel(stack, world);

			if(!this.hasLivingHarvestOverflowed(stack))
			{
				return originalHardness;
			}

			float observedHardness = this.efficiencyOnProperMaterial * HARDNESS_BOUNDARY_RESISTANCE_MULTIPLIER;
			if(Float.isNaN(observedHardness) || Float.isInfinite(observedHardness) || observedHardness <= 0.0F)
			{
				observedHardness = Float.MAX_VALUE;
			}

			return observedHardness;
		}
		
		/**
		 * 
		 * @param damageVsEntity
		 * @param material
		 * @param unlocalizedName
		 */
		
		protected ItemToolSuperWorldBlockBreaker(float damageVsEntity, ToolMaterial MATERIAL, Set<Block> allowedPlayerHarvest_hardcoreBlocksEffectiveAgainstValue)
		{
		   //Tool_SpuerWorldGemMod.TopSuperWorldAxe = new ItemTool(0.0f, SPUERWORLDTOPAXE, null);
		   
		   // Resource Library Path:assets\[Resource Library Name]\textures\items
		   // Current Resource Library Name:super_world_gem
		   // Warning! Resource Library Name Can Not Be Capital Letters!
			   
		   //资源库路径：assets\[Resource Library Name]\textures\items
		   //当前资源库名称：super_world_gem
		   // 警告！ 资源库名称不能是大写字母！
		   super(damageVsEntity, MATERIAL, allowedPlayerHarvest_hardcoreBlocksEffectiveAgainstValue);
		   this.setTextureName("super_world_gem_forge_mod:WorldBedrockTheDead_Animated");
		   this.setUnlocalizedName("TopSuperWorldBlockBreaker");
		   
		   //Add this object object to multiple tool properties. And convert it to a tool object.
		   //将这个物品对象，添加多个工具属性。并转换为工具物品对象。
		   this.setHarvestLevel("sword",getThisToolHarvestLevel());
		   this.setHarvestLevel("pickaxe",getThisToolHarvestLevel());
		   this.setHarvestLevel("axe",getThisToolHarvestLevel());
		   this.setHarvestLevel("shovel",getThisToolHarvestLevel());
		   this.setHarvestLevel("SPUERWORLDTOPBLOCKBREAKER", this.getHarvestLevel(itemStack, toolClass) );
		   this.setMaxDamage(MATERIAL.getMaxUses()); //Set the maximum durability, the 0 value is never damaged 设置最大耐久度,值为0的话即为永不损坏
		   
		   this.thisToolMaterial = MATERIAL;
		   this.damageVsEntity = 0.0f + MATERIAL.getDamageVsEntity();
		   this.efficiencyOnProperMaterial = MATERIAL.getEfficiencyOnProperMaterial();
		   this.BlocksEffectiveValue = allowedPlayerHarvest_hardcoreBlocksEffectiveAgainstValue;
		   this.maxStackSize = 1;
		   this.setCreativeTab(CreativeTabs.tabTools); 
	  
		}
		
		// Damage value of ItemStack is Item Meta-data
		public int getMetadata(ItemStack stack)
		{
			return stack.getItemDamage();
		}
		
		// Function name = func_150897_b is a isBlockCanBeHarvested()
		@Override
		public boolean func_150897_b(Block block)
		{
			/*
			if(allowedPlayerHarvest_hardcoreBlocksEffectiveAgainstValue.contains(block) == true && bannedPlayerHarvest_easyBlocksEffectiveValue.contains(block) == false)
			{
				return true;
			}
			else if (allowedPlayerHarvest_hardcoreBlocksEffectiveAgainstValue.contains(block) == false && bannedPlayerHarvest_easyBlocksEffectiveValue.contains(block) == true)
			{
				super.func_150897_b(block);
			}
			else if (allowedPlayerHarvest_hardcoreBlocksEffectiveAgainstValue.contains(block) == true && bannedPlayerHarvest_easyBlocksEffectiveValue.contains(block) == true)
			{
				return true;
			}
			return false;
			*/
			
			if(block != Blocks.air)
			{
				return true;
			}
			return false;
		}
		
		/**
		 * ItemStack sensitive version of {@link #canHarvestBlock(Block)}
		 * @param par1Block The block trying to harvest
		 * @param itemStack The itemstack used to harvest the block
		 * @return true if can harvest the block
		 */
		@Override
		public boolean canHarvestBlock(Block block, ItemStack itemStack)
		{
			return this.func_150897_b(block);
		}
		
		/**
		 * Metadata-sensitive version of getStrVsBlock
		 * @param itemstack The Item Stack
		 * @param block The block the item is trying to break
		 * @param metadata The items current metadata
		 * @return The damage strength of block
		 */
		@Override
		public float getDigSpeed(ItemStack itemStack, Block block, int meta)
		{
			
			if(ForgeHooks.isToolEffective(itemStack, block, meta))
			{
				return this.efficiencyOnProperMaterial;
			}
			else if(!ForgeHooks.isToolEffective(itemStack, block, meta))
			{
				return super.getDigSpeed(itemStack, block, meta);
			}
			else
			{
				return 0.0F;
			}
			
		}
		
		/**
		 * @Notes First, the against value based on the digging speed of the given block. 
		 * @Notes Then, if the value of the item stack digging speed is greater than the against value of the block digging speed.(The return value is less than or equal to 0F). Set the item's stack digging speed is equal to valid. 
		 * @Notes But, if the value of the item stack digging speed is less than the against value of the block digging speed. (The return value is greater than 0F). Set the item's stack digging speed is equal to invalid. 
		 * @Notes Finally, according to the above conditions, return the value of the digging speed (This item stack strength or This item stack hardness of the destructive power).
		 * 
		 * @Notes 首先，基于给定块的挖掘速度的反对值。
		 * @Notes 然后，如果物品堆栈挖掘速度的值，大于方块挖掘速度的反对值。(返回值小于或等于0F)。那么物品堆栈挖掘速度为有效。
		 * @Notes 但是，如果物品堆栈挖掘速度的值，小于方块挖掘速度的反对值。(返回值大于0F)。那么物品堆栈挖掘速度为无效。
		 * @Notes 最后，根据以上条件，返回挖掘速度的值（物品堆栈强度或物品堆栈硬度的破坏力）。
		 * 
		 * @Notes If value equal 1.0F the dig speed of base, (Quality+1)*2 if value equal correct blocktype. If value equal 1.5F the dig speed of sword.
		 * 
		 * @Notes 如果返回的强度值等于1.0F基础的挖掘速度, 如果(质量+ 1)* 2 的值等于正确的块类型。如果返回的强度值等于1.5F剑的挖掘速度
		 * 
		 * Reverse and overload data sets are used to break through the boundaries of excavation efficiency for unbreakable cubes.
		 * 反向和过载数据组，用于突破挖掘效率的界限，针对于牢不可破的立方体。
		 * 
		 */
		
		//This Function name getDestorySpeed (func_150893_a) is destroy speed of special block
		//This Function name func_150893_a is a getStrVsBlock() or getEfficiencyVersusBlock()
		
		@Override
		public float func_150893_a(ItemStack itemStack, Block block)
		{
			// Reacquire, new harvest level values, applied to custom tools material. Then, a new dig speed is generated.
			// 重新获取，新的收获水平值，应用于自定义工具材料。然后，生成新的挖掘速度。
			
			float myToolEfficiency = 0.0f;
			
			for(int DestoryBlockSpeedOverflow = 0; DestoryBlockSpeedOverflow <= allowedPlayerHarvest_hardcoreBlocksEffectiveAgainstValue.toString().length(); DestoryBlockSpeedOverflow++)
			{
				if(this.BlocksEffectiveValue.equals(block) == true || this.canHarvestBlock(block, itemStack) == true)
				{
					return this.efficiencyOnProperMaterial;
				}
				else if (block.getMaterial() == Material.wood || block.getMaterial() == Material.vine || block.getMaterial() == Material.plants)
				{
					return super.func_150893_a(itemStack, block);
	    		}
				else
				{
					
					if(bannedPlayerHarvest_easyBlocksEffectiveValue.contains(block) == false && allowedPlayerHarvest_hardcoreBlocksEffectiveAgainstValue.contains(block) == true)
					{
						myToolEfficiency = this.efficiencyOnProperMaterial;
					}
					else if(bannedPlayerHarvest_easyBlocksEffectiveValue.contains(block) == true && allowedPlayerHarvest_hardcoreBlocksEffectiveAgainstValue.contains(block) == false)
					{
						myToolEfficiency = super.func_150893_a(itemStack, block);
					}
					else
					{
						myToolEfficiency = this.getDigSpeed(itemStack, block, this.getMetadata(itemStack));
					}
				}
				
			}
			
			if(myToolEfficiency == 0.0F && this.canHarvestBlock(block, itemStack) == true)
			{
				return this.BlocksEffectiveValue.contains(block) ? this.efficiencyOnProperMaterial : this.getDigSpeed(itemStack, block, this.getMetadata(itemStack));
			}
			else if (myToolEfficiency == super.func_150893_a(itemStack, block))
			{
				return myToolEfficiency;
			}
			
			return myToolEfficiency != 0.0f ? myToolEfficiency : this.getThisEfficiencyOnProperMaterial();
			
		}
		
		/**
		 * Sets or removes the harvest level for the specified tool class.
		 *
		 * @param toolClass Class
		 * @param level Harvest level:
		 *     Wood:    0
		 *     Stone:   1
		 *     Iron:    2
		 *     Diamond: 3
		 *     Gold:    0
		 */
		@Override
		public void setHarvestLevel(String toolClass, int level)
		{
			if (level < -1)
				toolClasses.remove(toolClass);
			else if (level == -1)
				toolClasses.put(toolClass, level);
			else if (level == 0 )
				toolClasses.remove(toolClass);
			else if(level > 0)
				toolClasses.put(toolClass, level);
				
		}

		@Override
		public Set<String> getToolClasses(ItemStack stack)
		{
			if(toolClass != null || toolClasses != null)
			{
				return ImmutableSet.of("sword", "pickaxe", "shovel", "axe", toolClass);
			}
			else
			{
				return super.getToolClasses(stack);
			}
		}
		
		/**
		 * Queries the harvest level of this item stack for the specifred tool class,
		 * Returns -1 if this tool is not of the specified type
		 *
		 * @param stack This item stack instance
		 * @param toolClass Tool Class
		 * @return Harvest level, or -1 if not the specified tool type.
		 */
		@Override
		public int getHarvestLevel(ItemStack stack, String toolClass)
		{
			if(toolClass != null && this.getToolClasses(stack).contains(toolClass))
			{
				/*
				 * Keep the overflow state private to the living tool.  Vanilla/Forge uses
				 * negative harvest levels as "not this tool type", so after the real int
				 * overflow we expose Integer.MAX_VALUE to the ordinary harvest-level API
				 * while retaining Integer.MIN_VALUE + the overflow flag in ItemStack NBT.
				 */
				if(this.hasLivingHarvestOverflowed(stack))
				{
					return Integer.MAX_VALUE;
				}

				return this.getLivingHarvestLevel(stack);
			}

			return super.getHarvestLevel(stack, toolClass);
		}
		
		@Override
		public boolean getIsRepairable(ItemStack a, ItemStack b)
		{
			ItemStack matches = this.toolMaterial.getRepairItemStack();
			if (matches == null && net.minecraftforge.oredict.OreDictionary.itemMatches(matches, a, false)) 
			{
				return false;
			}
			else if(matches != null)
			{
				return true;
			}
			return net.minecraftforge.oredict.OreDictionary.itemMatches(matches, a, false);
		}
		
	/**
	 * Return the enchantability factor of the item, most of the time is based on material.
	 */
	@Override
	public int getItemEnchantability()
	{
		return 64;
	}

	/**
	 * Return the name for this tool's material.
	 */
	public String getToolMaterialName()
	{
		return this.toString();
	}
	
		//@Override
		public boolean hitEntity(ItemStack particular1_ItemStack, EntityPlayer particular2_Player, EntityLiving particular3_EntityLiving)
		{
			particular1_ItemStack.damageItem(256, particular2_Player);
			return true;
		}
		
		//@Override
		public boolean onBlockDestroyed(ItemStack particular01_ItemStack, World particular02_World, int particular03, int particular04_posX ,int particular05_posY, int particular06_posZ, EntityLiving particular07_EntityLiving)
		{
			particular01_ItemStack.damageItem(1, particular07_EntityLiving);
			return true;
		}
		
		/**
		 * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
		 * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
		 */
		@Override
		public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int positionX, int positionY, int positionZ, int length, float a, float b, float c)
		{
			/*
			 * Legacy versions of this tool used right-click + world.setBlockToAir() as
			 * a fallback.  Do not do that anymore: it bypasses the entire mining model.
			 *
			 * Returning false leaves the block untouched.  The new behaviour lives in
			 * the normal LEFT-CLICK mining path through ForgeHooks.blockStrength().
			 * The original implementation is preserved verbatim under /legacy_original.
			 */
			return false;
		}
		
		
		//The parameters are itemStack (a collection of items and quantities, metadata, etc.), world (world), entity (entity you own), slot (current slot number), isHeld (whether you own)
		//参数是itemStack（项目和数量，元数据等的集合），world（世界），entity（您拥有的实体），slot（当前插槽号），isHeld（是否拥有）
		@Override
		public void onUpdate(ItemStack itemStack, World world, Entity entity, int slot, boolean isHeld)
		{
			//Check if it is not enchanted
			//检查它是否未附魔
			if (itemStack.isItemEnchanted() == false) 
			{
				//Enchanting adds parameters in the order of enchantment and level
				//附魔按照结界和等级的顺序添加参数
				itemStack.addEnchantment(Enchantment.efficiency, 1);
				itemStack.addEnchantment(Enchantment.unbreaking, 1);
				itemStack.addEnchantment(Enchantment.knockback, 1);
				itemStack.addEnchantment(Enchantment.protection, 1);
			}
		}
	
	// /*
	// static
	// {
		// //Item.ToolMaterial SPUERWORLDTOPBLOCKBREAKER = EnumHelper.addToolMaterial("SPUERWORLDTOPBLOCKBREAKER", 64, 20480000, 51200000.0F, 10240000F, 0);
		// TopSuperWorldBlockBreaker = new ItemPickaxe(SPUERWORLDTOPBLOCKBREAKER) //SPUERWORLDTOPBLOCKBREAKER, blocksEffectiveAgainstValue
		// {
			  // public Set<String> getToolClasses(ItemStack stack) {
				  // HashMap<String, Integer> returnValue = new HashMap<String, Integer>();
				  // returnValue.put("sword", ToolHarvestLevel);
				  // returnValue.put("pickaxe", ToolHarvestLevel);
				  // returnValue.put("axe", ToolHarvestLevel);
				  // returnValue.put("shovel", ToolHarvestLevel);
				  // returnValue.put("SPUERWORLDTOPBLOCKBREAKER", ToolHarvestLevel);
				  // return returnValue.keySet();
			  // }
		 // }.setMaxStackSize(1).setCreativeTab(CreativeTabs.tabTools).setUnlocalizedName("TopSuperWorldBlockBreaker").setMaxDamage(102400);
	// }
	// //Item.itemRegistry.addObject(455, "MinecraftWorldDestroyer", TopSuperWorldBlockBreaker);
	// */
		
	/**
	 * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
	 * the damage on the stack.
	 */

	@SideOnly(Side.CLIENT)

	/**
	 * Returns True is the item is renderer in full 3D when hold.
	 */
	@Override
	public boolean isFull3D()
	{
		return true;
	}
	
  }
	
}

		 /////Mandatory Forge Code Start: [Warning!] Overridden to allow custom tool effectiveness/////
		 
		 /*
		 
		 @Override
		 public void setHarvestLevel(String toolClass, int level)
		 {
				if (level < 0 && level == -1)
					toolClasses.put(toolClass, level);
				if (level == 0)
					toolClasses.remove(toolClass);
				if (level > 0)
					toolClasses.remove(toolClass);
				if (level != -1)
					toolClasses.remove(toolClass);
				else
					toolClasses.remove(toolClass);
		 }
		 
		 @Override
		 public int getHarvestLevel(ItemStack stack, String toolClass)
		 {
			 int level = super.getHarvestLevel(stack, toolClass);
			 if (level != -1 && toolClass != null && toolClass.equals(this.toolClass))
			 {
				 level = -1;
				 return level;
			 }
			 if(level == 0 && toolClass != null && toolClass.equals(this.toolClass))
			 {
				level = -1;
				return level;
			 }
			 if(level == 0 && toolClass != null)
			 {
				level = -1;
				return level;
			 }
			 if (level != -1 && toolClass == null)
			 {
				 return this.toolMaterial.getHarvestLevel();
			 }
			 else
			 {
				 return this.toolMaterial.getHarvestLevel();
			 }
		 }
		 */
		 
		 /////Mandatory Forge Code End/////