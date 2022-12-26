package com.telerikacademy.utils;

public class ParsingHelpers {
    public static final String INVALID_ID = "Invalid value for ID. Should be a number.";
    public static int tryParseInt(String valueToParse, String errorMessage) {
        try {
            return Integer.parseInt(valueToParse);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
