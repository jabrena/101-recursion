package info.jab.recursion.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;

class MemoizerTest {

    @Test
    void shouldThrowExceptionWhenTryingToInstantiate() {
        assertThrows(InvocationTargetException.class, () -> {
            var constructor = Memoizer.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        });
    }
}