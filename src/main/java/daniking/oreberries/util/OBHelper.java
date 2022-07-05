package daniking.oreberries.util;

import daniking.oreberries.OBConfig;

public class OBHelper {
    public enum OreBerryType {
        IRON,
        GOLD,
        COPPER,
        TIN,
        ALUMINUM,
        ESSENCE;
    }

    public static ConfigStateAccess getConfigAccessFor(OreBerryType type) {
        final OBConfig config = OBConfig.getInstance();
        return switch (type) {
            case IRON -> config.iron;
            case GOLD -> config.gold;
            case COPPER -> config.copper;
            case TIN -> config.tin;
            case ALUMINUM -> config.aluminum;
            case ESSENCE -> config.essence;
        };
    }

}