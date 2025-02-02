package info.jab.recursion;

import java.math.BigInteger;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

public class FactorialBenchmark {

    private static final int NUMBER = 20;  // Número para calcular el factorial

    @Benchmark
    public BigInteger testIterativeFactorial() {
        return new Factorial().factorial(NUMBER);
    }

    @Benchmark
    public BigInteger testRecursiveFactorial() {
        return new Factorial().factorialRecursive(NUMBER);
    }

    public static void main(String[] ignored) throws RunnerException {
        Benchmarks.run(FactorialBenchmark.class);
    }
} 