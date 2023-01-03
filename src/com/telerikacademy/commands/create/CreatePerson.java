package com.telerikacademy.commands.create;

import com.telerikacademy.commands.contracts.Command;
import com.telerikacademy.core.TaskRepoImpl;

import java.util.List;

public class CreatePerson implements Command {
    private final TaskRepoImpl repository;

    public CreatePerson(TaskRepoImpl repository) {
        this.repository = repository;
    }

    @Override
    public String excecute(List<String> arguments) {
        return null;
    }
}
