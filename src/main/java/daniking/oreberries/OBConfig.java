package daniking.oreberries;

import daniking.oreberries.OreBerries;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;


@Config(name = OreBerries.MODID)
public class OBConfig implements ConfigData {

    @Comment(value = "comment")
    public int example = 1;
}