package com.telerikacademy.core;

import com.telerikacademy.commands.contracts.Command;
import com.telerikacademy.core.contracts.CommandFactory;
import com.telerikacademy.core.contracts.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManagementEngineImpl implements Engine {

    private static final String END_COMMAND = "End";
    private static final String SEPARATOR = "################";
    public static final String ERROR_MESSAGE = "Command cannot be empty!";
    private final CommandFactory commandFactory;
    private final TaskRepoImpl taskRepo;


    public TaskManagementEngineImpl() {
        this.commandFactory = new CommandFactoryImpl();
        this.taskRepo = new TaskRepoImpl();
    }



    @Override
    public void start() {
        Scanner scn = new Scanner(System.in);
        while (true) {
            try {
                String line = scn.nextLine();
                if (line.isBlank()) {
                    print(ERROR_MESSAGE);
                    continue;
                }
                if (line.equalsIgnoreCase(END_COMMAND)) {
                    break;
                }
                processCommand(line);
            }catch (Exception err ){
                if (err.getMessage() != null && !err.getMessage().isEmpty()){
                    print(err.getMessage());
                }
                else {
                    print(err.toString());
                }
            }
        }

    }

    private void processCommand(String line) {
        String commandName = extractCommandName(line);
        Command command = commandFactory.createCommandFromCommandName(commandName, taskRepo);
        List<String> parameters = extractCommandParameters(line);
        String commandResult = command.excecute(parameters);
        System.out.println(commandResult);
    }

 //createtask:
 //filter: The bears are cool
    private String extractCommandName(String inputLine) {
        return inputLine.split(": ")[0];
    }

    private List<String> extractCommandParameters(String inputLine) {
        String[] commandParts = inputLine.split(" ");
        ArrayList<String> parameters = new ArrayList<>();
        for (int i = 1; i < commandParts.length; i++) {
            parameters.add(commandParts[i]);
        }
        return parameters;
    }

    private void print(String result) {
        System.out.println(result);
        System.out.println(SEPARATOR);
    }
}



