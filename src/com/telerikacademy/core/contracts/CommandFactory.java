package com.telerikacademy.core.contracts;

import com.telerikacademy.commands.contracts.Command;
import com.telerikacademy.core.TaskRepoImpl;

public interface CommandFactory {

    Command createCommandFromCommandName(String commandTypeAsString , TaskRepoImpl taskRepo);
}
