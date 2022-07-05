package daniking.oreberries.item;

import daniking.oreberries.util.OreBerryColorProvider;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OreBerryItem extends Item implements OreBerryColorProvider {

    protected final String tooltip;
    protected final int color;
    public OreBerryItem(Settings settings, String color, String tooltip) {
        super(settings);
        this.tooltip = tooltip;
        this.color = Integer.decode(color);
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (tooltip != null) tooltip.add(Text.literal(this.tooltip).formatted(Formatting.GRAY));
    }

    @Override
    public int getColor() {
        return color;
    }
}
