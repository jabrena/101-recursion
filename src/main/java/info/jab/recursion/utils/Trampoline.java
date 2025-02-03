package info.jab.recursion.utils;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

@FunctionalInterface
public interface Trampoline<T> {
    T get();

    default boolean done() { 
        return true; 
    }

    default Trampoline<T> next() { 
        throw new NoSuchElementException(); 
    }

    static <T> Trampoline<T> done(final T value) { 
        return () -> value; 
    }

    static <T> Trampoline<T> more(final Supplier<? extends Trampoline<T>> next) {
        return new Trampoline<T>() {
            @Override 
            public boolean done() { 
                return false; 
            }

            @Override 
            public T get() { 
                return trampoline(this); 
            }

            @Override 
            public Trampoline<T> next() { 
                return next.get(); 
            }

            private T trampoline(Trampoline<T> trampoline) {
                while (!trampoline.done()) {
                    trampoline = trampoline.next();
                }
                return trampoline.get();
            }
        };
    }
}
