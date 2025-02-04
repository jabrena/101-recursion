package info.jab.recursion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestNumberTest {
    
    @Test
    public void shouldFindLargestNumberInArray() {
        // Given
        int[] arr = new int[] {1, 10, 9, 5, 9, 4, 15, 12, 19};
        LargestNumber largestNumber = new LargestNumber();
        
        // When
        int result = largestNumber.largestNumber(arr, arr.length, 0);
        
        // Then
        assertEquals(19, result);
    }

} 