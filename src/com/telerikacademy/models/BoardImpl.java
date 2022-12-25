package com.telerikacademy.models;

import com.telerikacademy.models.contracts.Board;
import com.telerikacademy.models.tasks.contracts.Task;
import com.telerikacademy.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

public class BoardImpl implements Board {

    private static final int MIN_LENGTH_NAME = 5;
    private static final int MAX_LENGTH_NAME = 10;
    private String name;
    private List<Task> tasks;
    private List<String> activity;

    public BoardImpl(String name, List<Task> tasks, List<String> activity) {
        setName(name);
        this.tasks = new ArrayList<>();
        this.activity = new ArrayList<>();
    }

    private void setName(String name) {
        ValidationHelpers.validateStringLength(name , MIN_LENGTH_NAME , MAX_LENGTH_NAME ,
                ValidationHelpers.ERROR_MESSAGE_FOR_LENGTH);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Task> getTask() {
        return new ArrayList<>(tasks);
    }

    @Override
    public List<String> getActivity() {
        return new ArrayList<>(activity);
    }
}
