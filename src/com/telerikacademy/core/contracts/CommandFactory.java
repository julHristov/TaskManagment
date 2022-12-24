package com.telerikacademy.core.contracts;

import com.telerikacademy.commands.contracts.Command;

public interface CommandFactory {

    Command createCommandFromCommandName(String commandTypeAsString , TaskRepo taskRepo);
}
