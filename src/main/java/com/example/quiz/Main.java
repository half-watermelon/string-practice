package com.example.quiz;

public class Main {

    public static void main(String... args) throws StripUtils.ExtractionFailedException {
        for (final String s : args) {
            System.out.printf(StripUtils.getRSBDecimal(s));
        }
    }
}
