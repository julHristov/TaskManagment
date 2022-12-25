package com.telerikacademy.core.contracts;

import com.telerikacademy.models.contracts.Member;
import com.telerikacademy.models.contracts.Team;

import java.util.List;

public interface TaskRepo {
    List<Team> getTeams();
    List<Member> getMembers();



}
