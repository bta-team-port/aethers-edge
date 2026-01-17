package teamport.aethersedge.item;

import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.world.World;
import teamport.aether.entity.projectile.ProjectileElementFire;
import teamport.aether.helper.ParticleMaker;
import teamport.aether.item.AetherHasCustomDamageType;
import teamport.aether.item.item_tool.ItemToolSwordAether;

public class ItemToolSwordPhoenix extends ItemToolSwordAether implements AetherHasCustomDamageType {
	public ItemToolSwordPhoenix(String name, String namespaceId, int id, ToolMaterial enumtoolmaterial) {
		super(name, namespaceId, id, enumtoolmaterial);
	}

	@Override
	public boolean hitEntity(ItemStack itemstack, Mob target, Mob attacker) {
		boolean hitEntity = super.hitEntity(itemstack, target, attacker);
		if (target instanceof Mob && target.hurtTime == 10 && hitEntity) {
			if (target instanceof Player && ((Player) target).gamemode.isPlayerInvulnerable()) {
				return false;
			} else {
				ParticleMaker.spawnFireSwordParticles(target);
				target.maxFireTicks = 600;
				target.remainingFireTicks = 600;
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public ItemStack onUseItem(ItemStack itemstack, World world, Player entityplayer) {
		if (!world.isClientSide) {
			ProjectileElementFire elementFire = new ProjectileElementFire(world, entityplayer);
			elementFire.setHeading(entityplayer.getLookAngle().x, entityplayer.getLookAngle().y, entityplayer.getLookAngle().z, 1.0F, 0.0F);
			world.playSoundAtEntity(entityplayer, entityplayer, "mob.ghast.fireball", 1.0F, (world.rand.nextFloat() - world.rand.nextFloat()) * 0.2F + 1.0F);
			world.entityJoinedWorld(elementFire);
			itemstack.damageItem(15, entityplayer);
			entityplayer.swingItem();
		}

		return itemstack;
	}

	@Override
	public DamageType getDamageType() {
		return DamageType.FIRE;
	}
}
