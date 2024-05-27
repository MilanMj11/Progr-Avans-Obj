package lab12.task1;

import java.util.*;
import java.util.function.BiFunction;

public class MyUtilityClass {
    public static <T> void printCollection(Collection<T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection cannot be null");
        }
        System.out.println(collection);
    }

    public static <T, Q> Q aggregate(Collection<T> collection, Q initial, BiFunction<Q, T, Q> accumulator) {
        if (collection == null || accumulator == null) {
            throw new IllegalArgumentException("Collection or accumulator cannot be null");
        }
        Q result = initial;
        for (T element : collection) {
            result = accumulator.apply(result, element);
        }
        return result;
    }

    public static <T> List<T> duplicateCollection(Collection<T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection cannot be null");
        }
        List<T> result = new ArrayList<>();
        for (T element : collection) {
            result.add(element);
            result.add(element);
        }
        return result;
    }
}
