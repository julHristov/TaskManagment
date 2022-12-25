package com.telerikacademy.models.tasks;

import com.telerikacademy.models.contracts.Comment;
import com.telerikacademy.models.enums.Priority;
import com.telerikacademy.models.enums.Status;
import com.telerikacademy.models.tasks.contracts.Task;
import com.telerikacademy.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

import static com.telerikacademy.utils.ValidationHelpers.*;
import static java.lang.String.*;

public abstract class TasksBase implements Task {

    public static final int TITLE_MIN_LENGTH = 10;
    public static final int TITLE_MAX_LENGTH = 50;
    public static final int DESCRIPTION_MIN_LENGTH = 10;
    public static final int DESCRIPTION_MAX_LENGTH = 500;

    public static final int ASSIGNEE_MIN_LENGTH = 5;
    public static final int ASSIGNEE_MAX_LENGTH = 20;
    public static final String ASSIGNEE_ERROR_MESSAGE = "Assignee name can not be less than %d" +
            "and more than %d symbols";
    public static final String TITLE_ERROR_MESSAGE = "Title can not have less than %d " +
            "and more than %d symbols";

    public static final String DESCRIPTION_ERROR_MESSAGE = "Description can not have less than %d" +
            "and more than %d symbols";
    private int id;
    private String title;
    private String description;
    private final List<String> changesHistory;
    private final List<Comment> comments;

    public TasksBase(int id, String title, String description) {
        setId(id);
        setTitle(title);
        setDescription(description);
        comments = new ArrayList<>();
        changesHistory = new ArrayList<>();
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setTitle(String title) {
        validateStringLength(title,
                TITLE_MIN_LENGTH,
                TITLE_MAX_LENGTH,
                format(TITLE_ERROR_MESSAGE,
                        TITLE_MIN_LENGTH,
                        TITLE_MAX_LENGTH));
        this.title = title;
    }

    public void setDescription(String description) {
        validateStringLength(description,
                DESCRIPTION_MIN_LENGTH,
                DESCRIPTION_MAX_LENGTH,
                format(DESCRIPTION_ERROR_MESSAGE,
                        DESCRIPTION_MIN_LENGTH,
                        DESCRIPTION_MAX_LENGTH));
        this.description = description;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<Comment> getComment() {
        return new ArrayList<>(comments);
    }

    @Override
    public List<String> getChangesHistory() {
        return new ArrayList<>(changesHistory);
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
        addActivity(format("%s added a new comment", comment.getAuthor()));
    }

    @Override
    public void removeComment(Comment comment) {
        if(comments.contains(comment)){
            throw new IllegalArgumentException("The comment you are trying to remove does not exist");
        }
        comments.remove(comment);
        addActivity(format("Comment by %s was removed", comment.getAuthor()));
    }
    @Override
    public void addActivity(String message) {
        changesHistory.add(message);
    }
}
