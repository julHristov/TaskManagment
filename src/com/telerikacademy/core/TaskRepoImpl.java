package com.telerikacademy.core;

import com.telerikacademy.core.contracts.TaskRepo;
import com.telerikacademy.models.TeamImpl;
import com.telerikacademy.models.contracts.Member;
import com.telerikacademy.models.contracts.Team;
import com.telerikacademy.models.enums.Priority;
import com.telerikacademy.models.enums.Severity;
import com.telerikacademy.models.tasks.BugImpl;
import com.telerikacademy.models.tasks.FeedbackImpl;
import com.telerikacademy.models.tasks.contracts.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepoImpl implements TaskRepo {
  public static int nextId;

  private final List<Task> tasks;

  private final List<Team> teams ;
  private final List<Member> members;

  public TaskRepoImpl() {
    this.teams = new ArrayList<>();
    this.members = new ArrayList<>();
    this.tasks = new ArrayList<>();
  }

  @Override
  public List<Team> getTeams() {
    return new ArrayList<>(teams);
  }

  @Override
  public List<Task> getTasks() {
    return new ArrayList<>(tasks);
  }
  @Override
  public List<Member> getMembers() {
    return new ArrayList<>(members);
  }
  @Override
  public void createBug(int id, String taskTitle, String description, Priority priority,
                         Severity severity, List<String> steps) {
    Task task = new BugImpl(++nextId, taskTitle, description, priority, severity, steps);
    this.tasks.add(task);
  }

  @Override
  public boolean taskExists(String taskName) {
    boolean exists = false;
    for (Task task : getTasks()){
      if(task.getTitle().equalsIgnoreCase(taskName)){
        exists = true;
        break;
      }
    }
    return exists;
  }

  @Override
  public void addBug(BugImpl bugToAdd) {

  }

  @Override
  public void addTeam(TeamImpl teamToAdd) {
//    teams.add(new TeamImpl(name));
  }

  @Override
  public void addFeedback(FeedbackImpl feedbackToAdd) {

  }
}
