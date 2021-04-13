package twilight_magical.minecraft_forge_modding.super_world_gem.tools;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Bridge between the ForgeHooks ASM patch and the living block-breaker item.
 *
 * This class intentionally does not change Block.blockHardness. It only gives
 * the held living tool one chance to reinterpret the hardness value that
 * ForgeHooks.blockStrength() just read for this single calculation.
 */
public final class LivingHardnessHooks
{
    private LivingHardnessHooks()
    {
    }

    public static float transformObservedHardness(float originalHardness,
            Object blockObject, Object playerObject, Object worldObject,
            int x, int y, int z)
    {
        if(originalHardness >= 0.0F)
        {
            return originalHardness;
        }

        if(!(blockObject instanceof Block) ||
           !(playerObject instanceof EntityPlayer) ||
           !(worldObject instanceof World))
        {
            return originalHardness;
        }

        Block block = (Block)blockObject;
        EntityPlayer player = (EntityPlayer)playerObject;
        World world = (World)worldObject;

        ItemStack stack = player.getCurrentEquippedItem();
        if(stack == null)
        {
            return originalHardness;
        }

        if(!(stack.getItem() instanceof LoadTopSuperWorldBlockBreaker.ItemToolSuperWorldBlockBreaker))
        {
            return originalHardness;
        }

        LoadTopSuperWorldBlockBreaker.ItemToolSuperWorldBlockBreaker livingTool =
                (LoadTopSuperWorldBlockBreaker.ItemToolSuperWorldBlockBreaker)stack.getItem();

        return livingTool.transformObservedHardness(
                stack, block, player, world, x, y, z, originalHardness);
    }
}
