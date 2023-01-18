package com.groupid.examplemod.core.platform.client;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;
import java.util.function.Supplier;

public class RenderRegistry {
    @ExpectPlatform
    public static void block(RenderType type, Block... blocks) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends Entity> void entity(EntityType<? extends T> type, Function<EntityRenderDispatcher, EntityRenderer<T>> factory) {
        throw new AssertionError();
    }

    @SafeVarargs @ExpectPlatform
    public static void itemColor(ItemColor color, Supplier<? extends ItemLike>... items) {
        throw new AssertionError();
    }

    @SafeVarargs @ExpectPlatform
    public static void blockColor(BlockColor color, Supplier<? extends Block>... blocks) {
        throw new AssertionError();
    }
}