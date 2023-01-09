package com.telerikacademy.models;

import com.telerikacademy.models.contracts.Board;
import com.telerikacademy.models.contracts.Member;
import com.telerikacademy.models.contracts.Team;
import com.telerikacademy.utils.ValidationHelpers;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class TeamImpl implements Team {

    private static final int MIN_LEN_NAME = 5;
    private static final int MAX_LEN_NAME = 15;

    private String name;
    private final List<Member> members;
    private final List<Board> boards;
    private final List<String> activityHistory;

    public TeamImpl(String name) {
        setName(name);
        this.members = new ArrayList<>();
        this.boards = new ArrayList<>();
        this.activityHistory = new ArrayList<>();
    }

    private void setName(String name) {
        ValidationHelpers.validateStringLength(name, MIN_LEN_NAME, MAX_LEN_NAME,
                ValidationHelpers.ERROR_MESSAGE_FOR_LENGTH);
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }

    @Override
    public List<Board> getBoards() {
        return new ArrayList<>(boards);
    }

    @Override
    public void addBoard(Board boardToAdd) {
        if (getBoards().contains(boardToAdd)) {
            throw new IllegalArgumentException(format("Board (%s) already exists", boardToAdd.getName()));
        }
        boards.add(boardToAdd);
        activityHistory.add(format("%s board was added to the team", boardToAdd.getName()));
    }
}
