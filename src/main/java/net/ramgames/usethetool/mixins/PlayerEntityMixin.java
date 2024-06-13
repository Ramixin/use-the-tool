package net.ramgames.usethetool.mixins;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ToolItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @SuppressWarnings("ShadowModifiers")
    @Shadow @Final private PlayerInventory inventory;

    @ModifyReturnValue(method = "getBlockBreakingSpeed", at = @At("RETURN"))
    private float cancelBreakingIfWrongTool(float original, @Local(argsOnly = true) BlockState block) {
        if(this.inventory.getMainHandStack().isEmpty() || !(this.inventory.getMainHandStack().getItem() instanceof ToolItem) ||this.inventory.getMainHandStack().isSuitableFor(block)) return original;
        return 0;
    }
}
