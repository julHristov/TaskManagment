package com.telerikacademy.core.contracts;

import com.telerikacademy.models.enums.Priority;
import com.telerikacademy.models.enums.Severity;
import com.telerikacademy.models.tasks.contracts.Task;

import java.util.List;

public interface TaskManagementRepository {
    List <Task>getTasks();

    void createTask(int id, String taskTitle, String description, Priority priority,
                    Severity severity, List<String> steps);

    boolean taskExists(String taskName);
}
