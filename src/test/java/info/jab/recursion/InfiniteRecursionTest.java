package info.jab.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.assertj.core.api.Assertions.assertThat;

class InfiniteRecursionTest {

    @Test
    void shouldThrowStackOverflowError() {
        // Given
        InfiniteRecursion infiniteRecursion = new InfiniteRecursion();

        // When
        StackOverflowError exception = assertThrows(StackOverflowError.class, () -> {
            infiniteRecursion.recurse();
        });

        // Then
        assertThat(exception).isNotNull();
    }
} 