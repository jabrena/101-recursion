package info.jab.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SumNumbersTest {

    private final SumNumbers sumNumbers = new SumNumbers();

    @ParameterizedTest(name = "Sum of first 100 numbers should be {0}")
    @CsvSource("5050") // Using simplified CsvSource syntax
    void shouldSumFirstHundredNumbers(int expectedSum) {
        assertThat(sumNumbers.sumFirstHundredNumbers())
            .isEqualTo(expectedSum);
    }

    @ParameterizedTest(name = "Recursive sum of first 100 numbers should be {0}")
    @CsvSource("5050")
    void shouldSumFirstHundredNumbersRecursive(int expectedSum) {
        assertThat(sumNumbers.sumFirstHundredNumbersRecursive())
            .isEqualTo(expectedSum);
    }
} 