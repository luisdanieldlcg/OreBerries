package daniking.oreberries;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.util.DyeColor;
import static daniking.oreberries.registry.ObjectRegistry.*;

@Environment(EnvType.CLIENT)
public class OreBerriesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> (((NuggetItem) stack.getItem()).getColor()),  COPPER_NUGGET, TIN_NUGGET);
    }
}
