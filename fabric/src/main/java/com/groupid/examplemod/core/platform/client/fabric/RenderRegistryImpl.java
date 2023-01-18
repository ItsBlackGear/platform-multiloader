package com.groupid.examplemod.core.platform.client.fabric;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

public class RenderRegistryImpl {
    public static void block(RenderType type, Block... blocks) {
        BlockRenderLayerMap.INSTANCE.putBlocks(type, blocks);
    }

    public static <T extends Entity> void entity(EntityType<? extends T> type, Function<EntityRenderDispatcher, EntityRenderer<T>> factory) {
        EntityRendererRegistry.INSTANCE.register(type, (manager, context) -> factory.apply(manager));
    }

    @SafeVarargs
    public static void itemColor(ItemColor color, Supplier<? extends ItemLike>... items) {
        Arrays.stream(items).forEach(item -> ColorProviderRegistry.ITEM.register(color, item.get()));
    }

    @SafeVarargs
    public static void blockColor(BlockColor color, Supplier<? extends Block>... blocks) {
        Arrays.stream(blocks).forEach(block -> ColorProviderRegistry.BLOCK.register(color, block.get()));
    }
}