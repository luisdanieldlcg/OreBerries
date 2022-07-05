package daniking.oreberries.util;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;

public record ObjectDefinition<T>(T object, Identifier id) {
    public static <T> List<T> toObjectList(List<ObjectDefinition<T>> list) {
       return toObjectList(list, t -> false);
    }
    public static <T> List<T> toObjectList(List<ObjectDefinition<T>> list, Predicate<T> exclude) {
        return list.stream()
                .map(ObjectDefinition::object)
                .filter(exclude.negate())
                .toList();
    }
}
