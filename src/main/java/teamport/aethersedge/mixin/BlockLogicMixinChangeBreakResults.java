package teamport.aethersedge.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import teamport.aethersedge.item.AdjustBlockDropped;

@Mixin(value = BlockLogic.class, remap = false)
public class BlockLogicMixinChangeBreakResults {


	@WrapOperation(method = "dropBlockWithCause", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/block/BlockLogic;getBreakResult(Lnet/minecraft/core/world/World;Lnet/minecraft/core/enums/EnumDropCause;IIIILnet/minecraft/core/block/entity/TileEntity;)[Lnet/minecraft/core/item/ItemStack;"))
	public ItemStack[] adjustResults(
		BlockLogic instance, World world, EnumDropCause dropCause,
		int x, int y, int z, int meta,
		TileEntity tileEntity, Operation<ItemStack[]> original,
		@Local(argsOnly = true) Player player
	) {
		ItemStack[] drops = original.call(instance, world, dropCause, x, y, z, meta, tileEntity);
		if(player == null) {
			return drops;
		}
		ItemStack heldItem = player.getHeldItem();
		if(heldItem != null && heldItem.getItem() instanceof AdjustBlockDropped){
			Item item = heldItem.getItem();
			return ((AdjustBlockDropped)item).adjustBreakingResults(world, dropCause, x, y, z, meta, tileEntity, player, drops);
		}else{
			return drops;
		}
	}

}
