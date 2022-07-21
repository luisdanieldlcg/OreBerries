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
        public String nuggetColor = "#FF6600";
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

        @Comment(value = "Max ore berry vein size chance. Defaults to 12.")
        public int veinSize = 12;

        @Comment(value = "Number of veins per chunk. Defaults to 6")
        public int rarity = 6;

        @Comment(value = "The lowest height where bushes will generate at. Defaults to 20.")
        public int minHeight = 20;

        @Comment(value = "The lowest height where bushes will generate at. Defaults to 64.")
        public int maxHeight = 60;

        @Override
        public String getOreBerryColor() {
            return oreBerryColor;
        }

        @Override
        public String getNuggetColor() {
            return nuggetColor;
        }

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

        @Override
        public int veinSize() {
            return veinSize;
        }

        @Override
        public int rarity() {
            return rarity;
        }

        @Override
        public int minHeight() {
            return minHeight;
        }
        @Override
        public int maxHeight() {
            return maxHeight;
        }
    }

    public static class TinEntry implements ConfigStateAccess {
        public String oreBerryColor = "#BB4422";
        public String nuggetColor = "#FFBA80";
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

        @Comment(value = "Max ore berry vein size chance")
        public int veinSize = 12;

        @Comment(value = "Number of veins per chunk. Defaults to 6")
        public int rarity = 6;

        @Comment(value = "The lowest height where bushes will generate at. Defaults to -16.")
        public int minHeight = -16;

        @Comment(value = "The lowest height where bushes will generate at. Defaults to 40.")
        public int maxHeight = 40;

        @Override
        public String getOreBerryColor() {
            return oreBerryColor;
        }

        @Override
        public String getNuggetColor() {
            return nuggetColor;
        }
        @Override
        public boolean growsInLight() {
            return this.growsInLight;
        }
        @Override
        public int maxDrop() {
            return this.maxDrop;
        }

        @Override
        public int rarity() {
            return rarity;
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

        @Override
        public int veinSize() {
            return veinSize;
        }
        @Override
        public int minHeight() {
            return minHeight;
        }
        @Override
        public int maxHeight() {
            return maxHeight;
        }
    }

    public static class AluminumEntry implements ConfigStateAccess {
        public String oreBerryColor = "#EEFFFF";
        public String nuggetColor = "#EEFFFF";
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

        @Comment(value = "Max ore berry vein size chance")
        public int veinSize = 14;

        @Comment(value = "Number of veins per chunk. Defaults to 6")
        public int rarity = 6;


        @Comment(value = "The lowest height where bushes will generate at. Defaults to -16.")
        public int minHeight = -16;

        @Comment(value = "The lowest height where bushes will generate at. Defaults to 60.")
        public int maxHeight = 60;

        @Override
        public String getOreBerryColor() {
            return oreBerryColor;
        }

        @Override
        public String getNuggetColor() {
            return nuggetColor;
        }
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
        @Override
        public int veinSize() {
            return veinSize;
        }
        @Override
        public int rarity() {
            return rarity;
        }
        @Override
        public int minHeight() {
            return minHeight;
        }
        @Override
        public int maxHeight() {
            return maxHeight;
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

        @Comment(value = "Max ore berry vein size chance")
        public int veinSize = 12;

        @Comment(value = "Number of veins per chunk. Defaults to 6")
        public int rarity = 6;

        @Comment(value = "The lowest height where bushes will generate at. Defaults to -16.")
        public int minHeight = -16;

        @Comment(value = "The lowest height where bushes will generate at. Defaults to sea level (64 in standard worlds).")
        public int maxHeight = 64;

        @Override
        public String getOreBerryColor() {
            return oreBerryColor;
        }
        @Override
        public String getNuggetColor() {
            return null;
        }
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
        @Override
        public int veinSize() {
            return veinSize;
        }
        @Override
        public int rarity() {
            return rarity;
        }
        @Override
        public int minHeight() {
            return minHeight;
        }
        @Override
        public int maxHeight() {
            return maxHeight;
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

        @Comment(value = "Max ore berry vein size chance")
        public int veinSize = 6;

        @Comment(value = "Number of veins per chunk. Defaults to 6")
        public int rarity = 6;

        @Comment(value = "The lowest height where bushes will generate at. Defaults to -16.")
        public int minHeight = -16;

        @Comment(value = "The lowest height where bushes will generate at. Defaults to 32.")
        public int maxHeight = 32;

        @Override
        public String getOreBerryColor() {
            return oreBerryColor;
        }
        @Override
        public String getNuggetColor() {
            return null;
        }
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
        @Override
        public int veinSize() {
            return veinSize;
        }
        @Override
        public int rarity() {
            return rarity;
        }
        @Override
        public int minHeight() {
            return minHeight;
        }
        @Override
        public int maxHeight() {
            return maxHeight;
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

        @Comment(value = "Max ore berry vein size chance")
        public int veinSize = 8;

        @Comment(value = "Number of veins per chunk. Defaults to 6")
        public int rarity = 6;

        @Comment(value = "The lowest height where bushes will generate at. Defaults to -16.")
        public int minHeight = -16;

        @Comment(value = "The lowest height where bushes will generate at. Defaults 32.")
        public int maxHeight = 32;

        @Override
        public String getOreBerryColor() {
            return null;
        }
        @Override
        public String getNuggetColor() {
            return null;
        }
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
        @Override
        public int veinSize() {
            return veinSize;
        }
        @Override
        public int rarity() {
            return rarity;
        }
        @Override
        public int minHeight() {
            return minHeight;
        }
        @Override
        public int maxHeight() {
            return maxHeight;
        }
    }

    public static void init() {
        AutoConfig.register(OBConfig.class, JanksonConfigSerializer::new);
    }
    public static OBConfig getInstance() {
        return AutoConfig.getConfigHolder(OBConfig.class).getConfig();
    }
}