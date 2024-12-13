package xyz.amymialee.stayexperienced.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.GameRules;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import xyz.amymialee.stayexperienced.StayExperienced;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Shadow public abstract boolean isSpectator();
    @Shadow public int totalExperience;
    @Shadow public int experienceLevel;

    @WrapMethod(method = "getExperienceToDrop")
    protected int getExperienceToDrop(@NotNull ServerWorld world, Operation<Integer> original) {
        if (world.getGameRules().getBoolean(GameRules.KEEP_INVENTORY) || this.isSpectator()) return 0;
        var total = this.totalExperience;
        if (this.experienceLevel <= 16) {
            total += this.experienceLevel * this.experienceLevel + 6 * this.experienceLevel;
        } else if (this.experienceLevel <= 31) {
            total += (int) (2.5 * this.experienceLevel * this.experienceLevel - 40.5 * this.experienceLevel + 360);
        } else {
            total += (int) (4.5 * this.experienceLevel * this.experienceLevel - 162.5 * this.experienceLevel + 2220);
        }
        var droppable = total * StayExperienced.EXPERIENCE_RETAINED.get();
        return (int) droppable;
    }
}