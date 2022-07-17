package daniking.oreberries.registry;

import daniking.oreberries.block.OreBerryBushBlock;
import daniking.oreberries.util.OBHelper;
import daniking.oreberries.util.OBIdentifier;
import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.block.Block;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class OreBerryBushGenerator {

    // Configured Features
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> IRON_OREBERRY_BUSH = ConfiguredFeatures.register(OBIdentifier.id("iron_oreberry_bush"), Feature.ORE, getBerryBushConfig(ObjectRegistry.IRON_OREBERRY_BUSH, 12));

    // Placed Features
    public static final RegistryEntry<PlacedFeature> IRON_OREBERRY_BUSH_UPPER = PlacedFeatures.register(OBIdentifier.id("iron_oreberry_upper"), IRON_OREBERRY_BUSH, modifiersWithCount(4, HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(32))));
    private static OreFeatureConfig getBerryBushConfig(Block bush, int size) {
        if (!(bush instanceof OreBerryBushBlock)) {
            throw new IllegalArgumentException("Block was not an OreBerryBushBlock");
        } else {
            return new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, bush.getDefaultState().with(OreBerryBushBlock.AGE, OreBerryBushBlock.MAX_AGE))), size);
        }
    }
    public static void init() {
        BiomeModification worldGen = BiomeModifications.create(new OBIdentifier("world_features"));
        if (canGenerate(OBHelper.OreBerryType.IRON)) {
            worldGen.add(ModificationPhase.ADDITIONS, BiomeSelectors.foundInOverworld(), ctx -> ctx.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.UNDERGROUND_ORES, IRON_OREBERRY_BUSH_UPPER.value()));
        }
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
    

    private static boolean canGenerate(OBHelper.OreBerryType type) {
        return OBHelper.getConfigAccessFor(type).generate();
    }
}
