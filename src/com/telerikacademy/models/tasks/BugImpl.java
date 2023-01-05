package com.telerikacademy.models.tasks;

import com.telerikacademy.models.contracts.Comment;
import com.telerikacademy.models.contracts.Member;
import com.telerikacademy.models.enums.Priority;
import com.telerikacademy.models.enums.Severity;
import com.telerikacademy.models.enums.Status;
import com.telerikacademy.models.enums.TaskType;
import com.telerikacademy.models.tasks.contracts.Bug;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.*;

public class BugImpl extends TasksBase implements Bug {

    private Priority priority;
    private Severity severity;
    private List<String> steps;
    private Member assignee;
    private Status status;

    public BugImpl(int id, String title, String description, Priority priority,
                   Severity severity, List<String> steps) {
        super(id, title, description);
        this.priority = priority;
        this.steps = new ArrayList<>();
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
    public TaskType getType() {
        return TaskType.BUG;
    }

    @Override
    public void changePriority(Priority priority) {
        if(this.priority == priority){
            throw new IllegalArgumentException(format("The priority is already set to %s",
                    this.priority.toString()));
        }
        this.priority = priority;
        steps.add(format("Priority changed to %s", priority.toString()));
    }

    @Override
    public void changeSeverity(Severity severity) {
        if(this.severity == severity){
            throw new IllegalArgumentException(format("The severity is already set to %s",
                    this.severity.toString()));
        }
        this.severity = severity;
        steps.add(format("Severity changed to %s", this.severity.toString()));
    }

    @Override
    public void changeStatus(Status status) {
        if(this.status == status){
            throw new IllegalArgumentException(format("The status is already set to %s", this.status.toString()));
        }
        this.status = status;
        steps.add(format("Status changed to %s", getStatus().toString()));
    }

    @Override
    public String toString() {
        return "BugImpl: %s\n" + super.toString() +
                "Priority - \n" + priority +
                "Severity - \n" + severity +
                "Steps - \n" + steps +
                "Assignee - \n" + assignee +
                "Status - \n" + status  ;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        BugImpl bug = (BugImpl) obj;
        return getTitle().equals(bug.getTitle()) &&
                getDescription().equals(bug.getDescription()) &&
                getPriority().equals(bug.getPriority()) && getSeverity().equals(bug.getSeverity())
                && getStatus().equals(bug.getStatus());
    }
}

