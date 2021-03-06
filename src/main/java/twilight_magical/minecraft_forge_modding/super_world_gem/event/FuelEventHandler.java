package twilight_magical.minecraft_forge_modding.super_world_gem.event;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import twilight_magical.minecraft_forge_modding.super_world_gem.blocks.Block_SuperWorldGemMod;
import twilight_magical.minecraft_forge_modding.super_world_gem.items.Item_SuperWorldGemMod;

import cpw.mods.fml.common.IFuelHandler;

public class FuelEventHandler implements IFuelHandler
{
	/*
	public int HellFireCoalBlock_GetItemId(Item HFCB_ItemFuel) 
	{
		  int HFCB_ItemId;
			
		  if (HFCB_ItemFuel instanceof ItemBlock && Block.getBlockFromItem(HFCB_ItemFuel) != Blocks.air) 
		  {
				
			  HFCB_ItemId = Block.getIdFromBlock(Block.getBlockFromItem(HFCB_ItemFuel));
				
		  }
		  else 
		  {
				
			  HFCB_ItemId = Item.getIdFromItem(HFCB_ItemFuel);
				
		  }
		  
		  return HFCB_ItemId;
	}
	
	public int HellFireCoalBlock_ReturnBurnTime(int HFCB_ItemId, Item HFCB_ItemFuel) 
	{
		  if(HFCB_ItemId == Block.getIdFromBlock(Block_SuperWorldGemMod.HellFireCoalBlock) || HFCB_ItemFuel == Item.getItemFromBlock(Block_SuperWorldGemMod.HellFireCoalBlock)) 
		  {

			 return 6400; //Return This Item Fuel Time
				
		  }
		  else
		  {

			  return 0;
			
		  }
	}

	public int HellFireCoalBlock_BurnTime(ItemStack fuel)
	{
		  Item HFCB_ItemFuel = fuel.getItem();
		  
		  int HFCB_ItemId = Block.getIdFromBlock(Block_SuperWorldGemMod.HellFireCoalBlock);
			
		  this.HellFireCoalBlock_GetItemId(HFCB_ItemFuel);
		  
		  return this.HellFireCoalBlock_ReturnBurnTime(HFCB_ItemId, HFCB_ItemFuel);
			
	}
	*/
	
	/**
	 * Burn time in ticks. 1 tick = 50 ms -> 10s = 200 ticks
	 * @return 
	 * 
	 * @see cpw.mods.fml.common.IFuelHandler#getBurnTime(net.minecraft.item.ItemStack)
	 */
	@Override
	public int getBurnTime(ItemStack fuel) 
	{
		Block blockFuel = Block.getBlockFromItem(fuel.getItem());
		Item itemFuel = fuel.getItem();
		
		if (blockFuel == Block_SuperWorldGemMod.HellFireCoalBlock)
		{
		  return 6400;
		}
		else if (itemFuel == Item_SuperWorldGemMod.ArcticIceBall)
		{
			return 3200;
		}
		else
		{
			return 0;
		}
		//return this.HellFireCoalBlock_BurnTime(fuel);
	}

}
