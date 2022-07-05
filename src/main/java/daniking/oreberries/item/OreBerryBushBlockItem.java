package daniking.oreberries.item;

import daniking.oreberries.util.OreBerryColorProvider;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class OreBerryBushBlockItem extends BlockItem implements OreBerryColorProvider {

    public OreBerryBushBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public int getColor() {
        return ((OreBerryColorProvider) getBlock()).getColor();
    }
}
