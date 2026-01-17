package teamport.aethersedge;

import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static teamport.aether.AetherMod.MOD_ID;

public class AetherEdgeRecipes implements RecipeEntrypoint {
	@Override
	public void onRecipesReady() {

	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(MOD_ID);
	}
}
