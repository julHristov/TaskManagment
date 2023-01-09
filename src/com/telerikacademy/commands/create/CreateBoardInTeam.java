package com.telerikacademy.commands.create;

import com.telerikacademy.commands.contracts.Command;
import com.telerikacademy.core.TaskRepoImpl;
import com.telerikacademy.models.contracts.Board;
import com.telerikacademy.models.contracts.Team;
import com.telerikacademy.utils.ValidationHelpers;

import java.util.List;

import static java.lang.String.*;

public class CreateBoardInTeam implements Command {
    public static final int EXPECTED_NUMBER_OF_PARAMETERS = 2;
    private String teamName;
    private String boardName;
    private final TaskRepoImpl taskRepo;

    public CreateBoardInTeam(TaskRepoImpl taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public String excecute(List<String> arguments) {
        ValidationHelpers.validateArgumentsCount(arguments, EXPECTED_NUMBER_OF_PARAMETERS);
        boardName = arguments.get(0);
        teamName = arguments.get(1);

        Board boardToAdd = taskRepo.createBoard(boardName);
        Team team = taskRepo.createTeam(teamName);
        team.addBoard(boardToAdd);
        return format("Board %s was added to Team %s", boardName, teamName);
    }
}
