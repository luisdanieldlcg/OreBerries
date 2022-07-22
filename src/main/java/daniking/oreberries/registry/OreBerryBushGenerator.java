package daniking.oreberries.registry;

import daniking.oreberries.block.OreBerryBushBlock;
import daniking.oreberries.util.ConfigStateAccess;
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
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> IRON_OREBERRY_BUSH = ConfiguredFeatures.register(OBIdentifier.id("iron_oreberry_bush"), Feature.ORE, getBerryBushConfig(ObjectRegistry.IRON_OREBERRY_BUSH));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> GOLD_OREBERRY_BUSH = ConfiguredFeatures.register(OBIdentifier.id("gold_oreberry_bush"), Feature.ORE, getBerryBushConfig(ObjectRegistry.GOLD_OREBERRY_BUSH));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> COPPER_OREBERRY_BUSH = ConfiguredFeatures.register(OBIdentifier.id("copper_oreberry_bush"), Feature.ORE, getBerryBushConfig(ObjectRegistry.GOLD_OREBERRY_BUSH));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> TIN_OREBERRY_BUSH = ConfiguredFeatures.register(OBIdentifier.id("tin_oreberry_bush"), Feature.ORE, getBerryBushConfig(ObjectRegistry.TIN_OREBERRY_BUSH));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ALUMINUM_OREBERRY_BUSH = ConfiguredFeatures.register(OBIdentifier.id("aluminum_oreberry_bush"), Feature.ORE, getBerryBushConfig(ObjectRegistry.ALUMINUM_OREBERRY_BUSH));
    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ESSENCE_OREBERRY_BUSH = ConfiguredFeatures.register(OBIdentifier.id("essence_oreberry_bush"), Feature.ORE, getBerryBushConfig(ObjectRegistry.ESSENCE_BERRY_BUSH));
    // Placed Features
    public static final RegistryEntry<PlacedFeature> IRON_OREBERRY_BUS_UPPER = PlacedFeatures.register(OBIdentifier.id("iron_oreberry_upper"), IRON_OREBERRY_BUSH, oreBerryModifiers(OBHelper.OreBerryType.IRON));
    public static final RegistryEntry<PlacedFeature> GOLD_OREBERRY_BUSH_UPPER = PlacedFeatures.register(OBIdentifier.id("gold_oreberry_upper"), GOLD_OREBERRY_BUSH, oreBerryModifiers(OBHelper.OreBerryType.GOLD));
    public static final RegistryEntry<PlacedFeature> COPPER_OREBERRY_BUSH_UPPER = PlacedFeatures.register(OBIdentifier.id("copper_oreberry_upper"), COPPER_OREBERRY_BUSH, oreBerryModifiers(OBHelper.OreBerryType.COPPER));
    public static final RegistryEntry<PlacedFeature> TIN_OREBERRY_BUSH_UPPER = PlacedFeatures.register(OBIdentifier.id("tin_oreberry_upper"), TIN_OREBERRY_BUSH, oreBerryModifiers(OBHelper.OreBerryType.TIN));
    public static final RegistryEntry<PlacedFeature> ALUMINUM_OREBERRY_BUSH_UPPER = PlacedFeatures.register(OBIdentifier.id("aluminum_oreberry_upper"), ALUMINUM_OREBERRY_BUSH, oreBerryModifiers(OBHelper.OreBerryType.ALUMINUM));
    public static final RegistryEntry<PlacedFeature> ESSENCE_OREBERRY_BUSH_UPPER = PlacedFeatures.register(OBIdentifier.id("essence_oreberry_upper"), ESSENCE_OREBERRY_BUSH, oreBerryModifiers(OBHelper.OreBerryType.ESSENCE));

    private static OreFeatureConfig getBerryBushConfig(Block bush) {
        if (!(bush instanceof OreBerryBushBlock oreBerry)) {
            throw new IllegalArgumentException("Block was not an OreBerryBushBlock");
        } else {
            return new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, bush.getDefaultState().with(OreBerryBushBlock.AGE, OreBerryBushBlock.MAX_AGE))), OBHelper.getConfigAccessFor(oreBerry.getType()).veinSize());
        }
    }
    public static void init() {
        final BiomeModification worldGen = BiomeModifications.create(new OBIdentifier("world_features"));
        if (canGenerate(OBHelper.OreBerryType.IRON)) {
            worldGen.add(ModificationPhase.ADDITIONS, BiomeSelectors.foundInOverworld(), ctx -> ctx.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.UNDERGROUND_ORES, IRON_OREBERRY_BUS_UPPER.value()));
        }
        if (canGenerate(OBHelper.OreBerryType.GOLD)) {
            worldGen.add(ModificationPhase.ADDITIONS, BiomeSelectors.foundInOverworld(), ctx -> ctx.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.UNDERGROUND_ORES, GOLD_OREBERRY_BUSH_UPPER.value()));
        }
        if (canGenerate(OBHelper.OreBerryType.COPPER)) {
            worldGen.add(ModificationPhase.ADDITIONS, BiomeSelectors.foundInOverworld(), ctx -> ctx.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.UNDERGROUND_ORES, COPPER_OREBERRY_BUSH_UPPER.value()));
        }
        if (canGenerate(OBHelper.OreBerryType.TIN)) {
            worldGen.add(ModificationPhase.ADDITIONS, BiomeSelectors.foundInOverworld(), ctx -> ctx.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.UNDERGROUND_ORES, TIN_OREBERRY_BUSH_UPPER.value()));
        }
        if (canGenerate(OBHelper.OreBerryType.TIN)) {
            worldGen.add(ModificationPhase.ADDITIONS, BiomeSelectors.foundInOverworld(), ctx -> ctx.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.UNDERGROUND_ORES, ALUMINUM_OREBERRY_BUSH_UPPER.value()));
        }
        if (canGenerate(OBHelper.OreBerryType.ESSENCE)) {
            worldGen.add(ModificationPhase.ADDITIONS, BiomeSelectors.foundInOverworld(), ctx -> ctx.getGenerationSettings().addBuiltInFeature(GenerationStep.Feature.UNDERGROUND_ORES, ESSENCE_OREBERRY_BUSH_UPPER.value()));
        }
    }
    
    private static HeightRangePlacementModifier getOreBerryHeight(OBHelper.OreBerryType type) {
        final ConfigStateAccess state = OBHelper.getConfigAccessFor(type);
        return HeightRangePlacementModifier.uniform(YOffset.fixed(state.minHeight()), YOffset.aboveBottom(state.maxHeight() - 1));
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> oreBerryModifiers(OBHelper.OreBerryType type) {
        return modifiers(CountPlacementModifier.of(OBHelper.getConfigAccessFor(type).rarity()), getOreBerryHeight(type));
    }
    

    private static boolean canGenerate(OBHelper.OreBerryType type) {
        return OBHelper.getConfigAccessFor(type).generate();
    }
}
