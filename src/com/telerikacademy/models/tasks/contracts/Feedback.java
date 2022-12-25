package com.telerikacademy.models.tasks.contracts;

import com.telerikacademy.models.contracts.Member;
import com.telerikacademy.models.enums.Status;

public interface Feedback {
    int getRating();

    Status getStatus();

    Member getAssignee();
}
