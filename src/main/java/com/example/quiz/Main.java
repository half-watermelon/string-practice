package com.example.quiz;

public class Main {

    public static void main(String... args) {
        try {
            for (final String s : args) {
                System.out.println(StripUtils.getRSBDecimal(s));
            }
        } catch (final StripUtils.ExtractionFailedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
