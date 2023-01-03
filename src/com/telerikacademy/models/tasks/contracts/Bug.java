package com.telerikacademy.models.tasks.contracts;

import com.telerikacademy.models.contracts.Member;
import com.telerikacademy.models.enums.Priority;
import com.telerikacademy.models.enums.Severity;
import com.telerikacademy.models.enums.Status;

import java.util.List;

public interface Bug {
    List<String> getListOfSteps();
    Priority getPriority();
    Severity getSeverity();
    void changePriority(Priority priority);
    void changeSeverity(Severity severity);
    void changeStatus(Status status);
    Member getAssignee();
}
