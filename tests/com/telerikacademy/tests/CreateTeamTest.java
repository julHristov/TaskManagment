package com.telerikacademy.tests;

import com.telerikacademy.models.TeamImpl;
import com.telerikacademy.models.contracts.Team;
import com.telerikacademy.models.tasks.BugImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CreateTeamTest {

    private static TeamImpl team;

    @BeforeEach
    public void setUp(){
        team = new TeamImpl("The Eagles");
    }

    @Test
    public void excecute() {
        fail("Not implemented yet");
    }
    public void createTeam_Should_Return_Message(){
        fail("Not implemented yet");
    }
}