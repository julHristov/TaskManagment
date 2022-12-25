package com.telerikacademy.models.tasks;

import com.telerikacademy.models.contracts.Comment;
import com.telerikacademy.models.contracts.Member;
import com.telerikacademy.models.enums.Priority;
import com.telerikacademy.models.enums.Severity;
import com.telerikacademy.models.enums.Status;
import com.telerikacademy.models.tasks.contracts.Bug;

import java.util.ArrayList;
import java.util.List;

import static com.telerikacademy.utils.ValidationHelpers.validateStringLength;
import static java.lang.String.format;

public class BugImpl extends TasksBase implements Bug {

    private Priority priority;
    private Severity severity;
    private List<String> steps;
    private Member assignee;
    private Status status;

    public BugImpl(int id, String title, String description, Priority priority,
                   Severity severity, Member assignee, List<String> steps) {
        super(id, title, description);
        this.priority = priority;
        this.steps = new ArrayList<>();
        this.assignee = assignee;
        this.status = Status.ACTIVE;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public List<Comment> getComment() {
        return new ArrayList<>();
    }

    @Override
    public List<String> getListOfSteps() {
        return new ArrayList<>();
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    @Override
    public Severity getSeverity() {
        return severity;
    }

    @Override
    public Member getAssignee() {
        return assignee;
    }

    @Override
    public void changePriority() {
    }

    @Override
    public void changeSeverity() {
    }

    @Override
    public void changeStatus() {
    }
}

