package com.telerikacademy.commands.create;

import com.telerikacademy.commands.contracts.Command;
import com.telerikacademy.core.TaskRepoImpl;
import com.telerikacademy.models.contracts.Member;
import com.telerikacademy.utils.ValidationHelpers;

import java.util.List;

import static com.telerikacademy.utils.ValidationHelpers.*;
import static java.lang.String.*;

public class CreatePerson implements Command {
    public static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    public static final String PERSON_CREATED = "Person with name %s was created";
    private final TaskRepoImpl repository;

    public CreatePerson(TaskRepoImpl repository) {
        this.repository = repository;
    }

    @Override
    public String excecute(List<String> arguments) {
        validateArgumentsCount(arguments, EXPECTED_NUMBER_OF_ARGUMENTS);
        String personName = arguments.get(0);
        Member member = repository.createPerson(personName);
        return format(PERSON_CREATED, personName);
    }

}
