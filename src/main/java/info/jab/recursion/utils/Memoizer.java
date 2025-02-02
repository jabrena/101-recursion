package info.jab.recursion.utils;

import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;
import java.util.function.BiFunction;

public final class Memoizer {
    
    private Memoizer() {
        throw new AssertionError("Utility class should not be instantiated");
    }
    
    public static <T, R> R callMemoized(final BiFunction<Function<T, R>, T, R> function, final T input) {

        Function<T, R> memoized = new Function<T, R>() {
            private final Map<T, R> store = new HashMap<>();

            public R apply(final T input) {
                return store.computeIfAbsent(input, key -> function.apply(this, key));
            }
        };
        return memoized.apply(input);
    }
}
