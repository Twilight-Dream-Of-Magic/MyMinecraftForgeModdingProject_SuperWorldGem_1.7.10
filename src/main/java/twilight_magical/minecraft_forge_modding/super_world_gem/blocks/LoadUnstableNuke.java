package twilight_magical.minecraft_forge_modding.super_world_gem.blocks;

import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.Explosion;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.util.IIcon;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.PotionEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.Entity;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.Minecraft;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class LoadUnstableNuke extends Block {
	
	public LoadUnstableNuke(String unlocalizedName, Material material, float hardness, float resistance) {
		super(material);
		this.setBlockName(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabRedstone);
		this.setHardness(hardness);
		this.setBlockTextureName("super_world_gem_forge_mod:UnstableNuke");
		this.setHarvestLevel("pickaxe",4);
		this.setHarvestLevel("SPUERWORLDTOPPICKAXE",8);
		this.setHarvestLevel("SPUERWORLDTOPBLOCKBREAKER", 8);
	}

	public LoadUnstableNuke(String unlocalizedName, float hardness, float resistance) {
	    this(unlocalizedName, Material.rock, hardness, resistance);

	}
	
	public LoadUnstableNuke(String unlocalizedName) {
		this(unlocalizedName, 32.0f, 2.0f);
	}
	
	
	// Minercaft SuperWorldGen Mod Nuke Block Explosion Core Code
	
	/*
	 if(true)
	 {
	 
	 }
	 */
	
	int Top = 0, Bottom = 0, Left = 0, Right = 0, Front = 0, Behind = 0;
	
	boolean redstonePower = false;
	
	World thisWorldObject;
	Entity theTriggeringEntity;
	double positionX;
	double positionY;
	double positionZ;
	float explosionStrength;
	
	@Override
	public void onBlockAdded(World thisWorldObject, int positionX, int positionY, int positionZ)
	{
		EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
		
		if (entity != null && thisWorldObject != null)
		{
			int le = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 320.0F) + 0.5D) & 3;
			thisWorldObject.setBlockMetadataWithNotify(positionX, positionY, positionZ, le, 2);
		}

		thisWorldObject.scheduleBlockUpdate(positionX, positionY, positionZ, this, this.tickRate(thisWorldObject));

	}

	//@Override
	public int positionXsProvidingStrongPower(IBlockAccess particular1_IBlockAccess, int particular2_posX, int particular3_posY, int particular4_posZ, int particular5)
	{
		return redstonePower ? 1 : 0;
	}
	
	/*****

     //Example of an explosion function prototype

     public Explosion createExplosion(Entity entityIn, double x, double y, double z, float strength, boolean isSmoking)
     {
         return this.newExplosion(entityIn, x, y, z, strength, false, isSmoking);
     }
    
     public Explosion newExplosion(Entity entityIn, double x, double y, double z, float strength, boolean isFlaming, boolean isSmoking)
     {
         Explosion explosion = new Explosion(this, entityIn, x, y, z, strength, isFlaming, isSmoking);
         if (net.minecraftforge.event.ForgeEventFactory.onExplosionStart(this, explosion)) return explosion;
         explosion.doExplosionA();
         explosion.doExplosionB(true);
         return explosion;
     }
	
	*****/
	
	//Creates an explosion. Argument: entity, x, y, z, strength
	public Explosion createExplosion(Entity theTriggeringEntity, double positionX, double positionY, double positionZ, float explosionStrength, boolean isSmokingValue)
    {
         return this.newExplosion(theTriggeringEntity, positionX, positionY, positionZ, explosionStrength, true, isSmokingValue);
    }

	//returns a new explosion. Does initiation (at time of writing Explosion is not finished)
	Explosion explosionInterface = new Explosion(thisWorldObject, theTriggeringEntity, positionX, positionY, positionZ, explosionStrength);
	public Explosion newExplosion(Entity theTriggeringEntity, double positionX, double positionY, double positionZ, float explosionStrength, boolean isFlamingValue, boolean isSmokingValue)
	{
		// isFlaming <-> Whether the impact is on fire. 
		// 影响是否着火
		explosionInterface.isFlaming = isFlamingValue;
	    // isSmoking <-> Affect whether to generate particles and destroy squares. 
		// 影响是否生成粒子和破坏方块
		explosionInterface.isSmoking = isSmokingValue;
		if (net.minecraftforge.event.ForgeEventFactory.onExplosionStart(thisWorldObject, explosionInterface)) return explosionInterface;
		
		// The first stage, the calculation of the broken box, the damage to the entity. 
		// 第一阶段，计算被破坏的方块，伤害实体
		explosionInterface.doExplosionA();
		// The second stage, the destruction of the box, the formation of particle effects and falling objects. 
		// 第二阶段，破坏方块，生成粒子效果和掉落物
		explosionInterface.doExplosionB(true);
		return explosionInterface;
	}

	@Override
	public void onNeighborBlockChange(World thisWorldObject, int positionX, int positionY, int positionZ, Block l)
	{
		EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
		
		if (Block.getIdFromBlock(l) > 0 && l.canProvidePower() && thisWorldObject.isBlockIndirectlyGettingPowered(positionX, positionY, positionZ)) 
		{
			
			if (!Minecraft.getMinecraft().isSingleplayer())
			{
			    Minecraft.getMinecraft().thePlayer.sendChatMessage("\u00A76 Hi Players, I am Twilight_Magical, the author of SuperWorldGem's Mod.");
			    Minecraft.getMinecraft().thePlayer.sendChatMessage("\u00A7c Inevitable nuke bombs have been activated, it is very dangerous, then I wish you good luck ");
			}
			
			//Explosion explosionInterface = new Explosion(world, entity, positionX, positionY, positionZ, 32768F);
			//explosionInterface.doExplosionA();
			//explosionInterface.doExplosionB(true);
			
		    if(true)
			{
				long Time_Control_Of_Explosion_Number;
				
				for(Time_Control_Of_Explosion_Number = 0;Time_Control_Of_Explosion_Number <= 3600;Time_Control_Of_Explosion_Number++)
				{
					if(Time_Control_Of_Explosion_Number == 0)
					{
						thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 2F, true);
					}
					if(Time_Control_Of_Explosion_Number == 240)
					{
						thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 4F, true);
					}
					if(Time_Control_Of_Explosion_Number == 480)
					{
						thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 8F, true);
					}
					if(Time_Control_Of_Explosion_Number == 780)
					{
						thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 16F, true);
					}
					if(Time_Control_Of_Explosion_Number == 960)
					{
						thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 32F, true);
					}
					if(Time_Control_Of_Explosion_Number == 1200)
					{
						thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 64F, true);
					}
					if(Time_Control_Of_Explosion_Number == 1440)
					{
						thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 128F, true);
					}
					if(Time_Control_Of_Explosion_Number == 1680)
					{
						thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 256F, true);
					}
					if(Time_Control_Of_Explosion_Number == 1920)
					{
						thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 512F, true);
					}
					if(Time_Control_Of_Explosion_Number == 2160)
					{
						thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 1024F, true);
					}
					if(Time_Control_Of_Explosion_Number == 2400)
					{
						thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 2048F, true);
					}
					if(Time_Control_Of_Explosion_Number == 2640)
					{
						thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 4096F, true);
					}
					if(Time_Control_Of_Explosion_Number == 2880)
					{
						thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 8192F, true);
					}
					if(Time_Control_Of_Explosion_Number == 3120)
					{
						thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 16384F, true);
					}
					if(Time_Control_Of_Explosion_Number == 3360)
					{
						thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 32768F, true);
					}
					if(Time_Control_Of_Explosion_Number == 3600)
					{
						thisWorldObject.newExplosion((Entity) null, positionX, positionY, positionZ, 65536F, true, true);
					}
				}
			}
				
			entity.attackEntityFrom(DamageSource.generic, 16392);
			entity.attackEntityFrom(DamageSource.outOfWorld, 8192);
			entity.attackEntityFrom(DamageSource.onFire, 4096);
			DamageSource.setExplosionSource(explosionInterface);

		}
	}

	@Override
	public void onBlockDestroyedByPlayer(World thisWorldObject, int positionX, int positionY, int positionZ, int l)
	{
	  EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
	  
	    if (!Minecraft.getMinecraft().isSingleplayer())
		{
		    Minecraft.getMinecraft().thePlayer.sendChatMessage("\u00A76 Hi Players, I am Twlilght_Yujiang, the author of SuperWorldGem's Mod.");
		    Minecraft.getMinecraft().thePlayer.sendChatMessage("\u00A7c Inevitable nuke bombs have been activated, it is very dangerous, then I wish you good luck ");
		}
	  
	    if(true)
		{
			long Time_Control_Of_Explosion_Number;
			
			for(Time_Control_Of_Explosion_Number = 0;Time_Control_Of_Explosion_Number <= 3600;Time_Control_Of_Explosion_Number++)
			{
				if(Time_Control_Of_Explosion_Number == 0)
				{
					this.createExplosion((Entity) null, positionX, positionY, positionZ, 2F, true);
				}
				if(Time_Control_Of_Explosion_Number == 240)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 4F, true);
				}
				if(Time_Control_Of_Explosion_Number == 480)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 8F, true);
				}
				if(Time_Control_Of_Explosion_Number == 780)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 16F, true);
				}
				if(Time_Control_Of_Explosion_Number == 960)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 32F, true);
				}
				if(Time_Control_Of_Explosion_Number == 1200)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 64F, true);
				}
				if(Time_Control_Of_Explosion_Number == 1440)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 128F, true);
				}
				if(Time_Control_Of_Explosion_Number == 1680)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 256F, true);
				}
				if(Time_Control_Of_Explosion_Number == 1920)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 512F, true);
				}
				if(Time_Control_Of_Explosion_Number == 2160)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 1024F, true);
				}
				if(Time_Control_Of_Explosion_Number == 2400)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 2048F, true);
				}
				if(Time_Control_Of_Explosion_Number == 2640)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 4096F, true);
				}
				if(Time_Control_Of_Explosion_Number == 2880)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 8192F, true);
				}
				if(Time_Control_Of_Explosion_Number == 3120)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 16384F, true);
				}
				if(Time_Control_Of_Explosion_Number == 3360)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 32768F, true);
				}
				if(Time_Control_Of_Explosion_Number == 3600)
				{
					thisWorldObject.newExplosion((Entity) null, positionX, positionY, positionZ, 65536F, true, true);
				}
			}
		}
	  
	    entity.attackEntityFrom(DamageSource.generic, 16392);
		entity.attackEntityFrom(DamageSource.outOfWorld, 8192);
		entity.attackEntityFrom(DamageSource.onFire, 4096);
	    DamageSource.setExplosionSource(explosionInterface);

	}

	@Override
	public void onBlockDestroyedByExplosion(World thisWorldObject, int positionX, int positionY, int positionZ, Explosion explosion)
	{
	  EntityPlayer entity = Minecraft.getMinecraft().thePlayer;
	  
	    if (!Minecraft.getMinecraft().isSingleplayer())
		{
		    Minecraft.getMinecraft().thePlayer.sendChatMessage("\u00A76 Hi Players, I am Twlilght_Yujiang, the author of SuperWorldGem's Mod.");
		    Minecraft.getMinecraft().thePlayer.sendChatMessage("\u00A7c Inevitable nuke bombs have been activated, it is very dangerous, then I wish you good luck ");
		}
	  
	    if(true)
		{
			long Time_Control_Of_Explosion_Number;
			
			for(Time_Control_Of_Explosion_Number = 0;Time_Control_Of_Explosion_Number <= 3600;Time_Control_Of_Explosion_Number++)
			{
				if(Time_Control_Of_Explosion_Number == 0)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 2F, true);
				}
				if(Time_Control_Of_Explosion_Number == 240)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 4F, true);
				}
				if(Time_Control_Of_Explosion_Number == 480)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 8F, true);
				}
				if(Time_Control_Of_Explosion_Number == 780)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 16F, true);
				}
				if(Time_Control_Of_Explosion_Number == 960)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 32F, true);
				}
				if(Time_Control_Of_Explosion_Number == 1200)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 64F, true);
				}
				if(Time_Control_Of_Explosion_Number == 1440)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 128F, true);
				}
				if(Time_Control_Of_Explosion_Number == 1680)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 256F, true);
				}
				if(Time_Control_Of_Explosion_Number == 1920)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 512F, true);
				}
				if(Time_Control_Of_Explosion_Number == 2160)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 1024F, true);
				}
				if(Time_Control_Of_Explosion_Number == 2400)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 2048F, true);
				}
				if(Time_Control_Of_Explosion_Number == 2640)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 4096F, true);
				}
				if(Time_Control_Of_Explosion_Number == 2880)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 8192F, true);
				}
				if(Time_Control_Of_Explosion_Number == 3120)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 16384F, true);
				}
				if(Time_Control_Of_Explosion_Number == 3360)
				{
					thisWorldObject.createExplosion((Entity) null, positionX, positionY, positionZ, 32768F, true);
				}
				if(Time_Control_Of_Explosion_Number == 3600)
				{
					thisWorldObject.newExplosion((Entity) null, positionX, positionY, positionZ, 65536F, true, true);
				}
			}
		}

	    entity.attackEntityFrom(DamageSource.generic, 16392);
		entity.attackEntityFrom(DamageSource.outOfWorld, 8192);
		entity.attackEntityFrom(DamageSource.onFire, 4096);
	    DamageSource.setExplosionSource(explosionInterface);

	}

	@Override
	public void onBlockClicked(World thisWorldObject, int positionX, int positionY, int positionZ, EntityPlayer theTriggeringEntity)
	{

	  if (theTriggeringEntity instanceof EntityLivingBase)
			((EntityLivingBase) theTriggeringEntity).addPotionEffect(new PotionEffect(20, 600, 2));

	}

	@Override
	public int onBlockPlaced(World thisWorldObject, int positionX, int positionY, int positionZ, int l, float a, float b, float c, int d)
	{
	  int returnValue = super.onBlockPlaced(thisWorldObject, positionX, positionY, positionZ, l, a, b, c, d);
	  EntityPlayer theTriggeringEntity = Minecraft.getMinecraft().thePlayer;

		if (theTriggeringEntity instanceof EntityLivingBase)
		      ((EntityLivingBase) theTriggeringEntity).addPotionEffect(new PotionEffect(2, 3600000, 5));

		if (theTriggeringEntity instanceof EntityLivingBase)
			  ((EntityLivingBase) theTriggeringEntity).addPotionEffect(new PotionEffect(9, 600, 2));

		if (theTriggeringEntity instanceof EntityLivingBase)
		      ((EntityLivingBase) theTriggeringEntity).addPotionEffect(new PotionEffect(20, 36000, 5));
		  
		return returnValue;
	}

	@Override
	public void onEntityCollidedWithBlock(World thisWorldObject, int positionX, int positionY, int positionZ, Entity theTriggeringEntity)
	{
		
	  if (theTriggeringEntity instanceof EntityLivingBase)
			((EntityLivingBase) theTriggeringEntity).addPotionEffect(new PotionEffect(20, 3600000, 5));

	  if (theTriggeringEntity instanceof EntityLivingBase)
			((EntityLivingBase) theTriggeringEntity).addPotionEffect(new PotionEffect(2, 3600000, 5));
			
	  if (theTriggeringEntity instanceof EntityLivingBase)
			((EntityLivingBase) theTriggeringEntity).addPotionEffect(new PotionEffect(9, 3600000, 2));

	  if (theTriggeringEntity instanceof EntityLivingBase)
			((EntityLivingBase) theTriggeringEntity).addPotionEffect(new PotionEffect(9, 360000, 5));

	}
	
}

