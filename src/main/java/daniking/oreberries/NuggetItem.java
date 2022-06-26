package daniking.oreberries;

import net.minecraft.item.Item;
import net.minecraft.util.DyeColor;

public class NuggetItem extends Item {

    private final DyeColor color;
    public NuggetItem(Settings settings, DyeColor color) {
        super(settings);
        this.color = color;
    }

    public DyeColor getColor() {
        return color;
    }
}
