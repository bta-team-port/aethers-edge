package teamport.aethersedge;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import turniplabs.halplibe.util.ClientStartEntrypoint;

import static teamport.aether.AetherMod.LOGGER;

@Environment(EnvType.CLIENT)
public class AetherEdgeClient implements ClientModInitializer, ClientStartEntrypoint {
	@Override
	public void onInitializeClient() {

	}

	@Override
	public void beforeClientStart() {

	}

	@Override
	public void afterClientStart() {
		LOGGER.info("Aether's Edge client initialized.");
	}
}
