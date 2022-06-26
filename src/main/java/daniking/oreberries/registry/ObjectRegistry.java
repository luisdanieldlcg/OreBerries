package daniking.oreberries.registry;

import daniking.oreberries.NuggetItem;
import daniking.oreberries.util.OBIdentifier;
import daniking.oreberries.util.ObjectDefinition;
import daniking.oreberries.OreBerries;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.DyeColor;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ObjectRegistry {

    private static final List<ObjectDefinition<Item>> ITEMS = new ArrayList<>();
    private static final List<ObjectDefinition<Block>> BLOCKS = new ArrayList<>();


    public static final Item COPPER_NUGGET = create("copper_nugget", new NuggetItem(getItemSettings(), DyeColor.BROWN));

    private static <T extends Item> T create(String path, T item) {
        ITEMS.add(new ObjectDefinition<>(item, new OBIdentifier(path)));
        return item;
    }

    private static Item.Settings getItemSettings() {
        return new Item.Settings().group(OreBerries.CREATIVE_TAB);
    }

    public static void init() {
        for (ObjectDefinition<Item> entry : ITEMS) {
            Registry.register(Registry.ITEM, entry.id(), entry.object());
        }
        for (ObjectDefinition<Block> entry : BLOCKS) {
            Registry.register(Registry.BLOCK, entry.id(), entry.object());
        }
    }

    public static List<ObjectDefinition<Item>> getItems() {
        return Collections.unmodifiableList(ITEMS);
    }

    public static List<ObjectDefinition<Block>> getBlocks() {
        return Collections.unmodifiableList(BLOCKS);
    }
}
