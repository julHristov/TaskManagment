package com.telerikacademy.core;

import com.telerikacademy.commands.create.CreateBugImplCommand;
import com.telerikacademy.commands.contracts.Command;
import com.telerikacademy.commands.create.CreateFeedback;
import com.telerikacademy.commands.create.CreateTeam;
import com.telerikacademy.commands.enums.CommandType;
import com.telerikacademy.core.contracts.CommandFactory;
import static com.telerikacademy.utils.ParsingHelpers.*;

public class CommandFactoryImpl implements CommandFactory {
    private static final String INVALID_COMMAND = "Invalid command name: %s!";

    @Override
    public Command createCommandFromCommandName(String commandTypeAsString, TaskRepoImpl taskRepo) {
             CommandType commandType = tryParseEnum(commandTypeAsString, CommandType.class,
                    String.format(INVALID_COMMAND, commandTypeAsString));
           //TODO!
            switch (commandType){
                case CREATEBUG:
                    return new CreateBugImplCommand(taskRepo);
                case CREATETEAM:
                    return new CreateTeam(taskRepo);
                case CREATEFEEDBACK:
                    return new CreateFeedback(taskRepo);
                default:
                throw new IllegalArgumentException(String.format(INVALID_COMMAND, commandTypeAsString));
        }
    }
}
