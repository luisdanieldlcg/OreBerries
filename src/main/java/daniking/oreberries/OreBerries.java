package daniking.oreberries;

import daniking.oreberries.registry.ObjectRegistry;
import daniking.oreberries.util.OBIdentifier;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.autoconfig.example.ExampleConfig;
import me.shedaniel.autoconfig.serializer.DummyConfigSerializer;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.autoconfig.serializer.PartitioningSerializer;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class OreBerries implements ModInitializer {

    public static final String MODID = "oreberries";
    public static final String VERSION = "1.19.1+1.0.0";
    public static final Logger LOGGER = LoggerFactory.getLogger(OreBerries.class);
    public static final ItemGroup CREATIVE_TAB = FabricItemGroupBuilder.build(new OBIdentifier("creative_tab"), () -> new ItemStack(Items.WOODEN_SWORD));
    public static OBConfig config;

    @Override
    public void onInitialize() {
        final ConfigHolder<OBConfig> holder = AutoConfig.register(OBConfig.class, JanksonConfigSerializer::new);
        config = holder.getConfig();
        ObjectRegistry.init();
        LOGGER.info("OreBerries initialized");
    }
}
