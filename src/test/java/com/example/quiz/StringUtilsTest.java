package com.example.quiz;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StringUtilsTest {

    @Test
    void test() throws StripUtils.ExtractionFailedException {
        final Map<String, String> cases = Map.of(
                "abcd123.456", "123.45",
                "abcd123", "123.00",
                "a1b2c3-3.1", "-3.10",
                "12.23.3123", "23.31",
                "z-23X.12999", "12999.00"
        );
        for (Map.Entry<String, String> entry : cases.entrySet()) {
            final String output = StripUtils.getRSBDecimal(entry.getKey());
            System.out.printf("%s->%s%n", entry.getKey(), output);
            assert output.equals(entry.getValue());
        }
        assertThrows(StripUtils.ExtractionFailedException.class, () -> StripUtils.getRSBDecimal("aA3.1414e"));
    }
}
