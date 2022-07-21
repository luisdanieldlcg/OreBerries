package daniking.oreberries.util;


import net.minecraft.item.Item;

/**
 * Provides access to the state of the {@link daniking.oreberries.OBConfig} in a convenient way.
 */
public interface ConfigStateAccess {


    /**
     * @return OreBerry hex color
     */
    String getOreBerryColor();
    /**
     * @return Nugget hex color
     */
    String getNuggetColor();
    /**
     * @return Whether the berry bush can or not grow in light.
     */
    boolean growsInLight();

    /**
     * @return Min berry drop count.
     */
    int minDrop();

    /**
     * @return Max berry drop count.
     */
    int maxDrop();

    /**
     * @return The berry item this bush will drop.
     */
    Item getBerry();

    /**
     * @return  Whether the berry will be generated in the world.
     */
    boolean generate();

    /**
     * @return Ore berry vein size
     */
    int veinSize();

    /**
     * @return Numbers of veins per chunk
     */
    int rarity();

    /**
     * @return The lowest height that these oreberry bushes will generate at. Defaults to 0.
     */
    int minHeight();

    /**
     * @return The highest height that these oreberry bushes will generate at.
     */
    int maxHeight();
}
