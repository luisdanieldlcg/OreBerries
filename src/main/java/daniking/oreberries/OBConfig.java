package daniking.oreberries;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import me.shedaniel.rei.api.client.config.ConfigManager;


@Config(name = OreBerries.MODID)
public class OBConfig implements ConfigData {

    @ConfigEntry.Category(value = "Copper")
    public CopperEntry copper = new CopperEntry();

    @ConfigEntry.Category(value = "Tin")
    public TinEntry tin = new TinEntry();

    public static class CopperEntry {
        public String oreBerryColor = "#FF8833";
        public String ingotColor = "#FF6600";
        @Comment(value = "The tooltip for Copper OreBerry")
        public String tooltip = "Tastes like metal";
    }

    public static class TinEntry {
        public String oreBerryColor = "#BB4422";
        public String ingotColor = "#FFBA80";
        @Comment(value = "The tooltip for Tin OreBerry")
        public String tooltip = "Tin Man";
    }

    public static void init() {
        AutoConfig.register(OBConfig.class, JanksonConfigSerializer::new);
    }
    public static OBConfig getInstance() {
        return AutoConfig.getConfigHolder(OBConfig.class).getConfig();
    }
}