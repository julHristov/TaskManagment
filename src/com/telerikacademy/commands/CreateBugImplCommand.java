package com.telerikacademy.commands;

import com.telerikacademy.commands.contracts.Command;
import com.telerikacademy.core.TaskRepoImpl;
import com.telerikacademy.models.enums.Priority;
import com.telerikacademy.models.enums.Severity;

import java.util.Arrays;
import java.util.List;

import static com.telerikacademy.utils.ValidationHelpers.*;
import static java.lang.String.*;

public class CreateBugImplCommand implements Command {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 6;
    private static final String TASK_ALREADY_EXISTS = "Task with title %s already exists";
    private static final String TASK_CREATED = "%s with title %s was created";

    private final TaskRepoImpl repository;
    public CreateBugImplCommand(TaskRepoImpl repository) {
        this.repository = repository;
    }

    @Override
    public String excecute(List<String> arguments) {
        validateArgumentsCount(arguments, EXPECTED_NUMBER_OF_ARGUMENTS);
        String title = arguments.get(0);
        String description = arguments.get(1);
        Priority priority = tryParsePriority(arguments.get(2).toUpperCase());
        Severity severity = tryParseSeverity(arguments.get(3).toUpperCase());
        List<String> steps = Arrays.asList(arguments.get(4).split(";"));
        return "";
    }

    private String createBug(int id, String title, String description, Priority priority,
                             Severity severity, List<String> steps){
        if(repository.taskExists(title)){
            throw new IllegalArgumentException(format(TASK_ALREADY_EXISTS, title));
        }
        repository.createTask(id, title, description, priority, severity, steps);
        return String.format(TASK_CREATED, "Bug", title);
    }
}
