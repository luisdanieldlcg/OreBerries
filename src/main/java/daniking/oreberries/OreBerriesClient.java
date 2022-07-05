package daniking.oreberries;

import daniking.oreberries.registry.ObjectRegistry;
import daniking.oreberries.util.ObjectDefinition;
import daniking.oreberries.util.OreBerryColorProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;

import java.util.List;

@Environment(EnvType.CLIENT)
public class OreBerriesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        final Block[] blocks = ObjectDefinition.toObjectList(ObjectRegistry.getBlocks()).toArray(new Block[0]);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutoutMipped(), blocks);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> (((OreBerryColorProvider) state.getBlock()).getColor()), blocks);
        final Item[] items = ObjectDefinition.toObjectList(ObjectRegistry.getItems(), item -> item.equals(ObjectRegistry.ESSENCE_BERRY)).toArray(new Item[0]);
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> (((OreBerryColorProvider) stack.getItem()).getColor()), items);
    }
}