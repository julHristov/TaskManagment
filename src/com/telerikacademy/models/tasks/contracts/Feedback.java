package com.telerikacademy.models.tasks.contracts;

import com.telerikacademy.models.contracts.Member;
import com.telerikacademy.models.enums.Status;
import com.telerikacademy.models.enums.TaskType;

public interface Feedback extends Task{
    int getRating();

    Status getStatus();

    Member getAssignee();

    void changeStatus(Status newStatus);

    public TaskType getType();
}
