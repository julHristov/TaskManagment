package com.telerikacademy.core;

import com.telerikacademy.core.contracts.TaskManagementRepository;
import com.telerikacademy.models.enums.Priority;
import com.telerikacademy.models.enums.Severity;
import com.telerikacademy.models.tasks.BugImpl;
import com.telerikacademy.models.tasks.contracts.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskManagementRepositoryImpl implements TaskManagementRepository {
    public static int id;

    private final List<Task> tasks;

    public TaskManagementRepositoryImpl() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public void createTask(int id, String taskTitle, String description, Priority priority,
                           Severity severity, List<String> steps) {
        Task task = new BugImpl(++id, taskTitle, description, priority, severity, steps);
        this.tasks.add(task);
    }

    @Override
    public boolean taskExists(String taskName) {
        boolean exists = false;
        for (Task task : getTasks()){
            if(task.getTitle().equalsIgnoreCase(taskName)){
                exists = true;
                break;
            }
        }
        return exists;
    }
}
