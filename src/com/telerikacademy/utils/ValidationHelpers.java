package com.telerikacademy.utils;

public class ValidationHelpers {

    public static final String ERROR_MESSAGE_FOR_LENGTH = "NAME LENGTH MUST BE BETWEEN %d and %d SIZE !";
    public static void validateValueInRange(double value, double min, double max, String errorMessage) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
    public static void validateStringLength(String stringToValidate, int minLength,
                                            int maxLength, String errorMessage){
        validateValueInRange(stringToValidate.length(),minLength, maxLength,errorMessage);
    }
}
