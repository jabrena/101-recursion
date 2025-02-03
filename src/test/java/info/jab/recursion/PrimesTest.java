package info.jab.recursion;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.ExecutionException;

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

    @Disabled
    @ParameterizedTest
    @CsvSource({
        "2, true",
        "3, true", 
        "4, false",
        "5, true",
        "6, false",
        "7, true",
        "8, false",
        "9, false",
        "11, true",
        "13, true"
    })
    void shouldCorrectlyIdentifyPrimeNumbersWithConcurrentRecursion(int number, boolean expectedResult) throws InterruptedException, ExecutionException {
        // Given
        Primes primes = new Primes();
        
        // When / Then
        assertThat(primes.isPrimeConcurrent(number))
            .as("%d should be identified as %s", number, expectedResult ? "prime" : "not prime")
            .isEqualTo(expectedResult);
    }
} 