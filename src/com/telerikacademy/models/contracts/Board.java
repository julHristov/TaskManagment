package com.telerikacademy.models.contracts;

import com.telerikacademy.models.tasks.contracts.Task;

import java.util.List;

public interface Board {

    String getName();
    List<Task> getTask();
    List<String> getActivity();
}
