package com.telerikacademy.core;

import com.telerikacademy.commands.create.CreateBoardInTeam;
import com.telerikacademy.commands.create.CreateBugImplCommand;
import com.telerikacademy.commands.contracts.Command;
import com.telerikacademy.commands.create.CreatePerson;
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
           //TODO
            switch (commandType){
                case CREATEPERSON:
                    return new CreatePerson(taskRepo);
                case CREATEFEEDBACK:
                    return null;
                case CREATEBOARDINTEAM:
                    return new CreateBoardInTeam(taskRepo);
                case CREATEBUG:
                    return null;
                case CREATEBUGINBOARD:
                    return null;
                case CREATEFEEDBACKINBOARD:
                    return null;
                case CREATESTORYINBOARD:
                    return null;
                case CREATETEAM:
                    return new CreateTeam(taskRepo);
                case ADDCOMMENTTOTASK:
                    return null;
                case ADDPERSONTOTEAM:
                    return null;
                case CHANGESTATEOFBUG:
                    return null;
                case CHANGESTATEOFFEEDBACK:
                    return null;
                case CHANGESTATEOFSTORY:
                    return null;
                case LISTALLBUGSFILTER:
                    return null;
                case LISTALLBUGSSORT:
                    return null;
                case LISTALLFEEDBACKSFILTER:
                    return null;
                case LISTALLFEEDBACKSSORT:
                    return null;
                case LISTALLSTORIESFILTER:
                    return null;
                case LISTALLSTORIESSORT:
                    return null;
                case LISTALLTASKFILTER:
                    return null;
                case LISTALLTASKSORT:
                    return null;
                case LISTTASKSWITHASSIGNEEFILTER:
                    return null;
                case LISTTASKSWITHASSIGNEESORT:
                    return null;
                case SHOWALLPERSONINTEAM:
                    return null;
                case SHOWALLTEAMBOARDS:
                    return null;
                case SHOWPEOPLE:
                    return null;
                case SHOWPERSONACTIVITY:
                    return null;
                case SHOWTEAM:
                    return null;
                case SHOWB0ARDSACTIVITY:
                    return null;
                case ASSIGNTASKTOPERSON:
                    return null;
                case UNASSIGNTASKFROMPERSON:
                    return null;

                default:
                throw new IllegalArgumentException(String.format(INVALID_COMMAND, commandTypeAsString));
        }
    }
}
