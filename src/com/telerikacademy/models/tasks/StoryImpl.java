package com.telerikacademy.models.tasks;

import com.telerikacademy.models.contracts.Comment;
import com.telerikacademy.models.contracts.Member;
import com.telerikacademy.models.enums.Priority;
import com.telerikacademy.models.enums.Size;
import com.telerikacademy.models.enums.Status;
import com.telerikacademy.models.tasks.contracts.Story;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class StoryImpl extends TasksBase implements Story {
    private Priority priority;
    private Status status;
    private Size size;
    private Member assignee;

    public StoryImpl(int id, String title, String description, Priority priority,
                     Size size, Status status, Member assignee) {
        super(id, title, description);
        this.priority = priority;
        this.size = size;
        this.status = Status.NOT_DONE;
        this.assignee = assignee;
    }

    @Override
    public Priority getPriority() {
        return priority;
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
    public Size getSize() {
        return size;
    }

    @Override
    public void changePriority(Priority newPriority) {
        Priority currentPriority = getPriority();
        if (currentPriority.equals(newPriority)) {
            throw new IllegalArgumentException(format("Priority is already at %s", getPriority()));
        }
    }
}
