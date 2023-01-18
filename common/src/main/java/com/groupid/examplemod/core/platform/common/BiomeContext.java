package com.groupid.examplemod.core.platform.common;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public interface BiomeContext {
    boolean is(Biome.BiomeCategory category);

    boolean is(ResourceKey<Biome> biome);
}