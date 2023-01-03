package com.telerikacademy.commands.create;

import com.telerikacademy.commands.contracts.Command;
import com.telerikacademy.core.TaskRepoImpl;
import com.telerikacademy.models.tasks.FeedbackImpl;
import com.telerikacademy.utils.ParsingHelpers;

import java.util.List;

import static com.telerikacademy.utils.ValidationHelpers.validateArgumentsCount;
import static java.lang.String.format;

public class CreateFeedback implements Command {
    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;
    private static final String FEEDBACK_ALREADY_EXISTS = "Task with title %s already exists";
    private static final String FEEDBACK_CREATED = "%s with title %s was created";

    public static final String INVALID_RATING_MESSAGE = "Rating should be a number";
    private final TaskRepoImpl repository;

    public CreateFeedback(TaskRepoImpl repository) {
        this.repository = repository;
    }

    @Override
    public String excecute(List<String> arguments) {
        validateArgumentsCount(arguments, EXPECTED_NUMBER_OF_ARGUMENTS);
        int id = ++TaskRepoImpl.nextId;
        String title = arguments.get(0);
        String description = arguments.get(1);
        int rating = ParsingHelpers.tryParseInt(arguments.get(2), INVALID_RATING_MESSAGE);
        return createFeedback(id, title, description, rating);
    }

    private String createFeedback(int id, String title, String description, int rating) {
        if (repository.taskExists(title)) {
            throw new IllegalArgumentException(format(FEEDBACK_ALREADY_EXISTS, title));
        }
        repository.addFeedback(new FeedbackImpl(id, title, description, rating));
        return format(FEEDBACK_CREATED, "Feedback", title);
    }
}
