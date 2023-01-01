package com.telerikacademy.commands.create;

import com.telerikacademy.commands.contracts.Command;
import com.telerikacademy.core.TaskRepoImpl;
import com.telerikacademy.models.TeamImpl;
import com.telerikacademy.utils.ValidationHelpers;

import java.util.List;

import static com.telerikacademy.utils.ValidationHelpers.*;
import static java.lang.String.*;

public class CreateTeam implements Command {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private static final String TEAM_CREATED_MESSAGE = "Team with name %s was created";
    private static final String TEAM_ALREADY_EXIST = "Team with name %s already exists";
    private final TaskRepoImpl repository;

    public CreateTeam(TaskRepoImpl repository) {
        this.repository = repository;
    }

    @Override
    public String excecute(List<String> arguments) {
        validateArgumentsCount(arguments, EXPECTED_NUMBER_OF_ARGUMENTS);
        String teamName = arguments.get(0);
        return createTeam(teamName);
    }
    private String createTeam(String name){
        if(repository.taskExists(name)){
            throw new IllegalArgumentException(format(TEAM_ALREADY_EXIST, name));
        }
        repository.addTeam(new TeamImpl(name));
        return format(TEAM_CREATED_MESSAGE, name);
    }
}
