package info.jab.recursion;

import java.math.BigInteger;
import java.util.stream.Stream;

import info.jab.recursion.utils.Memoizer;
import info.jab.recursion.utils.Trampoline;

import java.util.Map;
import java.util.HashMap;

/**
 * Example 4 : Fibonacci with Recursion
 */
public class Fibonacci {

    public BigInteger fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        return Stream.iterate(
                new BigInteger[]{BigInteger.ZERO, BigInteger.ONE},
                f -> new BigInteger[]{f[1], f[0].add(f[1])}
            )
            .limit(n + 1)
            .map(f -> f[0])
            .reduce((first, second) -> second)
            .orElse(BigInteger.ZERO);
    }

    private final Map<Integer, BigInteger> memo = new HashMap<>();

    public BigInteger fibonacciRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        return fibonacciMemoized(n);
    }

    private BigInteger fibonacciMemoized(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;
        
        BigInteger result = fibonacciMemoized(n - 1).add(fibonacciMemoized(n - 2));
        memo.put(n, result);
        return result;
    }

    public BigInteger fibonacciTailCall(final int n) {
        return Memoizer.callMemoized((fib, num) -> {
            return fib(num, BigInteger.ZERO, BigInteger.ONE).get();
        }, n);
    }

    private Trampoline<BigInteger> fib(final int n, final BigInteger acc1, final BigInteger acc2) {
        return switch (n) {
            case 0 -> Trampoline.done(acc1);
            default -> Trampoline.more(() -> fib(n - 1, acc2, acc1.add(acc2)));
        };
    }
}
