package daniking.oreberries.item;

import daniking.oreberries.util.OreBerryColorProvider;
import net.minecraft.item.Item;


public class NuggetItem extends Item implements OreBerryColorProvider {
    private final int color;
    public NuggetItem(Settings settings, String color) {
        super(settings);
        this.color = Integer.decode(color);
    }

    @Override
    public int getColor() {
        return color;
    }
}
