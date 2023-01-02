package com.telerikacademy.tests;

import com.telerikacademy.models.CommentImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentImplTest {

    private static CommentImpl comment;
    @BeforeEach
    public void setUp(){
        comment = new CommentImpl("Peter", "Content length should be more than 10 symbols " +
                "and less or equal to 100");
    }
    @Test
    void setAuthor_Should_Validate_Name_Length() {
        assertEquals(5, comment.getAuthor().length());
    }

    @Test
    void setAuthor_Should_Throw_Exception_When_Below_Min_Length(){
        assertThrows(IllegalArgumentException.class, ()->comment.setAuthor("X".repeat(2)));
    }

    @Test
    void setAuthor_Should_Throw_Exception_When_Above_Max_Length(){
        assertThrows(IllegalArgumentException.class, ()->comment.setAuthor("X".repeat(11)));
    }

    @Test
    void setContent_Should_Validate_Content_Length() {
        assertEquals(70, comment.getContent().length());
    }

    @Test
    void setContent_Should_Throw_Exception_When_Below_Min_Length(){
        assertThrows(IllegalArgumentException.class, ()->comment.setContent("X".repeat(8)));
    }

    @Test
    void setContent_Should_Throw_Exception_When_Above_Max_Length(){
        assertThrows(IllegalArgumentException.class, ()->comment.setContent("X".repeat(101)));
    }

    @Test
    void getContent_Should_Return() {
        assertEquals(70, comment.getContent().length());
    }

    @Test
    void getAuthor_Should_Return() {
        assertEquals(5, comment.getAuthor().length());
    }
}