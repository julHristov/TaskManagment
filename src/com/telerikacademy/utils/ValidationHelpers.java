package com.telerikacademy.utils;

import com.telerikacademy.models.enums.Priority;
import com.telerikacademy.models.enums.Severity;

import java.util.List;

public class ValidationHelpers {
    private static final String INVALID_NUMBER_OF_ARGUMENTS = "Invalid number of arguments. " +
            "Expected: %d; received: %d.";


    public static final String ERROR_MESSAGE_FOR_LENGTH = "NAME LENGTH MUST BE BETWEEN %d and %d SIZE !";
    private static final String NO_SUCH_PRIORITY_ENUM = "None of the enums in GenderType matches the value %s";
    private static final String NO_SUCH_SEVERITY_ENUM = "None of the enums in Severity matches the value %s";;

    public static void validateValueInRange(double value, double min, double max, String errorMessage) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
    public static void validateStringLength(String stringToValidate, int minLength,
                                            int maxLength, String errorMessage){
        validateValueInRange(stringToValidate.length(),minLength, maxLength,errorMessage);
    }
    public static void validateArgumentsCount(List<String> list, int expectedNumberOfParameters) {
        if (list.size() < expectedNumberOfParameters || list.size() > expectedNumberOfParameters) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS,
                    expectedNumberOfParameters, list.size()));
        }
    }
    public static Priority tryParsePriority(String valueToParse) {
        try {
            return Priority.valueOf(valueToParse.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format(NO_SUCH_PRIORITY_ENUM, valueToParse));
        }
    }

    public static Severity tryParseSeverity(String valueToParse) {
        try {
            return Severity.valueOf(valueToParse.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(String.format(NO_SUCH_SEVERITY_ENUM, valueToParse));
        }
    }
}
