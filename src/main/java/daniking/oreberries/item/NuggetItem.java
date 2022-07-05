package daniking.oreberries.item;

import daniking.oreberries.OBConfig;
import daniking.oreberries.util.OreBerryColorProvider;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
