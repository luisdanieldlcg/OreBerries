package daniking.oreberries;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NuggetItem extends Item {

    public enum Type {
        IRON,
        GOLD,
        COPPER,
        TIN,
        ALUMINUM,
        ESSENCE
    }

    private final Type type;
    public NuggetItem(Settings settings, Type type) {
        super(settings);
        this.type = type;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        final OBConfig cfg = OBConfig.getInstance();
        switch (this.type) {
            case COPPER -> addTooltip(cfg.copper.tooltip, tooltip);
            case TIN -> addTooltip(cfg.tin.tooltip, tooltip);
            default -> {

            }
        }
    }

    private static void addTooltip(String literal, List<Text> lines) {
        lines.add(Text.literal(literal).formatted(Formatting.GRAY));
    }
    public Type getType() {
        return type;
    }

    public int getColor() {
        final OBConfig cfg = OBConfig.getInstance();
        return switch (this.type) {
            case COPPER -> Integer.decode(cfg.copper.ingotColor);
            case TIN -> Integer.decode(cfg.tin.ingotColor);
            default -> -1;
        };
    }
}
