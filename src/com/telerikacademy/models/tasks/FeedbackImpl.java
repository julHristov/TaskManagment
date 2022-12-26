package com.telerikacademy.models.tasks;

import com.sun.nio.sctp.IllegalReceiveException;
import com.telerikacademy.models.contracts.Member;
import com.telerikacademy.models.enums.Priority;
import com.telerikacademy.models.enums.Status;
import com.telerikacademy.models.tasks.contracts.Feedback;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

public class FeedbackImpl extends TasksBase implements Feedback {
    private int rating;
    private Status status;
    private Member assignee;

    public FeedbackImpl(int id, String title, String description, int rating) {
        super(id, title, description);
        setRating(rating);
        this.status = Status.NEW;
    }

    public void setRating(int rating) {
        if (rating < 0) {
            throw new IllegalArgumentException("Rating can not be negative");
        }
        this.rating = rating;
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

    @Override
    public void changeStatus(Status newStatus) {
        List<Status> statusList = Arrays.asList(Status.UNSCHEDULED, Status.SCHEDULED, Status.DONE);
        Status currentStatus = getStatus();

        if (!statusList.contains(newStatus)) {
            throw new IllegalReceiveException("Invalid status");
        }
        if (currentStatus.equals(newStatus)) {
            throw new IllegalArgumentException("Status already exists");
        }
        this.status = newStatus;
        addActivity(format("Status of item with ID %d changed from %s to %s",
                getId(),
                currentStatus,
                this.status));
    }

    @Override
    public String toString() {
        return format("""
                        %sFeedback:\s
                        Rating -\s
                        Status -\s
                        Assignee -\s
                        """,
                super.toString(),
                rating,
                status,
                assignee);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FeedbackImpl feedback = (FeedbackImpl) obj;
        return getTitle().equals(feedback.getTitle()) &&
                getDescription().equals(feedback.getDescription()) &&
                getRating() == feedback.getRating() && getStatus().equals(feedback.getStatus());
    }
}