package info.jab.recursion.direct;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import info.jab.recursion.Benchmarks;
import info.jab.recursion.direct.Factorial;

public class FactorialBenchmark {

    private static final int NUMBER = 20;  // Número para calcular el factorial

    @Benchmark
    public long testIterativeFactorial() {
        return new Factorial().factorial(NUMBER);
    }

    @Benchmark
    public long testRecursiveFactorial() {
        return new Factorial().factorialRecursive(NUMBER);
    }

    public static void main(String[] ignored) throws RunnerException {
        Benchmarks.run(FactorialBenchmark.class);
    }
} 