package daniking.oreberries;

import daniking.oreberries.registry.ObjectRegistry;
import daniking.oreberries.registry.OreBerryBushGenerator;
import daniking.oreberries.util.OBIdentifier;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class OreBerries implements ModInitializer {

    public static final String MODID = "oreberries";
    public static final Logger LOGGER = LoggerFactory.getLogger(OreBerries.class);
    public static final ItemGroup CREATIVE_TAB = FabricItemGroupBuilder.build(new OBIdentifier("creative_tab"), () -> new ItemStack(ObjectRegistry.COPPER_NUGGET));


    @Override
    public void onInitialize() {
        OBConfig.init();
        ObjectRegistry.init();
        OreBerryBushGenerator.init();
        LOGGER.info("OreBerries initialized");
    }
}
