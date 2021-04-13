package twilight_magical.minecraft_forge_modding.super_world_gem.core;

import net.minecraft.launchwrapper.IClassTransformer;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

/**
 * Surgical Forge 1.7.10 patch.
 *
 * Original ForgeHooks.blockStrength() shape:
 *
 *   int metadata = world.getBlockMetadata(x, y, z);
 *   float hardness = block.getBlockHardness(world, x, y, z);
 *   if (hardness < 0.0F) return 0.0F;
 *
 * Patched shape:
 *
 *   float hardness = block.getBlockHardness(...);
 *   hardness = LivingHardnessHooks.transformObservedHardness(
 *	   hardness, block, player, world, x, y, z);
 *   if (hardness < 0.0F) return 0.0F;
 *
 * No block field is modified. Only the local float used by this one mining
 * calculation is replaced when the held living tool explicitly permits it.
 */
public class ForgeHooksHardnessTransformer implements IClassTransformer, Opcodes
{
	private static final String TARGET_CLASS = "net.minecraftforge.common.ForgeHooks";

	private static final String HOOK_OWNER =
			"twilight_magical/minecraft_forge_modding/super_world_gem/tools/LivingHardnessHooks";

	private static final String HOOK_NAME = "transformObservedHardness";

	/*
	 * Object parameters are deliberate. The core transformer itself is excluded
	 * from FML's normal class transformation/remapping, so keeping Minecraft
	 * class names out of this injected descriptor makes the patch less fragile
	 * between the development and reobfuscated 1.7.10 runtime.
	 */
	private static final String HOOK_DESC = "(FLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;III)F";

	@Override
	public byte[] transform(String name, String transformedName, byte[] basicClass)
	{
		if(basicClass == null)
		{
			return null;
		}

		if(!TARGET_CLASS.equals(name) && !TARGET_CLASS.equals(transformedName))
		{
			return basicClass;
		}

		ClassNode classNode = new ClassNode();
		ClassReader reader = new ClassReader(basicClass);
		reader.accept(classNode, 0);

		boolean patched = false;

		for(MethodNode method : classNode.methods)
		{
			if(!"blockStrength".equals(method.name))
			{
				continue;
			}

			/*
			 * In Forge 10.13.4.1614, the first FSTORE in blockStrength stores
			 * exactly the result of Block.getBlockHardness(...). Locating the
			 * local by opcode instead of naming the Minecraft method keeps this
			 * patch independent from MCP/SRG naming of getBlockHardness itself.
			 */
			for(AbstractInsnNode instruction = method.instructions.getFirst();
					instruction != null;
					instruction = instruction.getNext())
			{
				if(instruction.getOpcode() != FSTORE)
				{
					continue;
				}

				VarInsnNode hardnessStore = (VarInsnNode)instruction;
				int hardnessLocal = hardnessStore.var;

				InsnList inject = new InsnList();

				// originalHardness
				inject.add(new VarInsnNode(FLOAD, hardnessLocal));

				// block, player, world -- blockStrength is static
				inject.add(new VarInsnNode(ALOAD, 0));
				inject.add(new VarInsnNode(ALOAD, 1));
				inject.add(new VarInsnNode(ALOAD, 2));

				// x, y, z
				inject.add(new VarInsnNode(ILOAD, 3));
				inject.add(new VarInsnNode(ILOAD, 4));
				inject.add(new VarInsnNode(ILOAD, 5));

				inject.add(new MethodInsnNode(
						INVOKESTATIC,
						HOOK_OWNER,
						HOOK_NAME,
						HOOK_DESC));

				inject.add(new VarInsnNode(FSTORE, hardnessLocal));

				method.instructions.insert(instruction, inject);
				patched = true;
				break;
			}

			if(patched)
			{
				break;
			}
		}

		if(!patched)
		{
			throw new RuntimeException("SuperWorldGem: failed to patch ForgeHooks.blockStrength hardness boundary");
		}

		ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		classNode.accept(writer);
		return writer.toByteArray();
	}
}
