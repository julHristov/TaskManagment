package com.telerikacademy.models.contracts;

import java.util.List;

public interface Team {
    String getName() ;
    List<Member> getMembers();
    List<Board> getBoards();
    void addBoard(Board boardToAdd);
}
