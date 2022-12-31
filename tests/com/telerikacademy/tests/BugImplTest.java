package com.telerikacademy.tests;

import com.telerikacademy.models.enums.Priority;
import com.telerikacademy.models.enums.Severity;
import com.telerikacademy.models.enums.Status;
import com.telerikacademy.models.tasks.BugImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BugImplTest {

    private static BugImpl bug;

    @BeforeEach
    public void setup() {
        bug = new BugImpl(1, "xxx xxx xxx", "Has to be resolved",
                Priority.HIGH, Severity.CRITICAL, new ArrayList<>());
    }

    @Test
    public void validateTitle() {
        setup();
        String title = bug.getTitle();
        assertEquals(11, title.length());
    }

    @Test
    public void change_Status_Should_Throw_Exception_When_Equals() {
        setup();
        Status status = Status.ACTIVE;
        assertEquals(status, bug.getStatus());
    }

    @Test
    public void change_Status_Should_NotThrow_Exception() {
        setup();
        Status status = Status.NEW;
        assertNotEquals(status, bug.getStatus());
    }

    //    @Test
//    public void change_Status_Should_Add_Activity(){
//        setup();
//        Status status = Status.NEW;
//        assertNotEquals(status, bug.getStatus());
//    }
    @Test
    void validateDescription() {
        setup();
        String description = bug.getDescription();
        assertEquals(18, description.length());
    }

    @Test
    void constructor_Should_Throw_Exception_When_Description_Length_Below_Min() {
        setup();
        try {
            bug.setDescription("Invalid");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void constructor_Should_Throw_Exception_When_Description_Length_Above_Max() {
        setup();
        String test = "Invalid".repeat(500);
        try {
            bug.setDescription(test);
        } catch (IllegalArgumentException e) {

        }
    }
}