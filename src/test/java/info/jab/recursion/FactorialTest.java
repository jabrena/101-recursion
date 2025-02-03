package info.jab.recursion;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

class FactorialTest {

    private final Factorial factorial = new Factorial();

    @Property
    void shouldWorkWithFunctionalApproach(@ForAll @IntRange(min = 0, max = 10) int n) {
        BigInteger result = factorial.factorial(n);
        assertThat(result)
            .isInstanceOf(BigInteger.class)
            .isPositive();
    }

    @Property
    void shouldWorkWithRecursiveApproach(@ForAll @IntRange(min = 0, max = 10) int n) {
        BigInteger result = factorial.factorialRecursive(n);
        assertThat(result)
            .isInstanceOf(BigInteger.class)
            .isPositive();
    }

    @Property
    void shouldWorkWithTrampolineApproach(@ForAll @IntRange(min = 0, max = 10) int n) {
        BigInteger result = factorial.factorialRecursiveTrampoline(n);
        assertThat(result)
            .isInstanceOf(BigInteger.class)
            .isPositive();
    }


    @Property
    void shouldWorkWithForkJoinApproach(@ForAll @IntRange(min = 0, max = 10) int n) {
        BigInteger result = factorial.factorialRecursiveForkJoin(n);
        assertThat(result)
            .isInstanceOf(BigInteger.class)
            .isPositive();
    }

    @Test
    void shouldGetSameResultForAllApproachesWithFactorial10() {
        final int number = 10;
        BigInteger functionalResult = factorial.factorial(number);
        BigInteger recursiveResult = factorial.factorialRecursive(number);
        BigInteger trampolineResult = factorial.factorialRecursiveTrampoline(number);
        BigInteger forkJoinResult = factorial.factorialRecursiveForkJoin(number);

        assertThat(functionalResult)
            .isEqualTo(recursiveResult)
            .isEqualTo(trampolineResult)
            .isEqualTo(forkJoinResult);
    }

    @Test
    void shouldFailWhenInputIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> 
            factorial.factorialRecursive(-1)
        );
    }

    @Test
    void shouldThrowStackOverflowErrorForLargeNumbers() {
        assertThrows(StackOverflowError.class, () ->
            factorial.factorialRecursive(100_000)
        );
    }

    @Test
    void shouldThrowStackOverflowErrorForLargeNumbersTrampoline() {
        var result = factorial.factorialRecursiveTrampoline(100_000);
        assertThat(result).isInstanceOf(BigInteger.class);
    }

} 