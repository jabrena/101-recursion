package info.jab.recursion.tail;

/**
 * Example 4 : Fibonacci with Recursion
 */
public class Fibonaccy {

    public long fibonacciRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        return java.util.stream.Stream.iterate(
                new long[]{0, 1},
                f -> new long[]{f[1], f[0] + f[1]}
            )
            .limit(n + 1)
            .map(f -> f[0])
            .reduce((first, second) -> second)
            .orElse(0L);
    }

}
