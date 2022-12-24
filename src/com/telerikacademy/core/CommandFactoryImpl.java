package com.telerikacademy.core;

import com.telerikacademy.commands.contracts.Command;
import com.telerikacademy.core.contracts.CommandFactory;
import com.telerikacademy.core.contracts.TaskRepo;

public class CommandFactoryImpl implements CommandFactory {
    @Override
    public Command createCommandFromCommandName(String commandTypeAsString, TaskRepo taskRepo) {
        return null;
    }
}
