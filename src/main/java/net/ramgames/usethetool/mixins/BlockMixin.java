package net.ramgames.usethetool.mixins;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(AbstractBlock.class)
public class BlockMixin {

    @ModifyConstant(method = "calcBlockBreakingDelta", constant = @Constant(intValue = 100))
    private int disruptDefaultBreak(int constant) {
        return Integer.MAX_VALUE;
    }

}
