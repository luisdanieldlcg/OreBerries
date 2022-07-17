package daniking.oreberries.util;


import net.minecraft.item.Item;

/**
 * Provides access to the state of the {@link daniking.oreberries.OBConfig} in a convenient way.
 */
public interface ConfigStateAccess {

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
}
