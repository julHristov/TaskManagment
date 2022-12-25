package com.telerikacademy.models.tasks;

import com.telerikacademy.models.contracts.Member;
import com.telerikacademy.models.enums.Priority;
import com.telerikacademy.models.enums.Status;
import com.telerikacademy.models.tasks.contracts.Feedback;

import java.util.Base64;

public class FeedbackImpl extends TasksBase implements Feedback {
    private int rating;
    private Status status;
    private Member assignee;

    public FeedbackImpl(int id, String title, String description, int rating) {
        super(id, title, description);
        this.rating = rating;
        this.status = Status.NEW;
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public Member getAssignee() {
        return assignee;
    }

    @Override
    public Priority getPriority() {
        return null;
    }
}
