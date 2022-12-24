package com.telerikacademy.models.contracts;

import com.telerikacademy.models.tasks.contracts.Task;

import java.util.List;

public interface Member {

    String getName();
    List<Task> getTask();
    List<String> getActivity();

}
