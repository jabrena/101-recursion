package info.jab.recursion;

import java.math.BigInteger;
import java.util.stream.LongStream;

import info.jab.recursion.utils.TailCall;
import static info.jab.recursion.utils.TailCalls.call;
import static info.jab.recursion.utils.TailCalls.done;
import info.jab.recursion.utils.Trampoline;

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

    // Recursive approach without TCO
    public BigInteger factorialRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n <= 1) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(factorialRecursive(n - 1));
    }

    // Tail recursion approach with Trampoline
    public BigInteger factorialRecursiveTrampoline(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        return factorialTailRec(BigInteger.ONE, number).get();
    }

    private Trampoline<BigInteger> factorialTailRec(BigInteger factorial, final int number) {
        if (number <= 1) {
            return Trampoline.done(factorial);
        }
        return Trampoline.more(() -> 
            factorialTailRec(factorial.multiply(BigInteger.valueOf(number)), number - 1));
    }
}
