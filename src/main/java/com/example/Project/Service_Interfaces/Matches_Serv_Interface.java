package com.example.Project.Service_Interfaces;

import com.example.Project.Dto.Matches_Dto;

import java.util.List;

public interface Matches_Serv_Interface {


    public List<Matches_Dto> findAll();

    public List<Matches_Dto> findById(Long match_id);
    public Matches_Dto addMatch(Matches_Dto match_id);

    public void deleteMatch(Long match_id);

    public Matches_Dto updateMatch(long match_id, Matches_Dto matchesDto);
}
