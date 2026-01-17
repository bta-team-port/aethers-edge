package teamport.aethersedge.item;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import teamport.aether.helper.ParticleMaker;
import teamport.aether.item.AetherHasCustomDamageType;
import teamport.aether.item.AetherItems;
import teamport.aether.item.item_tool.ItemToolPickaxeAether;
import turniplabs.halplibe.helper.EnvironmentHelper;

public class ItemToolPickaxePhoenix extends ItemToolPickaxeAether implements AetherHasCustomDamageType {
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
	public boolean onBlockDestroyed(World world, ItemStack itemstack, int i, int x, int y, int z, Side side, Mob mob) {
		Block<?> block = Blocks.blocksList[i];
		if (block != null) {
			if (block.getHardness() > 0.0F || this.isSilkTouch()) {
				itemstack.damageItem(1, mob);
			}

			if (!EnvironmentHelper.isClientWorld()) {
				world.dropItem(x, y, z, new ItemStack(AetherItems.AMBROSIUM, 1));
			}
		}

		return true;
	}

	@Override
	public DamageType getDamageType() {
		return DamageType.FIRE;
	}
}
