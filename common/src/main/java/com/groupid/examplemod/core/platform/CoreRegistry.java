package com.groupid.examplemod.core.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public abstract class CoreRegistry<T> {
    protected final Registry<T> registry;
    protected final String modId;
    protected boolean isPresent;

    protected CoreRegistry(Registry<T> registry, String modId) {
        this.registry = registry;
        this.modId = modId;
        this.isPresent = false;
    }

    @ExpectPlatform
    public static <T> CoreRegistry<T> create(Registry<T> registry, String modId) {
        throw new AssertionError();
    }

    public abstract <E extends T> E register(String key, E entry);

    public void register() {
        if (this.isPresent) throw new IllegalArgumentException("Duplication of Registry: " + this.registry);
        this.isPresent = true;
        this.bootstrap();
    }

    protected abstract void bootstrap();

    public static class SimpleRegistry<T> extends CoreRegistry<T> {
        public SimpleRegistry(Registry<T> registry, String modId) {
            super(registry, modId);
        }

        @Override
        public <E extends T> E register(String key, E entry) {
            Registry.register(this.registry, new ResourceLocation(this.modId, key), entry);
            return entry;
        }

        @Override
        protected void bootstrap() {}
    }
}