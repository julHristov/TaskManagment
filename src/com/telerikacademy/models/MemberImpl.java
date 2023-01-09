package com.telerikacademy.models;

import com.telerikacademy.models.contracts.Member;
import com.telerikacademy.models.tasks.TasksBase;
import com.telerikacademy.models.tasks.contracts.Task;
import com.telerikacademy.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class MemberImpl implements Member {
    private static final int MIN_LEN_NAME = 5;
    private static final int MAX_LEN_NAME = 15;

    private String name ;
    private final List<Task> listOfTask;
    private final List<String> activity;

    public MemberImpl(String name) {
        setName(name);
        this.listOfTask = new ArrayList<>();
        this.activity = new ArrayList<>();
    }

    private void setName(String name) {
        ValidationHelpers.validateStringLength( name ,MIN_LEN_NAME , MAX_LEN_NAME  ,
                ValidationHelpers.ERROR_MESSAGE_FOR_LENGTH);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Task> getTask() {
        return new ArrayList<>(listOfTask);
    }

    @Override
    public List<String> getActivity() {
        return new ArrayList<>(activity);
    }

    @Override
    public void addTask(Task task) {
        if(listOfTask.contains(task)){
            throw new IllegalArgumentException("Task has already been assigned");
        }
        listOfTask.add(task);
        addActivity(String.format("Task with ID %d is assigned", task.getId()));
    }

    @Override
    public void removeTask(Task task) {
        if(!listOfTask.contains(task)){
            throw new IllegalArgumentException(String.format("Task %s is not in the list", task.getTitle()));
        }
        listOfTask.remove(task);
        addActivity(String.format("Task %s was removed from list", task.getTitle()));
    }

    @Override
    public void addActivity(String message) {
        activity.add(message);
    }
}
