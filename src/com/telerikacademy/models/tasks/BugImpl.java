package com.telerikacademy.models.tasks;

import com.telerikacademy.models.CommentImpl;
import com.telerikacademy.models.tasks.contracts.Bug;

import java.util.ArrayList;
import java.util.List;

import static com.telerikacademy.utils.ValidationHelpers.validateStringLength;
import static java.lang.String.format;

public class BugImpl extends TasksBase implements Bug {
    public static final int TITLE_MIN_LENGTH = 10;
    public static final int TITLE_MAX_LENGTH = 50;

    public static final int DESCRIPTION_MIN_LENGTH = 10;
    public static final int DESCRIPTION_MAX_LENGTH = 500;

    public static final String TITLE_ERROR_MESSAGE = "Title can not have less than %d " +
            "and more than %d symbols";

    public static final String DESCRIPTION_ERROR_MESSAGE = "Description can not have less than %d" +
            "and more than %d symbols";

    private static List<CommentImpl> comment;

    public BugImpl(int id, String title, String description) {
        super(id, title, description);
        comment = new ArrayList<>();
    }

    @Override
    public List<CommentImpl> getComment() {
        return new ArrayList<>(comment);
    }

    @Override
    protected void validateTitle(String title) {
        validateStringLength(title,
                TITLE_MIN_LENGTH,
                TITLE_MAX_LENGTH,
                format(TITLE_ERROR_MESSAGE,
                        TITLE_MIN_LENGTH,
                        TITLE_MAX_LENGTH));
    }

    @Override
    protected void validateDescription(String description) {
        validateStringLength(description,
                DESCRIPTION_MIN_LENGTH,
                DESCRIPTION_MAX_LENGTH,
                format(DESCRIPTION_ERROR_MESSAGE,
                        DESCRIPTION_MIN_LENGTH,
                        DESCRIPTION_MAX_LENGTH));
    }
}

