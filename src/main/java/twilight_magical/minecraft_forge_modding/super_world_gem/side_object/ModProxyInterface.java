package twilight_magical.minecraft_forge_modding.super_world_gem.side_object;

public interface ModProxyInterface {
	
	/*
	 * Run before anything else. Read your config, create blocks, items, etc, and register them with the GameRegistry
	 */

	//PALCommonProxy Preparatory Initializing
	public void preInit();

	/*
	 * Do your mod setup. Build whatever data structures you care about. Register recipes,
	 * send FMLInterModComms messages to other mods.
	 */

	//PALCommonProxy Initializing
	public void init();

    /*
	 * Handle interaction with other mods, complete your setup based on this.
	 */

	//DedicatedServerProxy Later Initializing (Mod class main Post Initializing)
	public void postInit();

}
