package xyz.amymialee.stayexperienced;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.NotNull;
import xyz.amymialee.mialib.templates.MDataGen;

public class StayExperiencedDataGen extends MDataGen {
    @Override
    protected void generateTranslations(MLanguageProvider provider, RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.@NotNull TranslationBuilder builder) {
        builder.add(StayExperienced.EXPERIENCE_RETAINED.getTranslationKey(), "Experience Retained");
        builder.add(StayExperienced.EXPERIENCE_RETAINED.getDescriptionTranslationKey(), "The amount of experience retained after death");
    }
}