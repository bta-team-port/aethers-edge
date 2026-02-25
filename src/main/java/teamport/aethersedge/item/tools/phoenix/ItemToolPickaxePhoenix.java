package teamport.aethersedge.item.tools.phoenix;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.world.World;
import teamport.aether.block.AetherBlockTags;
import teamport.aether.helper.ParticleMaker;
import teamport.aether.item.AetherHasCustomDamageType;
import teamport.aether.item.item_tool.ItemToolPickaxeAether;
import teamport.aethersedge.item.AdjustBlockDropped;

public class ItemToolPickaxePhoenix extends ItemToolPickaxeAether implements AetherHasCustomDamageType, PhoenixAdjustBlockDropped {
	public ItemToolPickaxePhoenix(String name, String namespaceId, int id, ToolMaterial enumtoolmaterial) {
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

	@Override
	public boolean canHarvestBlock(Mob mob, ItemStack itemStack, Block<?> block) {
		Integer miningLevel = (Integer)aetherMiningLevels.get(block);
		if (miningLevel != null) {
			return this.material.getMiningLevel() >= miningLevel;
		} else {
			return block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_PICKAXE) || block.hasTag(BlockTags.MINEABLE_BY_PICKAXE);
		}
	}

	@Override
	public float getStrVsBlock(ItemStack itemstack, Block<?> block) {
		return !block.hasTag(AetherBlockTags.MINEABLE_BY_AETHER_PICKAXE) && !block.hasTag(BlockTags.MINEABLE_BY_PICKAXE) ? 1.0F : this.material.getEfficiency(false);
	}

	@Override
	public DamageType getDamageType() {
		return DamageType.FIRE;
	}
}
