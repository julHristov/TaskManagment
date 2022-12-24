package com.telerikacademy.commands.contracts;

import java.util.List;

public interface Command {
    String excecute(List<String> arguments);
}
