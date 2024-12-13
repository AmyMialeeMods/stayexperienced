package xyz.amymialee.stayexperienced;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import xyz.amymialee.mialib.mvalues.MValue;

public class StayExperienced implements ModInitializer {
    public static final String MOD_ID = "stayexperienced";

    public static final MValue<Double> EXPERIENCE_RETAINED = MValue.of(id("experience_retained"), MValue.PERCENT).item(Items.EXPERIENCE_BOTTLE).build();

    @Override
    public void onInitialize() {}

    public static @NotNull Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}