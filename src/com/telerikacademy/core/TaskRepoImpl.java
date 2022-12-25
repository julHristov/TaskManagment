package com.telerikacademy.core;

import com.telerikacademy.core.contracts.TaskRepo;
import com.telerikacademy.models.contracts.Member;
import com.telerikacademy.models.contracts.Team;

import java.util.ArrayList;
import java.util.List;

public class TaskRepoImpl implements TaskRepo {

  private final   List<Team> teams ;
  private final List<Member> members;

  public TaskRepoImpl() {
    this.teams = new ArrayList<>();
    this.members = new ArrayList<>();
  }

  @Override
  public List<Team> getTeams() {
    return new ArrayList<>(teams);
  }

  @Override
  public List<Member> getMembers() {
    return new ArrayList<>(members);
  }
}
