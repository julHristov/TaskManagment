package com.telerikacademy.models.tasks.contracts;

import java.util.List;

public interface Task {
    int getId();
    String getTitle();
    String getDescription();
    List<String> getChangesHistory();
}
