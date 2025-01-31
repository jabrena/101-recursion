package info.jab.recursion;

import java.util.stream.LongStream;

/**
 * Example 2 : Factorial of a Number
 */
public class Factorial {

    public long factorial(int n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);
    }

    public long factorialRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n <= 1) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }

}
