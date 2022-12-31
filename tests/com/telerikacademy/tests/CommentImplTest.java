package com.telerikacademy.tests;

import com.telerikacademy.models.CommentImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentImplTest {

    @Test
    void setAuthor() {
        CommentImpl comment = new CommentImpl("XXX", "XXXXXXXXXX");
        String author = comment.getAuthor();
        assertEquals(3, author.length());
    }

    @Test
    void setContent() {
        fail("Not implemented yet");
    }

    @Test
    void getContent() {
        fail("Not implemented yet");
    }

    @Test
    void getAuthor() {
        fail("Not implemented yet");
    }
}