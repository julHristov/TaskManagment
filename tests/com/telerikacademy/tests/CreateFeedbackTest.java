package com.telerikacademy.tests;

import com.telerikacademy.commands.contracts.Command;
import com.telerikacademy.commands.create.CreateFeedback;
import com.telerikacademy.core.TaskRepoImpl;
import com.telerikacademy.models.contracts.Board;
import com.telerikacademy.models.contracts.Team;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static com.telerikacademy.tests.utils.TestUtilities.getList;
import static org.junit.Assert.*;

public class CreateFeedbackTest {

    public static final int EXPECTED_NUMBER_OF_ARGS = 3;
    private Command command;
    private TaskRepoImpl repository;
    private Team team;
    private Board board;

    @BeforeEach
    public void setup(){
        repository = new TaskRepoImpl();
        command = new CreateFeedback(repository);
    }
    @Test
    public void execute_Should_Throw_Exception_When_Arguments_Are_Less() {
        List<String> list = getList(EXPECTED_NUMBER_OF_ARGS - 1);
        assertThrows(IllegalArgumentException.class, () -> command.excecute(list));
    }
}