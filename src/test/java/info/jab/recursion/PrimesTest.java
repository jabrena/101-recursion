package info.jab.recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.assertj.core.api.Assertions.assertThat;

class PrimesTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/prime_numbers.txt")
    void shouldCorrectlyIdentifyPrimeNumbers(int number, boolean expectedResult) {
        // Given
        Primes primes = new Primes();
        
        // When / Then
        assertThat(primes.isPrime(number))
            .as("%d should be identified as %s", number, expectedResult ? "prime" : "not prime")
            .isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/prime_numbers.txt")
    void shouldCorrectlyIdentifyPrimeNumbersWithTailRecursion(int number, boolean expectedResult) {
        // Given
        Primes primes = new Primes();
        
        // When / Then
        assertThat(primes.isPrimeRecursive(number))
            .as("%d should be identified as %s", number, expectedResult ? "prime" : "not prime")
            .isEqualTo(expectedResult);
    }
} 