package com.telerikacademy.core;

import com.telerikacademy.core.contracts.CommandFactory;
import com.telerikacademy.core.contracts.Engine;
import com.telerikacademy.core.contracts.TaskRepo;

public class TaskManagementEngineImpl implements Engine {

    private final CommandFactory commandFactory;
    private final TaskRepo taskRepo;

    public TaskManagementEngineImpl(CommandFactory commandFactory, TaskRepo taskRepo) {
        this.commandFactory = new CommandFactoryImpl();
        this.taskRepo = new TaskRepoImpl();
    }

    @Override
    public void start() {

    }
}
