package com.telerikacademy.core;

import com.telerikacademy.commands.CreateBugImplCommand;
import com.telerikacademy.commands.contracts.Command;
import com.telerikacademy.commands.enums.CommandType;
import com.telerikacademy.core.contracts.CommandFactory;
import static com.telerikacademy.utils.ParsingHelpers.*;

public class CommandFactoryImpl implements CommandFactory {
    private static final String INVALID_COMMAND = "Invalid command name: %s!";

    @Override
    public Command createCommandFromCommandName(String commandTypeAsString, TaskRepoImpl taskRepo) {
             CommandType commandType = tryParseEnum(commandTypeAsString, CommandType.class,
                    String.format(INVALID_COMMAND, commandTypeAsString));

            switch (commandType){
                case CREATETASK:
                    return new CreateBugImplCommand(taskRepo);
                default:
                throw new IllegalArgumentException(String.format(INVALID_COMMAND, commandTypeAsString));
        }
    }
}
