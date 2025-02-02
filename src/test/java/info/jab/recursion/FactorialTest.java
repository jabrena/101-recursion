package info.jab.recursion;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FactorialTest {

    private final Factorial factorial = new Factorial();

    @Property
    void shouldReturnLongValueForNonNegativeInputs(@ForAll @IntRange(min = 0, max = 20) int n) {
        BigInteger result = factorial.factorial(n);
        assertThat(result)
            .isInstanceOf(BigInteger.class)
            .isPositive();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10, 15, 20})
    void shouldReturnLongValueForNonNegativeInputsParameterized(int n) {
        BigInteger result = factorial.factorial(n);
        assertThat(result)
            .isInstanceOf(BigInteger.class)
            .isPositive();
    }


    @Property
    void shouldReturnLongValueForNonNegativeInputs2(@ForAll @IntRange(min = 0, max = 20) int n) {
        BigInteger result = factorial.factorialRecursive(n);
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

    @Property
    void shouldReturnLongValueForNonNegativeInputs3(@ForAll @IntRange(min = 0, max = 10_000) int n) {
        BigInteger result = factorial.factorialRecursiveTrampoline(n);
        assertThat(result)
            .isInstanceOf(BigInteger.class)
            .isPositive();
    }

} 