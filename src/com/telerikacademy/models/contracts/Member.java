package com.telerikacademy.models.contracts;

import com.telerikacademy.models.tasks.contracts.Task;

import java.util.List;

public interface Member {

    String getName();
    List<Task> getTask();
    List<String> getActivity();
    void addTask(Task task);
    void removeTask(Task task);
    void addActivity(String message);

}
