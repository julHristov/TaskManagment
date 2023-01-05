package com.telerikacademy.models;

import com.telerikacademy.models.contracts.Board;
import com.telerikacademy.models.tasks.contracts.Bug;
import com.telerikacademy.models.tasks.contracts.Feedback;
import com.telerikacademy.models.tasks.contracts.Story;
import com.telerikacademy.models.tasks.contracts.Task;

import java.util.ArrayList;
import java.util.List;

import static com.telerikacademy.utils.ValidationHelpers.ERROR_MESSAGE_FOR_LENGTH;
import static com.telerikacademy.utils.ValidationHelpers.validateStringLength;
import static java.lang.String.format;

public class BoardImpl implements Board {

    protected static final int MIN_LENGTH_NAME = 5;
    protected static final int MAX_LENGTH_NAME = 10;
    private static final String TASK_EXISTS_MESSAGE = "Task already added to board!";
    private static final String BOARD_INFO = "Board name: %s | Number of tasks: %d";
    private String name;
    private final List<Bug> bugs;
    private final List<Story> stories;
    private final List<Feedback> feedbacks;
    private final List<String> activity;

    public BoardImpl(String name) {
        setName(name);
        this.bugs = new ArrayList<>();
        this.stories = new ArrayList<>();
        this.feedbacks = new ArrayList<>();
        this.activity = new ArrayList<>();
        addActivity(format("Board (%s) was created", name));
    }

    private void setName(String name) {
        validateStringLength(name, MIN_LENGTH_NAME, MAX_LENGTH_NAME,
                ERROR_MESSAGE_FOR_LENGTH);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Task> getTask() {
        List<Task> tasks = new ArrayList<>();
        tasks.addAll(bugs);
        tasks.addAll(stories);
        tasks.addAll(feedbacks);
        return tasks;
    }

    @Override
    public List<String> getActivity() {
        return new ArrayList<>(activity);
    }

    @Override
    public void addBugToBoard(Bug bugToAdd) {
        if (getBugs().contains(bugToAdd)) {
            throw new IllegalArgumentException(TASK_EXISTS_MESSAGE);
        }
        bugs.add(bugToAdd);
        addActivity(format("%s with ID %d was added to board", bugToAdd.getType(), bugToAdd.getId()));
    }

    @Override
    public void addStoryToBoard(Story storyToAdd) {
        if (getStories().contains(storyToAdd)) {
            throw new IllegalArgumentException(TASK_EXISTS_MESSAGE);
        }
        stories.add(storyToAdd);
        addActivity(format("%s with ID %d was added to board", storyToAdd.getType(), storyToAdd.getId()));
    }

    @Override
    public void addFeedBack(Feedback feedbackToAdd) {
        if (getFeedbacks().contains(feedbackToAdd)) {
            throw new IllegalArgumentException(TASK_EXISTS_MESSAGE);
        }
        feedbacks.add(feedbackToAdd);
        addActivity(format("%s with ID %d was added to board", feedbackToAdd.getType(), feedbackToAdd.getId()));
    }

    @Override
    public void addActivity(String message) {
        activity.add(message);
    }

    @Override
    public String toString() {
        return format(BOARD_INFO, name, getTask().size());
    }

    @Override
    public List<Bug> getBugs() {
        return new ArrayList<>(bugs);
    }

    @Override
    public List<Story> getStories() {
        return new ArrayList<>(stories);
    }

    @Override
    public List<Feedback> getFeedbacks() {
        return new ArrayList<>(feedbacks);
    }

}
