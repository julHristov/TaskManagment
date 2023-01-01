package com.telerikacademy.core.contracts;

import com.telerikacademy.models.TeamImpl;
import com.telerikacademy.models.contracts.Member;
import com.telerikacademy.models.contracts.Team;
import com.telerikacademy.models.enums.Priority;
import com.telerikacademy.models.enums.Severity;
import com.telerikacademy.models.tasks.BugImpl;
import com.telerikacademy.models.tasks.contracts.Task;

import java.util.List;

public interface TaskRepo {
    List<Team> getTeams();
    List<Member> getMembers();
    List <Task>getTasks();

    void createBug(int id, String taskTitle, String description, Priority priority,
                    Severity severity, List<String> steps);

    boolean taskExists(String taskName);

    void addBug(BugImpl bugToAdd);
    void addTeam(TeamImpl teamToAdd);



}
