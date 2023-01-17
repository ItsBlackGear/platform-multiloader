package com.blackgear.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class Environment {
    @ExpectPlatform
    public static CreativeModeTab createTab(ResourceLocation location, Supplier<ItemStack> icon) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isClientSide() {
        throw new AssertionError();
    }
}