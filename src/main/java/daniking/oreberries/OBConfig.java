package daniking.oreberries;

import daniking.oreberries.registry.ObjectRegistry;
import daniking.oreberries.util.ConfigStateAccess;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import net.minecraft.item.Item;


@Config(name = OreBerries.MODID)
public class OBConfig implements ConfigData {

    @ConfigEntry.Category(value = "Copper")
    public CopperEntry copper = new CopperEntry();

    @ConfigEntry.Category(value = "Tin")
    public TinEntry tin = new TinEntry();

    @ConfigEntry.Category(value = "Aluminum")
    public AluminumEntry aluminum = new AluminumEntry();

    @ConfigEntry.Category(value = "Iron")
    public IronEntry iron = new IronEntry();

    @ConfigEntry.Category(value = "Gold")
    public GoldEntry gold = new GoldEntry();

    @ConfigEntry.Category(value = "Essence")
    public EssenceEntry essence = new EssenceEntry();


    public static class CopperEntry implements ConfigStateAccess {
        public String oreBerryColor = "#FF8833";
        public String ingotColor = "#FF6600";
        @Comment(value = "The tooltip for Copper OreBerry")
        public String tooltip = "Tastes like metal";
        @Comment(value = "Whether the berry bush can grow in the light or not")
        public boolean growsInLight = false;
        @Comment(value = "Max berry drops")
        public int maxDrop = 3;
        @Comment(value = "Min berry drops")
        public int minDrop = 1;
        @Comment(value = "Whether this berry will be generated in the world")
        public boolean generate = true;

        @Override
        public boolean growsInLight() {
            return this.growsInLight;
        }
        @Override
        public int maxDrop() {
            return this.maxDrop;
        }

        @Override
        public Item getBerry() {
            return ObjectRegistry.COPPER_OREBERRY;
        }

        @Override
        public int minDrop() {
            return this.minDrop;
        }

        @Override
        public boolean generate() {
            return this.generate;
        }
    }

    public static class TinEntry implements ConfigStateAccess {
        public String oreBerryColor = "#BB4422";
        public String ingotColor = "#FFBA80";
        @Comment(value = "The tooltip for Tin OreBerry")
        public String tooltip = "Tin Man";
        @Comment(value = "Whether the berry bush can grow in the light or not")
        public boolean growsInLight = false;
        @Comment(value = "Max berry drops")
        public int maxDrop = 3;
        @Comment(value = "Min berry drops")
        public int minDrop = 1;

        @Comment(value = "Whether this berry will be generated in the world")
        public boolean generate = true;

        @Override
        public boolean growsInLight() {
            return this.growsInLight;
        }
        @Override
        public int maxDrop() {
            return this.maxDrop;
        }

        @Override
        public Item getBerry() {
            return ObjectRegistry.TIN_OREBERRY;
        }

        @Override
        public int minDrop() {
            return this.minDrop;
        }


        @Override
        public boolean generate() {
            return this.generate;
        }
    }

    public static class AluminumEntry implements ConfigStateAccess {
        public String oreBerryColor = "#EEFFFF";
        public String ingotColor = "#EEFFFF";
        @Comment(value = "The tooltip for Aluminum OreBerry")
        public String tooltip = "White Chocolate";
        @Comment(value = "Whether the berry bush can grow in the light or not")
        public boolean growsInLight = false;
        @Comment(value = "Max berry drops")
        public int maxDrop = 3;
        @Comment(value = "Min berry drops")
        public int minDrop = 1;

        @Comment(value = "Whether this berry will be generated in the world")
        public boolean generate = true;


        @Override
        public boolean growsInLight() {
            return this.growsInLight;
        }
        @Override
        public int maxDrop() {
            return this.maxDrop;
        }

        @Override
        public Item getBerry() {
            return ObjectRegistry.ALUMINUM_OREBERRY;
        }

        @Override
        public int minDrop() {
            return this.minDrop;
        }

        @Override
        public boolean generate() {
            return this.generate;
        }
    }

    public static class IronEntry implements ConfigStateAccess {
        public String oreBerryColor = "#FFC7A3";
        @Comment(value = "The tooltip for Iron OreBerry")
        public String tooltip = "Sweet Irony";
        @Comment(value = "Whether the berry bush can grow in the light or not")
        public boolean growsInLight = false;
        @Comment(value = "Max berry drops")
        public int maxDrop = 3;
        @Comment(value = "Min berry drops")
        public int minDrop = 1;

        @Comment(value = "Whether this berry will be generated in the world")
        public boolean generate = true;

        @Override
        public boolean growsInLight() {
            return this.growsInLight;
        }
        @Override
        public int maxDrop() {
            return this.maxDrop;
        }

        @Override
        public Item getBerry() {
            return ObjectRegistry.IRON_OREBERRY;
        }

        @Override
        public int minDrop() {
            return this.minDrop;
        }

        @Override
        public boolean generate() {
            return this.generate;
        }
    }

    public static class GoldEntry implements ConfigStateAccess {
        public String oreBerryColor = "#FFCC33";
        @Comment(value = "The tooltip for Gold OreBerry")
        public String tooltip = "Pure Luster";
        @Comment(value = "Whether the berry bush can grow in the light or not")
        public boolean growsInLight = false;
        @Comment(value = "Max berry drops")
        public int maxDrop = 3;
        @Comment(value = "Min berry drops")
        public int minDrop = 1;

        @Comment(value = "Whether this berry will be generated in the world")
        public boolean generate = true;

        @Override
        public boolean growsInLight() {
            return this.growsInLight;
        }
        @Override
        public int maxDrop() {
            return this.maxDrop;
        }
        @Override
        public int minDrop() {
            return this.minDrop;
        }
        @Override
        public Item getBerry() {
            return ObjectRegistry.GOLD_OREBERRY;
        }

        @Override
        public boolean generate() {
            return this.generate;
        }
    }

    public static class EssenceEntry implements ConfigStateAccess {
        public String tooltip = "Tastes like Creeper";
        @Comment(value = "Whether the berry bush can grow in the light or not")
        public boolean growsInLight = true;
        @Comment(value = "Max berry drops")
        public int maxDrop = 3;
        @Comment(value = "Min berry drops")
        public int minDrop = 1;

        @Comment(value = "Whether this berry will be generated in the world")
        public boolean generate = true;

        @Override
        public boolean growsInLight() {
            return this.growsInLight;
        }
        @Override
        public int maxDrop() {
            return this.maxDrop;
        }
        @Override
        public int minDrop() {
            return this.minDrop;
        }
        @Override
        public Item getBerry() {
            return ObjectRegistry.ESSENCE_BERRY;
        }
        @Override
        public boolean generate() {
            return this.generate;
        }
    }

    public static void init() {
        AutoConfig.register(OBConfig.class, JanksonConfigSerializer::new);
    }
    public static OBConfig getInstance() {
        return AutoConfig.getConfigHolder(OBConfig.class).getConfig();
    }
}