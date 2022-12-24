package com.telerikacademy.models.tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BugImplTest {

    @BeforeEach

    @Test
    void validateTitle() {
        BugImpl bug = new BugImpl(1, "xxx xxx xxx", "Has to be resolved");
        String title = bug.getTitle();
        assertEquals(11, title.length());
    }

    @Test
    void validateDescription() {
        BugImpl bug = new BugImpl(1, "xxx xxx xxx", "XXX XXX XXX");
        String description = bug.getDescription();
        assertEquals(11, description.length());
    }
}