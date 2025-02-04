package info.jab.recursion;

import org.junit.jupiter.api.Test;

public class ShowStackTraceTest {
    
    @Test
    void shouldPrintStackTrace() {
        ShowStackTrace.recursiveMethod(3);
    }
} 