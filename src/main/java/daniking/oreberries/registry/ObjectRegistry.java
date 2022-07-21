package daniking.oreberries.registry;

import daniking.oreberries.OBConfig;
import daniking.oreberries.block.OreBerryBushBlock;
import daniking.oreberries.item.EssenceOreBerryItem;
import daniking.oreberries.item.NuggetItem;
import daniking.oreberries.item.OreBerryBushBlockItem;
import daniking.oreberries.item.OreBerryItem;
import daniking.oreberries.util.OBHelper;
import daniking.oreberries.util.OBIdentifier;
import daniking.oreberries.util.ObjectDefinition;
import daniking.oreberries.OreBerries;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ObjectRegistry {

    private static final List<ObjectDefinition<Block>> BLOCKS = new ArrayList<>();
    private static final List<ObjectDefinition<Item>> ITEMS = new ArrayList<>();
    private static final OBConfig CONFIG_FILE = OBConfig.getInstance();

    // Nuggets
    public static final Item COPPER_NUGGET = create("copper_nugget", new NuggetItem(getItemSettings(), CONFIG_FILE.copper.nuggetColor));
    public static final Item TIN_NUGGET = create("tin_nugget", new NuggetItem(getItemSettings(), CONFIG_FILE.tin.nuggetColor));
    public static final Item ALUMINUM_NUGGET = create("aluminum_nugget", new NuggetItem(getItemSettings(), CONFIG_FILE.aluminum.nuggetColor));

    // OreBerries
    public static final Block IRON_OREBERRY_BUSH = create("iron_oreberry_bush", new OreBerryBushBlock(getBushBlockSettings(), OBHelper.OreBerryType.IRON));
    public static final Item IRON_OREBERRY = create("iron_oreberry", new OreBerryItem(getItemSettings(), CONFIG_FILE.iron.oreBerryColor, CONFIG_FILE.iron.tooltip));
    public static final Block GOLD_OREBERRY_BUSH = create("gold_oreberry_bush", new OreBerryBushBlock(getBushBlockSettings(), OBHelper.OreBerryType.GOLD));
    public static final Item GOLD_OREBERRY = create("gold_oreberry", new OreBerryItem(getItemSettings(), CONFIG_FILE.gold.oreBerryColor, CONFIG_FILE.gold.tooltip));
    public static final Block COPPER_OREBERRY_BUSH = create("copper_oreberry_bush", new OreBerryBushBlock(getBushBlockSettings(), OBHelper.OreBerryType.COPPER));
    public static final Item COPPER_OREBERRY = create("copper_oreberry", new OreBerryItem(getItemSettings(), CONFIG_FILE.copper.oreBerryColor, CONFIG_FILE.copper.tooltip));
    public static final Block TIN_OREBERRY_BUSH = create("tin_oreberry_bush", new OreBerryBushBlock(getBushBlockSettings(),  OBHelper.OreBerryType.TIN));
    public static final Item TIN_OREBERRY = create("tin_oreberry", new OreBerryItem(getItemSettings(), CONFIG_FILE.tin.oreBerryColor, CONFIG_FILE.tin.tooltip));
    public static final Block ALUMINUM_OREBERRY_BUSH = create("aluminum_oreberry_bush", new OreBerryBushBlock(getBushBlockSettings(), OBHelper.OreBerryType.ALUMINUM));
    public static final Item ALUMINUM_OREBERRY = create("aluminum_oreberry", new OreBerryItem(getItemSettings(), CONFIG_FILE.aluminum.oreBerryColor, CONFIG_FILE.aluminum.tooltip));
    public static final Block ESSENCE_BERRY_BUSH = create("essence_berry_bush", new OreBerryBushBlock(getBushBlockSettings(), OBHelper.OreBerryType.ESSENCE));
    public static final Item ESSENCE_BERRY = create("essence_berry", new EssenceOreBerryItem(getItemSettings(), "-1", CONFIG_FILE.essence.tooltip));


    private static <T extends Block> T create(String path, T block) {
        final Identifier id = new OBIdentifier(path);
        BLOCKS.add(new ObjectDefinition<>(block, id));
        ITEMS.add(new ObjectDefinition<>(new OreBerryBushBlockItem(block, getItemSettings()), id));
        return block;
    }

    private static <T extends Item> T create(String path, T item) {
        ITEMS.add(new ObjectDefinition<>(item, new OBIdentifier(path)));
        return item;
    }
    private static AbstractBlock.Settings getBushBlockSettings() {
        return FabricBlockSettings.of(Material.LEAVES).ticksRandomly().hardness(0.3F).sounds(BlockSoundGroup.METAL).nonOpaque();
    }
    private static Item.Settings getItemSettings() {
        return new Item.Settings().group(OreBerries.CREATIVE_TAB);
    }

    public static void init() {
        for (ObjectDefinition<Block> entry : BLOCKS) {
            Registry.register(Registry.BLOCK, entry.id(), entry.object());
        }
        for (ObjectDefinition<Item> entry : ITEMS) {
            Registry.register(Registry.ITEM, entry.id(), entry.object());
        }
    }

    public static List<ObjectDefinition<Item>> getItems() {
        return Collections.unmodifiableList(ITEMS);
    }

    public static List<ObjectDefinition<Block>> getBlocks() {
        return Collections.unmodifiableList(BLOCKS);
    }
}
