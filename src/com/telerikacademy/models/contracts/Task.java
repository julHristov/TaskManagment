package com.telerikacademy.models.contracts;

import java.util.List;

public interface Task {
    int getId();
    String getTitle();
    String getDescription();
    List<String> getChangesHistory();
}
