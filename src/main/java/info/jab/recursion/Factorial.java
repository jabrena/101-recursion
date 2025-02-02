package info.jab.recursion;

import java.math.BigInteger;
import java.util.stream.LongStream;

import info.jab.recursion.utils.TailCall;
import static info.jab.recursion.utils.TailCalls.call;
import static info.jab.recursion.utils.TailCalls.done;

/**
 * Example 2 : Factorial of a Number
 */
public class Factorial {

    // Iterative approach
    public BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        return LongStream.rangeClosed(1, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }

    // Recursive approach
    public BigInteger factorialRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n <= 1) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(factorialRecursive(n - 1));
    }

    // Tail recursion approach
    public BigInteger factorialRecursiveTrampoline(int number) {
        return factorialTailRec(BigInteger.ONE, number).invoke();
    }

    public TailCall<BigInteger> factorialTailRec(BigInteger factorial, final int number) {
        return switch (number) {
            case Integer n when n < 0 -> throw new IllegalArgumentException("Factorial is not defined for negative numbers");
            case 0, 1 -> done(factorial);
            default -> call(() -> factorialTailRec(factorial.multiply(BigInteger.valueOf(number)), number - 1));
        };
    }
}
