package teamport.aethersedge;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import teamport.aethersedge.item.AetherEdgeItems;
import turniplabs.halplibe.util.ModelEntrypoint;

@Environment(EnvType.CLIENT)
public class AetherEdgeModels implements ModelEntrypoint {
	@Override
	public void initBlockModels(BlockModelDispatcher dispatcher) {

	}

	@Override
	public void initItemModels(ItemModelDispatcher dispatcher) {
		dispatcher.addDispatch(new ItemModelStandard(AetherEdgeItems.TOOL_SWORD_PHOENIX, null).setIcon("aethersedge:item/tool_sword_phoenix").setFull3D().setFullBright());
		dispatcher.addDispatch(new ItemModelStandard(AetherEdgeItems.TOOL_AXE_PHOENIX, null).setIcon("aethersedge:item/tool_axe_phoenix").setFull3D().setFullBright());
		dispatcher.addDispatch(new ItemModelStandard(AetherEdgeItems.TOOL_PICKAXE_PHOENIX, null).setIcon("aethersedge:item/tool_pickaxe_phoenix").setFull3D().setFullBright());
		dispatcher.addDispatch(new ItemModelStandard(AetherEdgeItems.TOOL_SHOVEL_PHOENIX, null).setIcon("aethersedge:item/tool_shovel_phoenix").setFull3D().setFullBright());
	}

	@Override
	public void initEntityModels(EntityRenderDispatcher dispatcher) {

	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {

	}

	@Override
	public void initBlockColors(BlockColorDispatcher dispatcher) {

	}
}
