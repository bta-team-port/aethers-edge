package teamport.aethersedge.item;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tag.ItemTags;
import teamport.aethersedge.item.tools.phoenix.ItemToolAxePhoenix;
import teamport.aethersedge.item.tools.phoenix.ItemToolPickaxePhoenix;
import teamport.aethersedge.item.tools.phoenix.ItemToolShovelPhoenix;
import teamport.aethersedge.item.tools.phoenix.ItemToolSwordPhoenix;
import turniplabs.halplibe.helper.ItemBuilder;

import static teamport.aether.AetherConfig.itemID;
import static teamport.aethersedge.AetherEdgeMod.MOD_ID;

@SuppressWarnings({"java:S1104", "java:S1444", "java:S3008"})
public final class AetherEdgeItems {
	public static final ToolMaterial phoenix = (new ToolMaterial()).setDurability(1536).setEfficiency(8.0F, 10.0F).setMiningLevel(3);

	public static Item TOOL_PICKAXE_PHOENIX;
	public static Item TOOL_SHOVEL_PHOENIX;
	public static Item TOOL_AXE_PHOENIX;
	public static Item TOOL_SWORD_PHOENIX;

	private static boolean hasInit = false;

	private AetherEdgeItems() {
	}

	public static void init() {
		if (!hasInit) {
			hasInit = true;
			initializeItems();
		}
	}

	public static String itemKey(String string) {
		return MOD_ID + ":item/" + string;
	}

	public static void initializeItems() {
		registerArmor();
		registerTool();
		registerOther();
	}

	public static void registerOther() {

	}

	public static void registerTool() {
		TOOL_SWORD_PHOENIX = new ItemBuilder(MOD_ID)
			.setTags(ItemTags.PREVENT_CREATIVE_MINING)
			.build(new ItemToolSwordPhoenix("tool.sword.phoenix", itemKey("tool_sword_phoenix"), itemID("TOOL_SWORD_PHOENIX"), phoenix));

		TOOL_SHOVEL_PHOENIX = new ItemBuilder(MOD_ID)
			.build(new ItemToolShovelPhoenix("tool.shovel.phoenix", itemKey("tool_shovel_phoenix"), itemID("TOOL_SHOVEL_PHOENIX"), phoenix));

		TOOL_PICKAXE_PHOENIX = new ItemBuilder(MOD_ID)
			.build(new ItemToolPickaxePhoenix("tool.pickaxe.phoenix", itemKey("tool_pickaxe_phoenix"), itemID("TOOL_PICKAXE_PHOENIX"), phoenix));

		TOOL_AXE_PHOENIX = new ItemBuilder(MOD_ID)
			.build(new ItemToolAxePhoenix("tool.axe.phoenix", itemKey("tool_axe_phoenix"), itemID("TOOL_AXE_PHOENIX"), phoenix));
	}

	public static void registerArmor() {

	}
}
