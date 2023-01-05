package com.telerikacademy.models.contracts;

import com.telerikacademy.models.tasks.contracts.Bug;
import com.telerikacademy.models.tasks.contracts.Feedback;
import com.telerikacademy.models.tasks.contracts.Story;
import com.telerikacademy.models.tasks.contracts.Task;

import java.util.List;

public interface Board {

    String getName();
    List<Task> getTask();
    List<String> getActivity();
    void addBugToBoard(Bug bugToAdd);
    void addStoryToBoard(Story storyToAdd);
    void addFeedBack(Feedback feedbackToAdd);
    void addActivity(String message);
    List<Bug> getBugs();
    List<Story> getStories();
    List<Feedback> getFeedbacks();
}
