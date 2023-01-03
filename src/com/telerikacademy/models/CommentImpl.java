package com.telerikacademy.models;

import com.telerikacademy.models.contracts.Comment;
import static com.telerikacademy.utils.ValidationHelpers.*;
import static java.lang.String.*;

public class CommentImpl implements Comment {

    private static final int AUTHOR_NAME_MIN_LENGTH = 3;
    private static final int AUTHOR_NAME_MAX_LENGTH = 10;
    private static final int CONTENT_MIN_LENGTH = 10;
    private static final int CONTENT_MAX_LENGTH = 100;
    private static final String AUTHOR_NAME_ERROR_MESSAGE = "Author's name should be" +
            "between %d and %d symbols";

    private static final String CONTENT_LENGTH_ERROR_MESSAGE = "Content can not be less than" +
            "%d and more than %d symbols";

    private String author;
    private String content;
    public CommentImpl(String author, String content) {
        setAuthor(author);
        setContent(content);
    }

    public void setAuthor(String author) {
        validateStringLength(author,
                AUTHOR_NAME_MIN_LENGTH,
                AUTHOR_NAME_MAX_LENGTH,
                format(AUTHOR_NAME_ERROR_MESSAGE,
                        AUTHOR_NAME_MIN_LENGTH,
                        AUTHOR_NAME_MAX_LENGTH));
        this.author = author;
    }

    public void setContent(String content) {
        validateStringLength(content,
                CONTENT_MIN_LENGTH,
                CONTENT_MAX_LENGTH,
                format(CONTENT_LENGTH_ERROR_MESSAGE,
                        CONTENT_MIN_LENGTH,
                        CONTENT_MAX_LENGTH));
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("%s\n" +
                "Author: %s",
                content,
                author);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        CommentImpl comment = (CommentImpl) obj;
        return getAuthor().equals(comment.getAuthor()) &&
                getContent().equals(comment.getContent());
    }
}
