package teamport.aethersedge;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import teamport.aethersedge.item.AetherEdgeItems;
import turniplabs.halplibe.util.GameStartEntrypoint;

public class AetherEdgeMod implements ModInitializer, GameStartEntrypoint {
	public static final String MOD_ID = "aethersedge";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Aether's Edge initialized.");
	}

	@Override
	public void beforeGameStart() {
		AetherEdgeItems.init();
	}

	@Override
	public void afterGameStart() {
	}
}
