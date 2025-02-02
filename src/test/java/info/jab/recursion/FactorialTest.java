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
    void shouldReturnLongValueForNonNegativeInputs(@ForAll @IntRange(min = 0, max = 10) int n) {
        BigInteger result = factorial.factorial(n);
        assertThat(result)
            .isInstanceOf(BigInteger.class)
            .isPositive();
    }

    @Property
    void shouldReturnLongValueForNonNegativeInputs2(@ForAll @IntRange(min = 0, max = 10) int n) {
        BigInteger result = factorial.factorialRecursive(n);
        assertThat(result)
            .isInstanceOf(BigInteger.class)
            .isPositive();
    }

    @Property
    void shouldReturnLongValueForNonNegativeInputs3(@ForAll @IntRange(min = 0, max = 10) int n) {
        BigInteger result = factorial.factorialRecursiveTrampoline(n);
        assertThat(result)
            .isInstanceOf(BigInteger.class)
            .isPositive();
    }

    @Property
    void shouldReturnLongValueForNonNegativeInputs4(@ForAll @IntRange(min = 0, max = 10) int n) {
        BigInteger result = factorial.factorialTrampoline(n);
        assertThat(result)
            .isInstanceOf(BigInteger.class)
            .isPositive();
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
        factorial.factorialRecursiveTrampoline(100_000);
    }

} 