package com.telerikacademy.models.tasks.contracts;

import com.telerikacademy.models.enums.Priority;
import com.telerikacademy.models.enums.Status;
import com.telerikacademy.models.contracts.Comment;

import java.util.List;

public interface Task {
    int getId();
    String getTitle();
    String getDescription();
    List<String> getChangesHistory();
    Status getStatus();
    Priority getPriority();
    List<Comment> getComment();
    void addComment(Comment comment);
    void removeComment(Comment comment);
    void addActivity(String message);
}
