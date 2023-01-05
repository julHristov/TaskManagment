package com.telerikacademy.tests;

import com.telerikacademy.models.BoardImpl;
import com.telerikacademy.models.contracts.Board;
import com.telerikacademy.tests.utils.TestUtilities;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.telerikacademy.tests.utils.TestUtilities.INVALID_NAME_MIN_LENGTH;
import static org.junit.jupiter.api.Assertions.*;

public class BoardImplTest {

    private Board board;
    @BeforeEach
    public void setup_Board(){
        board = new BoardImpl(TestUtilities.VALID_NAME);
    }
    @Test
    public void constructor_Should_Throw_Exception_When_Name_Is_Below_Min_Length(){
        Assert.assertThrows(IllegalArgumentException.class,
                () -> new BoardImpl(INVALID_NAME_MIN_LENGTH));
    }

    @Test
    public void constructor_Should_Throw_Exception_When_Name_Is_Above_Max_Length(){
        Assert.assertThrows(IllegalArgumentException.class,
                () -> new BoardImpl(TestUtilities.INVALID_NAME_MAX_LENGTH));
    }
    @Test
    public void constructor_Should_Initialize_Name_When_Valid(){
        assertNotNull(board.getName());
    }
    @Test
    public void constructor_Should_Initialize_Task_When_Valid_Args(){
        assertNotNull(board.getTask());
    }

    @Test
    public void constructor_Should_Initialize_Activity_When_Valid_Args(){
        assertNotNull(board.getActivity());
    }
}
