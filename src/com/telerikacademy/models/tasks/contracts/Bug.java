package com.telerikacademy.models.tasks.contracts;

import com.telerikacademy.models.CommentImpl;

import java.util.List;

public interface Bug {
    public List<CommentImpl> getComment();
}
