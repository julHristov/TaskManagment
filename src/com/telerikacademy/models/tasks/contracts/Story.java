package com.telerikacademy.models.tasks.contracts;

import com.telerikacademy.models.contracts.Comment;
import com.telerikacademy.models.enums.Priority;
import com.telerikacademy.models.enums.Size;
import com.telerikacademy.models.enums.Status;

import java.util.List;

public interface Story {
    Size getSize();
    Priority getPriority();
    Status getStatus();
    List<Comment> getComment();

    void changePriority(Priority newPriority);
}
