package com.telerikacademy.tests.utils;

import java.util.List;

import static java.util.Arrays.asList;

public class TestUtilities {
    public static final int BELOW_MIN_LENGTH = 4;
    public static final int ABOVE_MAX_LENGTH = 11;
    public static final int VALID_NAME_LENGTH = 10;
    public static final String INVALID_NAME_MAX_LENGTH = "x".repeat(ABOVE_MAX_LENGTH);
    public static final String INVALID_NAME_MIN_LENGTH = "x".repeat(BELOW_MIN_LENGTH);
    public static final String VALID_NAME = getString(VALID_NAME_LENGTH);
    public static String getString(int size) {
        return "x".repeat(size);
    }

    /**
     * Returns a new List with size equal to wantedSize.
     * Useful when you do not care what the contents of the List are,
     * for example when testing if a list of a command throws exception
     * when it's parameters list's size is less/more than expected.
     *
     * @param size the size of the List to be returned.
     * @return a new List with size equal to wantedSize
     */
    public static List<String> getList(int size) {
        return asList(new String[size]);
    }

}
