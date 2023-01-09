package com.telerikacademy.tests;

import com.telerikacademy.models.BoardImpl;
import com.telerikacademy.models.contracts.Board;
import com.telerikacademy.models.enums.Priority;
import com.telerikacademy.models.enums.Severity;
import com.telerikacademy.models.tasks.BugImpl;
import com.telerikacademy.models.tasks.contracts.Bug;
import com.telerikacademy.tests.utils.TestUtilities;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.telerikacademy.tests.utils.TestUtilities.*;
import static org.junit.jupiter.api.Assertions.*;

public class BoardImplTest {

    private Board board;
    private Bug bug;
    @BeforeEach
    public void setupBoard(){
        board = new BoardImpl(TestUtilities.VALID_NAME);
    }
    @BeforeEach
    public void setupBug(){
        bug = new BugImpl(TestUtilities.VALID_ID,
                VALID_NAME,
                VALID_DESCRIPTION,
                Priority.HIGH,
                Severity.CRITICAL,
                list);
    }
    @Test
    public void constructor_Should_Throw_Exception_When_Name_Is_Below_Min_Length(){
        Assert.assertThrows(IllegalArgumentException.class,
                () -> new BoardImpl(TestUtilities.INVALID_NAME_MIN_LENGTH));
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

    @Test
    public void addBug_ShouldThrow_Exception_When_Bug_Is_In_The_List(){
        board.addBugToBoard(bug);
        assertThrows(IllegalArgumentException.class,
                ()->board.addBugToBoard(bug));
    }
    @Test
    public void addBug_Should_Add_Bug_When_Is_Not_In_The_List(){
        board.addBugToBoard(bug);
        assertEquals(1, board.getTask().size());
    }
}
