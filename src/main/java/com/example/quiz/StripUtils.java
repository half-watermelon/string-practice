package com.example.quiz;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StripUtils {

    private static final Pattern pattern = Pattern.compile("(-?\\d+\\.?\\d*)$");

    private StripUtils() {
    }

    /**
     * examples:
     * abcd123.456->123.45 (RoundingMode.DOWN)
     * a1b2c3-3.1->-3.10 (negative symbol)
     * abcd123->123.00 (trailing zeros)
     * 12.23.3123->23.31 (multiple points)
     * z-23X.12999->12999.00 (position of point)
     * a1ac3.14159e->ExtractionFailedException (can not extract)
     *
     * @param input
     * @return
     * @throws ExtractionFailedException
     */
    public static String getRSBDecimal(final String input) throws ExtractionFailedException {
        final Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            final BigDecimal decimal = (new BigDecimal(matcher.group()))
                    .setScale(2, RoundingMode.DOWN)
                    .stripTrailingZeros();
            return String.format("%.2f", decimal);
        } else {
            throw new ExtractionFailedException(input);
        }
    }

    public static class ExtractionFailedException extends Exception {
        public ExtractionFailedException(final String input) {
            super("failed to extract decimal from:" + input);
        }
    }
}
