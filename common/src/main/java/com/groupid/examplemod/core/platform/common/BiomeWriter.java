package com.groupid.examplemod.core.platform.common;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import java.util.function.BiConsumer;

public abstract class BiomeWriter {
    public void add(BiConsumer<BiomeWriter, BiomeContext> modifier) {
        modifier.accept(this, this.context());
    }

    public abstract ResourceLocation name();

    public abstract BiomeContext context();

    public abstract void feature(GenerationStep.Decoration decoration, ConfiguredFeature<?, ?> feature);

    public abstract void spawn(MobCategory category, MobSpawnSettings.SpawnerData data);

    public abstract void carver(GenerationStep.Carving carving, ConfiguredWorldCarver<?> carver);
}