package teamport.aethersedge.item.tools.phoenix;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicLog;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.data.gamerule.GameRules;
import net.minecraft.core.data.gamerule.TreecapitatorHelper;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import teamport.aether.block.AetherBlockTags;
import teamport.aether.helper.ParticleMaker;
import teamport.aether.item.AetherHasCustomDamageType;
import teamport.aether.item.AetherItems;
import teamport.aether.item.item_tool.ItemToolAxeAether;
import teamport.aethersedge.item.AetherEdgeItems;
import turniplabs.halplibe.helper.EnvironmentHelper;

public class ItemToolAxePhoenix extends ItemToolAxeAether implements AetherHasCustomDamageType, PhoenixAdjustBlockDropped {
	public ItemToolAxePhoenix(String name, String namespaceId, int id, ToolMaterial enumtoolmaterial) {
		super(name, namespaceId, id, enumtoolmaterial);
	}

	@Override
	public boolean hitEntity(ItemStack itemstack, Mob target, Mob attacker) {
		if (target instanceof Mob && target.hurtTime == 10 && attacker.isSneaking() && attacker instanceof Player) {
			ParticleMaker.spawnFireSwordParticles(target);
			target.maxFireTicks = 600;
			target.remainingFireTicks = 600;
		}

		return super.hitEntity(itemstack, target, attacker);
	}

	public float getStrVsBlock(ItemStack itemstack, Block<?> block) {
		return !block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_AXE) && !block.hasTag(BlockTags.MINEABLE_BY_AXE) ? 1.0F : this.material.getEfficiency(false);
	}

	@Override
	public boolean beforeDestroyBlock(World world, ItemStack itemStack, int blockId, int x, int y, int z, Side side, Player player) {
		if (!world.isClientSide && (Boolean)world.getGameRuleValue(GameRules.TREECAPITATOR) && !player.isSneaking()) {
			ItemStack held = player.getHeldItem();
			Block<?> block = Blocks.blocksList[blockId];
			if (Block.hasLogicClass(block, BlockLogicLog.class) && (block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_AXE) || held != null && held.itemID == AetherEdgeItems.TOOL_AXE_PHOENIX.id)) {
				return !(new TreecapitatorHelper(world, x, y, z, player)).chopTree();
			}
		}

		return true;
	}

	@Override
	public DamageType getDamageType() {
		return DamageType.FIRE;
	}
}
