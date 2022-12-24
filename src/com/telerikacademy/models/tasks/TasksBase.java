package com.telerikacademy.models.tasks;

import com.telerikacademy.models.tasks.contracts.Task;

import java.util.ArrayList;
import java.util.List;

public abstract class TasksBase implements Task {
    private int id;
    private String title;
    private String description;
    private final List<String> changesHistory;

    public TasksBase(int id, String title, String description) {
        setId(id);
        setTitle(title);
        setDescription(description);
        changesHistory = new ArrayList<>();
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setTitle(String title) {
        validateTitle(title);
        this.title = title;
    }

    public void setDescription(String description) {
        validateDescription(description);
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
    public List<String> getChangesHistory() {
        return new ArrayList<>(changesHistory);
    }

    protected abstract void validateTitle(String title);
    protected abstract void validateDescription(String description);
}
